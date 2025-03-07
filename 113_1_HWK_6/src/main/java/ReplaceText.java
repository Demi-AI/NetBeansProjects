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

public class ReplaceText {
  public static void main(String[] args) throws Exception {
    // 檢查命令行參數的使用情況
    if (args.length != 4) {
      System.out.println(
        "Usage: java ReplaceText sourceFile targetFile oldStr newStr");
      System.exit(1);
    }
    
    // 檢查來源文件是否存在
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
      System.out.println("Source file " + args[0] + " does not exist");
      System.exit(2);
    }
    
    // 輸出原始文件名和內容
    System.out.println("Original File: " + args[0]);
    List<String> originalContent = new ArrayList<>();
    try (Scanner input = new Scanner(sourceFile)) {
      while (input.hasNextLine()) {
        String line = input.nextLine();
        originalContent.add(line);
        System.out.println(line);
      }
    }
    
    System.out.println(); // 空行分隔
    
    // 輸出新文件名和內容
    System.out.println("New File: " + args[1]);
    List<String> newContent = new ArrayList<>();
    for (String line : originalContent) {
      String newLine = line.replaceAll(args[2], args[3]);
      newContent.add(newLine);
      System.out.println(newLine);
    }
    
    // 檢查目標文件是否存在並提示
    if (new File(args[1]).exists()) {
      System.out.println("\nTarget file " + args[1] + " already exists");
    } else {
      try (PrintWriter output = new PrintWriter(args[1])) {
        for (String newLine : newContent) {
          output.println(newLine);
        }
      }
    }
  }
}
