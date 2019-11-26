package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Rocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.RocketDAO;

public class RocketRegister extends AppCompatActivity {

    EditText etRocketName, etCreationDate, etRocketHeight, etRocketWeight, etStages, etRocketDesc;
    FloatingActionButton btnRegister;

    RocketDAO rocketDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket_register);

        rocketDAO = new RocketDAO(this);

        etRocketName = findViewById(R.id.etRocketName);
        etCreationDate = findViewById(R.id.etCreationDate);
        etRocketHeight = findViewById(R.id.etHeight);
        etRocketWeight = findViewById(R.id.etWeight);
        etStages = findViewById(R.id.etStages);
        etRocketDesc = findViewById(R.id.etDescription);

        btnRegister = (FloatingActionButton) findViewById(R.id.btnRocketRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
                Toast.makeText(getApplicationContext(), "Foguete cadastrado", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), RocketList.class);
                startActivity(i);
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

        rocketDAO.insert(new Rocket(rocketname, creationdate, height, weight, stages, rocketdesc));

    }

}
