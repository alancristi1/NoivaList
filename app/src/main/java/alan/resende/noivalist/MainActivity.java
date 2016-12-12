package alan.resende.noivalist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.lista);

        ArrayList<Task> itens = null;
        BancoController controller = new BancoController(this);

            itens = controller.getAllItens();
            ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(this, simple_list_item_1,itens);
            final ListView listView = (ListView) findViewById(R.id.lista);
            listview.setAdapter((ListAdapter) adapter);
        onRestart();

        //Instância do floatbutton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(intent);
            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Context ctx = view.getContext();
                final Task task = (Task)listview.getItemAtPosition(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir este cliente?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                new BancoController(getBaseContext()).deleteItem(task.id);
                                LoadList();
                                Toast.makeText(ctx, "Cliente excluído com sucesso!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .create()
                        .show();
                return false;
            }
        });
    }

    public void LoadList(){
        ArrayList<Task> itens = null;
        BancoController controller = new BancoController(this);
        itens = controller.getAllItens();
        ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(this, simple_list_item_1, itens);
        ListView listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter((ListAdapter) adapter);
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        LoadList();
    }
}
