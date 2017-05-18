package alan.resende.noivalist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.AdapterView;
import java.util.ArrayList;

/**
 * Created by alan on 28/10/16.
 */

public class BancoController {

    private Context ctx;

    public BancoController(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

    public static AcessoBD acessoBD = null;

    public BancoController(Context context){
        if(acessoBD == null){
            acessoBD = new AcessoBD(context);
        }
    }

    /*Method relation for Task*/

    public void addItem(String nome, String categoria){
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("categoria", categoria);
        db.insert("task ", null, values);
        db.close();
    }

    public int deleteItem(String id){
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        return db.delete("task", "ID=?", new String[] {id});
    }

    public ArrayList<Task> getAllItens(){
        SQLiteDatabase db = acessoBD.getReadableDatabase();
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
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("", nome);
        //  db.update("task",  values, nome, );
    }

    /*Method relation for Category*/

    public void addCategory(String nameCategory){
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nameCategory);
        db.insert("category ", null, values);
        db.close();
    }

    public ArrayList<Category> getAllCategory(){
        SQLiteDatabase db = acessoBD.getReadableDatabase();
        String sql = "SELECT nome FROM category ORDER BY nome DESC";
        ArrayList<Category> taskCategoria = new ArrayList<>();
        Cursor cursor;

        cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            taskCategoria = new ArrayList<>();

            do {
                String nome = cursor.getString(0);
                Category category = new Category(nome);
                taskCategoria.add(category);
            }while (cursor.moveToNext());
        }
        db.close();
        return taskCategoria;
    }

    public int deleteCategory(String id){
        SQLiteDatabase db = acessoBD.getWritableDatabase();
//        return db.delete("task", "ID=?", new String[] {id});
        return db.delete("task", "ID=?", new String[] {id});
    }

}
