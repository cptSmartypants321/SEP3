package onlinelibrary.onlib.Tier3.Shared;

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
}