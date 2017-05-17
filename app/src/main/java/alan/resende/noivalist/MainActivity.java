package alan.resende.noivalist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.lista);

        ArrayList<Task> itens;
        BancoController controller = new BancoController(this);

            itens = controller.getAllItens();
            ArrayAdapter<Task> adapter = new ArrayAdapter<>(this, simple_list_item_1,itens);
            final ListView listView = (ListView) findViewById(R.id.lista);
            listView.setAdapter(adapter);
        onRestart();

        FloatingActionMenu fabMenu = (FloatingActionMenu) findViewById(R.id.menuFab);
        fabMenu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean b) {
                Toast.makeText(getBaseContext(), "asdsa" + (b ? "true" : "false"), Toast.LENGTH_SHORT).show();
            }
        });

        fabMenu.setClosedOnTouchOutside(true);
        com.github.clans.fab.FloatingActionButton fab1 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab1);
        com.github.clans.fab.FloatingActionButton fab2 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fab2);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListCategoryActivity.class);
                startActivity(intent);
            }
        });


        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Context ctx = view.getContext();
                Task task = (Task)listView.getItemAtPosition(position);
                new BancoController(getBaseContext()).alterItem("", task.id);
                LoadList();
                Toast.makeText(ctx, "Tarefa alterada com sucesso", Toast.LENGTH_LONG).show();
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {
                final Context ctx = view.getContext();
                final Task task = (Task)listview.getItemAtPosition(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir este cliente?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                new BancoController(getBaseContext()).deleteItem(String.valueOf(task.id));
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
        ArrayList<Task> itens;
        BancoController controller = new BancoController(this);
        itens = controller.getAllItens();
        ArrayAdapter<Task> adapter = new ArrayAdapter<>(this, simple_list_item_1, itens);
        ListView listView = (ListView) findViewById(R.id.lista);
        FloatingActionMenu fabMenu = (FloatingActionMenu) findViewById(R.id.menuFab);
        fabMenu.close(true);
        listView.setAdapter(adapter);
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        LoadList();

    }
}
