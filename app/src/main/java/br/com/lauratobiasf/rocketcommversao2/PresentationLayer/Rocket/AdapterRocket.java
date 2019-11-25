package br.com.lauratobiasf.rocketcommversao2.PresentationLayer.Rocket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.lauratobiasf.rocketcommversao2.DataObjectLayer.Rocket;
import br.com.lauratobiasf.rocketcommversao2.R;

public class AdapterRocket extends RecyclerView.Adapter<AdapterRocket.RocketViewHolder>
{
    private List<Rocket> rocketList;

    public AdapterRocket(List<Rocket> rocketList)
    {
        this.rocketList = rocketList;
    }

    @Override
    public RocketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext()).inflate(   R.layout.adapter_rocket_list, parent, false);
        return new RocketViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(RocketViewHolder holder, int position)
    {
        Rocket rocket = rocketList.get(position);
        holder.rocket_name.setText(rocket.getRocket_name());
    }

    @Override
    public int getItemCount()
    {
        return rocketList.size();
    }

    public Rocket getRocket(int position)
    {
        return rocketList.get(position);
    }

    public class RocketViewHolder extends RecyclerView.ViewHolder
    {
        TextView rocket_name;

        public RocketViewHolder(View itemView) {
            super(itemView);

            rocket_name = itemView.findViewById(R.id.textName);
        }
    }
}
