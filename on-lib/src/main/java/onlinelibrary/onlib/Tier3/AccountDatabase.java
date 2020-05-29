package onlinelibrary.onlib.Tier3;

import onlinelibrary.onlib.Shared.Account;

import java.sql.*;
import java.util.ArrayList;

public class AccountDatabase implements DatabaseInterface {

    /**
     * @auther Jakob & Gregor
     * @version 1.0
     */


    private static Connection c = null;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String tempEmail;




    /**
     * A method for opening the connection to the database. Every time an operation is called on the database this method should be used
     * @throws SQLException is not handled in this method
     */
    private static void openConn() throws SQLException {
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "baster123");

    }

    /**
     * A method to compare the login infromation that the server got to the database
     * @param temp an Account object that should be compared to the database
     * @return a boolean value
     */

    public boolean compareLogin(Account temp) {
        try {
            openConn();
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM \"ViaOnlineLibrary\".users;");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String username = rs.getString("username");
                String pass = rs.getString("password");
                String mail = rs.getString("email");
                if(temp.getUsername()!= null || temp.getPassword()!=null)
                {
                    if (temp.getUsername().equals(username) && temp.getPassword().equals(pass)) {
                        System.out.println("account validated");
                        tempEmail = mail;
                        return true;
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
        return false;
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
                        "' WHERE username = '" + name + "';";


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
                        "' WHERE username = '" + name + "';";

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


}
