package com.company.service;


import com.company.model.ConnectionToServer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FIleManagerService {
    static String pathFile;

    public static void createFolderAndFile(String path,String fileName) {
        pathFile = path;
        File filePath = new File(path);                          // указываем путь где должна быть папка
        if (!filePath.exists()) {
            filePath.mkdir();                                        // создаем папку (mkdir - true) если папка создана (mkdir - false)
        }
        File file = new File(filePath + File.separator + fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();                                      // создаем папку (mkdir - true) если папка создана (mkdir - false)
            }
        }catch (
                IOException a){
            System.out.println("Something went wrong");
        }
    }

    public static ArrayList<ConnectionToServer> writeToFile(String fileName, ConnectionToServer obj) throws IOException {
        ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
        FileWriter writer = new FileWriter(pathFile + File.separator + fileName, true);
            try {
                writer.write(obj + "\n");
                arrayList.add(obj);
            }catch (IOException a){
                System.out.println("record failed");
            }
        writer.close();
        return arrayList;
    }

    public static ArrayList<ConnectionToServer> deleteOldInfo(int days, String fileName) throws IOException {
        File file = new File(pathFile + File.separator + fileName);
        long allDays = 1000*60*60*24*days;
        ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
        Date time = new Date();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String string = scanner.nextLine();
            String[] arr = string.split(" ");
            if (time.getTime() - allDays <= Long.parseLong(arr[0])){
                ConnectionToServer connectionToServer = new ConnectionToServer(Integer.parseInt(arr[1]), Long.parseLong(arr[0]),arr[2]);
                arrayList.add(connectionToServer);
            }
        }
        FileWriter writer = new FileWriter(CreateFolderAndFile.createAndUseFile(), false);
        for (int i = 0; i < arrayList.size(); i++){
            try {
                writer.write(arrayList.get(i) + "\n");
            }catch (IOException a){
                System.out.println("record failed");
            }
        }
        writer.close();
        return arrayList;
    }
}
