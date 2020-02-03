package com.company.service;

import com.company.model.ConnectionToServer;
import com.company.util.RandomNumbers;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FIleManagerServiceTest {
    String pathFile = System.getProperty("user.dir") + System.getProperty("file.separator") + "log";
    String fileName = "testForTest.txt";
    @Test
    void writeToFile() throws IOException {
        FIleManagerService.createFolderAndFile(pathFile,fileName);
        ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            ConnectionToServer connectionToServer = new ConnectionToServer();
            connectionToServer.setSession(RandomNumbers.getRandom(1000000, 9999999));
            connectionToServer.setTimestamp(new Date().getTime() - RandomNumbers.getRandom(50000000, 100000000));
            connectionToServer.setIp(
                    RandomNumbers.getRandom(1,255) + "." +
                            RandomNumbers.getRandom(1,255) + "." +
                            RandomNumbers.getRandom(1,255) + "." +
                            RandomNumbers.getRandom(1,255)  );
            if (i == 3){
                connectionToServer.setTimestamp(new Date().getTime());
            }
            arrayList.add(connectionToServer);
            FIleManagerService.writeToFile(fileName, connectionToServer, true);
        }
        ArrayList<ConnectionToServer> arrayList1 = FIleManagerService.readInfo(fileName);
        assert (arrayList.toString().equals(arrayList1.toString()));




    }

    @Test
    void deleteOldInfo() throws IOException {
        long time = new Date().getTime() - 1000 * 60;
        boolean append = false;
        ArrayList<ConnectionToServer> arrayList = FIleManagerService.readInfo(fileName);
        ArrayList<ConnectionToServer> arrayListRemove = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).getTimestamp() >= time){
                FIleManagerService.writeToFile(fileName, arrayList.get(i), append);
                arrayListRemove.add(arrayList.get(i));
                append = true;
            }
        }
        ArrayList<ConnectionToServer> arrayList1 = FIleManagerService.readInfo(fileName);
        System.out.println(arrayListRemove.toString());
        System.out.println(arrayList1.toString());
        assert (arrayListRemove.toString().equals(arrayList1.toString()));
    }
}