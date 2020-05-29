package onlinelibrary.onlib.Model;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.File;
import onlinelibrary.onlib.Shared.PropertyChangeSubject;

import java.util.ArrayList;
import java.util.HashMap;

public interface LibraryService extends PropertyChangeSubject {

    // HTTP GET --> READ

    HashMap<String, File> getAllFile();

    // HTTP POST --> CREATE
    public File addFile (File file);

    HashMap<String, File> getFileFromDatabase();

    HashMap<String,File> getOwnFileFromDatabase(Account account);

    public void createAccount(Account account);

    public Account login1(Account account);

    public Account editAcc(Account account);

    public File deleteFile(File file);

    public Account deleteAccount(Account account);

    // HTTP GET --> READ

    ArrayList<Account> getAllUsers();
}
