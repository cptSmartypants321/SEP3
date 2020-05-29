package onlinelibrary.onlib.Client;


import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.PropertyChangeSubject;

public interface Client extends PropertyChangeSubject {


    public void setAccount(Account acc);
    public void editPass(Account acc);
    public void editEmail(Account acc);
    public void createAcc(Account acc);
    public void deleteUser(String username);
    public String getAccountInfo();
    public boolean isAdmin();
    public void getAllFiles();








}
