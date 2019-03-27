package dk.cosby.timestampapplication.Settings;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * This class handles settings regarding work hours, overtime hours etc.
 */
public class TimeSettings {

    public static final SimpleDateFormat FORMAT_hhmmss = new SimpleDateFormat("hh:mm:ss", new Locale("US"));
    public static final SimpleDateFormat FORMAT_ddMMMyyyyhhmmss = new SimpleDateFormat("dd MMM yyyy\thh:mm:ss", new Locale("US"));
    public static final SimpleDateFormat FORMAT_hhmmssddMMMyyyy = new SimpleDateFormat("hh:mm:ss\tdd MMM yyyy", new Locale("US"));

    private long[] normalWorkDurationMillis = new long[7];
    private long[] breaksEachWeekdayMillis = new long[7];
    private ArrayList<Long> overtimeAfterDurationMillisArray = new ArrayList<Long>();


    public TimeSettings() {

        

    }
}
