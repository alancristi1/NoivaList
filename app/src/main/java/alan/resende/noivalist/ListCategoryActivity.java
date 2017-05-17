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

        com.github.clans.fab.FloatingActionButton fabCategory =
                (com.github.clans.fab.FloatingActionButton) findViewById(R.id.fabCategory);

        fabCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListCategoryActivity.this, AddCategoryActivity.class);
                startActivity(intent);
            }
        });

        ListView listView = (ListView) findViewById(R.id.listCategory);
        BancoController controller = new BancoController(this);
        ArrayList<Category> getCategory;
        getCategory = controller.getAllCategory();
        ArrayAdapter<Category> adapter = new ArrayAdapter<>(this, simple_list_item_1, getCategory);
        listView.setAdapter(adapter);
        onRestart();
    }
}
