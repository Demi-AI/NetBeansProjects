package com.mycompany._1_hwk_8;
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
    private int num;
    private boolean isGameStarted = false;

    @Override
    public void start(Stage primaryStage) {
        Label lblMessage = new Label("請按開始");
        TextField tfInput = new TextField();
        tfInput.setEditable(false);
        tfInput.setPrefWidth(100);
        Button btnAction = new Button("開始");
        lblMessage.setTextFill(Color.BLACK);

        btnAction.setOnAction(e -> {
            if (!isGameStarted) { 
                isGameStarted = true;
                num = new Random().nextInt(20);
                System.out.println("隨機數為: " + num);
                tfInput.setEditable(true);
                tfInput.clear();
                lblMessage.setText("請輸入數字猜猜看");
                lblMessage.setTextFill(Color.BLACK);
                btnAction.setText("猜!");
            } else {
                try {
                    int guess = Integer.parseInt(tfInput.getText());
                    if (guess > num) {
                        lblMessage.setText("Too Big");
                        lblMessage.setTextFill(Color.RED);
                    } else if (guess < num) {
                        lblMessage.setText("Too Small");
                        lblMessage.setTextFill(Color.GREEN);
                    } else {
                        lblMessage.setText("Correct! 請按開始");
                        lblMessage.setTextFill(Color.BLACK);
                        tfInput.setEditable(false);
                        btnAction.setText("開始");
                        isGameStarted = false;
                    }
                } catch (NumberFormatException ex) {
                    lblMessage.setText("請輸入有效的數字");
                    lblMessage.setTextFill(Color.RED);
                }
            }
        });
        btnAction.setFont(Font.font("Arial"));
        lblMessage.setFont(Font.font("Arial"));
        tfInput.setFont(Font.font("Arial"));

        HBox inputRow = new HBox(10, lblMessage, tfInput, btnAction);
        inputRow.setAlignment(Pos.CENTER);

        VBox mainBox = new VBox(10, inputRow);
        mainBox.setPadding(new Insets(15));
        mainBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainBox, 400, 150);
        primaryStage.setTitle("411631020 王羽蜨");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}