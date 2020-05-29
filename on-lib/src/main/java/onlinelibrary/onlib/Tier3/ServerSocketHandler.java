<<<<<<< HEAD:on-lib/src/main/java/onlinelibrary/onlib/Tier3/ServerSocketHandler.java
package onlinelibrary.onlib.Tier3;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Request;

import java.beans.PropertyChangeEvent;
=======
package onlinelibrary.onlib.Tier3.Server;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Request;
import onlinelibrary.onlib.Tier3.Shared.Model;

>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4:on-lib/src/main/java/onlinelibrary/onlib/Tier3/Server/ServerSocketHandler.java
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class ServerSocketHandler implements Runnable{
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    private Socket socket;
    // maybe this connection will be a problem ??? !
    //private Database model;
    private Model model;
    private ArrayList<Account> accounts;

    /**
     * A constuctor method  that initializes the Object input and output streams
     * @param socket a Socket object
     * @param model a connecton to the database interface
     */
    public ServerSocketHandler(Socket socket, Model model) {
        accounts= new ArrayList<>();

        this.socket = socket;
        this.model = model;

        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //model.addPropertyChangeListener("newUserAdded",this::userAdded);;
        //model.addPropertyChangeListener("userDeleted",this::userDeleted);

//        model.addListener("TaskRemoved", this::removeTask);
    }
    /*

    private void userDeleted(PropertyChangeEvent propertyChangeEvent) {
        String username = (String) propertyChangeEvent.getNewValue();

        Request req = new Request(Request.TYPE.DELETE, username);
        try {
            outToClient.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
/*
    private void userAdded(PropertyChangeEvent propertyChangeEvent) {
        try {
            Account newlyAdded = (Account) propertyChangeEvent.getNewValue();
            ArrayList<Account> list = new ArrayList<>();
            list.add(newlyAdded);
            Request req = new Request(Request.TYPE.ACCOUNTS, list);

            outToClient.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD:on-lib/src/main/java/onlinelibrary/onlib/Tier3/ServerSocketHandler.java
=======
 */

>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4:on-lib/src/main/java/onlinelibrary/onlib/Tier3/Server/ServerSocketHandler.java

    public void run() {
        try {
            while (true) {
                //System.out.println("Working");
                System.out.println(inFromClient.toString());
                System.out.println("here");

                //File temp = (File)inFromClient.readObject();

                //Request req= (Request)convertReq(temp);
                Request req= (Request)inFromClient.readObject();
                if(req.type == Request.TYPE.FILES){
                    //outToClient.writeObject(new Request(Request.TYPE.FILES, file));
<<<<<<< HEAD:on-lib/src/main/java/onlinelibrary/onlib/Tier3/ServerSocketHandler.java
                    System.out.println("Hello");
                    System.out.println(req.argument.toString());
                }


                if(req.type == Request.TYPE.ACCOUNTS){
                    System.out.println("Hello");
=======
                    System.out.println(req.argument.toString());
                }


                if(req.type == Request.TYPE.ACCOUNTS){
                    System.out.println(req.argument);

>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4:on-lib/src/main/java/onlinelibrary/onlib/Tier3/Server/ServerSocketHandler.java
                }

                if (req.equals(null)) {
                    System.out.println("Client disconnected :) ");
                }
                if (req.type == Request.TYPE.LOGIN) {

                    Account temp = (Account) req.get();
                    if (model.compareLogin(temp)) {
                        // send confirmation message
                        if (model.isAdmin(temp)) {
                            temp.setAdmin(true);
                            System.out.println("Server socket: IM AN ADMIN :)");
                            outToClient.writeObject(new Request(Request.TYPE.ADMIN, temp));
                        }

                        System.out.println("Login successful");
                        outToClient.writeObject(new Request(Request.TYPE.LOGIN, true));
                        System.out.println("Confirmation sent");
                        /*
                        outToClient.writeObject(new Request(Request.TYPE.EMAIL, model.getTempEmail()));
                        //outToClient.writeObject(new Request(Request.TYPE.ADD, ));
                        accounts.add(temp);
                        outToClient.writeObject(new Request(Request.TYPE.ACCOUNTS, model.userArray()));

                        */

                    } else {
                        // send error message to client
                        System.out.println("Login unsuccessful");
                        outToClient.writeObject(new Request(Request.TYPE.LOGIN, false));
                    }
                } else if (req.type == Request.TYPE.REMOVE) {
                    // model.taskRemoved((Object) req.task);
                } else if (req.type == Request.TYPE.DELETE) {
                    String username = (String) req.argument;
                    model.deleteUser(username);
                } else if (req.type == Request.TYPE.EDITPASS) {
                    // recieve an account from the socketClient

                    for (int i = 0; i < accounts.size(); i++) {
                        model.editPassword((Account) req.get());

                    }
                } else if (req.type == Request.TYPE.EDITEMAIL) {
                    // recieve an account from the socketClient

                    for (int i = 0; i < accounts.size(); i++) {
                        model.editEmail((Account) req.get());

                    }
                } else if (req.type == Request.TYPE.CREATEACC) {

                    System.out.println("CREATING ACCOUNT IN SSH");
                    model.createUser((Account) req.get());


                }

                if(inFromClient.equals(null)){
                    System.out.println("HELLO");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
