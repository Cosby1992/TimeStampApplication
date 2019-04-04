package dk.cosby.timestampapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = Shift.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ShiftDao shiftDao();


}
