package alan.resende.noivalist.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import alan.resende.noivalist.R;
import alan.resende.noivalist.model.Util;

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
                Util util = new Util(getBaseContext());
                util.addCategory(txtNameCategory.getText().toString());
                finish();
            }
        });
    }
}
