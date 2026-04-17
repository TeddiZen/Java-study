package Shocked;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            System.out.println("客户端启动成功");
            while (true){
                System.out.println("请输入消息");
                String msg = sc.nextLine();
                if (msg.equals("exit")){
                    socket.close();
                    break;
                }
                DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getLocalHost(), 8888);
                socket.send(packet);
                System.out.println("已向服务器发送消息\n" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
