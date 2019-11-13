package br.com.lauratobiasf.rocketcommversao2.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.lauratobiasf.rocketcommversao2.R;

public class MainActivity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void redirectToRocket(View view)
    {
        i = new Intent(getApplicationContext(), RocketListActivity.class);
        startActivity(i);

    }

    public void redirectToLaunch(View view) {

        i = new Intent(this, RocketRegister.class);
        startActivity(i);

    }
}
