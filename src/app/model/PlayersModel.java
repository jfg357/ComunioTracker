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

package app.model;

public class PlayersModel {

  private int playerID;
  private String playerFirstName;
  private String playerMiddleName;
  private String playerLastName;
  private String playerCountry;
  private String playerPhoto;
  private String playerHeatMap;

  public PlayersModel() {

  }

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