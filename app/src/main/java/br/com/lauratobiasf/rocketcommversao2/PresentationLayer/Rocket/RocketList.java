package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Rocket;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.RocketDAO;
import br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Generic.RecyclerItemClickListener;

public class RocketList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Rocket> rocketList = new ArrayList<Rocket>();
    Intent i;

    RocketDAO _dal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket_list);
        recyclerView = findViewById(R.id.rocket_recycler);

        _dal = new RocketDAO(this);

        //Listagem de Foguetes

        rocketList = _dal.getRockets();

        //Configurar Adapter

        final AdapterRocket adapter = new AdapterRocket(rocketList);

        //Configurar RecyclerView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Configurar Evento de Click

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent i = new Intent(getApplicationContext(), RocketDetails.class);

                                Rocket rocket = adapter.getRocket(position);
                                i.putExtra("rocket", rocket);

                                startActivity(i);

                            }

                            @Override
                            public void onLongItemClick(View view, int position)
                            {
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    public void redirectToRocketRegister(View view) {

        i = new Intent(this, RocketRegister.class);
        startActivity(i);

    }

    public void redirectToRocketDetails(View view) {

        i = new Intent(this, RocketDetails.class);
        startActivity(i);

    }
}
