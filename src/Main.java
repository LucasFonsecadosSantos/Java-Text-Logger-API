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