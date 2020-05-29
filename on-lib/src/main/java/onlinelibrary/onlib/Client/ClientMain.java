package onlinelibrary.onlib.Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import onlinelibrary.onlib.Controller.LibraryController;
import onlinelibrary.onlib.Model.LibraryService;
import onlinelibrary.onlib.Model.LibraryServiceImpl;
import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Component
public class ClientMain {
    private ClientSocketHandler1 socketHandler;
    private Socket socket = null;
    private LibraryService libraryService;
    private LibraryController libraryController;

    @Autowired
    public ClientMain(){
        try{


            //System.out.println("ClientMain libController : "+libraryController); // not null
            libraryService=new LibraryServiceImpl(this);
            libraryController= new LibraryController(libraryService);
            //System.out.println("ClientMain libService : "+libraryService); //not null
            Socket socket = new Socket("localhost",2910);
            socketHandler = new ClientSocketHandler1(socket, libraryService);

            Thread t = new Thread(socketHandler);
            t.setDaemon(true);
            t.start();

        } catch (UnknownHostException e){
            e.printStackTrace();
            System.out.println("CLIENTMAIN");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendToServer(Request.TYPE type, Object obj){
        socketHandler.sendToServer(type,obj);
    }

    public Account SendToServer1(Request.TYPE type, Object obj){
        return socketHandler.sendToServer1(type,obj);
    }

    public Object SendToServer2(Request.TYPE type, Object obj) {
        return socketHandler.sendToServer2(type, obj);
    }

    public LibraryController getLibraryController()
    {
        return libraryController;
    }



}
