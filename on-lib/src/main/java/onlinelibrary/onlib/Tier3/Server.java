package onlinelibrary.onlib.Tier3;

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
        DatabaseInterface m = new AccountDatabase();
        Model model = new ModelImplementation(m);
        Server server = new Server(model);
        try {
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
