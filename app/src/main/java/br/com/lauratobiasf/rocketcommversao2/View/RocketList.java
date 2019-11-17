package br.com.lauratobiasf.rocketcommversao2.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import br.com.lauratobiasf.rocketcommversao2.Controller.Adapter.AdapterRocket;
import br.com.lauratobiasf.rocketcommversao2.Model.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.RocketDAO;

public class RocketList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Rocket> rocketList = new ArrayList<Rocket>();
    Intent i;

    RocketDAO _dal = new RocketDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket_list);
        recyclerView = findViewById(R.id.rocket_recycler);

        //Listagem de Foguetes

        //rocketList = _dal.getRockets();
        rocketList.add(new Rocket(1, "Foguete 00"));
        rocketList.add(new Rocket(2, "Foguete 01"));
        rocketList.add(new Rocket(3, "Foguete 02"));
        rocketList.add(new Rocket(4, "Foguete 03"));
        rocketList.add(new Rocket(5, "Foguete 04"));
        rocketList.add(new Rocket(6, "Foguete 05"));
        rocketList.add(new Rocket(7, "Foguete 06"));
        rocketList.add(new Rocket(8, "Foguete 07"));

        //Configurar Adapter

        AdapterRocket adapter = new AdapterRocket(rocketList);

        //Configurar RecyclerView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void redirectToRocketRegister(View view) {

        i = new Intent(this, RocketRegister.class);
        startActivity(i);

    }
}
