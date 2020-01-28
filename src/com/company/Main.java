package com.company;

import com.company.model.ConnectionToServer;
import com.company.service.CheckFilesByDate;
import com.company.service.ReadFromFile;
import com.company.service.WriteToFile;

public class Main {

    public static void main(String[] args) throws Exception {
        for (ConnectionToServer a : WriteToFile.writeInfo()){
            System.out.println(a + " AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
        for (String b : ReadFromFile.readInfo()){
            System.out.println(b + " BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        }
        for (ConnectionToServer c : CheckFilesByDate.deleteOldInfo(1)){
            System.out.println(c + " CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        }
    }
}
