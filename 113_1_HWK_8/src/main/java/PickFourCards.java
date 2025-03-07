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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// 定義 PickFourCards 類別，繼承 Application，用於顯示一個隨機選擇四張卡片的 GUI 應用
public class PickFourCards extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 卡片圖片的資料夾路徑
        String cardFolderPath = "/card/";

        // 定義 ImageView 陣列，用於顯示四張卡片
        ImageView[] cardViews = new ImageView[4];
        for (int i = 0; i < 4; i++) {
            cardViews[i] = new ImageView(); // 創建 ImageView 物件
            cardViews[i].setFitWidth(100); // 設定卡片寬度
            cardViews[i].setFitHeight(150); // 設定卡片高度
        }

        // 創建一個按鈕，用於刷新卡片
        Button refreshButton = new Button("Refresh");
        refreshButton.setFont(Font.font("Arial")); // 設定按鈕字體
        refreshButton.setOnAction(e -> { // 設定按鈕的點擊事件
            Random random = new Random(); // 隨機數生成器
            for (int i = 0; i < 4; i++) {
                int cardNumber = random.nextInt(52) + 1; // 隨機選擇 1 到 52 之間的卡片
                String cardPath = cardFolderPath + cardNumber + ".png"; // 組合卡片圖片路徑
                Image cardImage = new Image(getClass().getResource(cardPath).toExternalForm()); // 加載卡片圖片
                cardViews[i].setImage(cardImage); // 設定卡片圖片到對應的 ImageView
            }
        });

        // 自動觸發按鈕點擊事件，初始顯示四張隨機卡片
        refreshButton.fire();

        // 創建一個 HBox 用於橫向排列卡片
        HBox cardBox = new HBox(10); // 卡片之間的間距為 10 像素
        cardBox.getChildren().addAll(cardViews); // 添加卡片到 HBox
        cardBox.setAlignment(Pos.CENTER); // 設定 HBox 的對齊方式為居中

        // 創建一個 VBox 用於垂直排列卡片和按鈕
        VBox root = new VBox(10); // 元素之間的間距為 10 像素
        root.getChildren().addAll(cardBox, refreshButton); // 添加 HBox 和按鈕到 VBox
        root.setAlignment(Pos.CENTER); // 設定 VBox 的對齊方式為居中

        // 創建場景並設置主視窗
        Scene scene = new Scene(root, 500, 300); // 設定場景大小為 500x300
        primaryStage.setTitle("Pick Four Cards"); // 設定視窗標題
        primaryStage.setScene(scene); // 將場景設定到主視窗
        primaryStage.show(); // 顯示主視窗
    }

    // 主方法，用於啟動 JavaFX 應用
    public static void main(String[] args) {
        launch(args); // 啟動 JavaFX 應用
    }
}
