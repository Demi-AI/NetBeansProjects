package com.mycompany._1_hwk_8;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PickFourCards extends Application {
    @Override
    public void start(Stage primaryStage) {
        String cardFolderPath = "/card/";
        ImageView[] cardViews = new ImageView[4];
        for (int i = 0; i < 4; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setFitHeight(150);
        }

        Button refreshButton = new Button("Refresh");
        refreshButton.setFont(Font.font("Arial"));
        refreshButton.setOnAction(e -> {
            Random random = new Random();
            for (int i = 0; i < 4; i++) {
                int cardNumber = random.nextInt(52) + 1;
                String cardPath = cardFolderPath + cardNumber + ".png";
                Image cardImage = new Image(getClass().getResource(cardPath).toExternalForm());
                cardViews[i].setImage(cardImage);
            }
        });

        refreshButton.fire();

        HBox cardBox = new HBox(10);
        cardBox.getChildren().addAll(cardViews);
        cardBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(10);
        root.getChildren().addAll(cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Pick Four Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
