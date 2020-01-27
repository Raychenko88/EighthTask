package com.company.service;

import java.io.File;
import java.io.IOException;

public class CreateFolderAndFile {

    public  File createNewFolder(){
        File filePath = new File("log");
        filePath.mkdir();

        return filePath;
    }
    public  File createAndUseFile(){
        File file = new File(createNewFolder() + "\\test.txt");
        try {
            file.createNewFile();
        }catch (
                IOException a){
            System.out.println("что то пошло не так");
        }
        return file;
    }
}
