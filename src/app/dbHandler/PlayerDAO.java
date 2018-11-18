package app.dbHandler;

import app.interfaces.*;
import app.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlayerDAO {
  // database URL, username and password
  private static final String DATABASE_URL = "jdbc:derby:lib\\ct";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "toor";

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
    return list;
  }

  public List<PlayersModel> getPlayerByFirstName(String playerFirstName) {
    String sqlQuery = "SELECT * FROM PLAYER_T WHERE PLAYERFIRSTNAME LIKE '%" + playerFirstName + "%'";
    List<PlayersModel> list = new ArrayList<>();
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
    return list;
  }
}