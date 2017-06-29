package digitalhouse.android.a0317moacns1c_03.Model.DAO;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dh3 on 29/06/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SAHKES_DB = "shakesDB";
    public static final Integer VERSION_DB = 1;

    public DatabaseHelper(Context context) {
        super(context, SAHKES_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE" + DAOTemaDB.TABLE_HISTORY + "(" +
                DAOTemaDB.ID + "INTEGER PRIMARY KEY," +
                DAOTemaDB.NAME + "TEXT NOT NULL," +
                DAOTemaDB.LINK + "TEXT," +
                DAOTemaDB.DURATION + "TEXT," +
                DAOTemaDB.TRACK_POSITION + "TEXT," +
                DAOTemaDB.DISK_NUMBER + "TEXT)" ;

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
