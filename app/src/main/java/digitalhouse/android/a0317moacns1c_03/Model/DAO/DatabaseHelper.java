package digitalhouse.android.a0317moacns1c_03.Model.DAO;

import android.content.Context;
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

        String query = "CREATE TABLE " + DAOShakeHistorialDB.TABLE_HISTORY + "(" +
                DAOShakeHistorialDB.ID + " INTEGER PRIMARY KEY," +
                DAOShakeHistorialDB.NAME + " TEXT NOT NULL," +
                DAOShakeHistorialDB.LINK + " TEXT," +
                DAOShakeHistorialDB.DURATION + "TEXT," +
                DAOShakeHistorialDB.TRACK_POSITION + " TEXT," +
                DAOShakeHistorialDB.DISK_NUMBER + " TEXT)" ;

        db.execSQL(query);

        String query1 = "CREATE TABLE " + DAOShakesDB.TABLE_SHAKES + "(" +
                DAOShakesDB.ID + " INTEGER PRIMARY KEY," +
                DAOShakesDB.NAME + " TEXT NOT NULL," +
                DAOShakesDB.LINK + " TEXT," +
                DAOShakesDB.DURATION + " TEXT," +
                DAOShakesDB.TRACK_POSITION + " TEXT," +
                DAOShakesDB.DISK_NUMBER + " TEXT)" ;

        db.execSQL(query1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
