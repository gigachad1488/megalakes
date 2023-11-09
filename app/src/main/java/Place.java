import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Place")
public class Place
{
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "name")
    public String name;
}
