/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
/*
類別名稱為 `Triangle`，繼承自 `GeometricObject`。此類別包含以下內容：
- 三個 double 型別的資料欄位，分別為 `side1`、`side2` 和 `side3`，其預設值均為 1.0，表示三角形的三個邊。
- 一個無參數的建構子，用來建立一個預設的三角形。
- 一個建構子，能根據指定的 `side1`、`side2` 和 `side3` 建立一個三角形。
- 所有三個資料欄位的存取方法（accessor methods）。
- 一個名為 `getArea()` 的方法，該方法返回此三角形的面積。面積的計算公式參見程式練習 2.19。
- 一個名為 `getPerimeter()` 的方法，該方法返回此三角形的周長。
- 一個名為 `toString()` 的方法，該方法返回三角形的字串描述，實現方式如下：
return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
撰寫一個測試程式，提示使用者輸入三角形的三個邊長、顏色，以及一個布林值以指示該三角形是否被填滿。
程式應根據這些邊長建立一個 `Triangle` 物件，並使用輸入的顏色和填滿屬性來設定對應的屬性。
最後，程式應顯示三角形的面積、周長、顏色，以及填滿狀態（true 或 false）。
*/

/*
GeometricObject
-------------------------
- color: String
- filled: boolean
-------------------------
+ GeometricObject()
+ GeometricObject(color: String, filled: boolean)
+ getColor(): String
+ setColor(color: String): void
+ isFilled(): boolean
+ setFilled(filled: boolean): void
+ toString(): String

GeometricObject UML 圖解釋：
1. 屬性 (Fields):
   - `color: String`：表示幾何物件的顏色，類型為 `String`。
   - `filled: boolean`：表示該幾何物件是否被填滿，類型為 `boolean`，用來儲存是否填滿的狀態。
2. 建構子 (Constructors):
   - `GeometricObject()`：無參數建構子，用於創建一個默認的幾何物件，顏色和填滿狀態可能會被設置為預設值。
   - `GeometricObject(color: String, filled: boolean)`：帶參數的建構子，允許指定顏色和填滿狀態來創建物件。
3. 方法 (Methods):
   - `getColor(): String`：用於返回幾何物件的顏色。
   - `setColor(color: String): void`：用於設定幾何物件的顏色，參數 `color` 是 `String` 類型。
   - `isFilled(): boolean`：用於返回是否填滿的狀態，結果為 `boolean` 類型。
   - `setFilled(filled: boolean): void`：用於設定物件的填滿狀態，參數 `filled` 是 `boolean` 類型。
   - `toString(): String`：返回該幾何物件的字串描述，通常會包括顏色和是否填滿的信息。

Triangle extends GeometricObject
-------------------------
- side1: double
- side2: double
- side3: double
-------------------------
+ Triangle()
+ Triangle(side1: double, side2: double, side3: double)
+ getSide1(): double
+ getSide2(): double
+ getSide3(): double
+ getArea(): double
+ getPerimeter(): double
+ toString(): String

Triangle UML 圖解釋：
1. 屬性 (Fields):
   - `side1: double`：表示三角形的第一邊長，類型為 `double`。
   - `side2: double`：表示三角形的第二邊長，類型為 `double`。
   - `side3: double`：表示三角形的第三邊長，類型為 `double`。
2. 建構子 (Constructors):
   - `Triangle()`：無參數建構子，用於創建一個默認的三角形，三個邊的長度都可能會設為預設值 1.0。
   - `Triangle(side1: double, side2: double, side3: double)`：帶參數的建構子，允許指定三個邊長來創建三角形物件。
3. 方法 (Methods):
   - `getSide1(): double`：返回三角形的第一邊長。
   - `getSide2(): double`：返回三角形的第二邊長。
   - `getSide3(): double`：返回三角形的第三邊長。
   - `getArea(): double`：計算並返回三角形的面積，基於三個邊的長度。
   - `getPerimeter(): double`：計算並返回三角形的周長，為三個邊長的總和。
   - `toString(): String`：返回該三角形的字串描述，包括三個邊的長度。
*/

/*
註解解說：
1. GeometricObject 類別：主要解釋了無參數建構子與帶參數建構子的用途，還有 color 和 filled 屬性的存取方法。
2. Triangle 類別：對無參數和帶參數建構子進行說明，還有如何計算三角形的面積與周長。
3. TestTriangle 類別：描述了如何從使用者那裡獲取輸入數據，並且創建 `Triangle` 物件來計算與顯示三角形的屬性。
*/
import java.util.Scanner;

// GeometricObject.java
class GeometricObject {
    private String color;
    private boolean filled;

    // 無參數建構子
    public GeometricObject() {
        this.color = "white";
        this.filled = false;
    }

    // 帶參數的建構子
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // 顏色的 getter 和 setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // filled 屬性的 getter 和 setter
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // toString 方法
    @Override
    public String toString() {
        return "GeometricObject [color=" + color + ", filled=" + filled + "]";
    }
}

// Triangle.java
class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    // 無參數建構子，用於建立預設三角形
    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    // 帶參數的建構子，指定三個邊長
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // 存取方法（getter 方法）
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // 使用海龍公式計算三角形面積的方法
    public double getArea() {
        double s = (side1 + side2 + side3) / 2; // 半周長
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // 計算周長的方法
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // toString 方法
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

// TestTriangle.java

public class TestTriangle {
    public static void main(String[] args) {
        // 建立一個 Scanner 物件以供使用者輸入
        Scanner input = new Scanner(System.in);

        // 提示使用者輸入三角形的三個邊長
        System.out.print("Enter side1 of the triangle: ");
        double side1 = input.nextDouble();
        System.out.print("Enter side2 of the triangle: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side3 of the triangle: ");
        double side3 = input.nextDouble();

        // 提示使用者輸入顏色
        System.out.print("Enter the color of the triangle: ");
        String color = input.next();

        // 提示使用者輸入三角形是否被填滿
        System.out.print("Is the triangle filled (true/false): ");
        boolean filled = input.nextBoolean();

        // 使用使用者輸入的資料建立一個 Triangle 物件
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        // 顯示三角形的面積、周長、顏色和填滿狀態
        System.out.println("The area of the triangle is: " + triangle.getArea());
        System.out.println("The perimeter of the triangle is: " + triangle.getPerimeter());
        System.out.println("The color of the triangle is: " + triangle.getColor());
        System.out.println("Is the triangle filled? " + triangle.isFilled());

        // 關閉 Scanner
        input.close();
    }
}

