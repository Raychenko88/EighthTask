package com.company.service;

import java.io.File;
import java.io.IOException;

public class CreateFolderAndFile {

    private static File createNewFolder(){
        File filePath = new File("log");
        filePath.mkdir();

        return filePath;
    }
    public static File createAndUseFile(){
        File file = new File(createNewFolder() + "\\test.txt");
        try {
            file.createNewFile();
        }catch (
                IOException a){
            System.out.println("Something went wrong");
        }
        return file;
    }
}
