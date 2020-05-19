package onlinelibrary.onlib.Client;


import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SocketClient implements Client {

    private ClientSocketHandler socketHandler;
    private Account acc;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Socket socket = null;


    /**
     * A constructor fr the SocketClient class that establishes the connection to the server and passes it to a new thead
     */

    public SocketClient() {
        try {
            socket = new Socket("localhost", 2910);
            System.out.println("Connected");
            socketHandler = new ClientSocketHandler(
                    new ObjectOutputStream(socket.getOutputStream()),
                    new ObjectInputStream(socket.getInputStream()), this);
            Thread t = new Thread(socketHandler);
            t.setDaemon(true);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method for sending an Account object used for logging in to the server
     *
     * @param acc An Account object that will be sent to the server
     */
    @Override
    public void setAccount(Account acc) {
        this.acc = acc;
        socketHandler.sendToServer(Request.TYPE.LOGIN, acc);
    }

    /**
     * A method to send a request to the server that a new account is created
     * @param acc An account object that will be sent to the server
     */
    @Override
    public void createAcc(Account acc) {

        socketHandler.sendToServer(Request.TYPE.CREATEACC, acc);
    }



    @Override
    public boolean isAdmin() {
        return acc.isAdmin();
    }


    /**
     * A method to send a request to the server that a user will be deleted
     * @param username A string for the username of the user that will be deleted
     */
    @Override
    public void deleteUser(String username) {
        socketHandler.sendToServer(Request.TYPE.DELETE,username);
    }

    /**
     * A method for changing the password and sending that change to the server
     * @param acc An Account that contains the updated password
     */
    @Override
    public void editPass(Account acc) {
        this.acc = acc;
        socketHandler.sendToServer(Request.TYPE.EDITPASS, acc);

    }

    /**
     * A method for changing the e-mail of the ueser
     * @param acc An Account that contains the new e-mail
     */
    @Override
    public void editEmail(Account acc) {
        this.acc = acc;
        socketHandler.sendToServer(Request.TYPE.EDITEMAIL, acc);
    }

        @Override
        public void addPropertyChangeListener (String name, PropertyChangeListener listener){
            support.addPropertyChangeListener(name, listener
            );
        }

        @Override
        public void addPropertyChangeListener (PropertyChangeListener listener){
            support.addPropertyChangeListener(listener);
        }

        @Override
        public void removePropertyChangeListener (String name, PropertyChangeListener listener){
            support.removePropertyChangeListener(name, listener);
        }

        @Override
        public void removePropertyChangeListener (PropertyChangeListener listener){
            support.removePropertyChangeListener(listener);
        }

        /**
         * A method for getting the conformation or rejection of the login details that were provided by the client
         *
         * @param argument a boolean value that determine if the user will be logged into the system
         */
        public void loginResult ( boolean argument){
            support.firePropertyChange("LoginResult", null, argument);
        }


    /**
     * A method for firing a Property change to the model manager that adds a new user to the ListView
     * @param users An ArrayList of type Account that will be put into the ListView
     */
        public void addNewUser(ArrayList<Account> users){
            support.firePropertyChange("newUserAdded",null,users);
        }
    /**
     * A method for firing a Property change to the model manager that delets a user from the ListView
     * @param username An ArrayList of type Account that will be taken out of the ListView
     */
        public void deleteUserFromList(String username){
            support.firePropertyChange("deleteUserFromList",null,username);
        }

    /**
     * A method for setting the email in the Account variable
     * @param email A String for the e-mail
     */
        public void setEmail(String email){
            acc.setEmail(email);
        }

    /**
     * A method for getting the Account information
     * @return A String object
     */
    @Override
        public String getAccountInfo(){
            System.out.println("USERNAME"+acc.getUsername());
            System.out.println( "EMAIL"+acc.getEmail());
            return acc.getUsername() + "\t" + acc.getEmail();

        }

    /**
     * A method for setting the account as an admin
     * @param temp An admin Account
     */
        public void setAdminAccount(Account temp)
        {
            this.acc = temp;
        }


    }



