package alan.resende.noivalist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by alan on 28/10/16.
 */

public class BancoController {

    public static AcessoBD acessoBD = null;
    public BancoController(Context context){
        if(acessoBD == null){
            acessoBD = new AcessoBD(context);
        }
    }

    public void addItem(String nome){
        String sql = "INSERT INTO task (nome) VALUES ('"+nome+"')";
        SQLiteDatabase db = acessoBD.getWritableDatabase();
        ContentValues values = new ContentValues();
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
}
