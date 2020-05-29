package onlinelibrary.onlib.Tier3.Database;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Comment;
import onlinelibrary.onlib.Shared.Files;
import onlinelibrary.onlib.Shared.Rating;

import java.util.ArrayList;

public interface DatabaseInterface {
    Account compareLogin(Account temp);
    void editPassword(Account acc);
    void editEmail(Account acc);
    void createUser(Account acc);
    ArrayList<Account> userArray();
    void deleteUser(String username);
    String getTempEmail();
    boolean isAdmin(Account temp);

    ArrayList<Files> files();
    void addFile(Files files);
    void deleteFile(String filename);
    void addRatingToFile(Rating rating, Files files, Account account);
    void addComment(Files files, Comment comment, Account account);
    ArrayList<Comment> comments(Files files);

}
