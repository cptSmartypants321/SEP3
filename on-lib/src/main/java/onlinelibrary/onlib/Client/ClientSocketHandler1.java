package onlinelibrary.onlib.Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import onlinelibrary.onlib.Model.LibraryService;
import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Request;

import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientSocketHandler1 implements Runnable{

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    LibraryService libraryService;


    public ClientSocketHandler1(Socket socket, LibraryService libraryService) throws IOException{
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        this.libraryService = libraryService;

    }

    @Override
    public void run() {
        int i =0;

        /*
        try{
            while (true){
                Request req = (Request) in.readObject();
                if(req.type == Request.TYPE.LOGINCONF){
                    System.out.println("CALLING CSH");
                   libraryService.loginConfirmation((boolean)req.argument);


                }

            }


        } catch (IOException e){
            e.printStackTrace();
            System.out.println("CLIENTSOCKETHANDLER1");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

         */


    }

    public void sendToServer(Request.TYPE type, Object obj) {
        try {
            Request req = new Request(type,obj);
           // File temp = new File("C:\\Users\\mathi\\OneDrive\\Dokumenter\\GitHub\\SEP3\\on-lib\\Test.json");
            //ObjectMapper mapper = new ObjectMapper();
            //mapper.writeValue(temp,req);
            out.writeObject(req);
            //temp.delete();
            //out.writeObject(new Request(type, obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Account sendToServer1(Request.TYPE type, Object obj){
        Request req = new Request(type,obj);
        try {
            out.writeObject(req);

            Request response = (Request)in.readObject();
            //System.out.println("SENDTOSERVER1: "+ response.argument);
            return (Account) response.argument;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (Account) obj;
    }

    public Object sendToServer2(Request.TYPE type, Object obj){
        Request req = new Request(type,obj);
        try {
            out.writeObject(req);

            Request response = (Request)in.readObject();
            //System.out.println("SENDTOSERVER2: "+ response.argument);
            return response.argument;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
