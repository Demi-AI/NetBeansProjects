/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.util.Random;

// 介面 Area
interface Area {
    double getArea();
}

// 抽象類別 Shape (實作 Area 和 Comparable)
abstract class Shape implements Area, Comparable<Shape> {
    public int compareTo(Shape other) {
        return Double.compare(this.getArea(), other.getArea());
    }
}

// 抽象類別 TwoD
abstract class TwoD extends Shape {
    private String name;
    
    public TwoD(String n) {
        this.name = n;
    }

    public String toString() {
        return "TwoD name=" + name;
    }
}

// 正方形 Square
class Square extends TwoD {
    private double length;

    public Square(String n, double len) {
        super(n);
        this.length = len;
    }

    public void enlarge(double d) {
        this.length *= d;
    }

    public String toString() {
        return super.toString() + " length=" + length;
    }

    public double getArea() {
        return length * length;
    }
}

// 抽象類別 ThreeD
abstract class ThreeD extends Shape {
    private String id;

    public ThreeD(String i) {
        this.id = i;
    }

    public String toString() {
        return "ThreeD id=" + id;
    }

    public abstract double getVol();
}

// 立方體 Cube
class Cube extends ThreeD {
    private double length;

    public Cube(String i, double len) {
        super(i);
        this.length = len;
    }

    public String toString() {
        return super.toString() + " length=" + length;
    }

    public double getArea() {
        return 6 * length * length;
    }

    public double getVol() {
        return length * length * length;
    }
}

// 主程式
public class Fin2 {
    public static void main(String[] args) {
        String studentId = "411631020"; // 學號
        int lastDigit = Character.getNumericValue(studentId.charAt(studentId.length() - 1));

        Shape[] arr = new Shape[3];
        arr[0] = new Square(studentId.substring(0, 3), 5);
        arr[1] = new Cube(studentId.substring(3, 6), 2);
        arr[2] = (lastDigit % 2 == 0) ? new Cube(studentId.substring(6), new Random().nextInt(5) + 1) :
                                        new Square(studentId.substring(6), new Random().nextInt(5) + 1);

        for (Shape s : arr) {
            System.out.println(s);
        }

        for (Shape s : arr) {
            if (s instanceof Square) {
                ((Square) s).enlarge(2);
                System.out.println(s + " area=" + s.getArea());
            }
        }

        for (Shape s : arr) {
            if (s instanceof Cube) {
                System.out.println(s + " area=" + s.getArea() + " vol=" + ((Cube) s).getVol());
            }
        }
        
        Shape maxShape = arr[0];
        for (Shape s : arr) {
            if (s.compareTo(maxShape) > 0) {
                maxShape = s;
            }
        }
        System.out.println("面積最大:" + maxShape);
    }
}

