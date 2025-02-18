package com.tit.week05.day01.csvhandling.basicproblems.readcsvfile;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\StudentData.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                String col[] = line.split(",");
                for (int i = 0; i < col.length; i++) {
                    System.out.print( col[i]+ "\t\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("File Not Found!");
        }
    }
}
