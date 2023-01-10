package com.example.codestates.Input_Output;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class FileReaderExample {
    public static void main(String[] args) {
        try {
            String fileName = "C:\\Users\\SAMSUNG\\IdeaProjects\\CodeStates\\src\\main\\java\\com\\example\\codestates\\Input_Output\\test.txt";
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);

            int data = 0;

            while ((data=bufferedReader.read()) != -1) {
                System.out.print((char) data);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
