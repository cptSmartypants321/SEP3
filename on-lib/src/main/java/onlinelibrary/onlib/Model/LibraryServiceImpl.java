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

import java.beans.PropertyChangeSupport;
import java.util.HashMap;

@SpringBootApplication(scanBasePackages={"onlinelibrary.onlib.Client"})
@Service
public class LibraryServiceImpl implements LibraryService{


    private Client client;
    public HashMap<String, File> getAllFiles;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ClientMain clientMain;
    private LibraryController libraryController;

    @Autowired
    public LibraryServiceImpl(@Qualifier ("clientMain") ClientMain clientMain){
        this.clientMain = clientMain;
        System.out.println(clientMain);
        libraryController=clientMain.getLibraryController();
        System.out.println("LSIMPL controller : "+libraryController); // does it 2 times null and then not null
    }

    @Override
    public HashMap<String, File> getAllFile() {
        File file = new File("hello");
        clientMain.sendToServer(Request.TYPE.FILES,file);
        return OnLibApplication.FileHashmap;
    }

    @Override
    public File addFile(File file) {
        File resultSet = OnLibApplication.FileHashmap.get(file.getFileName());
        if(resultSet != null){
            file = resultSet;
        }
        OnLibApplication.FileHashmap.put(file.getFileName(),file);
        return OnLibApplication.FileHashmap.get(file.getFileName());
    }

    @Override
    public HashMap<String, File> getFileFromDatabase() {

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
    }
}
