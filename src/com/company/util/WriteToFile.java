package com.company.util;

import com.company.model.ConnectionToServer;
import com.company.service.CreateFolderAndFile;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void writeInfo() throws IOException {
        FileWriter writer = new FileWriter(CreateFolderAndFile.createAndUseFile(), true);
        for (int i = 0; i < 10; i++){
            try {
                RandomNumbers randomNumbers = new RandomNumbers();
                writer.write(new ConnectionToServer(randomNumbers.session,randomNumbers.time.getTime(),randomNumbers.ip) + "\n");
            }catch (IOException a){
                System.out.println("record failed");
            }
        }
        writer.close();
    }
}
