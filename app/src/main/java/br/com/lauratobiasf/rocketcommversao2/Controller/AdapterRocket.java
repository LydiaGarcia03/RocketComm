package br.com.lauratobiasf.rocketcommversao2.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.lauratobiasf.rocketcommversao2.Model.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;

public class AdapterRocket extends RecyclerView.Adapter<AdapterRocket.MyViewHolder>
{
    private List<Rocket> rocketList;

    public AdapterRocket(List<Rocket> rocketList)
    {
        this.rocketList = rocketList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_rocket_list, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Rocket rocket = rocketList.get(position);
        holder.rocket_name.setText(rocket.getRocket_name());
    }

    @Override
    public int getItemCount()
    {
        return rocketList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView rocket_name;

        public MyViewHolder(View itemView) {
            super(itemView);

            rocket_name = itemView.findViewById(R.id.textName);
        }
    }
}
