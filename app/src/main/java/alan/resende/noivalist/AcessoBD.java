package alan.resende.noivalist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alan on 21/10/16.
 */

    public class AcessoBD extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "noivalist";
    private static final int VERSAO = 3;

    private static String TABLE_ITENS =
            "CREATE TABLE task("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "nome TEXT,"+
                    "categoria TEXT"+
                    ");";

    private  static String TABLE_CATEGORY =
            "CREATE TABLE category("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "nome TEXT"+
                    ");";


    public AcessoBD(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_ITENS);
        db.execSQL(TABLE_CATEGORY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//        if(newVersion > oldVersion) {
//            db.execSQL("ALTER TABLE task ADD COLUMN categoria TEXT");
//            db.close();
//        }

    }
}
    