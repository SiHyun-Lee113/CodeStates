package com.example.codestates.Input_Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\SAMSUNG\\IdeaProjects\\CodeStates\\src\\main\\java\\com\\example\\codestates\\Input_Output\\test.txt");
            String word = "codestates";

            byte b[] = word.getBytes();
            fileOutputStream.write(b);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
