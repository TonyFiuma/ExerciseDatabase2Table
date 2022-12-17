
package it.develhope.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test{
    public static void main(String[] args){

        Connection connection = null;
        try{
            // db parameters
            String url      = "jdbc:mysql://localhost:3306/newdb";
            String user     = "root";
            String password = "password";

            // create a connection to the database
            connection = DriverManager.getConnection(url,user,password);

            Statement statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS `students` (`id` INT(10) NOT NULL AUTO_INCREMENT,`last_name` VARCHAR(30) "+
                    "NULL DEFAULT NULL,`first_name` VARCHAR(30) NULL DEFAULT NULL, PRIMARY KEY (`id`))";

            String query1 = "INSERT INTO students (last_name,first_name) VALUE (\"Rossi\",\"Giuseppe\");";
            String query2 = "INSERT INTO students (last_name,first_name) VALUE (\"Bianchi\",\"Giorgio\");";
            String query3 = "INSERT INTO students (last_name,first_name) VALUE (\"Pinarelli\",\"Mauro\");";
            String query4 = "INSERT INTO students (last_name,first_name) VALUE (\"Righi\",\"Lara\");";

            statement.executeUpdate(query);
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            statement.executeUpdate(query4);

            System.out.println("queries executed!");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}