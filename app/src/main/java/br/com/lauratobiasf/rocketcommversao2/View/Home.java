package br.com.lauratobiasf.rocketcommversao2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.lauratobiasf.rocketcommversao2.R;

public class Home extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button btn_launch = findViewById(R.id.btn_launch);
       // Button btn_rocket = findViewById(R.id.btn_rocket);

       /* btn_launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(), LaunchList.class);
                Home.this.startActivity(i);
            }
        });*/


    }

    public void redirectToRocket(View view){

        i = new Intent(this, RocketList.class);
        startActivity(i);

    }

    public void redirectToLaunch(View view) {

        i = new Intent(this, LaunchList.class);
        startActivity(i);

    }
}
