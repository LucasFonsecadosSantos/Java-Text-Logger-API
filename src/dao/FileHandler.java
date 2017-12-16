package dao;

import utilies.DateFactory;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class FileHandler {

    private String fileName;
    private File file;
    private File directory;
    private DirectoryHandler directoryHandler;
    private DateFactory dateFactory;

    public FileHandler() {
        this.dateFactory = new DateFactory();
        this.directoryHandler = new DirectoryHandler();
        this.directory = this.directoryHandler.buildDirectory();
        createNewLogFile();
    }

    public File createNewLogFile() {
        this.file = new File("../logs/" + this.dateFactory.getOnlyDate() + ".txt");
        System.out.println(this.file);
        if(!this.file.exists()) {
            try {
                this.file = new File("../logs/"+ this.dateFactory.getOnlyDate() + ".txt");
                this.file.createNewFile();
                return this.file;
            } catch(Exception e) {
                System.out.println(e.toString());
                return null;
            }
        }else {
            return this.file;
        }
    }

}