import java.io.Serializable;

public class Account implements Serializable {

    private String username;
    private String password;
    private String email;
    private boolean isAdmin;


    /**
     * A constructor for the Account class
     * @param username a String for an username
     * @param password a String for the password
     */
    public Account(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        isAdmin = false;

    }

    public boolean isAdmin() {
        return isAdmin;
    }



    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    /**
     * A getter for the username
     * @return a String object
     */
    public String getUsername() {
        return username;
    }

    /**
     * A getter for the password
     * @return a String object
     */
    public String getPassword() {
        return password;
    }


    /**
     * A setter for the password
     * @param password A string value
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * An equals method for comparing Account objects
     * @param obj an object to compare to
     * @return a boolean value that is true if the objects are the same
     */
    public boolean equals(Object obj){
        if(!(obj instanceof Account)) return false;
        Account otherAccount = (Account)obj;
        return username.equals(otherAccount.username) && password.equals(otherAccount.password);
    }

    /**
     * A getter for the email
     * @return a String object
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A method for printing the information in the object
     * @return a String
     */
    public String toString(){
        return "Username: " + username + "\nPassword: " + password;
    }
}