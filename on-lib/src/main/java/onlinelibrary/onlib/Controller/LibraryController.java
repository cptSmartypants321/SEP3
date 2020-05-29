package onlinelibrary.onlib.Controller;

import lombok.AccessLevel;

import lombok.experimental.FieldDefaults;
import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.Comment;
import onlinelibrary.onlib.Shared.File;
import onlinelibrary.onlib.Model.LibraryService;
import org.apache.el.stream.Stream;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyChangeEvent;
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
        HashMap<String, File> files = libraryService.getAllFile();
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
    public File deleteFile(@RequestParam(value = "Name") String file){
        System.out.println("Deleting file from Blazor: " + file);
        // TODO: 28-05-2020 Convertion into a file object
        File file1 = new File(file);
        return libraryService.deleteFile(file1);
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
    public File addFile(@RequestBody String name){
        System.out.println("File Received from Blazor: " + name);
        // TODO: 28-05-2020 Fix the stream !!!
        //byte[] byteArray=new byte[name.count()];
        //name.toArray(byteArray);
        File file = new File("Hello");

        return libraryService.addFile(file);
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





}
