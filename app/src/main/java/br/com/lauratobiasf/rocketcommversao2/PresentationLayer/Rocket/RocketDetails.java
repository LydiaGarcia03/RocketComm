package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Rocket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.RocketDAO;
import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;

public class RocketDetails extends AppCompatActivity
{
    TextView txtName, txtHeight, txtWeight, txtStage, txtDateCreation, txtDescription;
    FloatingActionButton btnRocketDelete;
    RocketDAO rocketDAO;
    Rocket rocket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket_details);

        rocketDAO = new RocketDAO(this);

        txtName = findViewById(R.id.txtNameRocket);
        txtDateCreation = findViewById(R.id.txtDateRocket);
        txtHeight = findViewById(R.id.txtHeightRocket);
        txtWeight = findViewById(R.id.txtWeightRocket);
        txtStage = findViewById(R.id.txtStageRocket);
        txtDescription = findViewById(R.id.txtDescritionRocket);

        btnRocketDelete = (FloatingActionButton) findViewById(R.id.btnRocketDelete);
        btnRocketDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                Toast.makeText(getApplicationContext(), "Foguete deletado com sucesso", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), RocketList.class);
                startActivity(i);
            }
        });

        //Recuperar dados enviados

        Bundle dados = getIntent().getExtras();
        rocket = (Rocket) dados.getSerializable("rocket");

        //Configurar valores recuperados

        txtName.setText(rocket.getRocket_name());
        txtDateCreation.setText(rocket.getCreation_date());
        txtHeight.setText(Float.toString(rocket.getRocket_height()));
        txtWeight.setText(Float.toString(rocket.getRocket_weight()));
        txtStage.setText(Integer.toString(rocket.getStages()));
        txtDescription.setText(rocket.getRocket_description());

    }

    public void delete(){
        rocketDAO.deleteRocket(rocket);
    }
}
