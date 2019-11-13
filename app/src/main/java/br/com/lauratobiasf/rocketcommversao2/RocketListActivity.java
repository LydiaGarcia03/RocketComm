package br.com.lauratobiasf.rocketcommversao2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import br.com.lauratobiasf.rocketcommversao2.Model.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;

public class RocketListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Rocket> rocketList;

    RocketDAO _dal = new RocketDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = findViewById(R.id.rocket_list);

        //Listagem de Foguetes

        rocketList = _dal.getRockets();

        //Configurar Adapter

        AdapterRocket adapter = new AdapterRocket();

        //Configurar RecyclerView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
