package onlinelibrary.onlib.Controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import lombok.AccessLevel;

import lombok.experimental.FieldDefaults;
import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Comment;
import onlinelibrary.onlib.Shared.Files;
import onlinelibrary.onlib.Model.LibraryService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/OnlineLibrary")
//@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE)

public class LibraryController {

    boolean result;
    LibraryService libraryService;
    @Autowired
    public LibraryController(LibraryService service){
        libraryService = service;
       // libraryService.addPropertyChangeListener("result",this::loginResult);



    }




    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllFiles(){
        Files[] files = libraryService.getFileFromDatabase();
        if(files.equals(null)){
            return new ResponseEntity<>("SHIT WENT DONW",HttpStatus.BAD_REQUEST);
        } else {
            System.out.println("BOOOM: " + libraryService.getFileFromDatabase());
            return new ResponseEntity<>(libraryService.getFileFromDatabase(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers(){
        //ArrayList<Account> accounts
                return new ResponseEntity<>(libraryService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ResponseEntity<Object> getOwnFiles(@RequestParam(value = "account")String acc){
        System.out.println("Account: " + acc + " Requests own files");
        String[] accs = acc.split(":");
        Account acc1 = new Account(accs[0],accs[1],accs[2]);
            System.out.println("BOOOM: " + libraryService.getOwnFileFromDatabase(acc1));
            return new ResponseEntity<>(libraryService.getOwnFileFromDatabase(acc1), HttpStatus.OK);

    }
        // Method for removing a file from system.
        // Not using RequestMethod.DELETE as it doesnt return anything..
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Files deleteFile(@RequestBody String file) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Files> ref = new TypeReference<Files>(){};
        Files files = mapper.readValue(file, ref);

        System.out.println("Deleting file from Blazor: " + files);

        // TODO: 28-05-2020 Convertion into a file object

        return libraryService.deleteFile(files);
    }

    // TODO: 28-05-2020 Comment
    // TODO: 28-05-2020 Rate

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Comment comment(@RequestBody String req){
        return null;
    }

    // A method for deleting a user from the system.

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Account deleteAccount(@RequestBody String req){

        String[] acc = req.split(":");
        Account acc1 = new Account(acc[0],acc[1],acc[2]);
        System.out.println("Editing Account: " + req);
        return libraryService.deleteAccount(acc1);
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Files addFile(@RequestBody String name) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Files> ref = new TypeReference<Files>(){};
        Files files = mapper.readValue(name, ref);
        String[] path = files.getFileName().split("\\.");
        System.out.println("Format: " + path[1]);
        files.setCategory();
        files.setFormat(path[1]);
        System.out.println("File Received from Blazor: " + files.getFileName() + " Owner: " + files.getUsername());
        System.out.println(files.getFileName() + " Username " + files.getUsername() + "Rating: " + files.getRating() + " Category: " +files.isChemistry());

        // TODO: 28-05-2020 Fix the stream !!!
        //byte[] byteArray=new byte[name.count()];
        //name.toArray(byteArray);
        //File file = new File("Hello");

        return libraryService.addFile(files);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Account editAc(@RequestBody String req)
    {
        String[] acc = req.split(":");
        Account acc1 = new Account(acc[0],acc[1],acc[2]);
        System.out.println("Editing Account: " + req);
        return libraryService.editAcc(acc1);
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Account login( @RequestBody String request) throws InterruptedException, ParseException {        //@RequestParam(value = "request")
        System.out.println("User recieved "+ request);
        String[] acc = request.split(":");
        Account account = new Account(acc[0],acc[1],null);
        System.out.println(account.getUsername() + account.getPassword());
        Account responce = libraryService.login1(account);
        System.out.println("LIBRARY CONTROLLER: " + responce +" " + responce.getEmail());

        return responce;
    }

    /*
    @RequestMapping(value = "/login.", method = RequestMethod.GET)
    public ResponseEntity<Object> loginConfirmation(){


        System.out.println("this is the shit: " + result);

        return new ResponseEntity<>(result,HttpStatus.OK);

    }

     */


    @RequestMapping(value = "/createAcc", method = RequestMethod.POST)
    public Account createAccount( @RequestBody String request){        //@RequestParam(value = "request")
        System.out.println("User Creation recieved "+ request);
        String[] acc = request.split(":");
        Account account = new Account(acc[0],acc[1],acc[2]);
        libraryService.createAccount(account);
        return account;
    }

private void rf(Files files){
    String FILE_TO_RECEIVED = files.getFileName();
    int bytesRead;
    int current=0;
    FileOutputStream fos=null;
    BufferedOutputStream bos=null;
    try{
        System.out.println("Array size "+files.getMybytearray().length);
        fos = new FileOutputStream("./myfolder/" +FILE_TO_RECEIVED);
        bos = new BufferedOutputStream(fos);
        bos.write(files.getMybytearray());

        bos.flush();
        System.out.println("File "+FILE_TO_RECEIVED
                + " downloaded (" + current + " bytes read)");

    }
    catch (IOException e) {
        e.printStackTrace();
    }
    finally {
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bos != null) {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}



}
