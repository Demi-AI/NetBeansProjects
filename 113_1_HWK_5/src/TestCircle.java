/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */

// Point類別
class Point {
    protected int x;  // x 軸位置
    protected int y;  // y 軸位置

    // 帶參數的建構子，初始化 x 和 y
    public Point(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    // 無參數的建構子，將 x 和 y 初始化為 0
    public Point() {
        this(0, 0);
    }

    // 設定 x 和 y 的方法
    public void setPoint(int setX, int setY) {
        this.x = setX;
        this.y = setY;
    }
}

// Circle類別
class Circle extends Point {
    private double radius;  // 半徑

    // 帶參數的建構子，使用 super 方法初始化 x 和 y，並初始化 radius
    public Circle(int x, int y, double length) {
        super(x, y);
        this.radius = length;
    }

    // 計算面積的方法
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // 返回描述此圓形的字串
    @Override
    public String toString() {
        return String.format("Center: (%d, %d); Radius = %.2f;", x, y, radius);
    }
}

// TestCircle.java 類別，用於測試 Circle 類別
public class TestCircle {
    public static void main(String[] args) {
        // 創建 Circle 物件
        Circle circle = new Circle(5, 5, 5.0);

        // 輸出圓心、半徑和面積
        System.out.println(circle);  // 預期: Center: (5, 5); Radius = 5.00;
        System.out.printf("Area = %.2f\n", circle.getArea());  // 預期: Area = 78.54
    }
}
