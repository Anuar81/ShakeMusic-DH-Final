package digitalhouse.android.a0317moacns1c_03.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;

/**
 * Created by dh3 on 05/07/17.
 */

public class DAOShakesDB extends DatabaseHelper {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String LINK = "link";
    public static final String DURATION = "duration";
    public static final String TRACK_POSITION = "track_position";
    public static final String DISK_NUMBER = "disk_number";
    public static final String TABLE_SHAKES = "shakes";

    public DAOShakesDB (Context context) {super (context);}

    public void addShaKe (Tema tema){

        if (!checkIfExist(tema.getId())){

            SQLiteDatabase database = getWritableDatabase();

            ContentValues row = new ContentValues();
            row.put(ID, tema.getId());
            row.put(NAME, tema.getName());
            row.put(LINK, tema.getLink());
            row.put(DURATION, tema.getDuration());
            row.put(TRACK_POSITION, tema.getTrackPosition());
            row.put(DISK_NUMBER, tema.getDiskNumber());

            database.insert(TABLE_SHAKES, null, row);

            database.close();
        }
    }

    public void addTemas (List<Tema> temaList){
        for (Tema tema : temaList){
            addShaKe(tema);
        }
    }


    public List<Tema> getAllTemas (){

        List<Tema> temas = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        String select = "SELECT * FROM +" + TABLE_SHAKES;

        Cursor cursor = database.rawQuery(select, null);
        while (cursor.moveToNext()){

            Tema tema = new Tema();
            tema.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            tema.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            tema.setLink(cursor.getString(cursor.getColumnIndex(LINK)));
            tema.setDuration(cursor.getInt(cursor.getColumnIndex(DURATION)));
            tema.setTrackPosition(cursor.getInt(cursor.getColumnIndex(TRACK_POSITION)));
            tema.setDiskNumber(cursor.getInt(cursor.getColumnIndex(DISK_NUMBER)));

            temas.add(tema);
        }

        cursor.close();
        database.close();

        return temas;
    }


    public Tema getTema (Integer id){
        SQLiteDatabase database = getReadableDatabase();

        String query = "SELECT * FROM" + TABLE_SHAKES +
                "WHERE" + ID + "=" + id;

        Cursor cursor = database.rawQuery(query, null);
        Tema tema = null;
        if (cursor.moveToNext()) {

            tema = new Tema();
            tema.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            tema.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            tema.setLink(cursor.getString(cursor.getColumnIndex(LINK)));
            tema.setDuration(cursor.getInt(cursor.getColumnIndex(DURATION)));
            tema.setTrackPosition(cursor.getInt(cursor.getColumnIndex(TRACK_POSITION)));
            tema.setDiskNumber(cursor.getInt(cursor.getColumnIndex(DISK_NUMBER)));


        }
        cursor.close();
        database.close();

        return tema;
    }

    public Boolean checkIfExist(Integer id){
        Tema tema = getTema(id);
        return !(tema == null);
    }

}
