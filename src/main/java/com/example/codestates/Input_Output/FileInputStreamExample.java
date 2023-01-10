package com.example.codestates.Input_Output;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\SAMSUNG\\IdeaProjects\\CodeStates\\src\\main\\java\\com\\example\\codestates\\Input_Output\\test.txt");

            int i = 0;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println("i = " + (char)i);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
