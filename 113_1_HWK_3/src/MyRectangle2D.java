/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
/*
以下是關於 MyRectangle2D 類別的設計描述，翻譯成中文：
定義一個名為 MyRectangle2D 的類別，該類別包含：
1. 兩個 `double` 資料欄位 `x` 和 `y`，用來指定矩形的中心位置，並提供對應的 getter 和 setter 方法。
（假設矩形的邊與 x 軸或 y 軸平行。）
2. 資料欄位 `width` 和 `height`，並提供對應的 getter 和 setter 方法。
3. 一個無參數的構造函數，創建一個默認的矩形，其中心為 (0, 0)，寬度和高度均為 1。
4. 一個帶有指定 `x`、`y`、`width` 和 `height` 的構造函數，來創建指定的矩形。
5. 一個名為 `getArea()` 的方法，用於返回矩形的面積。
6. 一個名為 `getPerimeter()` 的方法，用於返回矩形的周長。
7. 一個名為 `contains(double x, double y)` 的方法，當指定的點 `(x, y)` 在該矩形內部時返回 `true`。（參見圖 10.24a）
8. 一個名為 `contains(MyRectangle2D r)` 的方法，當指定的矩形 `r` 完全在此矩形內部時返回 `true`。（參見圖 10.24b）
9. 一個名為 `overlaps(MyRectangle2D r)` 的方法，當指定的矩形 `r` 與此矩形重疊時返回 `true`。（參見圖 10.24c）
這些方法和構造函數使 MyRectangle2D 類別能夠靈活地處理矩形的基本幾何操作。
*/

/*
+--------------------------+
|      MyRectangle2D        |
+--------------------------+
| - x: double               |
| - y: double               |
| - width: double           |
| - height: double          |
+--------------------------+
| + MyRectangle2D()         |
| + MyRectangle2D(x: double, y: double, width: double, height: double) |
| + getX(): double          |
| + setX(x: double): void   |
| + getY(): double          |
| + setY(y: double): void   |
| + getWidth(): double      |
| + setWidth(width: double): void |
| + getHeight(): double     |
| + setHeight(height: double): void |
| + getArea(): double       |
| + getPerimeter(): double  |
| + contains(x: double, y: double): boolean |
| + contains(r: MyRectangle2D): boolean     |
| + overlaps(r: MyRectangle2D): boolean     |
+--------------------------+

UML 圖解釋：
- 類別名稱: MyRectangle2D
- 屬性:
  - `x`: 矩形中心的 x 坐標
  - `y`: 矩形中心的 y 坐標
  - `width`: 矩形的寬度
  - `height`: 矩形的高度
- 方法:
  - `MyRectangle2D()`：無參數構造函數
  - `MyRectangle2D(x, y, width, height)`：帶參構造函數
  - `getX()` 和 `setX()`：獲取和設置 x 坐標
  - `getY()` 和 `setY()`：獲取和設置 y 坐標
  - `getWidth()` 和 `setWidth()`：獲取和設置矩形的寬度
  - `getHeight()` 和 `setHeight()`：獲取和設置矩形的高度
  - `getArea()`：計算並返回矩形的面積
  - `getPerimeter()`：計算並返回矩形的周長
  - `contains(x, y)`：檢查點是否在矩形內
  - `contains(r)`：檢查矩形是否包含另一個矩形
  - `overlaps(r)`：檢查矩形是否與另一個矩形重疊
這個 UML 圖展示了 MyRectangle2D 類別的結構及其方法。
*/
public class MyRectangle2D {
    private double x, y;  // 矩形的中心點
    private double width, height;  // 矩形的寬度和高度

    // 無參數建構子，建立預設的矩形 (0, 0) 中心點，寬度和高度為1
    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    // 建構子，使用指定的中心點、寬度和高度建立矩形
    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // 獲取x座標
    public double getX() {
        return x;
    }

    // 設定x座標
    public void setX(double x) {
        this.x = x;
    }

    // 獲取y座標
    public double getY() {
        return y;
    }

    // 設定y座標
    public void setY(double y) {
        this.y = y;
    }

    // 獲取寬度
    public double getWidth() {
        return width;
    }

    // 設定寬度
    public void setWidth(double width) {
        this.width = width;
    }

    // 獲取高度
    public double getHeight() {
        return height;
    }

    // 設定高度
    public void setHeight(double height) {
        this.height = height;
    }

    // 計算矩形的面積
    public double getArea() {
        return width * height;
    }

    // 計算矩形的周長
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // 判斷點(x, y)是否位於矩形內部
    public boolean contains(double x, double y) {
        return x > this.x - width / 2 && x < this.x + width / 2 &&
               y > this.y - height / 2 && y < this.y + height / 2;
    }

    // 判斷矩形r是否完全包含在此矩形內
    public boolean contains(MyRectangle2D r) {
        return r.getX() - r.getWidth() / 2 >= this.x - this.width / 2 &&
               r.getX() + r.getWidth() / 2 <= this.x + this.width / 2 &&
               r.getY() - r.getHeight() / 2 >= this.y - this.height / 2 &&
               r.getY() + r.getHeight() / 2 <= this.y + this.height / 2;
    }

    // 判斷矩形r是否與此矩形重疊
    public boolean overlaps(MyRectangle2D r) {
        return !(r.getX() + r.getWidth() / 2 <= this.x - this.width / 2 ||
                 r.getX() - r.getWidth() / 2 >= this.x + this.width / 2 ||
                 r.getY() + r.getHeight() / 2 <= this.y - this.height / 2 ||
                 r.getY() - r.getHeight() / 2 >= this.y + this.height / 2);
    }

    // 測試方法
    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(0, 0, 4, 4);
        MyRectangle2D r2 = new MyRectangle2D(1, 1, 2, 2);
        MyRectangle2D r3 = new MyRectangle2D(5, 5, 2, 2);

        // 顯示矩形的面積和周長
        System.out.println("r1 面積: " + r1.getArea() + " 周長: " + r1.getPerimeter());

        // 測試點是否在矩形內
        System.out.println("r1 包含點(1, 1): " + r1.contains(1, 1));

        // 測試r2是否包含在r1內
        System.out.println("r1 包含r2: " + r1.contains(r2));

        // 測試r3是否與r1重疊
        System.out.println("r1 與r3重疊: " + r1.overlaps(r3));
    }
}
