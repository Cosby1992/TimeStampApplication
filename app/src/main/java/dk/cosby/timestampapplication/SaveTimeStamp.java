package dk.cosby.timestampapplication;


import android.app.Application;
import android.content.Context;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SaveTimeStamp  {

    private String timeNow = "";
    private Date currentDayInfo;

    public SaveTimeStamp(){

    }

    public String saveTimeNow(){

        currentDayInfo = Calendar.getInstance().getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        timeNow = simpleDateFormat.format(currentDayInfo);

        return currentDayInfo.toString();
    }

    public String getTimeNow() {
        return timeNow;
    }

    public void setTimeNow(String timeNow) {
        this.timeNow = timeNow;
    }

    public Date getCurrentDayInfo() {
        return currentDayInfo;
    }

    public void setCurrentDayInfo(Date currentDayInfo) {
        this.currentDayInfo = currentDayInfo;
    }
}
