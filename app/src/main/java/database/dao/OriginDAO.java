package database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import database.entities.Origin;

@Dao
public interface OriginDAO
{
    @Insert
    public void insert(Origin origin);
    @Update
    public void update(Origin origin);
    @Delete
    public void delete(Origin origin);

    @Query("SELECT * FROM Origin")
    List<Origin> getAllOrigins();
}