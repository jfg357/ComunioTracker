/**************************************************************************
 * (C) Copyright 2018  by Juan Gaviria & FGCU.                            *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this program make             *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in the code. The authors    *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

package app.views;

import app.interfaces.*;
import app.model.PlayersModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DisplayPlayer implements DBConnection {

  private static final String DEFAULT_QUERY = "SELECT * FROM PLAYER_T";

  private PlayersModel createPlayer(ResultSet rs) {
    PlayersModel p = new PlayersModel();
    try {
      p.setplayerID(rs.getInt("PLAYERID"));
      p.setplayerFirstName(rs.getString("PLAYERFIRSTNAME"));
      p.setplayerMiddleName(rs.getString("PLAYERMIDDLENAME"));
      p.setplayerLastName(rs.getString("PLAYERLASTNAME"));
      p.setplayerCountry(rs.getString("PLAYERCOUNTRY"));
      p.setplayerPhoto(rs.getString("PLAYERPHOTO"));
      p.setplayerHeatMap(rs.getString("PLAYERHEATMAP"));
    } catch (SQLException ex) {
    }
    return p;
  }

  public List<PlayersModel> getPlayers() {
    String sqlQuery = "SELECT * FROM PLAYER_T ORDER BY PLAYERID";
    List<PlayersModel> list = new ArrayList<>();
    doWork(sqlQuery, list);
    return list;
  }

  private void doWork(String sqlQuery, List<PlayersModel> list) {
    try {
      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sqlQuery);
      while (rs.next()) {
        PlayersModel p = createPlayer(rs);
        list.add(p);
      }
      rs.close();
      connection.close();
    } catch (SQLException ex) {

    }
  }

  public List<PlayersModel> getPlayerByFirstName(String playerFirstName) {
    String sqlQuery =
        "SELECT * FROM PLAYER_T WHERE PLAYERFIRSTNAME LIKE '%" + playerFirstName + "%'";
    List<PlayersModel> list = new ArrayList<>();
    doWork(sqlQuery, list);
    return list;
  }
}