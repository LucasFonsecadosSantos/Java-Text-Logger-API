import app.*;
import utilies.*;
import dao.*;
import java.io.File;
public class Main {

    public static void main(String[] args) {
        FileHandler f = new FileHandler();
        File file = f.createNewLogFile();
        System.out.println(f.hashCode());
    }
}