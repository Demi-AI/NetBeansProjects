/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
// GeometricObject類別實現Comparable介面
abstract class GeometricObject implements Comparable<GeometricObject> {
    // 尋找兩個幾何物件中較大的一個
    public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
        if (obj1.compareTo(obj2) > 0) {
            return obj1;
        }
        return obj2;
    }
    
    // 實現Comparable介面的compareTo方法
    @Override
    public int compareTo(GeometricObject obj) {
        if (this.getArea() > obj.getArea()) {
            return 1;
        } else if (this.getArea() < obj.getArea()) {
            return -1;
        }
        return 0;
    }
    
    // 抽象方法：獲取面積
    public abstract double getArea();
}

// Circle類別繼承GeometricObject
class Circle extends GeometricObject {
    private double radius;
    
    // 構造函數
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // 實現獲取面積的方法
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle類別繼承GeometricObject
class Rectangle extends GeometricObject {
    private double width;
    private double height;
    
    // 構造函數
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // 實現獲取面積的方法
    @Override
    public double getArea() {
        return width * height;
    }
}

// 測試程式
public class TestGeometricObject {
    public static void main(String[] args) {
        // 創建兩個圓形對象
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(6);
        
        // 測試比較兩個圓形
        System.out.println("兩個圓形中較大的面積是: " + 
            GeometricObject.max(c1, c2).getArea());
        
        // 創建兩個矩形對象
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(5, 6);
        
        // 測試比較兩個矩形
        System.out.println("兩個矩形中較大的面積是: " + 
            GeometricObject.max(r1, r2).getArea());
    }
}