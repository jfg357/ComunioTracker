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

import app.interfaces.*;
import app.model.ResultSetTableModel;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javax.swing.*;
import javax.swing.table.*;


public class DBQueryController implements DBConnection {

  @FXML
  private BorderPane borderPane;
  @FXML
  private TextArea queryTextArea;
  @FXML
  private TextField filterTextField;

  // default query retrieves all data from Authors table
  private static final String DEFAULT_QUERY = "SELECT * FROM PLAYER_T";

  // used for configuring JTable to display and sort data
  private ResultSetTableModel tableModel;
  private TableRowSorter<TableModel> sorter;

  public void initialize() {
    queryTextArea.setText(DEFAULT_QUERY);

    // create app.model.ResultSetTableModel and display database table
    try {
      // create TableModel for results of DEFAULT_QUERY
      tableModel = new ResultSetTableModel(DATABASE_URL,
          USERNAME, PASSWORD, DEFAULT_QUERY);

      // create JTable based on the tableModel
      JTable resultTable = new JTable(tableModel);

      // set up row sorting for JTable
      sorter = new TableRowSorter<>(tableModel);
      resultTable.setRowSorter(sorter);

      // configure SwingNode to display JTable, then add to borderPane
      SwingNode swingNode = new SwingNode();
      swingNode.setContent(new JScrollPane(resultTable));
      borderPane.setCenter(swingNode);
    } catch (SQLException sqlException) {
      displayAlert(AlertType.ERROR, "Database Error",
          sqlException.getMessage());
      tableModel.disconnectFromDatabase(); // close connection
      System.exit(1); // terminate application
    }
  }

  // query the database and display results in JTable
  @FXML
  void submitQueryButtonPressed(ActionEvent event) {
    // perform a new query
    try {
      tableModel.setQuery(queryTextArea.getText());
    } catch (SQLException sqlException) {
      displayAlert(AlertType.ERROR, "Database Error",
          sqlException.getMessage());

      // try to recover from invalid user query
      // by executing default query
      try {
        tableModel.setQuery(DEFAULT_QUERY);
        queryTextArea.setText(DEFAULT_QUERY);
      } catch (SQLException sqlException2) {
        displayAlert(AlertType.ERROR, "Database Error",
            sqlException2.getMessage());
        tableModel.disconnectFromDatabase(); // close connection
        System.exit(1); // terminate application
      }
    }
  }

  // apply specified filter to results
  @FXML
  void applyFilterButtonPressed(ActionEvent event) {
    String text = filterTextField.getText();

    if (text.length() == 0) {
      sorter.setRowFilter(null);
    } else {
      try {
        sorter.setRowFilter(RowFilter.regexFilter(text));
      } catch (PatternSyntaxException pse) {
        displayAlert(AlertType.ERROR, "Regex Error",
            "Bad regex pattern");
      }
    }
  }

  // display an Alert dialog
  private void displayAlert(
      AlertType type, String title, String message) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
