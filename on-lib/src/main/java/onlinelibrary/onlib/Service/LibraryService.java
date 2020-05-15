package onlinelibrary.onlib.Service;

import onlinelibrary.onlib.Model.File;

import java.util.HashMap;

public interface LibraryService {

    // HTTP GET --> READ

    HashMap<String, File> getAllFile();

    // HTTP POST --> CREATE
    File addFile (File file);
}
