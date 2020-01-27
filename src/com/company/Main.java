package com.company;

import com.company.model.ConnectionToServer;
import com.company.service.CreateFolderAndFile;
import com.company.util.RandomNumbers;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        CreateFolderAndFile createFolderAndFile = new CreateFolderAndFile();
        createFolderAndFile.createNewFolder();
        writeInfo(createFolderAndFile.createAndUseFile());
        deleteOldInfo(createFolderAndFile.createAndUseFile());
        readInfo(createFolderAndFile.createAndUseFile());
    }


    public static void writeInfo(File file) throws IOException{
        FileWriter writer = new FileWriter(file, true);
        for (int i = 0; i < 10; i++){
            try {
                RandomNumbers randomNumbers = new RandomNumbers();
                writer.write(new ConnectionToServer(randomNumbers.session,randomNumbers.time.getTime(),randomNumbers.ip) + "\n");
            }catch (IOException a){
                System.out.println("запись не прошла");
            }
        }
        writer.close();
    }


    public static void readInfo(File file) throws IOException{
        FileReader reader = new FileReader(file);
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

    public static void deleteOldInfo(File file) throws IOException {
    long threeDays = 1000*60*60*24*3;
    ArrayList<ConnectionToServer> arrayList = new ArrayList<>();
         Date time = new Date();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String string = scanner.nextLine();
            String[] arr = string.split(" ");
                if (time.getTime() - threeDays <= Long.parseLong(arr[0])){
                    ConnectionToServer connectionToServer = new ConnectionToServer(Integer.parseInt(arr[1]), Long.parseLong(arr[0]),arr[2]);
                    arrayList.add(connectionToServer);
                }
        }
        FileWriter writer = new FileWriter(file, false);
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
