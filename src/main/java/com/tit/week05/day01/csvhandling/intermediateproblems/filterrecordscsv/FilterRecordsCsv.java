package com.tit.week05.day01.csvhandling.intermediateproblems.filterrecordscsv;

import java.io.BufferedReader;
import java.io.FileReader;

public class FilterRecordsCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\StudentData.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Qualifying Records : ");
            int marksCol = -1;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");

                if (isHeader) {
                    for (int i = 0; i < col.length; i++) {
                        if (col[i].equalsIgnoreCase("Marks")) {
                            marksCol = i;
                        }
                    }
                    if (marksCol == -1) {
                        System.out.println("Marks column not found!");
                        return;
                    }
                    System.out.println(String.join("\t", col));
                    isHeader = false;
                } else {
                    if (Integer.parseInt(col[marksCol]) > 80) {
                        System.out.println(String.join("\t", col));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("File Not Found!");
        }
    }
}
