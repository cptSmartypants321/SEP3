package onlinelibrary.onlib.Model;

import onlinelibrary.onlib.Client.Client;
import onlinelibrary.onlib.Client.ClientMain;
import onlinelibrary.onlib.Controller.LibraryController;
import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.File;
import onlinelibrary.onlib.OnLibApplication;
import onlinelibrary.onlib.Shared.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
=======
import java.beans.PropertyChangeSupport;
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
import java.util.HashMap;

@SpringBootApplication(scanBasePackages={"onlinelibrary.onlib.Client"})
@Service
public class LibraryServiceImpl implements LibraryService{


<<<<<<< HEAD
    //private Client client;
    //public HashMap<String, File> getAllFiles;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ClientMain clientMain;
    private LibraryController libraryController;
    private boolean answer = false;
=======
    private Client client;
    public HashMap<String, File> getAllFiles;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ClientMain clientMain;
    private LibraryController libraryController;
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4

    @Autowired
    public LibraryServiceImpl(@Qualifier ("clientMain") ClientMain clientMain){
        this.clientMain = clientMain;
<<<<<<< HEAD
        libraryController=clientMain.getLibraryController();

=======
        System.out.println(clientMain);
        libraryController=clientMain.getLibraryController();
        System.out.println("LSIMPL controller : "+libraryController); // does it 2 times null and then not null
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
    }

    @Override
    public HashMap<String, File> getAllFile() {
        File file = new File("hello");
<<<<<<< HEAD
        clientMain.SendToServer2(Request.TYPE.FILES,null);
=======
        clientMain.sendToServer(Request.TYPE.FILES,file);
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
        return OnLibApplication.FileHashmap;
    }

    @Override
    public File addFile(File file) {
<<<<<<< HEAD
        /*
=======
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
        File resultSet = OnLibApplication.FileHashmap.get(file.getFileName());
        if(resultSet != null){
            file = resultSet;
        }
        OnLibApplication.FileHashmap.put(file.getFileName(),file);
        return OnLibApplication.FileHashmap.get(file.getFileName());
<<<<<<< HEAD

         */
        return (File) clientMain.SendToServer2(Request.TYPE.ADD, file);
=======
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
    }

    @Override
    public HashMap<String, File> getFileFromDatabase() {

<<<<<<< HEAD
        return (HashMap<String, File>) clientMain.SendToServer2(Request.TYPE.FILES, null);
    }

    @Override
    public HashMap<String, File> getOwnFileFromDatabase(Account account) {
        return (HashMap<String, File>) clientMain.SendToServer2(Request.TYPE.OWNFILES, account);
    }

    @Override
    public Account login1(Account account) {
        return clientMain.SendToServer1(Request.TYPE.LOGIN, account);
    }

    @Override
    public Account editAcc(Account account) {
        return clientMain.SendToServer1(Request.TYPE.EDIT, account);
    }

    @Override
    public File deleteFile(File file) {
        return (File)clientMain.SendToServer2(Request.TYPE.REMOVE, file);
    }

    @Override
    public Account deleteAccount(Account account) {
        return clientMain.SendToServer1(Request.TYPE.DELETE, account);
    }

    @Override
    public ArrayList<Account> getAllUsers() {
        return (ArrayList<Account>)clientMain.SendToServer2(Request.TYPE.ACCOUNTS, null);
    }


    @Override
    public void createAccount(Account account) {
       clientMain.sendToServer(Request.TYPE.CREATEACC,account);

    }




    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        support.addPropertyChangeListener(name,listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        support.removePropertyChangeListener(name,listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
=======
        return null;
    }

    @Override
    public void login(Account account) {
        clientMain.sendToServer(Request.TYPE.LOGIN, account);
    }

    @Override
    public void loginConfirmation(boolean t) {
        System.out.println("LS ARG: " + t +" "+libraryController);
        // TODO: 22-05-2020 PROBLEM WITH NULLPOINTERRRR 
        //libraryController.loginConfirmation(t);
    }

    @Override
    public void createAccount(Account account) {
        clientMain.sendToServer(Request.TYPE.CREATEACC,account);
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
    }
}
