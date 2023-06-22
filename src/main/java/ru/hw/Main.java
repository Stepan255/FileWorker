package ru.hw;

import com.sun.net.httpserver.Authenticator;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("E:\\Stepan\\Обучение\\GeekBrains\\learning_prog\\java\\my\\FileWorker");
        DirectoryTreePrinter.print(file);
    }
}