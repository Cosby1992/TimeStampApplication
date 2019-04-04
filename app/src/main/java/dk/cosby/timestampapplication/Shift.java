package dk.cosby.timestampapplication;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Shifts")
public class Shift {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int shiftId;

    @ColumnInfo(name = "start_time")
    private String timeStartShift;

    @ColumnInfo(name = "end_time")
    private String timeEndShift;

    @ColumnInfo(name = "start_date")
    private String dateStartShift;

    @ColumnInfo(name = "end_date")
    private String dateEndShift;

    @ColumnInfo(name = "length")
    private String shiftLength;


    //Constructor (no-arg)
    public Shift() {
    }



    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public String getTimeStartShift() {
        return timeStartShift;
    }

    public void setTimeStartShift(String timeStartShift) {
        this.timeStartShift = timeStartShift;
    }

    public String getTimeEndShift() {
        return timeEndShift;
    }

    public void setTimeEndShift(String timeEndShift) {
        this.timeEndShift = timeEndShift;
    }

    public String getDateStartShift() {
        return dateStartShift;
    }

    public void setDateStartShift(String dateStartShift) {
        this.dateStartShift = dateStartShift;
    }

    public String getDateEndShift() {
        return dateEndShift;
    }

    public void setDateEndShift(String dateEndShift) {
        this.dateEndShift = dateEndShift;
    }

    public String getShiftLength() {
        return shiftLength;
    }

    public void setShiftLength(String shiftLength) {
        this.shiftLength = shiftLength;
    }
}
