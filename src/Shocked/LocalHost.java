package Shocked;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {
    static void main(String[] args) {
        try {
            String host = InetAddress.getLocalHost().toString();
            System.out.println(host);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
