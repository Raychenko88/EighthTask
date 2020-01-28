package com.company.service;

import com.company.model.ConnectionToServer;
import com.company.util.RandomNumbers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {

    public static ArrayList<ConnectionToServer> writeInfo() throws IOException {
        FileWriter writer = new FileWriter(CreateFolderAndFile.createAndUseFile(), true);
        ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            try {
                RandomNumbers randomNumbers = new RandomNumbers();
                ConnectionToServer connectionToServer = new ConnectionToServer(randomNumbers.session,randomNumbers.time.getTime(),randomNumbers.ip);
                writer.write(connectionToServer + "\n");
                arrayList.add(connectionToServer);
            }catch (IOException a){
                System.out.println("record failed");
            }
        }
        writer.close();
        return arrayList;
    }
}
