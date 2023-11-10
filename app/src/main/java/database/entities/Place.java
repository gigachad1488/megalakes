package database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Place")
public class Place
{
    @PrimaryKey
    public long id;

    @ColumnInfo(name = "name")
    public String name;
}
