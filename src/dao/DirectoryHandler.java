package dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;

public class DirectoryHandler {

    private File logsDirectory;
    private String defaultLogsDirectoryName;

    public DirectoryHandler() {
        this.logsDirectory = null;
        setLogsDirectoryName("../logs/");
    }

    public File buildDirectory() {
        try {
            this.logsDirectory = new File(this.defaultLogsDirectoryName);
            if(!this.logsDirectory.exists()) {
                this.logsDirectory.mkdirs();
                return this.logsDirectory;
            }else {
                return this.logsDirectory;
            }   
        } catch(Exception e) {
            return null;
        }
    }

    public void setLogsDirectoryName(String name) {
        this.defaultLogsDirectoryName = name.toLowerCase().trim();
    }

    public String getDefaultLogsDirectoryName() {
        return this.defaultLogsDirectoryName;
    }
}