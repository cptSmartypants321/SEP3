package onlinelibrary.onlib.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import onlinelibrary.onlib.Model.File;
import onlinelibrary.onlib.Service.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/OnlineLibrary")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class LibraryController {

    @NonNull
    LibraryService libraryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HashMap<String, File> getAllFiles(){
        System.out.println(" Get All Files");
        return libraryService.getAllFile();

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public File addFile(@RequestParam(value = "Name") String name){
        File file = new File(name);
        libraryService.addFile(file);
        return file;
    }





}
