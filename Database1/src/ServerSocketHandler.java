import java.beans.PropertyChangeEvent;
import java.io.*;
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
        model.addPropertyChangeListener("newUserAdded",this::userAdded);;
        model.addPropertyChangeListener("userDeleted",this::userDeleted);

//        model.addListener("TaskRemoved", this::removeTask);
    }

    private void userDeleted(PropertyChangeEvent propertyChangeEvent) {
        String username = (String) propertyChangeEvent.getNewValue();

        Request req = new Request(Request.TYPE.DELETE, username);
        try {
            outToClient.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public void run() {
        try {
            while (true) {
                //System.out.println("Working");

                Request req = (Request) inFromClient.readObject();

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
                        outToClient.writeObject(new Request(Request.TYPE.EMAIL, model.getTempEmail()));
                        //outToClient.writeObject(new Request(Request.TYPE.ADD, ));
                        accounts.add(temp);
                        outToClient.writeObject(new Request(Request.TYPE.ACCOUNTS, model.userArray()));

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

                    model.createUser((Account) req.get());


                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
