package onlinelibrary.onlib.Shared;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Comment {

    private String comment;
    private String username;
    private String time;


    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss | yyyy/MM/dd ");
    LocalDateTime now;


    public Comment(String comment){
        this.comment = comment;
        now = LocalDateTime.now();
    }

    public Comment(String comment,String username, String time){
        this.comment = comment;
        this.username = username;
        this.time = time;

    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNow() {
        return dtf.format(now);
    }

}
