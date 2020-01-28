package com.company.util;

import com.company.service.CreateFolderAndFile;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    public static void readInfo() throws IOException {
        FileReader reader = new FileReader(CreateFolderAndFile.createAndUseFile());
        try
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        reader.close();
    }
}
