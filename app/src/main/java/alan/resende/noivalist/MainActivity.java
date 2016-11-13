package alan.resende.noivalist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        //Instância do floatbutton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(intent);
            }
        });
    }
}
