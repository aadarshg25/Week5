package com.tit.week05.day01.csvhandling.basicproblems.writecsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class WriteCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\EmployeeData.csv";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Number of Columns: ");
        int coln = input.nextInt();
        System.out.println("Enter the Number of Entries: ");
        int rown = input.nextInt() +1;
        String employeeDetails[][] = new String[rown][coln];
        System.out.println("Enter the Header to the File : ");
        for (int i = 0; i < coln; i++) {
            employeeDetails[0][i] = input.next();
        }
        for (int i = 1; i < rown; i++) {
            for (int j = 0; j < coln; j++) {
                System.out.println("Enter the " + employeeDetails[0][j]);
                employeeDetails[i][j] = input.next();
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            for (int i = 0; i < rown; i++) {
                for (int j = 0; j < coln; j++) {
                    if(j == coln-1){
                        bw.write(employeeDetails[i][j]);
                    }else{
                        bw.write(employeeDetails[i][j] + ",");
                    }

                }
                bw.write("\n");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
