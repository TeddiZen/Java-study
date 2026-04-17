package Shocked;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class Test {
    public static void main(String[] args) {
        // 学习UDP通讯
        try {
            DataOutputStream outputStream = new DataOutputStream(System.out);
            outputStream.writeUTF("hello world");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
