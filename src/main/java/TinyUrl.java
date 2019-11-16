import javax.swing.*;
import java.util.HashMap;
import java.util.Random;

public class TinyUrl {
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    private Random rand = new Random();

    String getRand() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(chars.charAt(rand.nextInt(62)));
        }
        return builder.toString();
    }

    public String encode(String longUrl) {
        String key = getRand();
        while(map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

    public static void main(String[] args) {
        TinyUrl tiny = new TinyUrl();
        System.out.println(tiny.encode("https://leetcode.com/problems/design-tinyurl"));
    }
}
