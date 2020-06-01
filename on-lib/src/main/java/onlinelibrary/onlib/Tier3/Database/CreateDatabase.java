package onlinelibrary.onlib.Tier3.Database;
import onlinelibrary.onlib.Shared.Comment;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 * A class used for initializing the database. It should be started once before operating the program
 * @author  Jakob & Gregor
 */
public class CreateDatabase {

    public static void main(String[] args) {
        String driver = "org.postgresql.Driver";

        String url = "jdbc:postgresql://localhost:5432/postgres";

        String user = "postgres";


        // Change the pw String to your password and run it one time only!
        String pw = "mat000";

        Connection connection = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, pw);
        } catch (SQLException e) {
            e.printStackTrace();
        }



        String sql = "CREATE SCHEMA IF NOT EXISTS \"ViaOnlineLibrary\";";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "CREATE TABLE IF NOT EXISTS \"ViaOnlineLibrary\".users ("
                + "  username varchar(50) NOT NULL PRIMARY KEY , "
                + "  password varchar(50) NOT NULL, "
                + "  email varchar(50) NOT NULL, "
                + "  isadmin boolean "+ ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String preparedSql = "INSERT INTO \"ViaOnlineLibrary\".users (username, password,email, isadmin) "
                + "SELECT * FROM (SELECT ?, ?,?,?) AS tmp ";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(preparedSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        addUserToDatabase(preparedStatement, "test", "test", "testemail3", true);
        addUserToDatabase(preparedStatement, "mat", "mat", "mat@gmail.com", true);


        try {
            String querysql = "SELECT  username, password,email FROM \"ViaOnlineLibrary\".users ORDER BY username;";
            PreparedStatement queryUserStatement = connection.prepareStatement(querysql);
            ResultSet resultSet = queryUserStatement.executeQuery();

            ArrayList<Object[]> results = new ArrayList<Object[]>();

            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                results.add(row);
            }

            resultSet.close();
            queryUserStatement.close();

            for (int i = 0; i < results.size(); i++) {
                Object[] row = results.get(i);
                String username = row[0].toString();
                String password = row[1].toString();
                String email = row[2].toString();

                System.out.println(username + " " + password + " " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        String sql2 = "CREATE TABLE IF NOT EXISTS \"ViaOnlineLibrary\".files ("
                + "  filename varchar(50) NOT NULL , "
                + "  username varchar(50) NOT NULL , "
                + "  uploadDate VARCHAR NOT NULL , "
                + "  format varchar(50) NOT NULL , "

                + "  filesize integer NOT NULL , "
                + "  path varchar,"
                + "  rating integer , "

                + "  math boolean, "
                + "  physics boolean , "
                + "  chemistry boolean , "
                + "  geography boolean , "
                + "  literature boolean , "
                + "  construction boolean, "
                + "  marketing boolean "
             + ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String preparedSql2 = "INSERT INTO \"ViaOnlineLibrary\".files (filename, username, uploadDate, format,filesize, path, rating, math, physics," +
                " chemistry, geography, literature, construction, marketing) "
                + "SELECT * FROM (SELECT ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?) AS tmp ";

        PreparedStatement preparedStatement2 = null;
        try {
            preparedStatement2 = connection.prepareStatement(preparedSql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        addFileToDatabase(preparedStatement2, "TestFile","Jakob", "22/01/2019","png",1200,"/s",4,true,false,false,false,false,false,false);





        String sql3 = "CREATE TABLE IF NOT EXISTS \"ViaOnlineLibrary\".comments ("
                + "  filename varchar(50) NOT NULL primary key , "
                + "  username varchar(50) NOT NULL , "
                + "  comment varchar(500) NOT NULL , "
                + "  commentDate varchar(50) NOT NULL "+ ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql3);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String preparedSql3 = "INSERT INTO \"ViaOnlineLibrary\".comments (filename, username, comment, commentDate) "
                + "SELECT * FROM (SELECT ?, ?, ?, ?) AS tmp ";

        PreparedStatement preparedStatement3 = null;
        try {
            preparedStatement3 = connection.prepareStatement(preparedSql3);
        } catch (SQLException e) {
            e.printStackTrace();
        }




        String sql4 = "CREATE TABLE IF NOT EXISTS \"ViaOnlineLibrary\".rating ("
                + " filename VARCHAR , "
                + " username VARCHAR , "
                + " rating integer , "
                + "  numberOfRating integer , "
                + "  totalRating VARCHAR "+ ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql4);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String preparedSql4 = "INSERT INTO \"ViaOnlineLibrary\".rating (filename, username, rating, numberOfRating, totalRating) "
                + "SELECT * FROM (SELECT ?, ?, ?, ?, ?) AS tmp ";

        PreparedStatement preparedStatement4 = null;
        try {
            preparedStatement4 = connection.prepareStatement(preparedSql4);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * A method for adding a user to the database
     *
     * @param preparedStatement a prepared statement object used for the sql querry
     * @param username          a String object to be added for the username
     * @param password          a String object to be added for the password
     * @param email             a String object to be added for the email
     */
    private static void addUserToDatabase(PreparedStatement preparedStatement, String username, String password, String email, boolean isadmin) {
        try {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setBoolean(4,isadmin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private static void addFileToDatabase(PreparedStatement preparedStatement2, String filename, String username, String uploadDate, String format, Integer filesize, String path,Integer rating, boolean math, boolean physics, boolean chemistry, boolean geography, boolean literature, boolean construction, boolean marketing) {
        try {
            preparedStatement2.setString(1, filename);
            preparedStatement2.setString(2, username);
            preparedStatement2.setString(3, uploadDate);
            preparedStatement2.setString(4, format);
            preparedStatement2.setInt(5, filesize);
            preparedStatement2.setString(6, path);
            preparedStatement2.setInt(7, rating);

            preparedStatement2.setBoolean(8, math);
            preparedStatement2.setBoolean(9, physics);
            preparedStatement2.setBoolean(10, chemistry);
            preparedStatement2.setBoolean(11, geography);
            preparedStatement2.setBoolean(12, literature);
            preparedStatement2.setBoolean(13, construction);
            preparedStatement2.setBoolean(14, marketing);
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void addCommentToDatabase(PreparedStatement preparedStatement1, String filename, String username, String comment, String commentDate) {
        try {
            preparedStatement1.setString(1, filename);
            preparedStatement1.setString(2, username);
            preparedStatement1.setString(3, comment);
            preparedStatement1.setString(4, commentDate);
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

