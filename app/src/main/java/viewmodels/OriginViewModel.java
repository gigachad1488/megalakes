package viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import database.Database;
import database.dao.OriginDAO;
import database.entities.Origin;

public class OriginViewModel extends AndroidViewModel {
    private OriginDAO originDAO;
    private LiveData<List<Origin>> allData;
    private LiveData<Origin> originAt;

    public OriginViewModel(Application application) {
        super(application);
        Database database = Database.getDatabase(application);
        originDAO = database.originDao();
        allData = originDAO.getAllOrigins();
    }

    public LiveData<List<Origin>> getAllData() {
        return allData;
    }

    public LiveData<Origin> getOriginAt(long id)
    {
      originAt = originDAO.getOriginAt(id);
      return  originAt;
    }

    public void insert(Origin origin)
    {
        originDAO.insert(origin);
    }

    public void update(Origin origin)
    {
        originDAO.update(origin);
    }

    public void delete(Origin origin)
    {
        originDAO.delete(origin);
    }


}
