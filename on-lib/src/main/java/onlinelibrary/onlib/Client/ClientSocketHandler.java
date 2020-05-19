package onlinelibrary.onlib.Client;


import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ClientSocketHandler implements Runnable {

    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;
    private SocketClient socketClient;


    /**
     * A constructor used for initializing the output and input streams as well as the socket client
     *
     * @param outToServer  and ObjectOutputStream object used for writing to the server
     * @param inFromServer an ObjectInputStream object used for receiving information from the server
     * @param socketClient a SocketClient object that is used for handling the requests that the client receives from the server
     */

    public ClientSocketHandler(ObjectOutputStream outToServer, ObjectInputStream inFromServer, SocketClient socketClient) {

        this.outToServer = outToServer;
        this.inFromServer = inFromServer;
        System.out.println(socketClient.toString());
        this.socketClient = socketClient;
    }

    @Override
    public void run() {
        try {

            while (true) {
                Request req = (Request) inFromServer.readObject();
                if (req.type == Request.TYPE.LOGIN) {
                    socketClient.loginResult((boolean) req.argument);
                } else if(req.type == Request.TYPE.EMAIL){
                    String email = (String) req.get();
                    socketClient.setEmail(email);
                }
                 else if (req.type == Request.TYPE.ACCOUNTS) {

                    Object argument1 = req.argument;
                    ArrayList<Account> argument = (ArrayList<Account>) argument1;
                    socketClient.addNewUser(argument);


                }else if(req.type== Request.TYPE.DELETE)
                {
                    String username=(String) req.argument;
                    socketClient.deleteUserFromList(username);
                }

                else if (req.type == Request.TYPE.ADMIN)
                {
                    Account temp = (Account) req.argument;
                    System.out.println("clientSocket : "+temp.isAdmin());
                    socketClient.setAdminAccount(temp);
                }
            }
        } catch (Exception e) {
            System.out.println("Lost connection to server :( ");
        }
    }

    /**
     * A method for sending requests to the server
     * @param type A Request type
     * @param obj  An Object that will be sent to the server
     */
    public void sendToServer(Request.TYPE type, Object obj) {
        try {
            outToServer.writeObject(new Request(type, obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



