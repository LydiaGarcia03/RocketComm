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
        setContentView(R.layout.activity_lauching);
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
