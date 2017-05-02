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

public class TaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button btn;
    EditText inputTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Button btn = (Button)findViewById(R.id.btn_task);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.categoria_array,
                android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inputTask = (EditText)findViewById(R.id.inputTask);
                BancoController controller = new BancoController(getBaseContext());
                System.out.println(inputTask);
                controller.addItem(inputTask.getText().toString());
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
