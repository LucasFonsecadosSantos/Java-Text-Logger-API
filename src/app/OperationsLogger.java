package app;

public class OperationsLogger extends Logger {
    
    public OperationsLogger(String softwareName, String softwareVersion, String[] softwareDevelopers) {
        super(softwareName, softwareVersion, softwareDevelopers);
    }

    @Override
    public void generateLog(String message) {
        
    }
}