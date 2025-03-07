/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class homework12_30 {
    public static void main(String[] args) {
        // 建立一個陣列來統計每個字母的出現次數
        // letterCount[0-25] 用於記錄 A-Z 的次數
        // letterCount[26-51] 用於記錄 a-z 的次數
        int[] letterCount = new int[52];

        // 提示使用者輸入檔案名稱
        Scanner input = new Scanner(System.in); // 用於讀取使用者輸入
        System.out.print("Enter a filename: "); // 提示訊息
        String filename = input.nextLine(); // 接收使用者輸入的檔案名稱

        try {
            // 嘗試讀取使用者指定的檔案
            File file = new File(filename); // 創建 File 物件
            Scanner fileScanner = new Scanner(file); // 用於逐行讀取檔案內容

            // 逐行讀取檔案內容
            while (fileScanner.hasNextLine()) { // 如果還有下一行，繼續處理
                String line = fileScanner.nextLine(); // 讀取當前行
                // 遍歷當前行的每個字元
                for (char c : line.toCharArray()) {
                    if (c >= 'A' && c <= 'Z') { // 如果是大寫字母 'A' 的 ASCII 值是 65，'Z' 的 ASCII 值是 90
                        letterCount[c - 'A']++; // 計算 A-Z 的出現次數
                    } else if (c >= 'a' && c <= 'z') { // 如果是小寫字母
                        letterCount[c - 'a' + 26]++; // 計算 a-z 的出現次數
                    }
                }
            }
            fileScanner.close(); // 關閉檔案掃描器

            // 顯示每個字母的次數（只顯示出現過的字母）
            for (int i = 0; i < 26; i++) { // 遍歷大寫字母 A-Z
                if (letterCount[i] > 0) { // 如果該字母出現過
                    System.out.println("Number of " + (char) ('A' + i) + "'s: " + letterCount[i]);
                }
            }
            for (int i = 0; i < 26; i++) { // 遍歷小寫字母 a-z
                if (letterCount[i + 26] > 0) { // 如果該字母出現過
                    System.out.println("Number of " + (char) ('a' + i) + "'s: " + letterCount[i + 26]);
                }
            }

        } catch (FileNotFoundException e) { // 如果檔案找不到
            System.out.println("File not found: " + filename); // 顯示錯誤訊息
        }

        input.close(); // 關閉使用者輸入的掃描器
    }
}
