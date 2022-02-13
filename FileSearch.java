package top.fishsen;



import java.io.*;

public class FileSearch {

    public static final String rootPath = "C:/Card";

    public static void mkRootFolder() {
        File file = new File(rootPath);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }
    }

    public static void mkFolder(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }
    }

    public static void delFolder(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null){
                 for(File files1:files) {
                     files1.delete();
                 }
            }
            file.delete();

        }
    }

    public static void mkFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            file.createNewFile();
        }
    }

    public static void storeUser(User user, String filePath) {
        File file = new File(filePath);

        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            oos.writeObject(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}