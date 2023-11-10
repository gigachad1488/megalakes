package database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import database.entities.Salinity;

@Dao
public interface SalinityDAO
{
    @Insert(onConflict = 2)
    public void insert(Salinity salinity);
    @Update
    public void update(Salinity salinity);
    @Delete
    public void delete(Salinity salinity);

    @Query("SELECT * FROM Salinity")
    List<Salinity> getAllSalinities();
}