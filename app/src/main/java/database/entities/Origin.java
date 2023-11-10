package database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Origin")
public class Origin
{
    @PrimaryKey
    public long id;

    @ColumnInfo(name = "origin")
    public String origin;
}
