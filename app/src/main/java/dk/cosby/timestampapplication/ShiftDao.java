package dk.cosby.timestampapplication;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ShiftDao {

    @Query("SELECT * FROM shifts")
    List<Shift> getAll();

    @Query("SELECT * FROM shifts WHERE id = :id")
    Shift findById(int id);

    @Query("SELECT * FROM shifts WHERE id IN (:shiftIds)")
    List<Shift> loadAllByIds(int[] shiftIds);

    @Query("SELECT * FROM shifts WHERE start_date LIKE :startDate")
    List<Shift> findByName(String startDate);

    @Query("SELECT * FROM shifts WHERE length > :length")
    List<Shift> findByLength(String length);

    @Insert
    void insertAll(Shift... shifts);

    @Insert
    void insertShift(Shift shift);

    @Delete
    void delete(Shift shift);



}
