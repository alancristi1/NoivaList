package alan.resende.noivalist;

<<<<<<< HEAD
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

=======
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294
import java.util.ArrayList;
import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
    //BancoController controller = new BancoController(this);
=======

>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        final BancoController controller = new BancoController(this);
        final ArrayList<Task> itens;
        itens = controller.getAllItens();
        //System.out.println(itens);
        final ArrayAdapter<Task> adapter = new ArrayAdapter<>(this, simple_list_item_1, itens);
        final ListView listview = (ListView) findViewById(R.id.lista);
        listview.setAdapter((ListAdapter) adapter);

=======
        ArrayList<String> itens = null;
        BancoController controller = new BancoController(this);

//        for (int i = 10; i < 20; i++) {
//            controller.addItem("" + i);

            itens = controller.getAllItens();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, simple_list_item_1, itens);
            ListView listview = (ListView) findViewById(R.id.lista);
            listview.setAdapter((ListAdapter) adapter);
        onRestart();
//        }
>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294
        //Instância do floatbutton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(intent);
            }
        });
<<<<<<< HEAD

        //final ArrayList<String> finalItens = itens;
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
=======
>>>>>>> c34bcb1935cbf087c7fbf5011191fde511e96294
    }
}
