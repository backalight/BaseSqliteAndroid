package fr.formation.basesqliteandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class DbInit extends SQLiteOpenHelper {

    public DbInit(Context ctxt) {
        super(ctxt, "annuaire", null, 1);//annuaire est le nom de la base de données. Le numero de version est fixé a un
    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contacts (" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                ", name TEXT NOT NULL" +
                ", tel TEXT" +
                ")";
        db.execSQL(sql);
    }

//cett methode est executée une seule fois pour créer la base de données

    @Override
    //celle ci est executer seulement si la version du fichier est differentes à celle du constructeur
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
