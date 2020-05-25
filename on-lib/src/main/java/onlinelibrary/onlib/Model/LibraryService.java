package onlinelibrary.onlib.Model;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.File;

import java.util.HashMap;

public interface LibraryService {

    // HTTP GET --> READ

    HashMap<String, File> getAllFile();

    // HTTP POST --> CREATE
    File addFile (File file);

    HashMap<String, File> getFileFromDatabase();

    public void login(Account account);

    public void loginConfirmation(boolean t);

    public void createAccount(Account account);
}
