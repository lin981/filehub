import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class UpUtil {
    public static void getFileList(String path, HashMap<String, String> filenames) {
        //路径当成文件对象
        File file = new File(path);
        File[] files = file.listFiles();
        if (null != files) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    getFileList(file1.getPath(), filenames);
                } else {
                    String name = file1.getName();
                    int index = name.indexOf("-");
                    String substring = name.substring(index + 1);
                    filenames.put(name, substring);
                }

            }
        }

    }

    public static String newFileNme(String fileName) {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return s+"-"+ fileName;
    }


}
