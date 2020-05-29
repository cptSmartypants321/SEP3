package onlinelibrary.onlib.Shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;


@Data
public class Files implements Serializable {
    @JsonProperty
    private String filename;
    @JsonProperty
    private String uploadDate;
    @JsonProperty
    private String username;
    @JsonProperty
    private String path;
    @JsonProperty
    private String format;
    @JsonProperty
    private int filesize;
    @JsonProperty
    private int rating;
    @JsonProperty
    private String category;
    @JsonProperty
    private boolean math = false;
    @JsonProperty
    private boolean physics = false;
    @JsonProperty
    private boolean chemistry = false;
    @JsonProperty
    private boolean geography = false;
    @JsonProperty
    private boolean literature = false;
    @JsonProperty
    private boolean construction = false;
    @JsonProperty
    private boolean marketing = false;
    @JsonProperty
    private byte[] mybytearray;

    /**
     * A constructor for the Shared.Files class that takes a String object and a byte array
     * @param fileName A string object that denotes the name of the file that we are sharing
     * @param mybytearray a byte array that is the file that we are sharing
     */
    public Files(String fileName, byte[] mybytearray)
    {this.filename=fileName;
        this.mybytearray=mybytearray;
    }
    public Files(String name)
    {
        this.filename=name;
    }

    public Files(){

    }

    public Files(String filename, String username, String uploadDate, String format, int filesize, String path , int rating,
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
    public String  getCategory()
    {
        return category;
    }

    public String toString(){
        return filename  + "\nSize: " +filesize  + "\nUSER: " + username + "\t\t DATE: "+ uploadDate;
    }
    public void setCategory()
    {
        if (category.equals("Math")) math = true;
        if (category.equals("Physics")) physics = true;
        if (category.equals("Chemistry")) chemistry = true;
        if (category.equals("Geography")) geography = true;
        if (category.equals("Literature")) literature = true;
        if (category.equals("Construction")) construction = true;
        if (category.equals("Marketing")) marketing = true;
    }
}
