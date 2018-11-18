package app.model;

import javafx.beans.property.*;

public class PlayersModel {

  private int playerID;
  private String playerFirstName;
  private String playerMiddleName;
  private String playerLastName;
  private String playerCountry;
  private String playerPhoto;
  private String playerHeatMap;

  public PlayersModel(){

  }
/*  public PlayersModel(int playerID, String playerFirstName, String playerMiddleName,
      String playerLastName, String playerCountry, String playerPhoto, String playerHeatMap) {
    this.playerID = playerID;
    this.playerFirstName = new String(playerFirstName);
    this.playerMiddleName = new String(playerMiddleName);
    this.playerLastName = new String(playerLastName);
    this.playerCountry = new String(playerCountry);
    this.playerPhoto = new String(playerPhoto);
    this.playerHeatMap = new String(playerHeatMap);
  }*/

  public int getplayerID() {
    return playerID;
  }

  public void setplayerID(int playerID) {
    this.playerID = playerID;
  }

  public String getplayerFirstName() {
    return playerFirstName;
  }

  public void setplayerFirstName(String playerFirstName) {
    this.playerFirstName = playerFirstName;
  }

  public String getplayerMiddleName() {
    return playerMiddleName;
  }

  public void setplayerMiddleName(String playerMiddleName) {
    this.playerMiddleName = playerMiddleName;
  }

  public String getplayerLastName() {
    return playerLastName;
  }

  public void setplayerLastName(String playerLastName) {
    this.playerLastName = playerLastName;
  }
  public String getplayerCountry() {
    return playerCountry;
  }

  public void setplayerCountry(String playerCountry) {
    this.playerCountry = playerCountry;
  }

  public String getplayerPhoto() {
    return playerPhoto;
  }

  public void setplayerPhoto(String playerPhoto) {
    this.playerPhoto = playerPhoto;
  }

  public String getplayerHeatMap() {
    return playerHeatMap;
  }

  public void setplayerHeatMap(String playerHeatMap) {
    this.playerHeatMap = playerHeatMap;
  }
}