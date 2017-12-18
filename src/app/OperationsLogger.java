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

public class OperationsLogger extends Logger {
    
    public OperationsLogger(String softwareName, String softwareVersion, String[] softwareDevelopers) {
        super(softwareName, softwareVersion, softwareDevelopers);
    }

    @Override
    public void generateLog(String message) {

    }
}