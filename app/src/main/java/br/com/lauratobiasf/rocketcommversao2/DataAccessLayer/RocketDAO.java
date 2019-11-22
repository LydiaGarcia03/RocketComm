package br.com.lauratobiasf.rocketcommversao2.DataAccessLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import br.com.lauratobiasf.rocketcommversao2.Model.Rocket;

        public class RocketDAO {

            SQLiteDatabase db;

            public void initDatabase(Context c){
                db = c.openOrCreateDatabase("rocketcomm", c.MODE_PRIVATE,null);
            }

            public void createTable(Context c){

                initDatabase(c);

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

            cursor.moveToNext();

        }

        return rocketArrayList;

    }

    public void insertRockets(Context c, String rocketname, String creationdate, Float height, Float weight, Integer stages, String desc){

        initDatabase(c);

        ContentValues contentValues = new ContentValues();
        contentValues.put("rocket_name", rocketname);
        contentValues.put("creation_date", creationdate);
        contentValues.put("rocket_height", height);
        contentValues.put("rocket_weight", weight);
        contentValues.put("stages", stages);
        contentValues.put("rocket_description", desc);

        db.insert("rockets", null, contentValues);

    }

    public void deleteRocket(Context c, Integer id){

        initDatabase(c);

        db.delete("rockets", "id=?" + id, null);

    }
}

