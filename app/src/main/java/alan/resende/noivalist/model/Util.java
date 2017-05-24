package alan.resende.noivalist.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

/**
 * Created by alan on 28/10/16.
 */

public class Util {

    public static DatabaseHandler handler = null;

    public Util(Context context){
        if(handler == null){
            handler = new DatabaseHandler(context);
        }
    }

    /*Method relation for Task*/

    public void addItem(String nome, String categoria){
        SQLiteDatabase db = handler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("categoria", categoria);
        db.insert("task ", null, values);
        db.close();
    }

    public int deleteItem(int id){
        SQLiteDatabase db = handler.getWritableDatabase();
        return db.delete("task", "ID=?", new String[] {String.valueOf(id)});
    }

    public ArrayList<Task> getAllItens(){
        SQLiteDatabase db = handler.getReadableDatabase();
        String sql = "SELECT id,nome FROM task";

        ArrayList<Task> tasks = new ArrayList<>();
        Cursor cursor;

        cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            tasks = new ArrayList<>();

            do {
                int id = cursor.getInt(0);
                String nome = cursor.getString(1);
                Task task = new Task(id, nome);
                tasks.add(task);
            }while (cursor.moveToNext());
        }
        db.close();
        return tasks;
    }

    public void alterItem(String nome, int id){
        SQLiteDatabase db = handler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("", nome);
        //  db.update("task",  values, nome, );
    }

    /*Method relation for Category*/

    public void addCategory(String nameCategory){
        SQLiteDatabase db = handler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nameCategory);
        db.insert("category ", null, values);
        db.close();
    }

    public ArrayList<Category> getAllCategory(){
        SQLiteDatabase db = handler.getReadableDatabase();
        String sql = "SELECT id,nome FROM category";

        ArrayList<Category> Arraycategory = new ArrayList<>();
        Cursor cursor;

        cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            Arraycategory = new ArrayList<>();

            do {
                int id = cursor.getInt(0);
                String nome = cursor.getString(1);
                Category category = new Category(id, nome);
                Arraycategory.add(category);
            }while (cursor.moveToNext());
        }
        db.close();
        return Arraycategory;
    }

    public int deleteCategory(int id){
        SQLiteDatabase db = handler.getWritableDatabase();
        return db.delete("category", "ID=?", new String[] {String.valueOf(id)});
    }
}
