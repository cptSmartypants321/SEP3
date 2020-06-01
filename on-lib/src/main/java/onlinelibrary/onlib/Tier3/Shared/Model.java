package onlinelibrary.onlib.Tier3.Shared;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Files;
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

    void addFile(Files files);

    public void deleteFile(Files files);

    Object getFiles();
}