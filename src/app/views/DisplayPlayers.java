package app.views;// Fig. 24.23: app.views.DisplayAuthors.java
// Displaying the contents of the Authors table.

import java.sql.*;

public class DisplayPlayers {
   public static void main(String args[]) {
      final String DATABASE_URL = "jdbc:derby:lib\\ct";
      final String SELECT_QUERY =                            
         "SELECT PLAYERID, PLAYERFIRSTNAME, PLAYERLASTNAME FROM PLAYER_T";

      // use try-with-resources to connect to and query the database
      try (                                                        
         Connection connection = DriverManager.getConnection(      
            DATABASE_URL, "root", "toor");
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
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
      }                                                   
   } 
} 




/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

 