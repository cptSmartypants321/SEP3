package onlinelibrary.onlib.Model;

import lombok.Data;
import onlinelibrary.onlib.Shared.Category;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class File {

    @NotNull
    private String name;
    private Category category;
    private String FileId;
    private Byte[] bytearray;
    private String Owner;
    private String Type;
    private int Size;
    private String date;

    public File(){
        this.FileId = UUID.randomUUID().toString();
    }

    public File(String name){
        this();
    this.name = name;
    }
   public String getFileId()
   {
       return FileId;
   }

}
