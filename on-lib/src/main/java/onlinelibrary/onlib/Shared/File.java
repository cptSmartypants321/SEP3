package onlinelibrary.onlib.Shared;

import lombok.Data;
import java.io.Serializable;


@Data
public class File implements Serializable {

    private String filename;
    private String uploadDate;
    private String username;
    private String path;
    private String format;

    private int filesize;
    private int rating;

    private boolean math = false;
    private boolean physics = false;
    private boolean chemistry = false;
    private boolean geography = false;
    private boolean literature = false;
    private boolean construction = false;
    private boolean marketing = false;

    private byte[] mybytearray;

    /**
     * A constructor for the Shared.Files class that takes a String object and a byte array
     * @param fileName A string object that denotes the name of the file that we are sharing
     * @param mybytearray a byte array that is the file that we are sharing
     */
    public File(String fileName,byte[] mybytearray)
    {this.filename=fileName;
        this.mybytearray=mybytearray;
    }
    public File(String name)
    {
        this.filename=name;
    }

    public File(String filename, String username, String uploadDate, String format,int filesize, String path , int rating,
                 boolean math, boolean physics, boolean chemistry, boolean geography, boolean literature, boolean construction, boolean marketing, byte[] mybytearray)
    {
        this.uploadDate=uploadDate;
        this.filename=filename;
        this.mybytearray=mybytearray;

        this.username = username;
        this.path = path;
        this.format = format;
        this.filesize = filesize;
        this.rating = rating;

        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.geography = geography;
        this.literature = literature;
        this.construction = construction;
        this.marketing = marketing;


    }



    /**
     * A getter for the file name
     * @return a String object for the file name
     */
    public String getFileName() {

        return filename;
    }

    public String getDateOfUpload(){
        return uploadDate;
    }

    public String getUsername() {
        return username;
    }

    public String getPath() {
        return path;
    }

    public String getFormat() {
        return format;
    }

    public int getFileSize() {
        return filesize;
    }

    /**
     * A setter for the file name that takes a String object as an argument
     * @param fileName A string object for the new file name
     */
    public void setFileName(String fileName) {
        this.filename = fileName;
    }

    /**
     * A getter for the byte array
     * @return a byte array object
     */
    public byte[] getMybytearray() {
        return mybytearray;
    }

    /**
     * A setter for the byte array
     * @param mybytearray a byte array object that denotes a new file
     */
    public void setMybytearray(byte[] mybytearray) {
        this.mybytearray = mybytearray;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isMath() {
        return math;
    }

    public void setMath(boolean math) {
        this.math = math;
    }

    public boolean isPhysics() {
        return physics;
    }

    public void setPhysics(boolean physics) {
        this.physics = physics;
    }

    public boolean isChemistry() {
        return chemistry;
    }

    public void setChemistry(boolean chemistry) {
        this.chemistry = chemistry;
    }

    public boolean isGeography() {
        return geography;
    }

    public void setGeography(boolean geography) {
        this.geography = geography;
    }

    public boolean isLiterature() {
        return literature;
    }

    public void setLiterature(boolean literature) {
        this.literature = literature;
    }

    public boolean isConstruction() {
        return construction;
    }

    public void setConstruction(boolean construction) {
        this.construction = construction;
    }

    public boolean isMarketing() {
        return marketing;
    }

    public void setMarketing(boolean marketing) {
        this.marketing = marketing;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String toString(){
        return filename  + "\nSize: " +filesize  + "\nUSER: " + username + "\t\t DATE: "+ uploadDate;
    }

}
