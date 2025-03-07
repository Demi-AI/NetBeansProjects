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

/**
 * Circular 類別繼承 JPanel，用於繪製圓形排列的文字。
 */
public class Circular extends JPanel {
    // 文字內容
    private final String text = "Welcome to Java";

    /**
     * 繪製元件內容。
     * @param g Graphics 對象，用於繪製圖形。
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 設置字體樣式
        g2d.setFont(new Font("Serif", Font.BOLD, 20));

        // 獲取面板中心點坐標
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // 定義圓形半徑
        int radius = 100;

        // 計算每個字母的角度增量
        double angleIncrement = 2 * Math.PI / text.length();

        // 遍歷每個字符，按圓形排列
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i); // 獲取當前字符
            double angle = i * angleIncrement - Math.PI / 2; // 計算字符的角度

            // 計算字符在圓周上的位置
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));

            // 平移到字符位置
            g2d.translate(x, y);
            // 旋轉字符方向以匹配圓周
            g2d.rotate(angle + Math.PI / 2);

            // 繪製字符
            g2d.drawString(String.valueOf(letter), 0, 0);

            // 恢復旋轉和平移
            g2d.rotate(-angle - Math.PI / 2);
            g2d.translate(-x, -y);
        }
    }

    /**
     * 主方法：創建並顯示窗口。
     * @param args 命令行參數。
     */
    public static void main(String[] args) {
        // 創建框架
        JFrame frame = new JFrame("Circular");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設置關閉行為
        frame.setSize(400, 400); // 設置框架大小
        frame.add(new Circular()); // 添加自定義繪製面板
        frame.setVisible(true); // 顯示框架
    }
}
