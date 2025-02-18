package com.tit.week05.day01.csvhandling.basicproblems.countrowscsvfile;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountRowsCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\StudentData.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int countRows = 0;
            while((line = br.readLine()) != null){
                countRows++;
            }
            System.out.println("Number of Rows : " + (countRows-1));
        } catch (Exception e) {
            System.out.println("File Not Found!");
        }
    }
}
