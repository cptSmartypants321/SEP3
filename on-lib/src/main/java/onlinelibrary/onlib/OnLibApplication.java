package onlinelibrary.onlib;


import onlinelibrary.onlib.Client.ClientMain;
import onlinelibrary.onlib.Model.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class OnLibApplication {

    public static HashMap<String, File> FileHashmap;
    public static void main(String[] args) {



        FileHashmap = new HashMap<>();
        File f1 = new File("FILEName");
        FileHashmap.put(f1.getFileId(),f1);

        ClientMain.Clientmain();


        SpringApplication.run(OnLibApplication.class, args);
    }

}
