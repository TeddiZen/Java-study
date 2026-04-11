import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;

public class App {
    public static void main(String[] args) throws Exception {
        // io流练习
        try (
            // 为什么要把fis放在try的括号里？
            // 因为fis是一个资源，需要在finally中关闭
            // 如果把fis放在try的括号里，那么在try中使用fis时，fis会被自动关闭
            Reader fis = new FileReader("data/text");
        ){
            char[] c = new char[3];
            int len;
            String str = "";
            while ((len = (fis.read(c))) != -1) {
                String s = new String(c, 0, len);
                str += s;
            }
            System.out.println(str);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            // 如果fis放在try的括号里，那么在finally中调用fis.close()会报错
            // 所以，在finally中调用fis.close()时，需要在try中捕获异常
        }
    }   
}
