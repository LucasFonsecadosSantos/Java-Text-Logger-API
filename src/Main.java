import app.*;
import utilies.*;
import dao.*;
import java.io.File;
public class Main {

    public static void main(String[] args) {
        String[] name = {"lucas", "igao"};
        StatusLogger logger = new StatusLogger("teste", "2.6", name);
        logger.generateLog("YEABAAA");
        logger.generateLog("DOLYCETA");
    }
}