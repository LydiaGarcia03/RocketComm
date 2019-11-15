package br.com.lauratobiasf.rocketcommversao2.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.lauratobiasf.rocketcommversao2.R;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.RocketDAO;

public class RocketRegister extends AppCompatActivity {

    EditText etRocketName, etCreationDate, etRocketHeight, etRocketWeight, etStages, etRocketDesc;
    RocketDAO rocketDAO;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket_register);

        etRocketName = findViewById(R.id.txtRocketName);
        etCreationDate = findViewById(R.id.txtCreationDate);
        etRocketHeight = findViewById(R.id.txtRocketHeight);
        etRocketWeight = findViewById(R.id.txtWeight);
        etStages = findViewById(R.id.txtStages);
        etRocketDesc = findViewById(R.id.txtRocketDesc);

        btnRegister = findViewById(R.id.btnRocketRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    public void register(){

        String rocketname = etRocketName.getText().toString();
        String creationdate = etCreationDate.getText().toString();
        Float height = Float.parseFloat(etRocketHeight.getText().toString());
        Float weight = Float.parseFloat(etRocketWeight.getText().toString());
        Integer stages = Integer.parseInt(etStages.getText().toString());
        String rocketdesc = etRocketDesc.getText().toString();

        rocketDAO.insertRockets(this, rocketname, creationdate, height, weight, stages, rocketdesc);

    }

}
