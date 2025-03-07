/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
// Colorable介面定義
interface Colorable {
    // 定義如何著色的方法
    void howToColor();
}

// Square類別繼承GeometricObject並實現Colorable介面
class Square extends GeometricObject implements Colorable {
    // 邊長屬性
    private double side;
    
    // 無參數構造函數
    public Square() {
        this.side = 0;
    }
    
    // 帶參數構造函數
    public Square(double side) {
        this.side = side;
    }
    
    // 獲取邊長
    public double getSide() {
        return side;
    }
    
    // 設置邊長
    public void setSide(double side) {
        this.side = side;
    }
    
    // 實現GeometricObject的getArea方法
    @Override
    public double getArea() {
        return side * side;
    }
    
    // 實現Colorable介面的howToColor方法
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}

// 測試程式
public class TestColorable {
    public static void main(String[] args) {
        // 創建包含5個GeometricObject的陣列
        GeometricObject[] objects = new GeometricObject[5];
        objects[0] = new Square(5);
        objects[1] = new Circle(3);
        objects[2] = new Square(4);
        objects[3] = new Rectangle(2, 3);
        objects[4] = new Square(6);
        
        // 遍歷陣列
        for (GeometricObject obj : objects) {
            // 顯示面積
            System.out.println("Area: " + obj.getArea());
            
            // 如果物件是可著色的，調用howToColor方法
            if (obj instanceof Colorable) {
                ((Colorable)obj).howToColor();
            }
        }
    }
}