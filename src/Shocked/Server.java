package Shocked;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Server {
    static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            System.out.println("服务器启动成功");
            while (true){
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                socket.receive(packet);
                System.out.println("已连接客户端 " + packet.getAddress() + ":" + packet.getPort());
                String msg = new String(packet.getData());
                System.out.println("客户端发送消息" + msg);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
