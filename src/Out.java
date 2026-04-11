import java.io.*;
import java.util.Scanner;

public class Out {
    public static void main() {
        try(
                OutputStream fis = new FileOutputStream("data/test2.txt");
                ) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            fis.write(str.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
