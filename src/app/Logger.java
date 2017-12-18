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
package app;

import dao.FileHandler;
import utilies.DateFactory;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 * @author Lucas Fonseca dos Santos
 * @since 11-18-2017
 * @version 1.0
 * 
 * This is the main class of API project. It represents the Logger
 * object that will be writes and registers all log documents.
 * It is an abstract class and other especializated class implements
 * it.
 * 
 */
public abstract class Logger {

    /**
     * The FileHandler object attribute.
     */
    private FileHandler fileHandler;

    /**
     * The log file object attribute.
     */
    private File logFile;

    /**
     * The software name attribute that uses this API.
     */
    private String softwareName;

    /**
     * The software version attribute that uses this API.
     */
    private String softwareVersion;

    /**
     * A string array attribute with all software developers that uses this API.
     */
    private String[] softwareDevelopers;

    /**
     * The string file header attribute.
     */
    private final String headerLogFile;

    /**
     * The DateFactory object attribute, used for getting
     * current system time to write into log status line.
     */
    private DateFactory dateFactory;

    /**
     * The logger object constructor. It receives a software name, version and responsable developers
     * and insert these informations at log file text header.
     * 
     * @param softwareName The software name that will be uses this API.
     * @param softwareVersion The software version that will be uses this API.
     * @param softwareDevelopers The software responsable developers that will be uses this API.
     */
    public Logger(String softwareName, String softwareVersion, String[] softwareDevelopers) {
        this.fileHandler = new FileHandler();
        this.logFile = this.fileHandler.createNewLogFile();
        this.dateFactory = new DateFactory();
        setSoftwareName(softwareName);
        setSoftwareVersion(softwareVersion);
        setSoftwareDeveloper(softwareDevelopers);
        setLogFileHeader();
    }

    /**
     * The public abstract method generateLog.
     * It must implemented by the class that will implements
     * this class.
     * 
     * It is responsible for get the system message and write this
     * at log file.
     * 
     * @param message The string message to write into log file.
     */
    public abstract void generateLog(String message);

    /**
     * This is a modifier method of software name attribute.
     * It receives the software name and change into upper case text.
     * 
     * @param name A software name string.
     */
    public void setSoftwareName(String name) {
        if(name != null) {
            this.softwareName = name.toUpperCase();
        }else {
            this.softwareName = "NULL";
        }
    }

    /**
     * This is a modifier method of software version attribute.
     * 
     * @param version A software version product.
     */
    public void setSoftwareVersion(String version) {
        if(version != null) {
            this.softwareVersion = "Version: " + version;
        }else {
            this.softwareVersion = "Version: "+version;
        }
    }

    /**
     * This is a modifier method of software developers attribute.
     * 
     * @param developer A string array with all software developers responsable.
     */
    public void setSoftwareDeveloper(String[] developers) {
        if(developers.length == 0 || developers == null) {
            String[] dev = new String[1];
            dev[0] = "Not informed.";
            this.softwareDevelopers = dev;
        }else {
            this.softwareDevelopers = developers;
        }
    }

    /**
     * It is an accessor method that returns the software name attribute
     * state.
     * 
     * @return String The software name string.
     */
    public String getSoftwareName() {
        return this.softwareName;
    }

    /**
     * It is an accessor method that returns the software version attribute
     * state.
     * 
     * @return String The software version string.
     */
    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    /**
     * It is an accessor method that returns the software developers name
     * attribute state.
     * 
     * @return String[] The software developers name string array.
     */
    public String[] getSoftwareDevelopers() {
        return this.softwareDevelopers;
    }

    /**
     * It is an accessor method that returns the current system time value.
     * 
     * @return String The current system time string.
     */
    public String getSystemTime() {
        return this.dateFactory.getCompleteDate();
    }

    /**
     * This method is responsible for creates a log text file header and insert it
     * into file. It contains all informations about the software that will uses by this
     * API and other informations.
     */
    public void setLogFileHeader() {
        if(this.logFile.length() == 0) {
            try {
                FileWriter fw = new FileWriter(this.logFile);
                String header = "+------------------------------------------------+\n";
                header += "+           LOG FILE GENERATOR TOOL              +\n";
                header += "+ Java API developed by Lucas Fonseca dos Santos.+\n";
                header += "+ General Public License. GPL-3.                 +\n";
                header += "+------------------------------------------------+\n";
                header += "SOFTWARE: " + getSoftwareName() + "\n";
                header += "VERSION: " + getSoftwareVersion() + "\n";
                String[] dev = getSoftwareDevelopers();
                header += "DEVELOPERS: ";
                for(String s : dev) {
                    header += s +";";
                }
                header += "\n+------------------------------------------------+\n";
                fw.write(header);
                fw.close();
            } catch(IOException ioe) {
                System.out.println(ioe.toString());
            } catch(Exception e) {
                System.out.println(e.toString());
            }
        }else {
            return;
        }
    }

    /**
     * This method writes a system status message log into log file.
     * It receives some message and writes that formatted by default pattern.
     * 
     * @param message A status system message to write into file.
     */
    public void writeMessage(String message) {
        try {
            FileWriter fw = new FileWriter(this.logFile, true);
            fw.write("\n" + message + ";");
            fw.close();
        } catch(IOException ioe) {
            System.out.println(ioe.toString());
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }

}