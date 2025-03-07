package com.mycompany._1_hwk_8;
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
        Label lblNum1 = new Label("Number 1:");
        TextField tfNum1 = new TextField();
        tfNum1.setPrefWidth(60);
        Label lblNum2 = new Label("Number 2:");
        TextField tfNum2 = new TextField();
        tfNum2.setPrefWidth(60);
        Label lblResult = new Label("Result:");
        TextField tfResult = new TextField();
        tfResult.setPrefWidth(60);
        tfResult.setEditable(false);
        lblNum1.setFont(Font.font("Arial"));
        lblNum2.setFont(Font.font("Arial"));
        lblResult.setFont(Font.font("Arial"));
        tfNum1.setFont(Font.font("Arial"));
        tfNum2.setFont(Font.font("Arial"));
        tfResult.setFont(Font.font("Arial"));

        HBox inputBox = new HBox(10, lblNum1, tfNum1, lblNum2, tfNum2, lblResult, tfResult);
        inputBox.setAlignment(Pos.CENTER);

        Button btnAdd = new Button("Add");
        Button btnSubtract = new Button("Subtract");
        Button btnMultiply = new Button("Multiply");
        Button btnDivide = new Button("Divide");
        btnAdd.setFont(Font.font("Arial"));
        btnDivide.setFont(Font.font("Arial"));
        btnMultiply.setFont(Font.font("Arial"));
        btnSubtract.setFont(Font.font("Arial"));

        HBox buttonBox = new HBox(10, btnAdd, btnSubtract, btnMultiply, btnDivide);
        buttonBox.setAlignment(Pos.CENTER);

        btnAdd.setOnAction(e -> {
            double num1 = Double.parseDouble(tfNum1.getText());
            double num2 = Double.parseDouble(tfNum2.getText());
            tfResult.setText(String.valueOf(num1 + num2));
        });

        btnSubtract.setOnAction(e -> {
            double num1 = Double.parseDouble(tfNum1.getText());
            double num2 = Double.parseDouble(tfNum2.getText());
            tfResult.setText(String.valueOf(num1 - num2));
        });

        btnMultiply.setOnAction(e -> {
            double num1 = Double.parseDouble(tfNum1.getText());
            double num2 = Double.parseDouble(tfNum2.getText());
            tfResult.setText(String.valueOf(num1 * num2));
        });

        btnDivide.setOnAction(e -> {
            double num1 = Double.parseDouble(tfNum1.getText());
            double num2 = Double.parseDouble(tfNum2.getText());
            if (num2 != 0) {
                tfResult.setText(String.valueOf(num1 / num2));
            } else {
                tfResult.setText("Error: Division by 0");
            }
        });

        VBox mainBox = new VBox(15, inputBox, buttonBox);
        mainBox.setPadding(new Insets(15));
        mainBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainBox, 400, 150);
        primaryStage.setTitle("SimpleCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

