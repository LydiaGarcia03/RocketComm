package br.com.lauratobiasf.rocketcommversao2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRocket extends RecyclerView.Adapter<AdapterRocket.MyViewHolder>
{
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adpter_rocket_list, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.rocket_name.setText("Nome de teste"); //Aqui pegaria do banco de dados
    }

    @Override
    public int getItemCount() {
        return 10;
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
