import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Water_balance")
public class WaterBalance
{
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "type")
    public String type;
}
