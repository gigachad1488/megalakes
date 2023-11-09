import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Origin")
public class Origin
{
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "origin")
    public String origin;
}
