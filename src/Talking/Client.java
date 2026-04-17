package Talking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner sc = new Scanner(System.in);
    static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1" ,  8888);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("客户端启动成功");
            while (true){
                String msg = sc.nextLine();
                if (msg.equals("exit")){
                    System.out.println("客户端退出成功");
                    break;
                }
                dos.writeUTF("text");
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
