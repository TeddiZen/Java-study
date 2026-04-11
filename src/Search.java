import java.io.File;

/**
 * 搜索文件的工具类
 * 用于在指定目录及其子目录中搜索符合条件的文件
 */
public class Search {
    /**
     * 主方法，程序的入口点
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        File file = null;
        try {
            // 设置搜索的根目录为 E:/
            file = new File("E:/");
            // 调用搜索方法，空字符串表示搜索所有文件
            searchFile(file, "");
        } catch (Exception e) {
            // 捕获并抛出运行时异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 递归搜索文件的方法
     * @param file 要搜索的目录
     * @param fileName 要搜索的文件名关键字
     */
    public static void searchFile(File file, String fileName){
        // 检查文件对象是否为空或不存在
        if( file == null || !file.exists()){
            return;
        }

        // 获取目录下的所有文件和子目录
        File[] files = file.listFiles();
        // 检查是否成功获取到文件列表且列表不为空
        if (files != null && files.length > 0) {
            // 遍历所有文件和子目录
            for (File fileMid : files){
                // 如果是文件，检查文件名是否包含指定关键字
                if (fileMid.isFile()) {
                    if (fileMid.getName().contains(fileName)){
                        // 找到匹配的文件，输出其绝对路径
                        System.out.println("找到文件： " + fileMid.getAbsolutePath());
                    }
                }
                // 如果是目录，递归搜索该目录
                else {
                    searchFile(fileMid, fileName);
                }
            }
        }
    }
}