/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {
    public static void main(String[] args) {

        // 創建主框架，標題為"Tic Tac Toe"
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設置關閉操作
        frame.setSize(300, 300); // 設置框架大小
        frame.setLayout(new GridLayout(3, 3)); // 使用3x3的網格佈局

        // 加載X, O, 和空白的圖標資源
        ImageIcon xIcon = new ImageIcon(Game.class.getResource("/images/x.gif"));
        ImageIcon oIcon = new ImageIcon(Game.class.getResource("/images/o.gif"));
        ImageIcon emptyIcon = new ImageIcon(Game.class.getResource("/images/empty.gif"));

        // 創建隨機數生成器
        Random rand = new Random();
        JLabel[][] cells = new JLabel[3][3]; // 用於存儲每個格子的JLabel對象

        // 初始化3x3的格子
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 隨機生成0, 1或2，對應X, O或空白
                int randomValue = rand.nextInt(3); 
                ImageIcon selectedIcon;
                switch (randomValue) {
                    case 0:
                        selectedIcon = xIcon; // 選擇X圖標
                        break;
                    case 1:
                        selectedIcon = oIcon; // 選擇O圖標
                        break;
                    default:
                        selectedIcon = emptyIcon; // 選擇空白圖標
                        break;
                }

                // 將選擇的圖標應用到JLabel並添加到框架中
                cells[i][j] = new JLabel(selectedIcon);
                frame.add(cells[i][j]);
            }
        }

        // 設置框架可見
        frame.setVisible(true);
    }
}
