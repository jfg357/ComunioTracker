/**************************************************************************
 * (C) Copyright 2018 by Juan Gaviria & FGCU.                             *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this program make             *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in the code. The authors    *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

  @FXML
  private Button btnDashboard;

  @FXML
  private Button btnPlayers;

  @FXML
  private Button btn_Timetable;

  @FXML
  private Button btnDBQuery;

  @FXML
  private Button btnSettings;

  @FXML
  private Button btnUpdate;

  @FXML
  private Button btnClasses;

  //my bad - the freaking mouse event
  @FXML

  private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
    if (mouseEvent.getSource() == btnDashboard) {
      loadStage("/app/fxml/Dashboard.fxml");
    } else if (mouseEvent.getSource() == btnPlayers) {
      loadStage("/app/fxml/Players.fxml");
    } else if (mouseEvent.getSource() == btn_Timetable) {
      loadStage("/app/fxml/Timetable.fxml");
    } else if (mouseEvent.getSource() == btnDBQuery) {
      loadStage("/app/fxml/DisplayQueryResults.fxml");
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  private void loadStage(String fxml) {
    try {
      Parent root = FXMLLoader.load(getClass().getResource(fxml));
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.getIcons().add(new Image("/app/icons/icon.png"));
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
