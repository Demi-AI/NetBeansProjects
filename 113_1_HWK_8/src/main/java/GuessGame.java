/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GuessGame extends Application {
    private int num; // 用來儲存隨機數字
    private boolean isGameStarted = false; // 標誌遊戲是否已經開始

    @Override
    public void start(Stage primaryStage) {
        // 建立顯示訊息的標籤
        Label lblMessage = new Label("請按開始");
        // 建立用戶輸入的文字框，預設不可編輯
        TextField tfInput = new TextField();
        tfInput.setEditable(false); // 初始時禁止編輯
        tfInput.setPrefWidth(100); // 設定文字框的寬度
        // 建立開始/猜測的按鈕
        Button btnAction = new Button("開始");

        lblMessage.setTextFill(Color.BLACK); // 設定訊息文字顏色為黑色

        // 設定按鈕的事件處理
        btnAction.setOnAction(e -> {
            if (!isGameStarted) { // 如果遊戲尚未開始
                isGameStarted = true; // 開始遊戲
                num = new Random().nextInt(20); // 隨機生成一個0到19的數字
                System.out.println("隨機數為: " + num); // 顯示隨機數字（僅在控制台顯示）
                tfInput.setEditable(true); // 啟用文字框編輯
                tfInput.clear(); // 清空文字框
                lblMessage.setText("請輸入數字猜猜看"); // 顯示提示文字
                lblMessage.setTextFill(Color.BLACK); // 設定文字顏色為黑色
                btnAction.setText("猜!"); // 改變按鈕文字為"猜!"
            } else { // 如果遊戲已經開始
                try {
                    // 解析用戶輸入的數字
                    int guess = Integer.parseInt(tfInput.getText());
                    if (guess > num) { // 如果猜的數字大於隨機數字
                        lblMessage.setText("Too Big"); // 顯示提示信息
                        lblMessage.setTextFill(Color.RED); // 設定文字顏色為紅色
                    } else if (guess < num) { // 如果猜的數字小於隨機數字
                        lblMessage.setText("Too Small"); // 顯示提示信息
                        lblMessage.setTextFill(Color.GREEN); // 設定文字顏色為綠色
                    } else { // 如果猜對了
                        lblMessage.setText("Correct! 請按開始"); // 顯示正確信息
                        lblMessage.setTextFill(Color.BLACK); // 設定文字顏色為黑色
                        tfInput.setEditable(false); // 禁止編輯輸入框
                        btnAction.setText("開始"); // 顯示"開始"文字
                        isGameStarted = false; // 重置遊戲狀態
                    }
                } catch (NumberFormatException ex) { // 當輸入的不是有效數字時
                    lblMessage.setText("請輸入有效的數字"); // 顯示錯誤提示
                    lblMessage.setTextFill(Color.RED); // 設定文字顏色為紅色
                }
            }
        });

        // 設定按鈕和文字的字型
        btnAction.setFont(Font.font("Arial"));
        lblMessage.setFont(Font.font("Arial"));
        tfInput.setFont(Font.font("Arial"));

        // 設定水平排列布局（按鈕、訊息和輸入框）
        HBox inputRow = new HBox(10, lblMessage, tfInput, btnAction);
        inputRow.setAlignment(Pos.CENTER); // 設定水平排列居中

        // 設定垂直排列布局（整體布局）
        VBox mainBox = new VBox(10, inputRow);
        mainBox.setPadding(new Insets(15)); // 設定內邊距
        mainBox.setAlignment(Pos.CENTER); // 設定垂直排列居中

        // 設定場景，並顯示視窗
        Scene scene = new Scene(mainBox, 400, 150); // 設定場景大小
        primaryStage.setTitle("411631020 王羽蜨"); // 設定視窗標題
        primaryStage.setScene(scene); // 設定場景
        primaryStage.show(); // 顯示視窗
    }

    public static void main(String[] args) {
        launch(args); // 啟動應用程式
    }
}
