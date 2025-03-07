/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.util.Scanner;

public class HWK12_2_MonthDays {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入1-12其中一個數字: ");
        
        try {
            int monthIndex = scanner.nextInt() - 1;
            System.out.println(months[monthIndex] + " 有 " + dom[monthIndex] + " 天");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("輸入的數字不在範圍內");
        }
    }
}
