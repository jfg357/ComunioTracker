package app.controllers;

import app.model.PlayerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private TableView<PlayerModel> tbData;
    @FXML
    public TableColumn<PlayerModel, Integer> playerId;

    @FXML
    public TableColumn<PlayerModel, String> firstName;

    @FXML
    public TableColumn<PlayerModel, String> lastName;

    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadChart();
        loadPlayers();
    }

    private void loadChart()
    {

        PieChart.Data slice1 = new PieChart.Data("Goals", 213);
        PieChart.Data slice2 = new PieChart.Data("Played"  , 67);
        PieChart.Data slice3 = new PieChart.Data("Missed" , 36);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

    }


    private ObservableList<PlayerModel> playerModels = FXCollections.observableArrayList(
        new PlayerModel(1, "Lionel", "Messi"),
        new PlayerModel(2, "James", "Rodriguez"),
        new PlayerModel(3, "Cristiano", "Ronaldo"),
        new PlayerModel(4, "Pibe", "Valderrrama")
    );


    private void loadPlayers()
    {
        playerId.setCellValueFactory(new PropertyValueFactory<>("PlayerId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tbData.setItems(playerModels);
    }

}
