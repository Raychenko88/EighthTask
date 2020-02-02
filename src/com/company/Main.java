package com.company;


import com.company.model.ConnectionToServer;
import com.company.service.FIleManagerService;
import com.company.util.RandomNumbers;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "log";
        String fileName = "test.txt";
        FIleManagerService.createFolderAndFile(filePath,fileName);
        for (int i = 0; i < 10; i++){
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
            FIleManagerService.writeToFile(fileName, connectionToServer, true);
        }
        FIleManagerService.deleteOldInfo(new Date().getTime() - 1000 , fileName);
    }
}
