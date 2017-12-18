/**
 * This software was written by Lucas Fonseca dos Santos,
 * and published under the GPL-3 License.
 * 
 * This is a free Java API for data log generation. It
 * generates a multiples kinds of log data documents, formatted
 * by the user specfication.
 * 
 * NOTE:
 * ---------------------------------------------------------------
 * If you will want to use this code, don't forget of to write
 * my name into documentation. Thanks!
 * ---------------------------------------------------------------
 * 
 * CONTACT:
 * GitHub:  github.com/LucasFonsecaDosSantos
 * Email:   lucas@lcfcompany.com.br
 * Website: lucas.lcfcompany.com.br
 * Copyleft (yn) 2017;
 */
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

/**
 * @author Lucas Fonseca dos Santos
 * @since 11-18-2017
 * @version 1.0
 * 
 * This class describes the File handler, prensents at
 * the API. It is responsible for verifys the log data file
 * and if this exists and other things.
 * 
 */
public class FileHandler {

    /**
     * Log file name attribute.
     */
    private String fileName;

    /**
     * Log file object attribute.
     */
    private File file;

    /**
     * Log directory file attribute.
     */
    private File directory;

    /**
     * DirectoryHandler object attribute.
     */
    private DirectoryHandler directoryHandler;

    /**
     * DateFactory object attribute.
     */
    private DateFactory dateFactory;

    /**
     * The FileHandler object constructor. It sets states to
     * dateFactory, directoryHandler and directory as new objects
     * and calls the creation new log file method that will
     * makes new log file for will be used by the API.
     */
    public FileHandler() {
        this.dateFactory = new DateFactory();
        this.directoryHandler = new DirectoryHandler();
        this.directory = this.directoryHandler.buildDirectory();
        createNewLogFile();
    }

    /**
     * This method is responsible for constructs new log file object with
     * name as current system date, but in the first step, this method verifys
     * if isn't already exists any log files with the same name.
     * 
     * @return File A file text log data object that has been created.
     */
    public File createNewLogFile() {
        this.file = new File("../logs/" + this.dateFactory.getOnlyDate() + ".txt");
        if(!this.file.exists()) {
            try {
                this.file = new File("../logs/"+ this.dateFactory.getOnlyDate() + ".txt");
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