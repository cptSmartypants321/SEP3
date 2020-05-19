import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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

    @Override
    public boolean isAdmin(Account temp)
    {
        return database.isAdmin(temp);
    }

}
