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
 * 
 */
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