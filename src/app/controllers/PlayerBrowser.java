package app.controllers;

import app.dbHandler.*;
import app.model.*;
import javafx.application.Application;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayerBrowser extends Application {

  // List of contact table properties
  private String[] propertyName = {"playerID", "playerFirstName", "playerMiddleName",
      "playerLastName", "playerCountry", "playerPhoto", "playerHeatMap"};
  private String[] propertyLabel = {"ID", "First Name", "Middle Name", "Last Name",
      "Country of Origin", "Photo", "Heat Map"};
  private PlayerDAO player = new PlayerDAO();
  private final GridPane gridPane = new GridPane();
  private final Label lblName = new Label("Search by Name");
  private final TextField searchField = new TextField();
  private ObservableList<PlayersModel> observableNames;
  private FilteredList<PlayersModel> filteredData;
  private SortedList<PlayersModel> sortedData;
  private final ListView<PlayersModel> listView;
  TableView<PlayersModel> playersTableView = new TableView<>();

  public PlayerBrowser() {
    lblName.setTextFill(Color.web("#0076a3"));
    observableNames = FXCollections.observableArrayList(player.getPlayers());
    filteredData = new FilteredList<>(observableNames, p -> true);
    sortedData = new SortedList<>(filteredData);
    listView = new ListView<>(sortedData);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Player List");
    primaryStage.setMaximized(true);
    BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane, 650, 400, true);
    gridPane.setPadding(new Insets(10));
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(lblName, 0, 0);
    gridPane.add(searchField, 0, 1);

    // Search TextField event handling
    searchField.textProperty().addListener((observable, oldValue, newValue) ->
        filteredData.setPredicate(str -> {
          if (newValue == null || newValue.isEmpty()) {
            return true;
          }
          if (str.getplayerFirstName().toLowerCase().contains(newValue.toLowerCase())) {
            return true;
          }
          return false;
        }));
    listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    listView.setPrefHeight(Integer.MAX_VALUE);

    // Sets a new cell factory to use in the ListView.
    // This throws away all old list cells and new ListCells
    // created with the new cell factory.
    listView.setCellFactory(listView -> {
      Tooltip tooltip = new Tooltip();
      ListCell<PlayersModel> cell = new ListCell<PlayersModel>() {
        //@Override
        public void updateItem(PlayersModel PlayersModel,
            Boolean empty) {
          super.updateItem(PlayersModel, empty);
          if (PlayersModel != null) {
            setText(PlayersModel.getplayerFirstName());
            tooltip.setText(PlayersModel.getplayerLastName());
            setTooltip(tooltip);
          } else {
            setText(null);
          }
        }
      };
      return cell;
    });

    gridPane.add(listView, 0, 2);

    // Create and initializing TableView
    ObservableList<PlayersModel> playersModelList = FXCollections.observableArrayList();
    playersTableView.setItems(playersModelList);
    playersTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    for (int i = 0; i < propertyLabel.length; i++) {
      TableColumn<PlayersModel, Object> col = new TableColumn<>(propertyLabel[i]);
      col.setCellValueFactory(new PropertyValueFactory<>(propertyName[i]));
      playersTableView.getColumns().add(col);
    }

    borderPane.setCenter(playersTableView);
    borderPane.setLeft(gridPane);

    // TableView will populate from the playersModelList
    // playersModelList will have value according to the
    // item selected in the ListView
    listView.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<PlayersModel>() {
          //@Override
          public void changed(ObservableValue<? extends PlayersModel>
              observable, PlayersModel oldValue, PlayersModel newValue) {
            if (observable != null && observable.getValue() != null) {
              playersModelList.clear();
              playersModelList.addAll(player.getPlayerByFirstName(newValue.getplayerFirstName()));
            }
          }
        });
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}