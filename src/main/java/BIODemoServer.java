import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIODemoServer extends Thread {
    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(0);
            ExecutorService executor = Executors.newFixedThreadPool(8);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                executor.execute(requestHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BIODemoServer server = new BIODemoServer();
        server.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        }
    }
}

// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class NIODemoServer extends Thread {

    public void run() {
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {// 创建Selector和Channel
            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocketChannel.configureBlocking(false);
            // 注册到Selector，并说明关注点
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("start server");
            while (true) {
                System.out.println("selector ready to select");
                selector.select();// 阻塞等待就绪的Channel，这是关键点之一
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    // 生产系统中一般会额外进行就绪状态检查
                    sayHelloWorld((ServerSocketChannel) key.channel());
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(ServerSocketChannel serverSocketChannel) throws IOException {
        try (SocketChannel socketChannel = serverSocketChannel.accept()) {
            System.out.println("write hello world");
            ByteBuffer encode = Charset.defaultCharset().encode("Hello world!");
            socketChannel.write(encode);
        }
    }

    public static void main(String[] args) throws IOException {
        NIODemoServer server = new NIODemoServer();
        server.start();
    }

}


class NIOClient {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
                socketChannel.configureBlocking(false);
                System.out.println("t1与服务器的连接建立成功");
                ByteBuffer byteBuffer = ByteBuffer.wrap("Hello world!".getBytes());
                int read = socketChannel.read(byteBuffer);
                System.out.println("t1read" + read);
                System.out.println("t1receive" + new String(byteBuffer.array()).trim());
            } catch (Exception e) {

            }
        }
        , "t1").start();

        new Thread(() -> {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
                socketChannel.configureBlocking(false);
                System.out.println("t2与服务器的连接建立成功");
                ByteBuffer byteBuffer = ByteBuffer.wrap("Hello world!".getBytes());
                int read = socketChannel.read(byteBuffer);
                System.out.println("t2read" + read);
                System.out.println("t2receive" + new String(byteBuffer.array()).trim());
            } catch (Exception e) {

            }
        }
        , "t1").start();

    }
}