package br.com.lauratobiasf.rocketcommversao2.DataAccessLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Launch;

public class LaunchDAO {

    public SQLiteDatabase db;

    public LaunchDAO(Context c){
        db = c.openOrCreateDatabase("rocketcomm", c.MODE_PRIVATE, null);
    }

    public void createTable() {

        db.execSQL("CREATE TABLE IF NOT EXISTS launches(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "fk_rocket_id INTEGER NOT NULL," +
                "launch_datetime DATETIME NOT NULL," +
                "launch_total_time REAL," +
                "motor_type TEXT NOT NULL," +
                "recover_system TEXT," +
                "altimeter INT NOT NULL);");

    }

    public void insertLaunch(int fk_rocket_id, float launch_total_time, String motor_type, String recover_system, boolean altimeter){

        ContentValues contentValues = new ContentValues();
        contentValues.put("launches", fk_rocket_id);
        contentValues.put("launches", launch_total_time);
        contentValues.put("launches", motor_type);
        contentValues.put("launches", recover_system);
        contentValues.put("launches", altimeter);

        db.insert("launches", null, contentValues);

    }

    public void deleteLaunch(Launch launch){

        //db.delete("launches", "id=?" + launch.getId(), null);
        db.execSQL("DELETE FROM launches WHERE id = " + launch.getId());

    }

}
