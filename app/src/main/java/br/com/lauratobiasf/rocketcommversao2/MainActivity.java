package br.com.lauratobiasf.rocketcommversao2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void redirectToRocket(View view){

        i = new Intent(this, RocketRegisterActivity.class);
        startActivity(i);

    }

    public void redirectToLaunch(View view) {

        i = new Intent(this, RocketRegisterActivity.class);
        startActivity(i);

    }
}
