package fr.formation.basesqliteandroid;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creation de la base de donnée
        //création et mise à jour eventuelles
        DbInit dbInit = new DbInit(this);
        SQLiteDatabase db = dbInit.getWritableDatabase();
        //db.insert() ajouter dans la base
        //db.query pour rechercher
        //db.delete() efface
        //db.update()mettre a jour

    }

    public void clear(View view) {
    }

    public void search(View view) {
    }

    public void delete(View view) {
    }

    public void save(View view) {
    }
}
