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


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PlayerModel {

  private SimpleIntegerProperty playerId;
  private SimpleStringProperty firstName;
  private SimpleStringProperty lastName;

  public PlayerModel(Integer playerId, String firstName, String lastName) {
    this.playerId = new SimpleIntegerProperty(playerId);
    this.firstName = new SimpleStringProperty(firstName);
    this.lastName = new SimpleStringProperty(lastName);
  }

  public int getPlayerId() {
    return playerId.get();
  }

  public void setPlayerId(int playerId) {
    this.playerId = new SimpleIntegerProperty(playerId);
  }

  public String getFirstName() {
    return firstName.get();
  }

  public void setFirstName(String firstName) {
    this.firstName = new SimpleStringProperty(firstName);
  }

  public String getLastName() {
    return lastName.get();
  }

  public void setLastName(String lastName) {
    this.lastName = new SimpleStringProperty(lastName);
  }
}