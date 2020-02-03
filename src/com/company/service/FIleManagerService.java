package com.company.service;


import com.company.model.ConnectionToServer;
import java.io.File;
import java.io.FileReader;
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
    }

    public static void writeToFile(String fileName, ConnectionToServer obj, boolean append) throws IOException {
        FileWriter writer = new FileWriter(pathFile + File.separator + fileName, append);
            try {
                writer.write(obj + "\n");
                writer.flush();
            }catch (IOException a){
                System.out.println("record failed");
            }
        writer.close();
    }

    public static  ArrayList<ConnectionToServer> readInfo(String fileName) throws IOException {
        FileReader reader = new FileReader(pathFile + File.separator + fileName);
        ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()){
            String string = scanner.nextLine();
            String[] arr = string.split(" ");
            ConnectionToServer connectionToServer = new ConnectionToServer(Integer.parseInt(arr[1]), Long.parseLong(arr[0]),arr[2]);
            arrayList.add(connectionToServer);
        }
        reader.close();
        return arrayList;
    }

    public static void deleteOldInfo(long time, String fileName) throws IOException {
        boolean append = false;
        ArrayList<ConnectionToServer> arrayList = readInfo(fileName);
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).getTimestamp() >= time){
                writeToFile(fileName, arrayList.get(i), append);
                append = true;
            }
        }
    }
}
