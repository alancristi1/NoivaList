package alan.resende.noivalist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        final EditText txtNameCategory = (EditText)findViewById(R.id.txtNameCategory);
        Button btnSaveCategory = (Button)findViewById(R.id.btnSaveCategory);

        btnSaveCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BancoController controller = new BancoController(getBaseContext());
                controller.addCategory(txtNameCategory.getText().toString());
                finish();
            }
        });
    }
}
