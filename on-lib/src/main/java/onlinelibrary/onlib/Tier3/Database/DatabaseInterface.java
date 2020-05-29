package onlinelibrary.onlib.Tier3.Database;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Comment;
import onlinelibrary.onlib.Shared.File;
import onlinelibrary.onlib.Shared.Rating;

import java.util.ArrayList;

public interface DatabaseInterface {
<<<<<<< HEAD
    Account compareLogin(Account temp);
=======
    boolean compareLogin(Account temp);
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4
    void editPassword(Account acc);
    void editEmail(Account acc);
    void createUser(Account acc);
    ArrayList<Account> userArray();
    void deleteUser(String username);
    String getTempEmail();
    boolean isAdmin(Account temp);

    ArrayList<File> files();
    void addFile(File file);
    void deleteFile(String filename);
    void addRatingToFile(Rating rating, File file, Account account);
    void addComment(File file, Comment comment, Account account);
    ArrayList<Comment> comments(File files);

}
