package onlinelibrary.onlib.Service;

import onlinelibrary.onlib.Model.File;
import onlinelibrary.onlib.OnLibApplication;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LibraryServiceImpl implements LibraryService{
    @Override
    public HashMap<String, File> getAllFile() {
        return OnLibApplication.FileHashmap;
    }

    @Override
    public File addFile(File file) {
        File resultSet = OnLibApplication.FileHashmap.get(file.getFileId());
        if(resultSet != null){
            file = resultSet;
        }
        OnLibApplication.FileHashmap.put(file.getFileId(),file);
        return OnLibApplication.FileHashmap.get(file.getFileId());
    }
}
