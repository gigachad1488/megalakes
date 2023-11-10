package database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import database.entities.WaterBalance;

@Dao
public interface WaterBalanceDAO
{
    @Insert
    public void insert(WaterBalance waterBalance);
    @Update
    public void update(WaterBalance waterBalance);
    @Delete
    public void delete(WaterBalance waterBalance);

    @Query("SELECT * FROM Water_balance")
    List<WaterBalance> getAllWaterBalances();
}