package se.dara.lang.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Dara on 2015-06-11.
 */
public class SqliteController extends SQLiteOpenHelper {

    public SqliteController(Context applicationcontext) {
        super(applicationcontext, "lang.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE lang ( lang_id TEXT PRIMARY KEY, lang_String TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void storeLanguage(HashMap<String, String> language){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        for(String key : language.keySet()){
            cv.put("lang_id", key);
            cv.put("lang_string", language.get(key));
            db.insert("lang", null, cv);
        }
    }

    public HashMap<String, String> getLanguage(String lang){
        String q = "SELECT * FROM lang WHERE lang_id LIKE '"+lang+"%'";
        HashMap<String, String> result = new HashMap<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(q, null);
        if (cursor.moveToFirst()) {
            do {
                result.put(cursor.getString(0), cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return result;
    }
}
