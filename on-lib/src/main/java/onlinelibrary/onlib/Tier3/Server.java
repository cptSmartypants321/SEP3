<<<<<<< HEAD:on-lib/src/main/java/onlinelibrary/onlib/Tier3/Server.java
package onlinelibrary.onlib.Tier3;
=======
package onlinelibrary.onlib.Tier3.Server;

import onlinelibrary.onlib.Tier3.Database.Database;
import onlinelibrary.onlib.Tier3.Database.DatabaseInterface;
import onlinelibrary.onlib.Tier3.Shared.Model;
import onlinelibrary.onlib.Tier3.Shared.ModelImplementation;
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4:on-lib/src/main/java/onlinelibrary/onlib/Tier3/Server/Server.java

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Model data;

    /**
     * A constructor for the server class
     * @param data
     */
    public Server (Model data) {
        this.data=data;

    }

    /**
     * A method used for starting the server in a new thread
     * @throws IOException is not handled in this method
     */
    public void runServer() throws IOException {
        ServerSocket welcomeSocket = new ServerSocket(2910);
        System.out.println("Server started..");
        while(true) {

            Socket socket = welcomeSocket.accept();
            System.out.println("Client connected");
            ServerSocketHandler ssh = new ServerSocketHandler(socket, data);
            Thread t = new Thread(ssh);
            t.start();
        }
    }

    public static void main(String[] args) {
        DatabaseInterface m = new Database();
        Model model = new ModelImplementation(m);
        Server server = new Server(model);
        try {
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
