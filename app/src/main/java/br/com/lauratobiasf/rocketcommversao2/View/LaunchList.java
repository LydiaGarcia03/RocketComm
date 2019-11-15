package br.com.lauratobiasf.rocketcommversao2.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.lauratobiasf.rocketcommversao2.Controller.Adapter.AdapterLaunch;
import br.com.lauratobiasf.rocketcommversao2.DataAccessLayer.LaunchDAO;
import br.com.lauratobiasf.rocketcommversao2.Model.Launch;
import br.com.lauratobiasf.rocketcommversao2.R;

public class LaunchList extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private ArrayList<Launch> launchList = new ArrayList<Launch>();

    LaunchDAO _dal = new LaunchDAO();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_launch_list);
        recyclerView = findViewById(R.id.launch_recycler);

        //Listagem de lançamentos

        //launchList = _dal
        launchList.add(new Launch(1));
        launchList.add(new Launch(2));
        launchList.add(new Launch(3));

        //Configurar Adpter

        AdapterLaunch adapterLaunch = new AdapterLaunch(launchList);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterLaunch);
    }
}
