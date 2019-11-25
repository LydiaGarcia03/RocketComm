package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Launch;
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

import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Launch;
import br.com.lauratobiasf.rocketcommversao2.R;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.LaunchDAO;
import br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Generic.RecyclerItemClickListener;

public class LaunchList extends AppCompatActivity
{
    private RecyclerView recycler;
    private ArrayList<Launch> launchList = new ArrayList<Launch>();
    Intent intent;

    LaunchDAO _dal = new LaunchDAO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_list);
        recycler = findViewById(R.id.launch_recycler);

        //Listagem de Lançamentos

        //launchList = _dal.getLaunches();

        launchList.add(new Launch("Lançamento 01"));
        launchList.add(new Launch("Lançamento 02"));
        launchList.add(new Launch("Lançamento 03"));
        launchList.add(new Launch("Lançamento 04"));
        launchList.add(new Launch("Lançamento 05"));
        launchList.add(new Launch("Lançamento 06"));
        launchList.add(new Launch("Lançamento 07"));
        launchList.add(new Launch("Lançamento 08"));

        //Configurar Adapter

        AdapterLaunch adapterLaunch = new AdapterLaunch(launchList);

        //Configurar RecyclerView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recycler.setAdapter(adapterLaunch);

        //Configurar Evento de Click

        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recycler,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void redirectToLaunchRegister(View view) {

        intent = new Intent(this, LaunchRegister.class);
        startActivity(intent);

    }
}
