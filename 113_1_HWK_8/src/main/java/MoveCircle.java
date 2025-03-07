/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// 定義 MoveCircle 類別，繼承 Application，用於顯示一個可移動的圓形圖形
public class MoveCircle extends Application {
    private double paneWidth = 400; // 面板的寬度
    private double paneHeight = 300; // 面板的高度
    private double ballRadius = 15; // 圓形的半徑
    private Circle ball; // 圓形物件

    @Override
    public void start(Stage primaryStage) {
        // 創建 Pane 作為圓形的容器
        Pane ballPane = new Pane();

        // 創建圓形，設定顏色為紅色
        ball = new Circle(ballRadius, Color.RED);
        ball.setCenterX(paneWidth / 2); // 圓形的初始水平位置（居中）
        ball.setCenterY(paneHeight / 2); // 圓形的初始垂直位置（居中）
        ballPane.getChildren().add(ball); // 將圓形添加到 Pane
        ballPane.setPrefSize(paneWidth, paneHeight); // 設定 Pane 的首選尺寸

        // 創建控制圓形移動的按鈕
        Button leftButton = new Button("Left"); // 左移按鈕
        Button rightButton = new Button("Right"); // 右移按鈕
        Button upButton = new Button("Up"); // 上移按鈕
        Button downButton = new Button("Down"); // 下移按鈕

        // 設定按鈕字體
        leftButton.setFont(Font.font("Arial"));
        rightButton.setFont(Font.font("Arial"));
        upButton.setFont(Font.font("Arial"));
        downButton.setFont(Font.font("Arial"));

        // 設定按鈕的點擊事件，移動圓形
        leftButton.setOnAction(e -> moveBall(-10, 0)); // 左移 10 像素
        rightButton.setOnAction(e -> moveBall(10, 0)); // 右移 10 像素
        upButton.setOnAction(e -> moveBall(0, -10)); // 上移 10 像素
        downButton.setOnAction(e -> moveBall(0, 10)); // 下移 10 像素

        // 使用 HBox 將按鈕橫向排列
        HBox controlBox = new HBox(10, leftButton, rightButton, upButton, downButton); // 按鈕之間的間距為 10 像素

        // 使用 BorderPane 作為主要佈局
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane); // 圓形容器位於中央
        pane.setBottom(controlBox); // 按鈕控制面板位於底部

        // 創建場景並設定到主視窗
        Scene scene = new Scene(pane, paneWidth, paneHeight); // 場景大小與面板一致
        primaryStage.setTitle("MoveCircle"); // 設定視窗標題
        primaryStage.setScene(scene); // 將場景設定到主視窗
        primaryStage.show(); // 顯示主視窗
    }

    // 移動圓形的方法
    private void moveBall(double dx, double dy) {
        double newX = ball.getCenterX() + dx; // 計算圓形的新水平位置
        double newY = ball.getCenterY() + dy; // 計算圓形的新垂直位置

        // 確保圓形的新位置不會超出面板邊界
        if (newX - ballRadius >= 0 && newX + ballRadius <= paneWidth) {
            ball.setCenterX(newX); // 更新圓形的水平位置
        }
        if (newY - ballRadius >= 0 && newY + ballRadius <= paneHeight) {
            ball.setCenterY(newY); // 更新圓形的垂直位置
        }
    }

    // 主方法，用於啟動 JavaFX 應用
    public static void main(String[] args) {
        launch(args); // 啟動 JavaFX 應用
    }
}

