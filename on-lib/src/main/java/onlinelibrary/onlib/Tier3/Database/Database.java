package onlinelibrary.onlib.Tier3.Database;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Comment;
import onlinelibrary.onlib.Shared.Files;
import onlinelibrary.onlib.Shared.Rating;

import java.sql.*;
import java.util.ArrayList;

public class Database implements DatabaseInterface {

    /**
     * @auther Jakob & Gregor
     * @version 1.0
     */


    private static Connection c = null;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String tempEmail;
   private ArrayList<Files> files=new ArrayList<>();





    /**
     * A method for opening the connection to the database. Every time an operation is called on the database this method should be used
     * @throws SQLException is not handled in this method
     */
    private static void openConn() throws SQLException {
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "mat000");

    }

    /**
     * A method to compare the login infromation that the server got to the database
     * @param temp an Account object that should be compared to the database
     * @return a boolean value
     */

    public Account compareLogin(Account temp) {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".users;");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String username = rs.getString("username");
                String pass = rs.getString("password");
                String mail = rs.getString("email");
                boolean admin = rs.getBoolean("isadmin");
                if(temp.getUsername()!= null || temp.getPassword()!=null)
                {
                    if (temp.getUsername().equals(username) && temp.getPassword().equals(pass)) {
                        System.out.println("account validated");
                        tempEmail = mail;
                        Account acc = new Account(username,pass,mail);
                        acc.setAdmin(admin);
                        return acc;
                    }
                }

            }
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Account ac1 = new Account("null","null","null");
        return ac1;
    }


    public boolean isAdmin(Account temp)
    {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".users;");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                String username=rs.getString("username");
                String password=rs.getString("password");
                boolean isAdmin=rs.getBoolean("isadmin");
                if (username.equals(temp.getUsername()) && password.equals(temp.getPassword()) && isAdmin)
                {
                    return true;
                }
                else return false;
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String getTempEmail(){
        return tempEmail;
    }

    public void deleteUser(String username) {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".users;");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(username);

            String praparesql="DELETE FROM \"ViaOnlineLibrary\".users WHERE username='"+username+"';";

            try {
                PreparedStatement ps=c.prepareStatement(praparesql);
                rs=ps.executeQuery();
                ps.close();
            } catch (SQLException e) {
                System.out.println("User deleted: "+username);;
            }


            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editPassword(Account acc) {

        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".users;");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String name = rs.getString("username");

                String q1 = "UPDATE  \"ViaOnlineLibrary\".users set password = '" + acc.getPassword() +
                        "' WHERE username = '" + acc.getUsername() + "';";


                PreparedStatement ps = c.prepareStatement(q1);

                int x = ps.executeUpdate();

                if (x > 0)
                    System.out.println("Password Successfully Updated");
                else
                    System.out.println("ERROR OCCURED ");

            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editEmail(Account acc) {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".users;");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String name = rs.getString("username");

                String q1 = "UPDATE  \"ViaOnlineLibrary\".users set email = '" + acc.getEmail() +
                        "' WHERE username = '" + acc.getUsername() + "';";

                System.out.println(q1);
                PreparedStatement ps = c.prepareStatement(q1);

                int x = ps.executeUpdate();

                if (x > 0)
                    System.out.println("Email Successfully Updated");
                else
                    System.out.println("ERROR OCCURED ");

            }
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public ArrayList<Account> userArray() {

        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".users;");
            ResultSet rs = preparedStatement.executeQuery();
            accounts.clear();
            while (rs.next()) {

                String username = rs.getString("username");
                String pass = rs.getString("password");
                String email = rs.getString("email");
                boolean isAdmin = rs.getBoolean("isadmin");
                Account temp=new Account(username, pass, email);
                temp.setAdmin(isAdmin);
                accounts.add(temp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("WAS THIS IT ?");
        return accounts;
    }

    public void createUser(Account acc) {

        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".users;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {


                String preparedSql = "INSERT INTO \"ViaOnlineLibrary\".users (username, password,email,isadmin) "
                        + "SELECT * FROM (SELECT ?, ?,?,?) AS tmp ";


                try {
                    preparedStatement = c.prepareStatement(preparedSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                addUserToDatabase(preparedStatement, acc.getUsername(), acc.getPassword(), acc.getEmail(), acc.isAdmin());

                resultSet.close();
                preparedStatement.close();

            }

        } catch (SQLException e) {
            System.out.println("User Added ");
        }

    }

    public ArrayList<Files> files() {

        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".files;");
            ResultSet rs = preparedStatement.executeQuery();
            files.clear();
            while (rs.next()) {

                String filename = rs.getString("filename");
                String username = rs.getString("username");
                String uploadDate = rs.getString("uploadDate");
                String format = rs.getString("format");
                Integer filesize = rs.getInt("filesize");
                Integer rating = rs.getInt("rating");
                String path = rs.getString("path");


                boolean math = rs.getBoolean("math");
                boolean physics = rs.getBoolean("physics");
                boolean chemistry = rs.getBoolean("chemistry");
                boolean geography = rs.getBoolean("geography");
                boolean literature = rs.getBoolean("literature");
                boolean construction = rs.getBoolean("construction");
                boolean marketing = rs.getBoolean("marketing");


                files.add(new Files(filename, username, uploadDate, format, filesize, path , rating, math, physics, chemistry, geography, literature, construction, marketing, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return files;
    }



    @Override
    public void addFile(Files files) {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".files;");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("DATABASE: " + files.getFileName() + files.getDateOfUpload());


            while (rs.next()) {
                System.out.println("file not in database");

                String preparedSql = "INSERT INTO \"ViaOnlineLibrary\".files (filename, username, uploadDate, format, filesize, path , rating, math, physics, chemistry, geography, literature, construction, marketing)" +
                        "SELECT * FROM (SELECT ?, ?,?,?,?,?,?,?,?,?,?,?) AS tmp";
                try {
                    preparedStatement = c.prepareStatement(preparedSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs.next()==false)
            {
                String preparedSql = "INSERT INTO \"ViaOnlineLibrary\".files (filename, username, uploadDate, format, filesize, path , rating, math, physics, chemistry, geography, literature, construction, marketing)" +
                        "SELECT * FROM (SELECT ?, ?,?,?,?,?,?,?,?,?,?,?,?,?) AS tmp";
                try {
                    preparedStatement = c.prepareStatement(preparedSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("File Now in database!");
            addFileTODataBase(preparedStatement, files.getFileName(), files.getUsername(), files.getDateOfUpload(), files.getFormat(), files.getFileSize(), files.getPath(), files.getRating(), files.isMath(), files.isPhysics(), files.isChemistry(), files.isGeography(), files.isLiterature(), files.isConstruction(), files.isMarketing());

            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void deleteFile(String filename) {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".files;");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(filename);
            String praparesql="DELETE FROM \"ViaOnlineLibrary\".files WHERE filename='"+filename+"';";

            try {
                PreparedStatement ps=c.prepareStatement(praparesql);
                rs=ps.executeQuery();
                ps.close();
            } catch (SQLException e) {
                System.out.println("File deleted: "+filename);;
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void addRatingToFile(Rating rating, Files files, Account account) {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".rating;");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("DATABASE: " + files.getFileName() + " " + account.getUsername());


            while (rs.next()) {
                System.out.println("rating not in database");

                String preparedSql = "INSERT INTO \"ViaOnlineLibrary\".rating (filename, username, rating, numberofrating, totalrating)" +
                        "SELECT * FROM (SELECT ?, ?, ?, ?, ?) AS tmp";
                try {
                    preparedStatement = c.prepareStatement(preparedSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            String username = rs.getString("username");

            String filename = rs.getString("filename");

            double numberofratings = rs.getDouble("numberofrating");

            double totalratings = rs.getDouble("totalrating");
            if(account.getUsername().equals(username) && files.getFileName().equals(filename))
            {

                String preparedSql = "INSERT INTO \"ViaOnlineLibrary\".rating (filename, username, rating, numberofrating, totalrating)" +
                        "SELECT * FROM (SELECT ?, ?, ?, ?, ?) AS tmp";
                try {
                    preparedStatement = c.prepareStatement(preparedSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            numberofratings++;
            totalratings += rating.getRating()/numberofratings;

            System.out.println("Rating Now in database!");
            addRatingToFileDatabase(preparedStatement, files.getFileName(),account.getUsername(),rating.getRating(),numberofratings,totalratings);
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addComment(Files files, Comment comment, Account account) {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".comment;");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("DATABASE: " + files.getFileName() +" "+ account.getUsername());


            while (rs.next()) {
                System.out.println("Comment not in database");

                String preparedSql = "INSERT INTO \"ViaOnlineLibrary\".files (filename, username, comment,commentdate)" +
                        "SELECT * FROM (SELECT ?, ?,?,?) AS tmp";
                try {
                    preparedStatement = c.prepareStatement(preparedSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs.next()==false)
            {
                String preparedSql = "INSERT INTO \"ViaOnlineLibrary\".files (filename, username, comment,commentdate)" +
                        "SELECT * FROM (SELECT ?, ?,?,?) AS tmp";
                try {
                    preparedStatement = c.prepareStatement(preparedSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Comment now in database!");
            addCommentTODataBase(preparedStatement, files.getFileName(),account.getUsername(),comment.getComment(), comment.getNow());
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Comment> comments(Files files) {

        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".comments;");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {


                String filename = rs.getString("filename");
                String username = rs.getString("username");
                String comment = rs.getString("comment");

                String commentdate = rs.getString("commentdate");



                if (files.getFileName().equals(filename))
                {
                    comments(files).add(new Comment(username,commentdate,comment));
                }




            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments(files);
    }




    private void addCommentTODataBase(PreparedStatement preparedStatement3, String filename, String username, String comment, String commentdate) {

        try {
            preparedStatement3.setString(1, filename);
            preparedStatement3.setString(2, username);
            preparedStatement3.setString(3, comment);
            preparedStatement3.setString(4, commentdate);
            preparedStatement3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private static void addRatingToFileDatabase(PreparedStatement preparedStatement, String filename, String username, double rating, double numberofrating, double totalrating) {
        try {
            preparedStatement.setString(1, filename);
            preparedStatement.setString(2, username);
            preparedStatement.setDouble(3, rating);
            preparedStatement.setDouble(4, numberofrating);

            preparedStatement.setDouble(5, totalrating);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void addFileTODataBase(PreparedStatement preparedStatement2, String filename, String username, String uploadDate, String format, int filesize, String path, int rating, boolean math, boolean physics, boolean chemistry, boolean geography, boolean literature, boolean construction, boolean marketing) {

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






    private static void addUserToDatabase(PreparedStatement preparedStatement, String username, String password, String email, boolean isadmin) {
        try {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setBoolean(4, isadmin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
