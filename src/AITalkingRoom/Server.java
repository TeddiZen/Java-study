package AITalkingRoom;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);
            System.out.println("服务器启动成功，等待客户端连接...");

            // 死循环接收客户端
            while (true) {
                Socket socket = server.accept();
                System.out.println("有客户端上线：" + socket.getInetAddress());

                // 每个客户端开一个独立线程
                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 单独抽方法处理一个客户端
    private static void handleClient(Socket socket) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            String msg;

            // 4. 判断是否读到数据，解决客户端断开抛异常
            while ((msg = dis.readUTF()) != null) {
                System.out.println(socket.getInetAddress() + " 说：" + msg);
            }
        } catch (IOException e) {
            // 客户端断开会触发这个，正常现象
            System.out.println("客户端断开连接：" + socket.getInetAddress());
        } finally {
            try {
                if (dis != null) dis.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}