/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Function extends JPanel {
    // 用於存儲繪製的點的列表
    private final java.util.List<Point> points = new ArrayList<>();

    // 構造方法，初始化拋物線的點
    public Function() {
        double scaleFactor = 0.0125; // 縮放因子，用於調整拋物線的形狀
        // 計算範圍內的點，並將其存儲在 points 列表中
        for (int x = -100; x <= 100; x++) {
            int xCoord = x + 200; // 調整 X 坐標到面板中心
            int yCoord = 200 - (int) (scaleFactor * x * x); // 根據拋物線公式計算 Y 坐標，並翻轉 Y 軸方向
            points.add(new Point(xCoord, yCoord)); // 將點添加到列表中
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 繪製面板背景
        Graphics2D g2d = (Graphics2D) g;

        // 繪製 X 軸和 Y 軸
        g2d.drawLine(200, 0, 200, 400); // Y 軸
        g2d.drawLine(0, 200, 400, 200); // X 軸

        g2d.setColor(Color.BLUE); // 設置繪圖顏色為藍色

        // 繪製拋物線，連接相鄰的點
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i); // 獲取當前點
            Point p2 = points.get(i + 1); // 獲取下一個點
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y); // 繪製兩點之間的直線
        }
    }

    public static void main(String[] args) {
        // 創建框架並設置屬性
        JFrame frame = new JFrame("Function Plot"); // 設置窗口標題
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設置關閉操作
        frame.setSize(400, 400); // 設置窗口大小
        frame.add(new Function()); // 將 Function 面板添加到框架中
        frame.setVisible(true); // 顯示窗口
    }
}
