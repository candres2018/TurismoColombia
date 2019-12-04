package com.example.turismocolombia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.turismocolombia.Model.LugarT;

import java.util.List;

public class TuristicAdapter extends RecyclerView.Adapter<TuristicAdapter.LugartViewHolder> {
    List<LugarT> lugart;

    public TuristicAdapter(List<LugarT> restaurante){
        this.lugart = restaurante;
    }

    @Override
    public int getItemCount() {
        return lugart.size();
    }

    @Override
    public LugartViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        LugartViewHolder rvh = new LugartViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(LugartViewHolder LugartViewHolder, int i) {
        LugartViewHolder.sitios_turisticos.setText(lugart.get(i).getSitios_turisticos());
        LugartViewHolder.ubicacion.setText(lugart.get(i).getUbicacion());
        LugartViewHolder.descripci_n.setText(lugart.get(i).getDescripci_n());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class LugartViewHolder extends RecyclerView.ViewHolder {
        TextView sitios_turisticos;
        TextView ubicacion;
        TextView descripci_n;

        LugartViewHolder(View itemView) {
            super(itemView);
            sitios_turisticos = itemView.findViewById(R.id.sitios_turisticos);
            ubicacion = itemView.findViewById(R.id.ubicacion);
            descripci_n = itemView.findViewById(R.id.descripci_n);
        }
    }

}
