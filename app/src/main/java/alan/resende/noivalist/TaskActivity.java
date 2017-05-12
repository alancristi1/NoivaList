package alan.resende.noivalist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        final EditText[] inputTask = {(EditText) findViewById(R.id.inputTask)};
        Button btn = (Button)findViewById(R.id.btn_task);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        BancoController controller = new BancoController(this);
        ArrayList<Task> getCategory = controller.getAllCategory();
        ArrayAdapter adapterSpinner = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, getCategory);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inputTask[0] = (EditText)findViewById(R.id.inputTask);
                BancoController controller = new BancoController(getBaseContext());
                System.out.println(inputTask[0]);
                controller.addItem(inputTask[0].getText().toString());
                finish();
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        System.out.println("Selecionado " + pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
