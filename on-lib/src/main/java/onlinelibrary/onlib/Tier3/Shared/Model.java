package onlinelibrary.onlib.Tier3.Shared;

<<<<<<< HEAD
import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.File;
import onlinelibrary.onlib.Shared.PropertyChangeSubject;

public interface Model extends PropertyChangeSubject {
    Account compareLogin(Account temp);

    void editPassword(Account account);

    void editEmail(Account account);

    void createUser(Account account);

    Object userArray();

    void deleteUser(String username);

    String getTempEmail();

    boolean isAdmin(Account temp);

    void addFile(File file);

    public void deleteFile(File file);
=======
import onlinelibrary.onlib.Shared.*;

import java.util.ArrayList;

public interface Model extends PropertyChangeSubject {
    boolean compareLogin(Account temp);
    void editPassword(Account account);
    void editEmail(Account account);
    void createUser(Account account);
    Object userArray();
    void deleteUser(String username);
    String getTempEmail();
    boolean isAdmin(Account temp);

    ArrayList<File> files();
    void addFile(File file);
    void deleteFile(String filename);
    void addRatingToFile(Rating rating, File file, Account account);
    void addComment(File file, Comment comment, Account account);
    ArrayList<Comment> comments(File files);
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
}