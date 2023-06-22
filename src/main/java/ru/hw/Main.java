package ru.hw;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir"));
        Directory.printAsTree(file);
        try {
            Directory.copyDir(System.getProperty("user.dir"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}