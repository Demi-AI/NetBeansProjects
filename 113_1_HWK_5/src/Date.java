/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Date {
    private int day;     // 1 到 31
    private int month;   // 1 到 12
    private int year;    // 例如，2014
    
    final static int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // 建構函式
    public Date(int m, int d, int y) {
        this.year = y;
        
        // 設定月份
        if (m >= 1 && m <= 12) {
            this.month = m;
        } else {
            this.month = 1;
        }

        // 根據年份是否為閏年設定日期
        int maxDays = daysPerMonth[this.month];
        if (this.month == 2 && checkLeap(this.year)) {
            maxDays = 29;
        }
        
        if (d >= 1 && d <= maxDays) {
            this.day = d;
        } else {
            this.day = 1;
        }
    }

    // 靜態方法：檢查某年份是否為閏年
    public static boolean checkLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    // 實例方法：檢查物件年份是否為閏年
    public boolean isLeap() {
        return checkLeap(this.year);
    }

    // 以 mm/dd/yyyy 格式傳回日期字串
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.month, this.day, this.year);
    }

    // 計算該日期是所在年份的第幾天
    public int yearDate() {
        int dayOfYear = this.day;
        for (int i = 1; i < this.month; i++) {
            dayOfYear += daysPerMonth[i];
        }
        if (this.month > 2 && isLeap()) {
            dayOfYear += 1;
        }
        return dayOfYear;
    }

    // 主程式
    public static void main(String[] args) {
        // 將 d1 的值替換為你的實際生日
        Date d1 = new Date(12, 27, 2003);  // 範例：替換為實際生日
        Date d2 = new Date(12, 31, 2023);
        Date d3 = new Date(2, 29, 2024);
        Date d4 = new Date(2, 29, 2025);  // 非閏年的無效日期
        
        System.out.println("日期 d1: " + d1 + " - 年內第幾天: " + d1.yearDate());
        System.out.println("日期 d2: " + d2 + " - 年內第幾天: " + d2.yearDate());
        System.out.println("日期 d3: " + d3 + " - 年內第幾天: " + d3.yearDate());
        System.out.println("日期 d4: " + d4 + " - 年內第幾天: " + d4.yearDate());
    }
}

