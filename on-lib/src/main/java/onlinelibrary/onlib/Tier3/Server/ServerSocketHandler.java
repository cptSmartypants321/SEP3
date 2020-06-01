package onlinelibrary.onlib.Tier3.Server;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Files;
import onlinelibrary.onlib.Shared.Request;
import onlinelibrary.onlib.Tier3.Shared.Model;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


public class ServerSocketHandler implements Runnable{
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    private Socket socket;
    // maybe this connection will be a problem ??? !
    //private Database model;
    private Model model;
    private ArrayList<Account> accounts;

    public static HashMap<String, Files> FileHashmap;

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

 */


    public void run() {
        try {
            while (true) {
                //File temp = (File)inFromClient.readObject();
                //Request req= (Request)convertReq(temp);
                Request req= (Request)inFromClient.readObject();
                if(req.type == Request.TYPE.FILES){
                    //FileHashmap = new HashMap<>();
                    //Files f1 = new Files("GOESTOTOWN");
                    //Files f2 = new Files("JENSISHERE");
                    //FileHashmap.put(f1.getFileName(),f1);
                    //FileHashmap.put(f2.getFileName(),f2);

                    ArrayList<Files> files = (ArrayList<Files>)model.getFiles();
                    Files[] filesToSend= new Files[files.size()];
                    for (int i=0;i <files.size();i++)
                    {
                        filesToSend[i]= files.get(i);
                    }
                    System.out.println("Sending filelist to client: " + filesToSend);
                    outToClient.writeObject(new Request(Request.TYPE.FILES, filesToSend));
                }
                if(req.type == Request.TYPE.OWNFILES){
                    // TODO: 27-05-2020 do shit
                }

                    // if statement which if entered returns an ArrayList of Accounts
                if(req.type == Request.TYPE.ACCOUNTS){
                    System.out.println("Getting Accounts from database: " + model.userArray());
                    ArrayList<Account> users = (ArrayList<Account>)model.userArray();
                    Account[] usersToSend= new Account[users.size()];
                    for (int i=0;i <users.size();i++)
                    {
                        usersToSend[i]= users.get(i);
                    }
                    outToClient.writeObject(new Request(Request.TYPE.ACCOUNTS, usersToSend));

                }

                if (req.equals(null)) {
                    System.out.println("Client disconnected :) ");
                }
                if(req.type == Request.TYPE.ADD){
                    Files files = (Files)req.argument;
                    System.out.println("Adding file to server " + files);
                    files.setPath("C:\\Users\\mathi\\OneDrive\\Skrivebord\\2020Collection\\on-lib\\FileServer\\" + files.getFileName());
                    model.addFile(files);


                    // adds file to server folder
                    recieveFle(files);
                    outToClient.writeObject(new Request(Request.TYPE.ADD, files));
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
                    model.deleteFile((Files)req.argument);
                    Files f = (Files)req.argument;
                    //File fileremove = new File(((Files)req.argument).getPath());
                    File fileremove = new File("C:\\Users\\mathi\\OneDrive\\Skrivebord\\2020Collection\\on-lib\\FileServer\\" + ((Files) req.argument).getFileName());
                    fileremove.delete();
                    System.out.println("File: " + req.argument + " Deleted");
                    outToClient.writeObject(new Request(Request.TYPE.REMOVE, f));
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
                    // recieve an account from the socketClient

                    for (int i = 0; i < accounts.size(); i++) {
                        model.editPassword((Account) req.get());

                    }
                } else if (req.type == Request.TYPE.EDITEMAIL) {
                    // recieve an account from the socketClient

                    for (int i = 0; i < accounts.size(); i++) {
                        model.editEmail((Account) req.get());

                    }
                }

                 */

                else if (req.type == Request.TYPE.CREATEACC) {

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

    public void recieveFle(Files files)  {
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


}
