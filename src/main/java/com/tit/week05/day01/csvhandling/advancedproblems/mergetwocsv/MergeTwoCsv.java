package com.tit.week05.day01.csvhandling.advancedproblems.mergetwocsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoCsv {
    public static void main(String[] args) {
        String filePath1 = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\Students1.csv";
        String filePath2 = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\Students2.csv";
        String writePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\UpdatedStudent.csv";

        Map<String, String> studentData = new HashMap<>();

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(filePath1));
                BufferedReader br2 = new BufferedReader(new FileReader(filePath2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(writePath))
        ) {
            String line;
            boolean isHeader = true;

            // Read the second CSV and store data based on ID
            while ((line = br2.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];  // Assuming ID is in the first column
                String marksGrade = columns[1] + "," + columns[2];  // Marks and Grade are in second and third columns
                studentData.put(id, marksGrade);
            }

            // Write the merged CSV

            while ((line = br1.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];  // Assuming ID is in the first column

                if (isHeader) {
                    bw.write(String.join(",", columns) + ",Marks,Grade");  // Add new columns for Marks and Grade
                    bw.newLine();
                    isHeader = false;
                } else {
                    // Merge data from the second CSV using the ID
                    String marksGrade = studentData.get(id);
                    if (marksGrade != null) {
                        bw.write(String.join(",", columns) + "," + marksGrade);
                    } else {
                        bw.write(String.join(",", columns) + ",,");  // If no matching ID, leave empty
                    }
                    bw.newLine();
                }
            }

            System.out.println("CSV files merged successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
