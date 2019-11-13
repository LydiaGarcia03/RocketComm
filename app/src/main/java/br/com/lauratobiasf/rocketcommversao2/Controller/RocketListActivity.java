package br.com.lauratobiasf.rocketcommversao2.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.List;

import br.com.lauratobiasf.rocketcommversao2.Model.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.RocketDAO;

public class RocketListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Rocket> rocketList;

    RocketDAO _dal = new RocketDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = findViewById(R.id.rocket_list);

        //Listagem de Foguetes

        //rocketList = _dal.getRockets();
        Rocket rocket = new Rocket(1, "laura");
        Rocket rocket1 = new Rocket(2, "lydia");
        Rocket rocket2 = new Rocket(3, "sabrina");
        rocketList.add(rocket);
        rocketList.add(rocket1);
        rocketList.add(rocket2);

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
