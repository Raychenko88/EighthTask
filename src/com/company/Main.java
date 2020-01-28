package com.company;

import com.company.util.CheckFilesByDate;
import com.company.util.ReadFromFile;
import com.company.util.WriteToFile;

public class Main {

    public static void main(String[] args) throws Exception {
        WriteToFile.writeInfo();
        ReadFromFile.readInfo();
        CheckFilesByDate.deleteOldInfo();
    }
}
