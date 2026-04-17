package AITalkingRoom;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner sc = new Scanner(System.in);

    // 1. main 方法必须加 public
    public static void main(String[] args) {
        // 2. 把 socket 提出来，finally 里关闭
        Socket socket = null;
        DataOutputStream dos = null;

        try {
            socket = new Socket("127.0.0.1", 8888);
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("客户端启动成功");

            while (true) {
                String msg = sc.nextLine();
                if (msg.equals("exit")) {
                    System.out.println("客户端退出成功");
                    break;
                }
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("客户端异常：" + e.getMessage());
        } finally {
            // 3. 关闭资源
            try {
                if (dos != null) dos.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}