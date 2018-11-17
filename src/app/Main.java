package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/Home.fxml"));
        primaryStage.setTitle("Comunio Tracker");
        primaryStage.getIcons().add(new Image("/app/icons/icon.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    //you can download the glyph browser - link provided.
    public static void main(String[] args) {
        launch(args);
    }
}
