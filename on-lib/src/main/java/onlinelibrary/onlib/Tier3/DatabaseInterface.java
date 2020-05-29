package onlinelibrary.onlib.Tier3;

import onlinelibrary.onlib.Shared.Account;

import java.util.ArrayList;

public interface DatabaseInterface {
    boolean compareLogin(Account temp);
    void editPassword(Account acc);
    void editEmail(Account acc);
    void createUser(Account acc);
    ArrayList<Account> userArray();
    void deleteUser(String username);
    String getTempEmail();
    boolean isAdmin(Account temp);
}
