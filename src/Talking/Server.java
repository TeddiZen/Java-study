package Talking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("服务器启动成功");
            new Thread(() -> {
                while (true){
                    try {
                        Socket socket = server.accept();
                        System.out.println(socket.getLocalSocketAddress());
                        InputStream stream = socket.getInputStream();
                        DataInputStream doc = new DataInputStream(stream);
                        while (true){
                            String msg = doc.readUTF();
                            System.out.println(msg);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
