package alan.resende.noivalist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TaskActivity extends AppCompatActivity {

    Button btn;
    EditText inputTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Button btn = (Button)findViewById(R.id.btn_task);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inputTask = (EditText)findViewById(R.id.inputTask);
                BancoController controller = new BancoController(getBaseContext());
                System.out.println(inputTask);
                controller.addItem(inputTask.toString());
                finish();
            }
        });
    }


}
