package alan.resende.noivalist.controller;

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

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

import alan.resende.noivalist.R;
import alan.resende.noivalist.model.Category;
import alan.resende.noivalist.model.Util;

import static android.R.layout.simple_list_item_1;

public class ListCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);

        com.github.clans.fab.FloatingActionButton fabCategory =
                (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fabCategory);
        FloatingActionMenu fabMenu = (FloatingActionMenu) findViewById(R.id.menuFab);
        fabMenu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean b) {
//                Toast.makeText(getBaseContext(), "asdsa" + (b ? "true" : "false"), Toast.LENGTH_SHORT).show();
            }
        });

        fabMenu.setClosedOnTouchOutside(true);
        fabCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCategoryActivity.this, AddCategoryActivity.class);
                startActivity(intent);
            }
        });

        final ListView listview = (ListView) findViewById(R.id.listCategory);
        final Util util = new Util(this);
        final ArrayList<Category> getCategory;
        getCategory = util.getAllCategory();
        final ArrayAdapter<Category> adapter = new ArrayAdapter<>(this, simple_list_item_1, getCategory);
        listview.setAdapter(adapter);
        onRestart();

        //      Functions for this list
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Context ctx = view.getContext();
//                Category category = (Category) listview.getItemAtPosition(position);
//                new Util(getBaseContext()).alterItem("", category.id);
//                LoadList();
//                Toast.makeText(ctx, "Tarefa alterada com sucesso", Toast.LENGTH_LONG).show();
//            }
//        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, final long id) {
                final Context ctx = view.getContext();
                final Category category = (Category)listview.getItemAtPosition(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir este cliente?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                new Util(getBaseContext()).deleteCategory(category.id);
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
        ArrayList<Category> getCategory;
        Util util = new Util(this);
        getCategory = util.getAllCategory();
        ArrayAdapter<Category> adapter = new ArrayAdapter<>(this, simple_list_item_1, getCategory);
        ListView listview = (ListView) findViewById(R.id.listCategory);
        FloatingActionMenu fabMenu = (FloatingActionMenu) findViewById(R.id.menuFab);
        fabMenu.close(true);
        listview.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LoadList();
    }
}
