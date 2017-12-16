package utilies;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactory {

    private SimpleDateFormat completeDatePattern;
    private SimpleDateFormat onlyDatePattern;
    private SimpleDateFormat onlyTimePattern;
    private Date currentDate;

    public DateFactory() {
        this.completeDatePattern = new SimpleDateFormat("[dd-MM-yyyy | HH:mm:ss]");
        this.onlyDatePattern = new SimpleDateFormat("[dd-MM-yyyy]");
        this.onlyTimePattern = new SimpleDateFormat("[HH:mm:ss]");
        this.currentDate = null;
    }

    public String getCompleteDate() {
        this.currentDate = new Date();
        return this.completeDatePattern.format(this.currentDate);
    }

    public String getOnlyDate() {
        this.currentDate = new Date();
        return this.onlyDatePattern.format(this.currentDate);
    }

    public String getTimePattern() {
        this.currentDate = new Date();
        return this.onlyTimePattern.format(this.currentDate);
    }
}