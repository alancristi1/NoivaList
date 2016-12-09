package alan.resende.noivalist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 28/10/16.
 */

public class BancoController {

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

    public void addItem(String nome){
        String sql = "INSERT INTO task (nome) VALUES ('"+nome+"')";
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        ContentValues values = new ContentValues();
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

}
