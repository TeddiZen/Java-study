import java.io.FileReader;
import java.io.Reader;

public class In {
    public static void main() {
        try (
                Reader fis = new FileReader("data/test1.txt")
                ){
            char[] c = new char[3];
            int len;
            while ((len = fis.read(c)) != -1){
                String str = new String(c, 0, len);
                System.out.print(str);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
