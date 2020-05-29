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
        String pw = "k4j4mnzswek";

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

                + "  math boolean, "
                + "  physics boolean , "
                + "  chemistry boolean , "
                + "  geography boolean , "
                + "  literature boolean , "
                + "  construction boolean, "
                + "  marketing boolean, "

                + "  filesize integer NOT NULL , "
                + "  rating integer , "
                + "  path varchar(50) NOT NULL"+ ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String preparedSql2 = "INSERT INTO \"ViaOnlineLibrary\".files (filename, username, uploadDate, format, math, physics," +
                " chemistry, geography, literature, construction, marketing, filesize, rating, path) "
                + "SELECT * FROM (SELECT ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?) AS tmp ";

        PreparedStatement preparedStatement2 = null;
        try {
            preparedStatement2 = connection.prepareStatement(preparedSql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        addFileToDatabase(preparedStatement2, "TestFile","Jakob", "22/01/2019","png",true,false,false,false,false,false,false,1200,4,"/s");





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

        Comment comment = new Comment("This file is shit ! Dont ever use it!");

        addCommentToDatabase(preparedStatement3,"File1","Jakob", comment.getComment(),comment.getNow());




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




    private static void addFileToDatabase(PreparedStatement preparedStatement2, String filename, String username, String uploadDate, String format, boolean math, boolean physics, boolean chemistry, boolean geography, boolean literature, boolean construction, boolean marketing,  Integer filesize, Integer rating, String path) {
        try {
            preparedStatement2.setString(1, filename);
            preparedStatement2.setString(2, username);
            preparedStatement2.setString(3, uploadDate);
            preparedStatement2.setString(4, format);
            preparedStatement2.setBoolean(5, math);
            preparedStatement2.setBoolean(6, physics);
            preparedStatement2.setBoolean(7, chemistry);
            preparedStatement2.setBoolean(8, geography);
            preparedStatement2.setBoolean(9, literature);
            preparedStatement2.setBoolean(10, construction);
            preparedStatement2.setBoolean(11, marketing);
            preparedStatement2.setInt(12, filesize);
            preparedStatement2.setInt(13, rating);
            preparedStatement2.setString(14, path);
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

