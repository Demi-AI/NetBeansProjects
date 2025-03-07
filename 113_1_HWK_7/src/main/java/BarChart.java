/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import javax.swing.*;
import java.awt.*;

public class BarChart extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;

        // 各部分分數占比
        int project = 20;
        int quiz = 10;
        int midterm = 30;
        int finalExam = 40;

        // 每個柱形的寬度
        int barWidth = 80;
        // 柱形之間的間距
        int spacing = 20;

        // 柱形圖的初始 x 和 y 坐標
        int x = 50;
        int y = 200;

        // 繪製 Project 的柱形
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y - project, barWidth, project); // 填充紅色柱形
        g2d.drawString("Project -- 20%", x + 5, y + 20); // 在柱形下方顯示標籤

        // 繪製 Quiz 的柱形
        g2d.setColor(Color.BLUE);
        g2d.fillRect(x + (barWidth + spacing), y - quiz, barWidth, quiz); // 填充藍色柱形
        g2d.drawString("Quiz -- 10%", x + (barWidth + spacing) + 5, y + 20); // 在柱形下方顯示標籤

        // 繪製 Midterm 的柱形
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x + 2 * (barWidth + spacing), y - midterm, barWidth, midterm); // 填充綠色柱形
        g2d.drawString("Midterm -- 30%", x + 2 * (barWidth + spacing) + 5, y + 20); // 在柱形下方顯示標籤

        // 繪製 Final Exam 的柱形
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(x + 3 * (barWidth + spacing), y - finalExam, barWidth, finalExam); // 填充橙色柱形
        g2d.drawString("Final -- 40%", x + 3 * (barWidth + spacing) + 5, y + 20); // 在柱形下方顯示標籤

        // 繪製 X 軸
        g2d.setColor(Color.BLACK);
        g2d.drawLine(30, y, 500, y); // X 軸線條從 (30, y) 繪製到 (500, y)
    }

    public static void main(String[] args) {

        // 創建窗口框架
        JFrame frame = new JFrame("Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設置關閉行為
        frame.setSize(500, 400); // 設置窗口大小
        frame.add(new BarChart()); // 添加 BarChart 畫布
        frame.setVisible(true); // 設置窗口可見
    }
}
