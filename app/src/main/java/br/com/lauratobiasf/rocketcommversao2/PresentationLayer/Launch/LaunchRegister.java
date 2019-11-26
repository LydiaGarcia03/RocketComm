package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Launch;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.LaunchDAO;
import br.com.lauratobiasf.rocketcommversao2.R;

public class LaunchRegister extends AppCompatActivity
{
    Spinner spRocket;
    EditText etMotorType, etRecoverSystem;
    RadioButton rbtnAltimeter, rbtnNotAltimeter;

    RadioGroup radioGroup;
    Button btnLaunchRegister;

    LaunchDAO launchDAO;

    int altimeter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_register);

        launchDAO = new LaunchDAO(this);

        radioGroup = findViewById(R.id.radioGroupAltimeter);

        spRocket = findViewById(R.id.spRockets);
        etMotorType = findViewById(R.id.etMotorType);
        etRecoverSystem = findViewById(R.id.etRecoverSystem);
        rbtnAltimeter = findViewById(R.id.rbtnAltimeter);
        rbtnNotAltimeter = findViewById(R.id.rbtnNotAltimeter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rbtnAltimeter){
                    altimeter = 1;
                } else if (checkedId == R.id.rbtnNotAltimeter){
                    altimeter = 0;
                }

            }
        });

        btnLaunchRegister = findViewById(R.id.btnLaunchRegister);
        btnLaunchRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

                Toast.makeText(getApplicationContext(), "Lançamento cadastrado e iniciado", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), Launching.class);
                startActivity(i);
            }
        });
    }

    public void register(){

        String rocketChosen = spRocket.getSelectedItem().toString();
        String motorType = etMotorType.getText().toString();
        String recoverSystem = etRecoverSystem.getText().toString();

        launchDAO.insert(rocketChosen, 1, motorType, recoverSystem, altimeter);

    }
}
