package br.com.lauratobiasf.rocketcommversao2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class LaunchDAO {

    SQLiteDatabase db;

    public LaunchDAO(Context c) {

        db = c.openOrCreateDatabase("rocketcomm", c.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS launches(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "fk_rocket_id INTEGER NOT NULL," +
                "launch_datetime DATETIME NOT NULL," +
                "launch_site_lon REAL," +
                "launch_site_lat REAL," +
                "motor_type TEXT NOT NULL," +
                "recover_system TEXT NOT NULL," +
                "altimeter INT NOT NULL);");

    }
}
