package com.tit.week05.day01.csvhandling.intermediateproblems.modifycsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ModifyCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\EmployeeData.csv";
        String writePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\UpdatedEmployeeData.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(writePath))){
            String line;
            int departmentCol = -1;
            boolean isHeader = true;
            int salary =0;
            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");
                if (isHeader) {
                    for (int i = 0; i < col.length; i++) {
                        if (col[i].equalsIgnoreCase("department")) {
                            departmentCol = i;
                        }
                    }
                    if (departmentCol == -1) {
                        System.out.println("department column not found!");
                        return;
                    }
                    bw.write(String.join("\t", col));
                    bw.newLine();
                    isHeader = false;
                } else {
                    if (col[departmentCol].equalsIgnoreCase("IT")) {
                        int currentSalary = Integer.parseInt(col[3]);
                        salary = (int) (0.1f * currentSalary) + currentSalary;
                        col[3] = String.valueOf(salary);
                    }
                    bw.write(String.join("\t", col));
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            System.out.println("File Not Found!");
        }
    }
}
