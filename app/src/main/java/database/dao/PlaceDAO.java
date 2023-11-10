package database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import database.entities.Place;

@Dao
public interface PlaceDAO
{
    @Insert
    public void insert(Place place);
    @Update
    public void update(Place place);
    @Delete
    public void delete(Place place);

    @Query("SELECT * FROM Place")
    List<Place> getAllPlaces();
}
