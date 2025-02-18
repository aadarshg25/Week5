package com.tit.week05.day01.csvhandling.advancedproblems.readlargecsv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\large_file.csv";
        int batchSize = 100;
        int totalRecordsProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;
                totalRecordsProcessed++;

                if (count == batchSize) {
                    System.out.println("Processed " + totalRecordsProcessed + " records...");
                    count = 0;
                }
            }

            System.out.println("Total Records Processed: " + totalRecordsProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

