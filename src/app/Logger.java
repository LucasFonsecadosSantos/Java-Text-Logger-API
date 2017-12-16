package app;

import dao.FileHandler;

public abstract class Logger {

    private FileHandler FileHandler;
    private String softwareName;
    private String softwareVersion;
    private String[] softwareDevelopers;
    private String headerLogFile;

    public Logger(String softwareName, String softwareVersion, String[] softwareDevelopers) {
        setSoftwareName(softwareName);
        setSoftwareVersion(softwareVersion);
        setSoftwareDeveloper(softwareDevelopers);
        setLogFileHeader();
    }

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

    public void setLogFileHeader() {
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
    }


}