package utilitys;
import java.io.File;

public class FileManager {

    /**
     * Get the absolute path of a file from a relative path
     * @param fileRelativePath Relative file path
     * @return Absolute file path
     */
    public static String getAbsolutePathFromRelativePath(String fileRelativePath) {
        File file = new File(fileRelativePath);
        return file.getAbsolutePath();
    }

    /**
     * Get the name of a file from a file path
     * @param fileLocalPath relative or absolute file path
     * @return File Name
     */
    public static String getFileName(String fileLocalPath) {
        File file = new File(fileLocalPath);
        return file.getName();
    }
}
