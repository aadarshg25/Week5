package com.tit.week05.day01.csvhandling.advancedproblems.encryptdecryptcsv;

import java.io.*;
import java.util.Base64;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class EncryptDecryptCsv {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\EmployeeData.csv";
        String outputFile = "C:\\Users\\ASUS\\Desktop\\Week5\\src\\main\\resources\\employees_encrypted.csv";

        encryptAndWriteCSV(inputFile, outputFile);

        decryptAndReadCSV(outputFile);
    }

    public static void encryptAndWriteCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String line;
            writer.writeNext(new String[]{"ID", "Name", "Email", "Salary"});

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                data[2] = encrypt(data[2]);
                data[3] = encrypt(data[3]);

                writer.writeNext(data);
            }

            System.out.println("Encrypted data has been written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptAndReadCSV(String inputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            String[] line;
            reader.readNext();

            while ((line = reader.readNext()) != null) {
                line[2] = decrypt(line[2]);
                line[3] = decrypt(line[3]);

                System.out.println("ID: " + line[0] + ", Name: " + line[1] + ", Email: " + line[2] + ", Salary: " + line[3]);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String decrypt(String data) {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        return new String(decodedBytes);
    }
}
