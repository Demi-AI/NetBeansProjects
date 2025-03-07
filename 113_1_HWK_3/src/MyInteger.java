/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
/*
+----------------------+
|      MyInteger        |
+----------------------+
| - value: int          |
+----------------------+
| + MyInteger(value: int)|
| + getValue(): int     |
| + isEven(): boolean   |
| + isOdd(): boolean    |
| + isPrime(): boolean  |
| + isEven(int value): boolean |
| + isOdd(int value): boolean  |
| + isPrime(int value): boolean|
| + isEven(MyInteger obj): boolean |
| + isOdd(MyInteger obj): boolean  |
| + isPrime(MyInteger obj): boolean|
| + equals(int value): boolean    |
| + equals(MyInteger obj): boolean|
| + parseInt(chars: char[]): int  |
| + parseInt(str: String): int    |
+----------------------+
*/
public class MyInteger {
    private int value;

    // 建構函式，接收 int 值
    public MyInteger(int value) {
        this.value = value;
    }

    // 取得 value 的值
    public int getValue() {
        return value;
    }

    // 檢查是否為偶數
    public boolean isEven() {
        return value % 2 == 0;
    }

    // 檢查是否為奇數
    public boolean isOdd() {
        return value % 2 != 0;
    }

    // 檢查是否為質數
    public boolean isPrime() {
        if (value < 2) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    // 靜態方法：檢查特定 int 是否為偶數
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    // 靜態方法：檢查特定 int 是否為奇數
    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    // 靜態方法：檢查特定 int 是否為質數
    public static boolean isPrime(int value) {
        if (value < 2) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    // 靜態方法：檢查 MyInteger 物件是否為偶數
    public static boolean isEven(MyInteger obj) {
        return obj.isEven();
    }

    // 靜態方法：檢查 MyInteger 物件是否為奇數
    public static boolean isOdd(MyInteger obj) {
        return obj.isOdd();
    }

    // 靜態方法：檢查 MyInteger 物件是否為質數
    public static boolean isPrime(MyInteger obj) {
        return obj.isPrime();
    }

    // 檢查物件值是否等於特定 int 值
    public boolean equals(int value) {
        return this.value == value;
    }

    // 檢查物件值是否等於另一個 MyInteger 物件的值
    public boolean equals(MyInteger obj) {
        return this.value == obj.getValue();
    }

    // 靜態方法：將 char 陣列轉換為 int 值
    public static int parseInt(char[] chars) {
        return Integer.parseInt(new String(chars));
    }

    // 靜態方法：將字串轉換為 int 值
    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    // 測試 MyInteger 類別
    public static void main(String[] args) {
        MyInteger num1 = new MyInteger(7);
        MyInteger num2 = new MyInteger(10);

        // 測試 isEven(), isOdd(), isPrime()
        System.out.println("num1 is even: " + num1.isEven());
        System.out.println("num1 is odd: " + num1.isOdd());
        System.out.println("num1 is prime: " + num1.isPrime());

        // 測試靜態方法 isEven(), isOdd(), isPrime()
        System.out.println("10 is even: " + MyInteger.isEven(10));
        System.out.println("7 is prime: " + MyInteger.isPrime(7));

        // 測試 equals 方法
        System.out.println("num1 equals 7: " + num1.equals(7));
        System.out.println("num1 equals num2: " + num1.equals(num2));

        // 測試 parseInt 方法
        char[] chars = {'1', '2', '3'};
        System.out.println("Parse chars to int: " + MyInteger.parseInt(chars));
        System.out.println("Parse string to int: " + MyInteger.parseInt("456"));
    }
}
