import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        // 利用递归查找制定文件
        File file = new File("./");
        findFile(file, "text");
    }
    /**
 * 在指定文件或目录中查找指定名称的文件
 * @param file 要搜索的文件或目录
 * @param fileName 要查找的文件名
 * 说明：如果file是目录，则递归搜索目录下的所有文件；如果file是文件且名称与fileName相同，则打印该文件的绝对路径
 */
    static void findFile(File file, String fileName) {
        // 检查当前file是否为目录
        if (file.isDirectory()) {
            // 获取目录中的所有文件和子目录
            File[] files = file.listFiles();
            // 遍历目录中的每个文件和子目录
            for (File f : files) {
                // 递归调用findFile方法搜索子文件或子目录
                findFile(f, fileName);
            }
        } else if (file.getName().equals(fileName)) {
            // 如果当前file是文件且文件名与目标文件名相同，打印文件的绝对路径
            System.out.println("找到文件：" + file.getAbsolutePath());
        }
    }

}
