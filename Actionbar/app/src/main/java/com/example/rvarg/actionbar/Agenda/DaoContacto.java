package com.example.rvarg.actionbar.Agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rvarg on 07/09/2017.
 */

class DaoContacto extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "DBContactos";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_contacto = "contacto";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nombre";
    private static final String KEY_PHONENUMBER = "telefono";
    private static final String KEY_email = "email";
    private static final String KEY_imagen = "imagen";

    public static String TAG = "tag";
    private static final String CREATE_TABLE_Contacto = "CREATE TABLE "
            + TABLE_contacto + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
            + KEY_PHONENUMBER + " TEXT," + KEY_email + " TEXT," + KEY_imagen + " TEXT);";
    private SQLiteDatabase db = null;
    public DaoContacto(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_Contacto);
    }
    public void open() {
        try { // Abrimos la base de datos en modo escritura
            db = this.getWritableDatabase();
        } catch (Exception e) {
            throw new RuntimeException("Error al abrir la base de datos.");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS; " + CREATE_TABLE_Contacto);
        onCreate(db);
    }
    public long addContactoDetail(Conctacto student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getNombre());
        values.put(KEY_PHONENUMBER, student.getTelefono());
        values.put(KEY_email, student.getEmail());
        long insert = db.insert(TABLE_contacto, null, values);
        return insert;
    }
    public int updateEntry(Conctacto student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getNombre());
        values.put(KEY_PHONENUMBER, student.getTelefono());
        values.put(KEY_email, student.getEmail());
        return db.update(TABLE_contacto, values, KEY_ID + " = ?",
                new String[]{String.valueOf(student.id)});
    }
    public void deleteEntry(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_contacto, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
    public Conctacto getStudent(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_contacto + " WHERE "
                + KEY_ID + " = " + id;
        Log.d(TAG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Conctacto students = new Conctacto();
        students.id = c.getInt(c.getColumnIndex(KEY_ID));
        students.telefono = c.getString(c.getColumnIndex(KEY_PHONENUMBER));
        students.nombre = c.getString(c.getColumnIndex(KEY_NAME));
        students.email = c.getString(c.getColumnIndex(KEY_email));

        return students;
    }
    public List<Conctacto> searchContact(String name) {
        List<Conctacto> studentsArrayList = new ArrayList<Conctacto>();
        String selectQuery = "SELECT  * FROM " + TABLE_contacto + " WHERE "+KEY_NAME+" LIKE '%"+name+"%'";
        Log.d(TAG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Conctacto students = new Conctacto();
                students.id = c.getInt(c.getColumnIndex(KEY_ID));
                students.telefono = c.getString(c.getColumnIndex(KEY_PHONENUMBER));
                students.nombre = c.getString(c.getColumnIndex(KEY_NAME));
                students.email = c.getString(c.getColumnIndex(KEY_email));
                studentsArrayList.add(students);
            } while (c.moveToNext());
        }
        return studentsArrayList;
    }
    public List<Conctacto> getAllStudentsList() {
        List<Conctacto> studentsArrayList = new ArrayList<Conctacto>();
        String selectQuery = "SELECT  * FROM " + TABLE_contacto;
        Log.d(TAG, selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Conctacto students = new Conctacto();
                students.id = c.getInt(c.getColumnIndex(KEY_ID));
                students.telefono = c.getString(c.getColumnIndex(KEY_PHONENUMBER));
                students.nombre = c.getString(c.getColumnIndex(KEY_NAME));
                students.email = c.getString(c.getColumnIndex(KEY_email));
                studentsArrayList.add(students);
            } while (c.moveToNext());
        }
        return studentsArrayList;
    }
}
