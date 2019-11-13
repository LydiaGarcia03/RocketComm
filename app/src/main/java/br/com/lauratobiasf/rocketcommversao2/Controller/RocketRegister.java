package br.com.lauratobiasf.rocketcommversao2.Controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.lauratobiasf.rocketcommversao2.R;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.RocketDAO;

public class RocketRegister extends AppCompatActivity {

    EditText etRocketName, etCreationDate, etRocketHeight, etRocketWeight, etStages, etRocketDesc;
    RocketDAO rocketDAO;

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

    }

    public void register(){



    }

}
