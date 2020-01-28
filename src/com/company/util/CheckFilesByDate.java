package com.company.util;

import com.company.model.ConnectionToServer;
import com.company.service.CreateFolderAndFile;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CheckFilesByDate {

    public static void deleteOldInfo() throws IOException {
        long threeDays = 1000*60*60*24*3;
        ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
        Date time = new Date();
        Scanner scanner = new Scanner(CreateFolderAndFile.createAndUseFile());
        while (scanner.hasNextLine()){
            String string = scanner.nextLine();
            String[] arr = string.split(" ");
            if (time.getTime() - threeDays <= Long.parseLong(arr[0])){
                ConnectionToServer connectionToServer = new ConnectionToServer(Integer.parseInt(arr[1]), Long.parseLong(arr[0]),arr[2]);
                arrayList.add(connectionToServer);
            }
        }
        FileWriter writer = new FileWriter(CreateFolderAndFile.createAndUseFile(), false);
        for (int i = 0; i < arrayList.size(); i++){
            try {
                writer.write(arrayList.get(i) + "\n");
            }catch (IOException a){
                System.out.println("запись не прошла");
            }
        }
        writer.close();
    }
}
