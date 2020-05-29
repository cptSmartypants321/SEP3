<<<<<<< HEAD
package onlinelibrary.onlib.Tier3.Server;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.File;
import onlinelibrary.onlib.Shared.Request;
import onlinelibrary.onlib.Tier3.Shared.Model;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
=======
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
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4


public class ServerSocketHandler implements Runnable{
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    private Socket socket;
    // maybe this connection will be a problem ??? !
    //private Database model;
    private Model model;
    private ArrayList<Account> accounts;

<<<<<<< HEAD
    public static HashMap<String, File> FileHashmap;

=======
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
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

<<<<<<< HEAD
 */

=======
<<<<<<< HEAD:on-lib/src/main/java/onlinelibrary/onlib/Tier3/ServerSocketHandler.java
=======
 */

>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4:on-lib/src/main/java/onlinelibrary/onlib/Tier3/Server/ServerSocketHandler.java
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4

    public void run() {
        try {
            while (true) {
<<<<<<< HEAD
                //File temp = (File)inFromClient.readObject();
                //Request req= (Request)convertReq(temp);
                Request req= (Request)inFromClient.readObject();
                if(req.type == Request.TYPE.FILES){
                    FileHashmap = new HashMap<>();
                    File f1 = new File("GOESTOTOWN");
                    File f2 = new File("JENSISHERE");
                    FileHashmap.put(f1.getFileName(),f1);
                    FileHashmap.put(f2.getFileName(),f2);
                    outToClient.writeObject(new Request(Request.TYPE.FILES, FileHashmap));
                }
                if(req.type == Request.TYPE.OWNFILES){
                    // TODO: 27-05-2020 do shit
                }

                    // if statement which if entered returns an ArrayList of Accounts
                if(req.type == Request.TYPE.ACCOUNTS){
                    System.out.println("Getting Accounts from database: " + model.userArray());
                    outToClient.writeObject(new Request(Request.TYPE.ACCOUNTS, model.userArray()));

=======
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
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
                }

                if (req.equals(null)) {
                    System.out.println("Client disconnected :) ");
                }
<<<<<<< HEAD
                if(req.type == Request.TYPE.ADD){
                    File file = (File)req.argument;
                    System.out.println("Adding file to server " + file);
                    model.addFile(file);

                    // adds file to server folder
                    recieveFle(file);
                    outToClient.writeObject(new Request(Request.TYPE.ADD, file));
                }
                if (req.type == Request.TYPE.LOGIN) {

                    Account temp = (Account) req.get();

                    if (model.compareLogin(temp).getUsername().equals(temp.getUsername()) & model.compareLogin(temp).getPassword().equals(temp.getPassword())) {
                        // send confirmation message
                        Account account = model.compareLogin(temp);
                        if (model.isAdmin(account)) {
                            account.setAdmin(true);
                            System.out.println("Server socket: IM AN ADMIN :)");
                            System.out.println(temp);
                            outToClient.writeObject(new Request(Request.TYPE.ADMIN, model.compareLogin(account)));
                        }

                        System.out.println("Login successful");
                        System.out.println("HERE IS TEMP" + temp);
                        outToClient.writeObject(new Request(Request.TYPE.LOGINCONF, account));
                        System.out.println("Confirmation sent");
                    } else {
                        // send error message to client
                        System.out.println("Login unsuccessful");
                        Account acc = new Account("null","null","null");
                        acc.setAdmin(false);
                        outToClient.writeObject(new Request(Request.TYPE.LOGIN, acc));
                    }

                    // An if statement which if entered deletes a specific file.
                } else if (req.type == Request.TYPE.REMOVE) {
                    model.deleteFile((File)req.argument);
                    System.out.println("File: " + req.argument + " Deleted");
                    outToClient.writeObject(new Request(Request.TYPE.REMOVE, req.argument));
                    // TODO: 28-05-2020 needs to be deleted from FileServer as well


                } else if (req.type == Request.TYPE.DELETE) {
                    Account acc = (Account) req.argument;
                    System.out.println("Deleting Account: " + acc);
                    model.deleteUser(acc.getUsername());
                    outToClient.writeObject(acc);


                } else if(req.type == Request.TYPE.EDIT){
                    Account acc = (Account)req.argument;
                    model.editPassword(acc);
                    model.editEmail(acc);
                    outToClient.writeObject(new Request(Request.TYPE.EDIT, acc));
                }
                /*
                else if (req.type == Request.TYPE.EDITPASS) {
=======
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
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
                    // recieve an account from the socketClient

                    for (int i = 0; i < accounts.size(); i++) {
                        model.editPassword((Account) req.get());

                    }
                } else if (req.type == Request.TYPE.EDITEMAIL) {
                    // recieve an account from the socketClient

                    for (int i = 0; i < accounts.size(); i++) {
                        model.editEmail((Account) req.get());

                    }
<<<<<<< HEAD
                }

                 */

                else if (req.type == Request.TYPE.CREATEACC) {
=======
                } else if (req.type == Request.TYPE.CREATEACC) {
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4

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
<<<<<<< HEAD

    public void recieveFle(File files)  {
        // A name for the file to be received
        String FILE_TO_RECEIVED = files.getFileName();
        int bytesRead;
        int current=0;
        FileOutputStream fos=null;
        BufferedOutputStream bos=null;

        try{
            System.out.println("Array size "+files.getMybytearray().length);
            fos = new FileOutputStream("./FileServer/" +FILE_TO_RECEIVED);
            bos = new BufferedOutputStream(fos);
            bos.write(files.getMybytearray());

            bos.flush();
            System.out.println("File "+FILE_TO_RECEIVED
                    + " downloaded (" + current + " bytes read)");

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


=======
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
}
