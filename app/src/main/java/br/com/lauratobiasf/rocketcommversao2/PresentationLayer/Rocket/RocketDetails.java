package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Rocket;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;

public class RocketDetails extends AppCompatActivity
{
    TextView txtName, txtHeight, txtWeight, txtStage, txtDateCreation, txtDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket_details);

        txtName = findViewById(R.id.txtNameRocket);

        //Recuperar dados enviados

        Bundle dados = getIntent().getExtras();
        Rocket rocket = (Rocket) dados.getSerializable("rocket");

        //Configurar valores recuperados

        txtName.setText(rocket.getRocket_name());

    }
}
