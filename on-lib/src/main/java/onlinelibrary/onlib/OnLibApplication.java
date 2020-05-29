package onlinelibrary.onlib;

import onlinelibrary.onlib.Shared.Files;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class OnLibApplication {

    public static HashMap<String, Files> FileHashmap;
    public static void main(String[] args) {



       FileHashmap = new HashMap<>();
        Files f1 = new Files("FILEName");
        FileHashmap.put(f1.getFileName(),f1);




        SpringApplication.run(OnLibApplication.class, args);
    }

}
