package com.example.codestates.Input_Output;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File parentDir = new File("./");
        File[] list = parentDir.listFiles();

        String prefix = "codeasdfasdfasdf";

        for(int i =0; i <list.length; i++) {
            String fileName = list[i].getName();

            if(fileName.endsWith("txt") && !fileName.startsWith("code")) {
                list[i].renameTo(new File(parentDir, prefix + fileName));
            }
        }
    }
}
