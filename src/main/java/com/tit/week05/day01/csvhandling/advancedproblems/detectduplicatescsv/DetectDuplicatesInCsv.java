package com.tit.week05.day01.csvhandling.advancedproblems.detectduplicatescsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DetectDuplicatesInCsv{
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\StudentData.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            HashSet<String> uniqueIds = new HashSet<>();
            reader.readNext();

            String[] line;
            while ((line = reader.readNext()) != null) {
                String id = line[0];

                if (!uniqueIds.add(id)) {
                    System.out.println("Duplicate record found: " + String.join(", ", line));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

