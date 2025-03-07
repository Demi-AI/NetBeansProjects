/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
/*
以下是關於 Rational 類別的設計與描述：
設計一個名為 Rational 的類別。該類別包含：
1. 兩個 `int` 資料欄位，用於表示分子和分母。
2. 一個構造函數，用於創建指定分子和分母的 Rational 物件。
3. 分別返回分子和分母的 getter 方法。
4. 一個 `normalize()` 方法，該方法返回一個新的 Rational 物件，該物件與當前 Rational 物件具有相同的小數值，但分子不再能被分母整除。
（具體來說，它將一個值 P1/Q1 轉換為等價的 P2/Q2，使得 P2 不能被 Q2 整除。
提示：您需要找到當前 Rational 的分子和分母的最大公約數來實現這一點。）
5. `isWhole()` 和 `isDecimal()` 方法，這兩個方法分別返回 true，以檢查該有理數是否為整數或具有小數部分。
6. `equals(int numerator, int denominator)` 和 `equals(Rational r)` 方法，
這些方法返回 true，當分子和分母值在正規化後相等時。
7. 一個靜態方法 `parseRational(char[], char[])`，該方法將兩個數字字符陣列轉換為 Rational 物件。
8. 一個靜態方法 `parseRational(String)`，該方法將包含由 '/' 分隔的數字字符的字符串轉換為 Rational 物件。
另外，請繪製該類別的 UML 圖，並實現該類別。撰寫一個客戶端程式，來測試該類別中的所有方法。
*/

/*
+---------------------+
|       Rational      |
+---------------------+
| - numerator: int    |
| - denominator: int   |
+---------------------+
| + Rational(numerator: int, denominator: int) |
| + getNumerator(): int |
| + getDenominator(): int |
| + normalize(): Rational |
| + isWhole(): boolean   |
| + isDecimal(): boolean  |
| + equals(numerator: int, denominator: int): boolean |
| + equals(r: Rational): boolean |
| + parseRational(numChars: char[], denomChars: char[]): Rational |
| + parseRational(str: String): Rational |
+---------------------+

UML 圖解釋：
- 類別名稱: Rational
- 屬性:
  - `numerator`：表示分子的整數型態欄位
  - `denominator`：表示分母的整數型態欄位
- 方法:
  - `Rational(numerator: int, denominator: int)`：構造函數
  - `getNumerator()`：返回分子
  - `getDenominator()`：返回分母
  - `normalize()`：返回一個標準化的 Rational 物件
  - `isWhole()`：檢查是否為整數
  - `isDecimal()`：檢查是否為小數
  - `equals(numerator: int, denominator: int)`：檢查分子和分母是否相等
  - `equals(r: Rational)`：檢查兩個 Rational 物件是否相等
  - `parseRational(numChars: char[], denomChars: char[])`：從字符陣列解析 Rational 物件
  - `parseRational(str: String)`：從字符串解析 Rational 物件
這個 UML 圖表述了 Rational 類別的結構及其方法，提供了一個清晰的視覺表示。
*/

public class Rational {
    private int numerator; // 分子
    private int denominator; // 分母

    // 建構子，使用指定的分子和分母建立Rational物件
    public Rational(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    // 獲取分子
    public int getNumerator() {
        return numerator;
    }

    // 獲取分母
    public int getDenominator() {
        return denominator;
    }

    // 將分數標準化，返回一個新的Rational物件
    public Rational normalize() {
        int gcd = gcd(numerator, denominator);
        return new Rational(numerator / gcd, denominator / gcd);
    }

    // 檢查是否為整數
    public boolean isWhole() {
        return numerator % denominator == 0;
    }

    // 檢查是否為小數
    public boolean isDecimal() {
        return !isWhole();
    }

    // 判斷兩個數值是否相等（使用分子和分母）
    public boolean equals(int numerator, int denominator) {
        Rational r = new Rational(numerator, denominator);
        return this.numerator == r.numerator && this.denominator == r.denominator;
    }

    // 判斷兩個Rational物件是否相等
    public boolean equals(Rational r) {
        return this.numerator == r.numerator && this.denominator == r.denominator;
    }

    // 解析字符陣列，將其轉換為Rational物件
    public static Rational parseRational(char[] numChars, char[] denomChars) {
        int numerator = Integer.parseInt(new String(numChars));
        int denominator = Integer.parseInt(new String(denomChars));
        return new Rational(numerator, denominator);
    }

    // 解析字符串，將其轉換為Rational物件
    public static Rational parseRational(String str) {
        String[] parts = str.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return new Rational(numerator, denominator);
    }

    // 計算最大公因數
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 測試方法
    public static void main(String[] args) {
        Rational r1 = new Rational(4, 8);
        Rational r2 = new Rational(2, 4);

        // 顯示標準化結果
        System.out.println("r1 標準化: " + r1.normalize().getNumerator() + "/" + r1.normalize().getDenominator());

        // 檢查是否為整數或小數
        System.out.println("r1 是否為整數: " + r1.isWhole());
        System.out.println("r1 是否為小數: " + r1.isDecimal());

        // 比較r1與r2是否相等
        System.out.println("r1 與 r2 是否相等: " + r1.equals(r2));

        // 使用字串解析Rational物件
        Rational r3 = Rational.parseRational("6/9");
        System.out.println("r3 的值: " + r3.getNumerator() + "/" + r3.getDenominator());
    }
}

