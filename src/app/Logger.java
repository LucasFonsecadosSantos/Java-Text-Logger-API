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

public abstract class Logger {

    private FileHandler fileHandler;
    private File logFile;
    private String softwareName;
    private String softwareVersion;
    private String[] softwareDevelopers;
    private String headerLogFile;
    private DateFactory dateFactory;

    public Logger(String softwareName, String softwareVersion, String[] softwareDevelopers) {
        this.fileHandler = new FileHandler();
        this.logFile = this.fileHandler.createNewLogFile();
        this.dateFactory = new DateFactory();
        setSoftwareName(softwareName);
        setSoftwareVersion(softwareVersion);
        setSoftwareDeveloper(softwareDevelopers);
        setLogFileHeader();
    }

    public abstract void generateLog(String message);

    public void setSoftwareName(String name) {
        if(name != null) {
            this.softwareName = name.toUpperCase();
        }else {
            this.softwareName = "NULL";
        }
    }

    public void setSoftwareVersion(String version) {
        if(version != null) {
            this.softwareVersion = "Version: 0.0";
        }else {
            this.softwareVersion = "Version: "+version;
        }
    }

    public void setSoftwareDeveloper(String[] developers) {
        if(developers.length == 0 || developers == null) {
            String[] dev = new String[1];
            dev[0] = "Not informed.";
            this.softwareDevelopers = dev;
        }else {
            this.softwareDevelopers = developers;
        }
    }

    public String getSoftwareName() {
        return this.softwareName;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public String[] getSoftwareDevelopers() {
        return this.softwareDevelopers;
    }

    public String getSystemTime() {
        return this.dateFactory.getCompleteDate();
    }

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