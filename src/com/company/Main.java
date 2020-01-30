package com.company;


import com.company.model.ConnectionToServer;
import com.company.service.FIleManagerService;
import com.company.util.RandomNumbers;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "log";
        String fileName = "test.txt";
        ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
        FIleManagerService.createFolderAndFile(filePath,fileName);
        for (int i = 0; i < 10; i++){
            RandomNumbers randomNumbers = new RandomNumbers();
            ConnectionToServer obj = new ConnectionToServer(randomNumbers.session,randomNumbers.time.getTime(),randomNumbers.ip);
            FIleManagerService.writeToFile(fileName, obj);
        }
        FIleManagerService.deleteOldInfo(1, fileName);
    }
}
