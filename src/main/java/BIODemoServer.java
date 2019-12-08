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
                int readChannels = selector.select();// 阻塞等待就绪的Channel，这是关键点之一
                System.out.println("after select");
                if (readChannels == 0) {
                    System.out.println("readchannel is 0");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();
                    if (key.isAcceptable()) {
                        // 有已经接受的新的到服务端的连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        System.out.println("accept socket channel");

                        // 有新的连接并不代表这个通道就有数据，
                        // 这里将这个新的 SocketChannel 注册到 Selector，监听 OP_READ 事件，等待数据
                        ByteBuffer buffer = ByteBuffer.wrap("返回给客户端的数据...".getBytes());
                        socketChannel.write(buffer);
                        socketChannel.close();
                    } else if (key.isReadable()) {
                        // 有数据可读
                        // 上面一个 if 分支中注册了监听 OP_READ 事件的 SocketChannel
                        System.out.println("read socket channel");
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        Thread.sleep(1000);
                        ByteBuffer buffer = ByteBuffer.wrap("返回给客户端的数据...".getBytes());
                        socketChannel.write(buffer);
                        socketChannel.close();
                    }

                }
            }
        } catch (IOException | InterruptedException e) {
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

                Selector selector = Selector.open();
                socketChannel.register(selector, SelectionKey.OP_READ);

                while (true) {
                    //选择一组键，其相应的通道已为 I/O 操作准备就绪。
                    //此方法执行处于阻塞模式的选择操作。
                    selector.select();

                    //返回此选择器的已选择键集。
                    Set<SelectionKey> keys = selector.selectedKeys();
                    System.out.println("keys=" + keys.size());
                    Iterator<SelectionKey> keyIterator = keys.iterator();
                    while (keyIterator.hasNext()) {
                        SelectionKey key = keyIterator.next();
                        keyIterator.remove();

                        if (key.isReadable()) {//读取数据
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            System.out.print("receive message:");
                            SocketChannel client = (SocketChannel) key.channel();
                            //将缓冲区清空以备下次读取
                            readBuffer.clear();
                            int num = client.read(readBuffer);
                            System.out.println(new String(readBuffer.array(), 0, num));
                        }
                    }
                }
            } catch (Exception e) {

            }

        }, "t1").start();

    }
}