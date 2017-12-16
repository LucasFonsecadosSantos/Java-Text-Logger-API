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
        System.out.println(this.directory.getAbsolutePath() + this.dateFactory.getOnlyDate() + ".txt");
        this.file = new File(this.directory.getAbsolutePath() + this.dateFactory.getOnlyDate() + ".txt");
        if(!this.file.exists()) {
            try {
                this.file.createNewFile();
                return this.file;
            } catch(Exception e) {
                return null;
            }
        }else {
            return this.file;
        }
    }

}