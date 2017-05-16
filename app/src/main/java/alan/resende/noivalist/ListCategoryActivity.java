package alan.resende.noivalist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class ListCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);

        ListView listviewCategory = new ListView(this);
        com.github.clans.fab.FloatingActionButton fabCategory =
                (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fabCategory);

        fabCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCategoryActivity.this, AddCategoryActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<Task> itens;
        BancoController controller = new BancoController(this);
        itens = controller.getAllCategory();
        ArrayAdapter<Task> adapter = new ArrayAdapter<>(this, simple_list_item_1,itens);
        listviewCategory.setAdapter(adapter);
        onRestart();
    }
}
