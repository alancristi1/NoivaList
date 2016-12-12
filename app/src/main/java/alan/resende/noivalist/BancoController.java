package alan.resende.noivalist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
<<<<<<< HEAD
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;
=======

import java.util.ArrayList;
>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294

/**
 * Created by alan on 28/10/16.
 */

public class BancoController {

<<<<<<< HEAD
    private Context ctx;

    public static AcessoBD acessoBD = null;
    public BancoController(MainActivity context){
        if(acessoBD == null){
            acessoBD = new AcessoBD((Context) context);
        }
    }

    public BancoController(Context ctx) {
        this.ctx = ctx;
    }

    public BancoController(AdapterView.OnItemLongClickListener onItemLongClickListener) {
    }

=======
    public static AcessoBD acessoBD = null;
    public BancoController(Context context){
        if(acessoBD == null){
            acessoBD = new AcessoBD(context);
        }
    }

>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294
    public void addItem(String nome){
        String sql = "INSERT INTO task (nome) VALUES ('"+nome+"')";
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        ContentValues values = new ContentValues();
<<<<<<< HEAD
        values.put("", nome);
        db.insert("task ", null, values);
        db.execSQL(sql);
        db.close();
    }

    public void deleteItem(int id){
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        //String sql = "DELETE FROM task WHERE id = ('"+position+"')";
        String sql = "DELETE FROM task WHERE id=" + id;
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<Task> getAllItens(){
        return getAllItens(null);
    }

    public ArrayList<Task> getAllItens(String nomeB){
        SQLiteDatabase db = acessoBD.getReadableDatabase();
        String sql = "SELECT id,nome FROM task";

        ArrayList<Task> tasks = new ArrayList<>();
        Cursor cursor;
        //ArrayList<String> itens = null;

        cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            tasks = new ArrayList<Task>();

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

=======
        values.put("nome", nome);
        db.insert("task ", null, values);
        db.execSQL(sql);
    }

    public ArrayList<String> getAllItens(){
        SQLiteDatabase db = acessoBD.getReadableDatabase();
        String sql = "SELECT nome FROM task";
        Cursor cursor;
        ArrayList<String> itens = null;

        cursor = db.rawQuery(sql, null);
        if(cursor != null && cursor.moveToFirst()){
            itens = new ArrayList<String>();

            do {
                itens.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        return itens;
    }
>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294
}
