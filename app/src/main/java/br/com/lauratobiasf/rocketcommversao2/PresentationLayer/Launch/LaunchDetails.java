package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Launch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.LaunchDAO;
import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Launch;
import br.com.lauratobiasf.rocketcommversao2.R;

public class LaunchDetails extends AppCompatActivity {

    TextView txtLaunchRocketName, txtLaunchDate, txtTotalTime, txtMotorType, txtRecoverSystem;
    RadioGroup radioGroup;
    RadioButton rbtnAltimeter, rbtnNotAltimeter;

    Launch launch;
    LaunchDAO launchDAO;
    FloatingActionButton btnLaunchDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_details);

        launchDAO = new LaunchDAO(this);

        txtLaunchRocketName = findViewById(R.id.txtRocketChosen);
        txtLaunchDate = findViewById(R.id.txtLaunchDate);
        txtTotalTime = findViewById(R.id.txtTotalTimeLaunch);
        txtMotorType = findViewById(R.id.txtMotorType);
        txtRecoverSystem = findViewById(R.id.txtRecoverSystem);
        radioGroup = findViewById(R.id.radioGroupLaunchDetail);
        rbtnAltimeter = findViewById(R.id.rbtnAltimeterLaunchDetail);
        rbtnNotAltimeter = findViewById(R.id.rbtnNotAltimeterLaunchDetail);

        btnLaunchDelete = findViewById(R.id.btnLaunchDelete);
        btnLaunchDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                Toast.makeText(getApplicationContext(), "Lançamento deletado com sucesso", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), LaunchList.class);
                startActivity(i);
            }
        });

        //Recuperar dados enviados

        Bundle dados = getIntent().getExtras();
        launch = (Launch) dados.getSerializable("launch");

    }

    public void delete(){
        launchDAO.delete(launch);
    }
}
