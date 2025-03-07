/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.awt.*;
import java.util.Calendar;
import javax.swing.*;

// 定義 DetailedClock 類別，繼承 JPanel，表示繪製時鐘的面板
public class DetailedClock extends JPanel {
    private int hour, minute, second; // 儲存當前時間的時、分、秒

    // 構造函數，用於初始化時鐘的時間
    public DetailedClock() {
        // 獲取當前時間
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR); // 獲取小時（12小時制）
        minute = calendar.get(Calendar.MINUTE); // 獲取分鐘
        second = calendar.get(Calendar.SECOND); // 獲取秒
    }

    // 重寫 paintComponent 方法，用於繪製時鐘
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 呼叫父類的 paintComponent 進行基礎繪製
        Graphics2D g2d = (Graphics2D) g; // 使用 Graphics2D 提供更高級的繪圖功能

        // 計算時鐘的半徑和中心點
        int clockRadius = Math.min(getWidth(), getHeight()) / 2 - 50; // 時鐘半徑
        int centerX = getWidth() / 2; // 中心點X座標
        int centerY = getHeight() / 2; // 中心點Y座標

        // 繪製圓形時鐘外框
        g2d.setColor(Color.BLACK); // 設定顏色為黑色
        g2d.drawOval(centerX - clockRadius, centerY - clockRadius, 2 * clockRadius, 2 * clockRadius);

        // 繪製時鐘的刻度
        for (int i = 0; i < 60; i++) {
            int length = (i % 5 == 0) ? 15 : 5; // 每五個刻度畫長線，其餘畫短線
            double angle = Math.toRadians(i * 6); // 計算每個刻度的角度（6度間隔）
            int x1 = (int) (centerX + clockRadius * Math.cos(angle)); // 刻度外端X座標
            int y1 = (int) (centerY - clockRadius * Math.sin(angle)); // 刻度外端Y座標
            int x2 = (int) (centerX + (clockRadius - length) * Math.cos(angle)); // 刻度內端X座標
            int y2 = (int) (centerY - (clockRadius - length) * Math.sin(angle)); // 刻度內端Y座標
            g2d.drawLine(x1, y1, x2, y2); // 繪製刻度線
        }

        // 繪製時針
        drawHand(g2d, centerX, centerY, clockRadius * 0.5, (hour % 12 + minute / 60.0) * 30, 8, Color.BLACK);

        // 繪製分針
        drawHand(g2d, centerX, centerY, clockRadius * 0.7, minute * 6, 5, Color.BLUE);

        // 繪製秒針
        drawHand(g2d, centerX, centerY, clockRadius * 0.9, second * 6, 2, Color.RED);

        // 繪製數字時間
        String timeString = String.format("%02d:%02d:%02d", hour, minute, second); // 格式化時間為 hh:mm:ss
        g2d.setFont(new Font("Arial", Font.BOLD, 20)); // 設定字體樣式與大小
        g2d.drawString(timeString, centerX - 40, centerY + clockRadius + 30); // 繪製時間字串
    }

    // 繪製指針的方法
    private void drawHand(Graphics2D g2d, int x, int y, double length, double angle, int width, Color color) {
        g2d.setColor(color); // 設定指針的顏色
        g2d.setStroke(new BasicStroke(width)); // 設定指針的寬度
        double radians = Math.toRadians(angle - 90); // 將角度轉換為弧度，調整方向使其從垂直向上開始
        int xEnd = (int) (x + length * Math.cos(radians)); // 指針末端X座標
        int yEnd = (int) (y + length * Math.sin(radians)); // 指針末端Y座標
        g2d.drawLine(x, y, xEnd, yEnd); // 繪製指針
    }

    // 主方法，創建並顯示時鐘的 JFrame
    public static void main(String[] args) {
        JFrame frame = new JFrame("Detailed Clock"); // 創建 JFrame，標題為 "Detailed Clock"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設定關閉操作
        frame.setSize(400, 400); // 設定窗口大小
        frame.add(new DetailedClock()); // 添加時鐘面板
        frame.setVisible(true); // 設定窗口可見
    }
}
