package app;

public class StatusLogger extends Logger {
    
    public StatusLogger(String softwareName, String softwareVersion, String[] softwareDevelopers) {
        super(softwareName, softwareVersion, softwareDevelopers);
    }

    @Override
    public void generateLog(String message) {
        super.writeMessage(super.getSystemTime() + ": " + message);
    }
}