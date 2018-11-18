package app.dbHandler;// Main application class that loads and displays the GUI.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DisplayQueryResults extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = 
         FXMLLoader.load(getClass().getResource("app/fxml/DisplayQueryResults.fxml"));
      
      Scene scene = new Scene(root);
      stage.setTitle("Display Query Results");
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}
