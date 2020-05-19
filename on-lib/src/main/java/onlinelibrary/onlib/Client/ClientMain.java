package onlinelibrary.onlib.Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

    public static void Clientmain(){
        try{
            Socket socket = new Socket("localhost",2910);
            ClientSocketHandler1 c = new ClientSocketHandler1(socket);
            new Thread(c, "client connection");
        } catch (UnknownHostException e){
            e.printStackTrace();
            System.out.println("CLIENTMAIN");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
