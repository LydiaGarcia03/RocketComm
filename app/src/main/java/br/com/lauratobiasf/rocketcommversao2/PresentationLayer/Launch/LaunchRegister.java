package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Launch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.LaunchDAO;
import br.com.lauratobiasf.rocketcommversao2.R;

public class LaunchRegister extends AppCompatActivity
{
    Spinner spRocket;
    EditText etMotorType, etRecoverSystem;
    RadioButton rbtnAltimeter;
    Button btnLaunchRegister;

    LaunchDAO launchDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_register);

        btnLaunchRegister = findViewById(R.id.btnLaunchRegister);
        btnLaunchRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLaunch();
                
                Intent i = new Intent(getApplicationContext(), Launching.class);
                startActivity(i);
            }
        });
    }

    public void initLaunch(){

        spRocket = findViewById(R.id.spRockets);
        etMotorType = findViewById(R.id.etMotorType);
        etRecoverSystem = findViewById(R.id.etRecoverSystem);
        rbtnAltimeter = findViewById(R.id.rbtnAltimeter);

        String rocketChosen = spRocket.getSelectedItem().toString();

        //launchDAO.db.execSQL("SELECT id FROM rockets WHERE rocket_name = " + rocketChosen);

        launchDAO.insertLaunch(getApplicationContext(), 1, 1, etMotorType.getText().toString(), etRecoverSystem.getText().toString(), false);

    }
}
