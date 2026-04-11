import java.io.*;

public class Copy {
    public static void main(String[] args) {
        copyFile("C:\\Users\\TeddiZen\\IdeaProjects\\IOStream\\data\\testPng.png","C:\\Users\\TeddiZen\\IdeaProjects\\IOStream\\copyData\\testCopyPng.png");
    }

    static void copyFile(String from, String to){
        try (
                InputStream input = new FileInputStream(from);
                OutputStream out = new FileOutputStream(to);
                ){
            byte[] b = new byte[1024];
            int len;
            while ((len = input.read(b)) != -1){
                out.write(b, 0 ,len);
            }
            System.out.println("复制成功！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
