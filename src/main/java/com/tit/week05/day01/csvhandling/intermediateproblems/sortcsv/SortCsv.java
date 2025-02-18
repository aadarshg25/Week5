package com.tit.week05.day01.csvhandling.intermediateproblems.sortcsv;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class SortCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\EmployeeData.csv";
        System.out.println("Top 5 highest-paid employees : ");
        ArrayList<String> highestPaid = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int salaryCol = -1;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String col[] = line.split(",");
                if (isHeader) {
                    for (int i = 0; i < col.length; i++) {
                        if (col[i].equalsIgnoreCase("salary")) {
                            salaryCol = i;
                        }
                    }
                    if (salaryCol == -1) {
                        System.out.println("salary column not found!");
                        return;
                    }
                    System.out.println(String.join(" " , col));
                    isHeader = false;
                } else {
                        highestPaid.add(String.join(" ",col));
                }
            }
            Collections.sort(highestPaid, new Comparator<String>() {
                @Override
                public int compare(String emp1, String emp2) {
                    // Split the strings to extract salary (last part)
                    String[] empDetails1 = emp1.split(" ");
                    String[] empDetails2 = emp2.split(" ");

                    int salary1 = Integer.parseInt(empDetails1[empDetails1.length - 1]);
                    int salary2 = Integer.parseInt(empDetails2[empDetails2.length - 1]);


                    return Integer.compare(salary2, salary1);
                }
            });
            for (int i =0 ;i < 5 ;i ++) {
                System.out.println(highestPaid.get(i));
            }
        } catch (Exception e) {
            System.out.println("File Not Found!");
        }
    }
}
