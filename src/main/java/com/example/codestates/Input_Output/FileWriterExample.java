package com.example.codestates.Input_Output;

import java.io.FileWriter;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
            String fileName = "C:\\Users\\SAMSUNG\\IdeaProjects\\CodeStates\\src\\main\\java\\com\\example\\codestates\\Input_Output\\test.txt";
            FileWriter fileWriter = new FileWriter(fileName);

            String str = "file writer test";
            fileWriter.write(str);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
