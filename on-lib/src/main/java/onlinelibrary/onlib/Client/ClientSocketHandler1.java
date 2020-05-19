package onlinelibrary.onlib.Client;

import onlinelibrary.onlib.Shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.ScatteringByteChannel;

public class ClientSocketHandler1 implements Runnable{

    private Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    public ClientSocketHandler1(Socket socket) throws IOException{
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try{
            while (true){
                Request req = (Request) in.readObject();
                //if(req.type == Request.TYPE.EDITEMAIL)

            }

        } catch (IOException e){
            e.printStackTrace();
            System.out.println("CLIENTSOCKETHANDLER1");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
