package br.com.lauratobiasf.rocketcommversao2.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

import br.com.lauratobiasf.rocketcommversao2.Controller.Adapter.AdapterRocket;
import br.com.lauratobiasf.rocketcommversao2.Model.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.RocketDAO;

public class RocketList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Rocket> rocketList = new ArrayList<Rocket>();

    RocketDAO _dal = new RocketDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket_list);
        recyclerView = findViewById(R.id.rocket_recycler);

        //Listagem de Foguetes

        //rocketList = _dal.getRockets();
        rocketList.add(new Rocket(1, "laura"));
        rocketList.add(new Rocket(2, "sabrina"));
        rocketList.add(new Rocket(3, "lydia"));


        //Configurar Adapter

        AdapterRocket adapter = new AdapterRocket(rocketList);

        //Configurar RecyclerView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }
}
