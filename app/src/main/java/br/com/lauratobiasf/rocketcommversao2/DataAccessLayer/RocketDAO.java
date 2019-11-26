package br.com.lauratobiasf.rocketcommversao2.DataAccessLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Rocket;

public class RocketDAO {

    SQLiteDatabase db;

    public RocketDAO(Context c){
        db = c.openOrCreateDatabase("rocketcomm", c.MODE_PRIVATE,null);
    }

    public void createTable(){

        db.execSQL("CREATE TABLE IF NOT EXISTS rockets(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "rocket_name TEXT NOT NULL," +
                "creation_date TEXT NOT NULL," +
                "rocket_height REAL," +
                "rocket_weight REAL," +
                "stages INTEGER," +
                "rocket_desc TEXT);");

    }

    public ArrayList<Rocket> getRockets(){

        ArrayList<Rocket> rocketArrayList = new ArrayList<Rocket>();

        Cursor cursor = db.rawQuery("SELECT * FROM rockets", null, null);

        cursor.moveToFirst();

        int id, stages;
        float rocket_height, rocket_weight;
        String rocket_name, creation_date, rocket_description;

        while(!cursor.isAfterLast()){

            id = cursor.getInt(cursor.getColumnIndex("id"));
            rocket_name = cursor.getString(cursor.getColumnIndex("rocket_name"));
            creation_date = cursor.getString(cursor.getColumnIndex("creation_date"));
            rocket_height = cursor.getFloat(cursor.getColumnIndex("rocket_height"));
            rocket_weight = cursor.getFloat(cursor.getColumnIndex("rocket_weight"));
            stages = cursor.getInt(cursor.getColumnIndex("stages"));
            rocket_description = cursor.getString(cursor.getColumnIndex("rocket_desc"));

            Rocket rocket = new Rocket(id, rocket_name, creation_date, rocket_height, rocket_weight, stages, rocket_description);

            rocketArrayList.add(rocket);

            cursor.moveToNext();

        }

        return rocketArrayList;

    }

    public void insert(Rocket rocket){

        ContentValues contentValues = new ContentValues();
        contentValues.put("rocket_name", rocket.getRocket_name());
        contentValues.put("creation_date", rocket.getCreation_date());
        contentValues.put("rocket_height", rocket.getRocket_height());
        contentValues.put("rocket_weight", rocket.getRocket_weight());
        contentValues.put("stages", rocket.getStages());
        contentValues.put("rocket_desc", rocket.getRocket_description());

        db.insert("rockets", null, contentValues);

    }

    public void deleteRocket(Rocket rocket){

        db.execSQL("DELETE FROM rockets WHERE id = " + rocket.getId());

    }
}

