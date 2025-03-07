/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class Fin4 extends Application {
    private TextField heightField, weightField;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("411631020 Fin4"); // 學號

        // 建立輸入欄位
        Label heightLabel = new Label("請輸入身高:");
        heightField = new TextField();
        Label weightLabel = new Label("請輸入體重:");
        weightField = new TextField();
        resultLabel = new Label("結果:");

        // 建立按鈕
        Button maleButton = new Button("男");
        Button femaleButton = new Button("女");
        Button clearButton = new Button("清空");

        // 設定 GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        // 加入元件
        grid.add(heightLabel, 0, 0);
        grid.add(heightField, 1, 0);
        grid.add(weightLabel, 0, 1);
        grid.add(weightField, 1, 1);
        grid.add(maleButton, 0, 2);
        grid.add(femaleButton, 1, 2);
        grid.add(clearButton, 0, 3, 2, 1);
        grid.add(resultLabel, 0, 4, 2, 1);

        // **男按鈕 - 內部類別**
        maleButton.setOnAction(new MaleHandler());

        // **女按鈕 - 匿名類別**
        femaleButton.setOnAction(e -> {
            calculateBMI("女");
        });

        // **清空按鈕 - Lambda**
        clearButton.setOnAction(e -> {
            heightField.clear();
            weightField.clear();
            resultLabel.setText("結果:");
        });

        // 設定場景
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // 計算 BMI
    private void calculateBMI(String gender) {
        try {
            double height = Double.parseDouble(heightField.getText()) / 100;
            double weight = Double.parseDouble(weightField.getText());
            double bmi = weight / (height * height);
            String status = getStatus(gender, bmi);
            resultLabel.setText(String.format("%s: %s, BMI: %.2f", gender, status, bmi));
        } catch (NumberFormatException e) {
            resultLabel.setText("請輸入有效數字");
        }
    }

    // 取得 BMI 狀態
    private String getStatus(String gender, double bmi) {
        if (gender.equals("男")) {
            if (bmi <= 19.2) return "過輕";
            else if (bmi <= 25.6) return "正常";
            else return "肥胖";
        } else {
            if (bmi <= 18.3) return "過輕";
            else if (bmi <= 24.0) return "正常";
            else return "肥胖";
        }
    }

    // 內部類別處理男生按鈕事件
    private class MaleHandler implements javafx.event.EventHandler<javafx.event.ActionEvent> {
        public void handle(javafx.event.ActionEvent event) {
            calculateBMI("男");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
