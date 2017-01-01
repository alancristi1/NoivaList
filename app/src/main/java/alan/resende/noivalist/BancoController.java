package alan.resende.noivalist;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;
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

    public void addItem(String nome){
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        db.insert("task ", null, values);
        db.close();
    }

    public int deleteItem(String id){
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        return db.delete("task", "ID=?", new String[] {id});
    }

    public ArrayList<Task> getAllItens(){
        return getAllItens(null);
    }

    public ArrayList<Task> getAllItens(String nomeB){
        SQLiteDatabase db = acessoBD.getReadableDatabase();
        String sql = "SELECT id,nome FROM task";

        ArrayList<Task> tasks = new ArrayList<>();
        Cursor cursor;

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

    public void alterItem(String nome, int id){
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("", nome);
        //  db.update("task",  values, nome, );
    }
}
