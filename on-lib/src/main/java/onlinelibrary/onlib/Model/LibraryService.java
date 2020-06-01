package onlinelibrary.onlib.Model;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Files;
import onlinelibrary.onlib.Shared.PropertyChangeSubject;

import java.util.ArrayList;
import java.util.HashMap;

public interface LibraryService extends PropertyChangeSubject {

    // HTTP GET --> READ

    HashMap<String, Files> getAllFile();

    // HTTP POST --> CREATE
    public Files addFile (Files files);

    Files[] getFileFromDatabase();

    HashMap<String, Files> getOwnFileFromDatabase(Account account);

    public void createAccount(Account account);

    public Account login1(Account account);

    public Account editAcc(Account account);

    public Files deleteFile(Files files);

    public Account deleteAccount(Account account);

    // HTTP GET --> READ

    Account[] getAllUsers();
}
