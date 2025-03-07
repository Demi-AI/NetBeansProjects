/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 建立標籤和文字框
        Label lblNum1 = new Label("Number 1:"); // 標籤：數字1
        TextField tfNum1 = new TextField(); // 輸入框：數字1
        tfNum1.setPrefWidth(60); // 設定文字框寬度
        Label lblNum2 = new Label("Number 2:"); // 標籤：數字2
        TextField tfNum2 = new TextField(); // 輸入框：數字2
        tfNum2.setPrefWidth(60); // 設定文字框寬度
        Label lblResult = new Label("Result:"); // 標籤：結果
        TextField tfResult = new TextField(); // 輸入框：結果
        tfResult.setPrefWidth(60); // 設定文字框寬度
        tfResult.setEditable(false); // 結果框不可編輯
        lblNum1.setFont(Font.font("Arial")); // 設定字型
        lblNum2.setFont(Font.font("Arial")); // 設定字型
        lblResult.setFont(Font.font("Arial")); // 設定字型
        tfNum1.setFont(Font.font("Arial")); // 設定字型
        tfNum2.setFont(Font.font("Arial")); // 設定字型
        tfResult.setFont(Font.font("Arial")); // 設定字型

        // 建立HBox佈局，將標籤和文字框放在一行
        HBox inputBox = new HBox(10, lblNum1, tfNum1, lblNum2, tfNum2, lblResult, tfResult);
        inputBox.setAlignment(Pos.CENTER); // 設定內容置中

        // 建立操作按鈕
        Button btnAdd = new Button("Add"); // 加法按鈕
        Button btnSubtract = new Button("Subtract"); // 減法按鈕
        Button btnMultiply = new Button("Multiply"); // 乘法按鈕
        Button btnDivide = new Button("Divide"); // 除法按鈕
        btnAdd.setFont(Font.font("Arial")); // 設定字型
        btnDivide.setFont(Font.font("Arial")); // 設定字型
        btnMultiply.setFont(Font.font("Arial")); // 設定字型
        btnSubtract.setFont(Font.font("Arial")); // 設定字型

        // 建立HBox佈局，將按鈕放在一行
        HBox buttonBox = new HBox(10, btnAdd, btnSubtract, btnMultiply, btnDivide);
        buttonBox.setAlignment(Pos.CENTER); // 設定內容置中

        // 設定加法按鈕的事件處理
        btnAdd.setOnAction(e -> {
            double num1 = Double.parseDouble(tfNum1.getText()); // 讀取數字1
            double num2 = Double.parseDouble(tfNum2.getText()); // 讀取數字2
            tfResult.setText(String.valueOf(num1 + num2)); // 顯示加法結果
        });

        // 設定減法按鈕的事件處理
        btnSubtract.setOnAction(e -> {
            double num1 = Double.parseDouble(tfNum1.getText()); // 讀取數字1
            double num2 = Double.parseDouble(tfNum2.getText()); // 讀取數字2
            tfResult.setText(String.valueOf(num1 - num2)); // 顯示減法結果
        });

        // 設定乘法按鈕的事件處理
        btnMultiply.setOnAction(e -> {
            double num1 = Double.parseDouble(tfNum1.getText()); // 讀取數字1
            double num2 = Double.parseDouble(tfNum2.getText()); // 讀取數字2
            tfResult.setText(String.valueOf(num1 * num2)); // 顯示乘法結果
        });

        // 設定除法按鈕的事件處理
        btnDivide.setOnAction(e -> {
            double num1 = Double.parseDouble(tfNum1.getText()); // 讀取數字1
            double num2 = Double.parseDouble(tfNum2.getText()); // 讀取數字2
            if (num2 != 0) { // 檢查除數是否為0
                tfResult.setText(String.valueOf(num1 / num2)); // 顯示除法結果
            } else {
                tfResult.setText("Error: Division by 0"); // 若除數為0，顯示錯誤訊息
            }
        });

        // 建立VBox佈局，將所有元件放在垂直排列
        VBox mainBox = new VBox(15, inputBox, buttonBox);
        mainBox.setPadding(new Insets(15)); // 設定內邊距
        mainBox.setAlignment(Pos.CENTER); // 設定內容置中

        // 設定場景，並顯示視窗
        Scene scene = new Scene(mainBox, 400, 150); // 設定場景大小
        primaryStage.setTitle("SimpleCalculator"); // 設定視窗標題
        primaryStage.setScene(scene); // 設定場景
        primaryStage.show(); // 顯示視窗
    }

    public static void main(String[] args) {
        launch(args); // 啟動應用程式
    }
}
