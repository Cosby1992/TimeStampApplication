package dk.cosby.timestampapplication;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SaveTimeStamp  {

    private String time = "";
    private String date = "";
    private String timeAndDate = "";
    private Date currentDayInfo = null;

    private SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat sdfDate = new SimpleDateFormat("dd MMM yyyy");
    private SimpleDateFormat sdfTimeAndDate = new SimpleDateFormat("HH:mm:ss dd MMM yyyy");


    //no arg constructor creating
    public SaveTimeStamp(){
        currentDayInfo = Calendar.getInstance().getTime();
        date = sdfDate.format(currentDayInfo);
        time = sdfTime.format(currentDayInfo);
        timeAndDate = sdfTimeAndDate.format(currentDayInfo);
    }

    public String secondsToString(int seconds) {

        int hours = seconds/60/60;
        int minutes = seconds/60;
        seconds = seconds%60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


    //////////////////////////////// GETTERS AND SETTERS //////////////////////////////////////////

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getCurrentDayInfo() {
        return currentDayInfo;
    }

    public void setCurrentDayInfo(Date currentDayInfo) {
        this.currentDayInfo = currentDayInfo;
    }
}
