package com.mycompany._1_hwk_8;
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

public class MoveCircle extends Application {
    private double paneWidth = 400;
    private double paneHeight = 300;
    private double ballRadius = 15;
    private Circle ball;

    @Override
    public void start(Stage primaryStage) {
        Pane ballPane = new Pane();
        ball = new Circle(ballRadius, Color.RED);
        ball.setCenterX(paneWidth / 2);
        ball.setCenterY(paneHeight / 2);
        ballPane.getChildren().add(ball);
        ballPane.setPrefSize(paneWidth, paneHeight);

        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");
        Button upButton = new Button("Up");
        Button downButton = new Button("Down");
        leftButton.setFont(Font.font("Arial"));
        rightButton.setFont(Font.font("Arial"));
        upButton.setFont(Font.font("Arial"));
        downButton.setFont(Font.font("Arial"));

        leftButton.setOnAction(e -> moveBall(-10, 0)); 
        rightButton.setOnAction(e -> moveBall(10, 0)); 
        upButton.setOnAction(e -> moveBall(0, -10));
        downButton.setOnAction(e -> moveBall(0, 10)); 

        HBox controlBox = new HBox(10, leftButton, rightButton, upButton, downButton);

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(controlBox);

        Scene scene = new Scene(pane, paneWidth, paneHeight);
        primaryStage.setTitle("MoveCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveBall(double dx, double dy) {
        double newX = ball.getCenterX() + dx;
        double newY = ball.getCenterY() + dy;

        if (newX - ballRadius >= 0 && newX + ballRadius <= paneWidth) {
            ball.setCenterX(newX);
        }
        if (newY - ballRadius >= 0 && newY + ballRadius <= paneHeight) {
            ball.setCenterY(newY);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
