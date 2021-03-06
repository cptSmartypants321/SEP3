package onlinelibrary.onlib.Shared;

import java.io.Serializable;

public class Request implements Serializable {

    public enum TYPE {
        ADD,
        REMOVE,
        LOGIN,
        LOGINCONF,
        EDIT,
        EDITPASS,
        EDITEMAIL,
        CREATEACC,
        ACCOUNTS,
        DELETE,
        EMAIL,
        ADMIN,
        FILES,
        OWNFILES,

    }

    public TYPE type;
    public Object argument;
    private Account account;
    private Comment comment;

    /**
     * A constructor for the Request class
     * @param type An enum type for the type of request
     * @param t An Object that is going to be sent
     * @param account an Account object
     */
    public Request(TYPE type, Object file, Comment comment, Account account) {
        this.type = type;
        this.argument = file;
        this.comment = comment;
        this.account = account;

    }

    /**
     * A constructor for the Request class
     * @param type an enum type
     * @param t an object that is going to be sent
     */
    public Request(TYPE type, Object t) {
        this.type = type;
        this.argument = t;
    }

    /**
     * A set method for an object
     * @param t an object
     */
    public void set(Object t)
    {
        this.argument =t;
    }

    /**
     * A getter method for an object
     * @return an Object
     */
    public Object get()
    {
        return argument;
    }
}
