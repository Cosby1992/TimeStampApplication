package dk.cosby.timestampapplication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtilities {

    private final SimpleDateFormat SDF_TIME_HHmmss = new SimpleDateFormat("HH:mm:ss");
    private final SimpleDateFormat SDF_DATE_ddMMMyyyy = new SimpleDateFormat("dd MMM yyyy");
    private final SimpleDateFormat SDF_TIME_AND_DATE_HHmmss_ddMMMyyyy = new SimpleDateFormat("HH:mm:ss dd MMM yyyy");


    //Constructor (no-arg)
    public TimeUtilities() {
    }


    /**
     * This method takes two times in milliseconds and find the amount of time between.
     *
     * @param timeStartMillis earliest time to compare.
     * @param timeFinishMillis latest time to compare.
     *
     * @return String containing the time in HH:mm:ss format
     */
    public String timeBetweenMillis(long timeStartMillis, long timeFinishMillis){
        return SDF_TIME_HHmmss.format(new Date((long)Math.ceil((double)timeFinishMillis-timeStartMillis)));
    }


    public String getTimeDateFromMillis(long millis){
        return SDF_TIME_AND_DATE_HHmmss_ddMMMyyyy.format(new Date(millis));
    }

    public String getTimeFromMillis(long millis){
        return SDF_TIME_HHmmss.format(new Date(millis));
    }

    public String getDateFromMillis(long millis){
        return SDF_DATE_ddMMMyyyy.format(new Date(millis));
    }


}
