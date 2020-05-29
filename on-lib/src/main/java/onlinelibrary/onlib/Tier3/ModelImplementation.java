<<<<<<< HEAD:on-lib/src/main/java/onlinelibrary/onlib/Tier3/ModelImplementation.java
package onlinelibrary.onlib.Tier3;

import onlinelibrary.onlib.Shared.Account;
=======
package onlinelibrary.onlib.Tier3.Shared;

import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Comment;
import onlinelibrary.onlib.Shared.File;
import onlinelibrary.onlib.Shared.Rating;
import onlinelibrary.onlib.Tier3.Database.DatabaseInterface;
>>>>>>> 607546fece7dbdc8dbff0aef0c195dab5039a9b4:on-lib/src/main/java/onlinelibrary/onlib/Tier3/Shared/ModelImplementation.java

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelImplementation implements Model {
    private DatabaseInterface database;
    PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ModelImplementation(DatabaseInterface database) {
        this.database = database;
    }

    @Override
    public boolean compareLogin(Account temp) {
        return database.compareLogin(temp);
    }


    @Override
    public void editPassword(Account account) {
        database.editPassword(account);
    }

    @Override
    public void editEmail(Account account) {
        database.editEmail(account);
    }

    @Override
    public void createUser(Account account) {
        database.createUser(account);
        support.firePropertyChange("newUserAdded",null,account);

    }

    @Override
    public Object userArray() {
        return database.userArray();
    }


    @Override
    public void deleteUser(String username) {
        database.deleteUser(username);
        support.firePropertyChange("userDeleted",null,username);
    }

    @Override
    public String getTempEmail() {
        return database.getTempEmail();
    }

    @Override
    public boolean isAdmin(Account temp)
    {
        return database.isAdmin(temp);
    }

    @Override
    public ArrayList<File> files() {
        return null;
    }

    @Override
    public void addFile(File file) {

    }

    @Override
    public void deleteFile(String filename) {

    }

    @Override
    public void addRatingToFile(Rating rating, File file, Account account) {

    }

    @Override
    public void addComment(File file, Comment comment, Account account) {

    }

    @Override
    public ArrayList<Comment> comments(File files) {
        return null;
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        support.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }



}
