package app;

public class ReportLogger extends Logger {
    
    public ReportLogger(String softwareName, String softwareVersion, String[] softwareDevelopers) {
        super(softwareName, softwareVersion, softwareDevelopers);
    }

    @Override
    public void generateLog(String message) {

    }
}