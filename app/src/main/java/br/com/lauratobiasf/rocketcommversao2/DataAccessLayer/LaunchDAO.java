package br.com.lauratobiasf.rocketcommversao2.DataAccessLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Launch;

public class LaunchDAO {

    public SQLiteDatabase db;

    public LaunchDAO(Context c){
        db = c.openOrCreateDatabase("rocketcomm", c.MODE_PRIVATE, null);
    }

    public void createTable() {

        db.execSQL("CREATE TABLE IF NOT EXISTS launches(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "launch_rocket_name TEXT," +
                "launch_total_time REAL," +
                "launch_datetime TEXT," +
                "motor_type TEXT NOT NULL," +
                "recover_system TEXT," +
                "altimeter INTEGER NOT NULL);");

    }

    public ArrayList<Launch> getLaunches(){

        ArrayList<Launch> launchArrayList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM launches", null, null);

        cursor.moveToFirst();

        int id, altimeter;
        String rocket_name, total_time_launch, motor_type, launch_datetime, recover_system;

        while(!cursor.isAfterLast()){

            id = cursor.getInt(cursor.getColumnIndex("id"));
            rocket_name = cursor.getString(cursor.getColumnIndex("launch_rocket_name"));
            total_time_launch = cursor.getString(cursor.getColumnIndex("launch_total_time"));
            launch_datetime = cursor.getString(cursor.getColumnIndex("launch_datetime"));
            motor_type = cursor.getString(cursor.getColumnIndex("motor_type"));
            recover_system = cursor.getString(cursor.getColumnIndex("recover_system"));
            altimeter = cursor.getInt(cursor.getColumnIndex("altimeter"));

            Launch launch = new Launch(id, rocket_name, total_time_launch, launch_datetime, motor_type, recover_system, altimeter);

            launchArrayList.add(launch);

            cursor.moveToNext();

        }

        return launchArrayList;
    }

    public void insert(String rocket_name, float launch_total_time, String motor_type, String recover_system, int altimeter){

        ContentValues contentValues = new ContentValues();
        contentValues.put("launch_rocket_name", rocket_name);
        contentValues.put("launch_total_time", launch_total_time);
        contentValues.put("launch_datetime", "agora");
        contentValues.put("motor_type", motor_type);
        contentValues.put("recover_system", recover_system);
        contentValues.put("altimeter", altimeter);

        db.insert("launches", null, contentValues);

    }

    public void delete(Launch launch){

        db.execSQL("DELETE FROM launches WHERE id = " + launch.getId());

    }

}
