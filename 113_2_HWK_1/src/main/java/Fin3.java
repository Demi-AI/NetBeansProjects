/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.io.*;
import java.util.*;

public class Fin3 {
    public static void main(String[] args) {
        try {
            File file = new File("scores.txt");
            Scanner scanner = new Scanner(file);
            int lineCount = 0, wordCount = 0;
            
            List<String[]> data = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;
                String[] words = line.split(" ");
                wordCount += words.length;
                data.add(words);
            }
            scanner.close();

            System.out.println("File scores.txt has " + lineCount + " lines " + wordCount + " words");

            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.print("please enter id: ");
                String id = input.next();
                boolean found = false;

                for (String[] row : data) {
                    if (row[1].equals(id)) {
                        System.out.println(row[0] + " " + row[2] + " " + row[3]);
                        found = true;
                        break;
                    }
                }

                if (found) break;
                System.out.println("not in file, try again");
            }
            input.close();
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }
}

