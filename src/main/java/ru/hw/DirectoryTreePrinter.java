package ru.hw;

import java.io.File;

public class DirectoryTreePrinter {
    private static final String INDENT = "  ";
    public static void print(File directory) {
        DirectoryTreePrinter.print(directory, DirectoryTreePrinter.INDENT, true);
    }

    private static void print(File directory, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└");
            indent += DirectoryTreePrinter.INDENT;
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
            print(files[i], indent, length-1 == i);
        }
    }
}
