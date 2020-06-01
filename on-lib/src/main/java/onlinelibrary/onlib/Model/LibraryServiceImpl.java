package onlinelibrary.onlib.Model;

import onlinelibrary.onlib.Client.ClientMain;
import onlinelibrary.onlib.Controller.LibraryController;
import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Files;
import onlinelibrary.onlib.OnLibApplication;
import onlinelibrary.onlib.Shared.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication(scanBasePackages={"onlinelibrary.onlib.Client"})
@Service
public class LibraryServiceImpl implements LibraryService{


    //private Client client;
    //public HashMap<String, File> getAllFiles;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ClientMain clientMain;
    private LibraryController libraryController;
    private boolean answer = false;

    @Autowired
    public LibraryServiceImpl(@Qualifier ("clientMain") ClientMain clientMain){
        this.clientMain = clientMain;
        libraryController=clientMain.getLibraryController();

    }

    @Override
    public HashMap<String, Files> getAllFile() {
        Files files = new Files("hello");
        clientMain.SendToServer2(Request.TYPE.FILES,null);
        return OnLibApplication.FileHashmap;
    }

    @Override
    public Files addFile(Files files) {
        /*
        File resultSet = OnLibApplication.FileHashmap.get(file.getFileName());
        if(resultSet != null){
            file = resultSet;
        }
        OnLibApplication.FileHashmap.put(file.getFileName(),file);
        return OnLibApplication.FileHashmap.get(file.getFileName());

         */
        return (Files) clientMain.SendToServer2(Request.TYPE.ADD, files);
    }

    @Override
    public Files[] getFileFromDatabase() {

        return (Files[]) clientMain.SendToServer2(Request.TYPE.FILES, null);
    }

    @Override
    public HashMap<String, Files> getOwnFileFromDatabase(Account account) {
        return (HashMap<String, Files>) clientMain.SendToServer2(Request.TYPE.OWNFILES, account);
    }

    @Override
    public Account login1(Account account) {
        //Files file = new Files("Hello");
        //clientMain.sendToServer(Request.TYPE.REMOVE, file);
        return clientMain.SendToServer1(Request.TYPE.LOGIN, account);

    }

    @Override
    public Account editAcc(Account account) {
        return clientMain.SendToServer1(Request.TYPE.EDIT, account);
    }

    @Override
    public Files deleteFile(Files files) {
        return (Files)clientMain.SendToServer2(Request.TYPE.REMOVE, files);
    }

    @Override
    public Account deleteAccount(Account account) {
        return clientMain.SendToServer1(Request.TYPE.DELETE, account);
    }

    @Override
    public Account[] getAllUsers() {
        return (Account[])clientMain.SendToServer2(Request.TYPE.ACCOUNTS, null);
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
    }
}
