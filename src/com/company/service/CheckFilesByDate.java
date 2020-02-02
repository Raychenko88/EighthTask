package com.company.service;

import com.company.model.ConnectionToServer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CheckFilesByDate {

//    public static ArrayList<ConnectionToServer> deleteOldInfo(int days) throws IOException {
//        long threeDays = 1000*60*60*24*days;
//        ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
//        Date time = new Date();
//        Scanner scanner = new Scanner(CreateFolderAndFile.createAndUseFile());
//        while (scanner.hasNextLine()){
//            String string = scanner.nextLine();
//            String[] arr = string.split(" ");
//            if (time.getTime() - threeDays <= Long.parseLong(arr[0])){
//                ConnectionToServer connectionToServer = new ConnectionToServer(Integer.parseInt(arr[1]), Long.parseLong(arr[0]),arr[2]);
//                arrayList.add(connectionToServer);
//            }
//        }
//        FileWriter writer = new FileWriter(CreateFolderAndFile.createAndUseFile(), false);
//        for (int i = 0; i < arrayList.size(); i++){
//            try {
//                writer.write(arrayList.get(i) + "\n");
//            }catch (IOException a){
//                System.out.println("record failed");
//            }
//        }
//        writer.close();
//        return arrayList;
//    }
}
