package Shocked;

import javax.print.Doc;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("客户端启动成功");
            while (true){
                System.out.println("请输入消息");
                String msg = sc.nextLine();
                if (msg.equals("exit")){
                    socket.close();
                    break;
                }
                dos.writeUTF(msg);
                System.out.println("已向服务器发送消息\n" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
