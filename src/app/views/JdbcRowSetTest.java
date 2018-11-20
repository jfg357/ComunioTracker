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

package app.views;

import app.interfaces.*;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest implements DBConnection {

  public static void main(String args[]) {
    // connect to database books and query database
    try (JdbcRowSet rowSet =
        RowSetProvider.newFactory().createJdbcRowSet()) {

      // specify JdbcRowSet properties
      rowSet.setUrl(DATABASE_URL);
      rowSet.setUsername(USERNAME);
      rowSet.setPassword(PASSWORD);
      rowSet.setCommand("SELECT * FROM League_T"); // set query
      rowSet.execute(); // execute query

      // process query results
      ResultSetMetaData metaData = rowSet.getMetaData();
      int numberOfColumns = metaData.getColumnCount();
      System.out.printf("Table of League Database:%n%n");

      // display rowset header
      for (int i = 1; i <= numberOfColumns; i++) {
        System.out.printf("%-8s\t", metaData.getColumnName(i));
      }
      System.out.println();

      // display each row
      while (rowSet.next()) {
        for (int i = 1; i <= numberOfColumns; i++) {
          System.out.printf("%-8s\t", rowSet.getObject(i));
        }
        System.out.println();
      }
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
      System.exit(1);
    }
  }
}

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
