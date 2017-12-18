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
 * @see class
 * 
 * This class describes the Directory Handler, prensents at
 * the API. It is responsible for verifys the log data file
 * directory as if this exists and other things.
 * 
 */
public class DirectoryHandler {

    /**
     * A data text log file directory file attribute.
     */
    private File logsDirectory;

    /**
     * A default log directory name String attribute.
     */
    private String defaultLogsDirectoryName;

    /**
     * The directory handler object constructor.
     * It sets a null state to logs directory file attribute
     * and sets a new log directory default name.
     */
    public DirectoryHandler() {
        this.logsDirectory = null;
        setLogsDirectoryName("../logs/");
    }

    /**
     * This method is responsible for build the data log text file directory.
     * If it exists, this method doesn't make it.
     * 
     * @return File The file object that was build by method.
     */
    public File buildDirectory() {
        try {
            this.logsDirectory = new File(this.defaultLogsDirectoryName);
            if(!this.logsDirectory.exists()) {
                this.logsDirectory.mkdirs();
                return this.logsDirectory;
            }else {
                System.out.println(this.logsDirectory);
                return this.logsDirectory;
            }   
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * This is a modifier log directory default name attribute
     * state. It change the String to lower case and trim.
     * 
     * @param name The log directory String name.
     */
    public void setLogsDirectoryName(String name) {
        this.defaultLogsDirectoryName = name.toLowerCase().trim();
    }

    /**
     * This is a accessor method of log directory name state attribute.
     * 
     * @return String The log directory name.
     */
    public String getDefaultLogsDirectoryName() {
        return this.defaultLogsDirectoryName;
    }
}