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
// Displaying the contents of the Authors table.

import app.interfaces.*;
import java.sql.*;

public class DisplayPlayers implements DBConnection {

  public static void main(String args[]) {
    final String SELECT_QUERY =
        "SELECT PLAYERID, PLAYERFIRSTNAME, PLAYERLASTNAME FROM PLAYER_T";

    try (
        Connection connection = DriverManager.getConnection(
            DATABASE_URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_QUERY)) {

      // get ResultSet's meta data
      ResultSetMetaData metaData = resultSet.getMetaData();
      int numberOfColumns = metaData.getColumnCount();

      System.out.printf("Table of League Database:%n%n");

      // display the names of the columns in the ResultSet
      for (int i = 1; i <= numberOfColumns; i++) {
        System.out.printf("%-8s\t", metaData.getColumnName(i));
      }
      System.out.println();

      // display query results
      while (resultSet.next()) {
        for (int i = 1; i <= numberOfColumns; i++) {
          System.out.printf("%-8s\t", resultSet.getObject(i));
        }
        System.out.println();
      }
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }
}