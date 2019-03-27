package dk.cosby.timestampapplication.Settings;


import android.content.Context;

import com.google.gson.Gson;

/**
 * This class keeps track of all weekly settings like breaks and normal work hours.
 */
public class WeekSettings {



    private double[] weeklyWorkHours = {0,0,0,0,0,0,0};
    private double[] weeklyBreakHours = {0,0,0,0,0,0,0};


    //no arg constructor
    public WeekSettings() {
    }


//////////////////////////////////// GETTERS AND SETTERS //////////////////////////////////////////
    public double[] getWeeklyWorkHours() {
        return weeklyWorkHours;
    }

    public void setWeeklyWorkHours(double[] weeklyWorkHours) {
        this.weeklyWorkHours = weeklyWorkHours;
    }

    public double[] getWeeklyBreakHours() {
        return weeklyBreakHours;
    }

    public void setWeeklyBreakHours(double[] weeklyBreakHours) {
        this.weeklyBreakHours = weeklyBreakHours;
    }
}
