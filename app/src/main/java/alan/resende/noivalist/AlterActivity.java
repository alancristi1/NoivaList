package alan.resende.noivalist;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by alan on 21/10/16.
 */

public class AlterActivity extends Activity {

    EditText task;
    AcessoBD db;
    String nome;
    Button alterar;
    Button deletar;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteration);

        nome = this.getIntent().getStringExtra("nome");
        //db = new AcessoBD(getBaseContext());
        task = (EditText)findViewById(R.id.editName); //edith text que n foi criado

//        cursor = db.Select(nome);
//        //task.setText(cursor.getString(cursor.getColumnIndexOrThrow(db.Select(nome))));
//        alterar = (Button)findViewById(R.id.btnAlter); //botao n criado
//        alterar.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                //db.update(nome.getText().toString());//provavel que seja getText();
//                db.update(nome);
//                Intent intent = new Intent(AlterActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        //Deletar
//        deletar = (Button)findViewById(R.id.btnDel); //Button Delete
//        deletar.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                db.Delete(nome);
//                Intent intent = new Intent(AlterActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }
}
