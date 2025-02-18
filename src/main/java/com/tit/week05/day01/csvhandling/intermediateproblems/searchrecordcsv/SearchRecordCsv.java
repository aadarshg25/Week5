package com.tit.week05.day01.csvhandling.intermediateproblems.searchrecordcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class SearchRecordCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\EmployeeData.csv";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Employee : ");
        String name = sc.next();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int nameCol = -1;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");
                if (isHeader) {
                    for (int i = 0; i < col.length; i++) {
                        if (col[i].equalsIgnoreCase("Name")) {
                            nameCol = i;
                        }
                    }
                    if (nameCol == -1) {
                        System.out.println("Name column not found!");
                        return;
                    }
                    System.out.println(String.join("\t", col[2],col[3]));
                    isHeader = false;
                } else {
                    if (col[nameCol].equalsIgnoreCase(name)) {
                        System.out.println(String.join("\t\t", col[2],col[3]));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("File Not Found!");
        }
    }
}
