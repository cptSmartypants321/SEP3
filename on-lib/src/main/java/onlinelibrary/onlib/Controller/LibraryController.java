package onlinelibrary.onlib.Controller;

import lombok.AccessLevel;

import lombok.experimental.FieldDefaults;
import onlinelibrary.onlib.Shared.Account;
import onlinelibrary.onlib.Shared.File;
import onlinelibrary.onlib.Model.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/OnlineLibrary")
//@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class LibraryController {


    LibraryService libraryService;
    @Autowired
    public LibraryController(LibraryService service){
        libraryService = service;

    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllFiles(){
        HashMap<String, File> files = libraryService.getAllFile();
        if(files.equals(null)){
            return new ResponseEntity<>("SHIT WENT DONW",HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(files, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public File addFile(@RequestParam(value = "Name") String name){
        File file = new File(name);
        libraryService.addFile(file);
        return file;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Account login( @RequestBody String request){        //@RequestParam(value = "request")
        System.out.println("User recieved "+ request);
        String[] acc = request.split(":");
        Account account = new Account(acc[0],acc[1],null);
        libraryService.login(account);

        return account;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<Object> loginConfirmation(boolean t){
        String ans;
        System.out.println("SEND TO BLAZOR " + t); // need you to be true
        if(t == true){
            ans = "yes";
            System.out.println("ANS = " + ans);
        }else{
            ans = "no";
            System.out.println("ANS = " + ans);
        }

        return new ResponseEntity<>(ans,HttpStatus.OK);
    }

    @RequestMapping(value = "/createAcc", method = RequestMethod.POST)
    public Account createAccount( @RequestBody String request){        //@RequestParam(value = "request")
        System.out.println("User Creation recieved "+ request);
        String[] acc = request.split(":");
        Account account = new Account(acc[0],acc[1],acc[2]);
        libraryService.createAccount(account);
        return account;
    }





}
