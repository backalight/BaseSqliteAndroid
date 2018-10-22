package fr.formation.basesqliteandroid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button seek;
    Button save;
    Button vider;
    Button delete;
    EditText etSearch;
    EditText etId;
    EditText etName;
    EditText etTel;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creation de la base de donnée
        //création et mise à jour eventuelles
        DbInit dbInit = new DbInit(this);
         db = dbInit.getWritableDatabase();
        //db.insert() ajouter dans la base
        //db.query pour rechercher
        //db.delete() efface
        //db.update()mettre a jour
        save = findViewById(R.id.btInsert);
        seek = findViewById(R.id.btSearch);
        vider = findViewById(R.id.btNew);
        delete = findViewById(R.id.btDelete);
        etSearch = findViewById(R.id.etSearch);
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);
    }

    public void clear(View view) {
    }

    public void search(View view) {
        String colonnes[]={"id","name","tel"};
        String nom = etSearch.getText().toString();
        nom=nom.toUpperCase();
        nom=nom.replace("'","''");
        String critere="UPPER(name)='"+nom+"'";
        Cursor cursor = db.query("contacts", colonnes, critere, null, null, null, null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
        etId.setText(cursor.getString(0));
        etName.setText(cursor.getString(1));
        etTel.setText(cursor.getString(2));}
        else{
            Toast.makeText(this,"INTROUVABLE",Toast.LENGTH_LONG);
        }
    }

    public void delete(View view) {
    }

    public void save(View view) {

        ContentValues values = new ContentValues();
        values.put("name",etName.getText().toString());
        values.put("tel",etTel.getText().toString());
        db.insert("contacts","",values);
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG);


    }

}
