package ru.hw;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class Directory {
    private static final String INDENT = "  ";
    private static final String SEP = System.getProperty("file.separator");

    public static void copyDir(String pathDir) throws Exception {
        File source = new File(pathDir);
        if (!source.isDirectory()) {
            throw new Exception("Directory path unfounded. Path: " + pathDir);
        }
        File destination = new File(pathDir + SEP + "backup");
        if (!destination.exists()) {
            if (destination.mkdir()) {
                System.out.println("Directory \"backup\" created.");
            } else {
                throw new Exception("Directory path unfounded. Path: " + pathDir);
            }
        } else {
            System.out.println("Directory \"backup\" already exists.");
        }
        for (File file : Objects.requireNonNull(source.listFiles())) {
            copy(file.toPath(), Path.of(destination + SEP + file.getName()));
        }
    }

    private static void copy(Path source, Path destination) {
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Объект " + source.getFileName() + " успешно скопирован.");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }

    public static void printAsTree(File directory) {
        Directory.printAsTree(directory, Directory.INDENT, true);
    }

    private static void printAsTree(File directory, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└");
            indent += Directory.INDENT;
        } else {
            System.out.print("├");
            indent += "│   ";
        }
        System.out.println(directory.getName());
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        int length = files.length;
        for (int i = 0; i < length; i++) {
            printAsTree(files[i], indent, length - 1 == i);
        }
    }
}
