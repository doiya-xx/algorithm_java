package utils.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOp {

    public static boolean createDir(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
            System.out.printf("Dir: '%1$s' created successfully%n", path);
            return true;
        } else {
            System.out.printf("Dir: '%1$s' has exists%n", path);
            return false;
        }
    }

    public static boolean createFile(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
            System.out.printf("File: '%1$s' created successfully!%n", path);
            return true;
        } else {
            System.out.printf("File: '%1$s' has exists!%n", path);
            return false;
        }
    }

    private static void printIndent(int level) {
        level*=3;
        for (int i = 0; i < level; i++) {
            System.out.print(" ");
        }
    }

    public static void printDirectoryTree(Path dir, int level) throws IOException {
        if (Files.isDirectory(dir)) {
            printIndent(level);
            System.out.println("├- " + dir.getFileName());
            Files.newDirectoryStream(dir).forEach(path -> {
                try {
                    if (Files.isDirectory(path)) {
                        printDirectoryTree(path, level + 1);
                    } else {
                        printIndent(level + 1);
                        System.out.println("├- " + path.getFileName());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
