package fabs.util;

import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileUtil {
    public static String COMPONENT_NAME_TOKEN = "%COMPONENT_NAME%";
    public static String MUTATION_TYPE_FILE_PATH_TOKEN = "%MUTATION_FILE%";
    public static String MUTATION_NAME_TOKEN = "%MUTATION_NAME%";

    /**
     * Get the file content
     *
     * @param fileName
     * @return
     */
    public String getContent(String fileName) {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(fileName);

        Scanner scanner = new Scanner(resourceStream);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line).append("\n");
        }

        scanner.close();
        return result.toString();
    }

    public void writeFile(String content, VirtualFile destinationFile) throws IOException {
        destinationFile.setBinaryContent(content.getBytes());
    }
}
