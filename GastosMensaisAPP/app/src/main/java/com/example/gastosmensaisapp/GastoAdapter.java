package com.example.gastosmensaisapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GastoAdapter extends RecyclerView.Adapter<GastoAdapter.GastoViewHolder> {
    private List<Gasto> gastos;
    private OnGastoClickListener listener;

    public interface OnGastoClickListener {
        void onGastoClick(Gasto gasto);
    }

    public GastoAdapter(List<Gasto> gastos, OnGastoClickListener listener) {
        this.gastos = gastos;
        this.listener = listener;
    }

    public void atualizarGastos(List<Gasto> novosGastos) {
        this.gastos.clear();
        this.gastos.addAll(novosGastos);
        notifyDataSetChanged(); // Notifica o adaptador sobre a alteração nos dados
    }

    @Override
    public GastoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gasto, parent, false);
        return new GastoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GastoViewHolder holder, int position) {
        Gasto gasto = gastos.get(position);
        holder.textDescricao.setText(gasto.getDescricao());
        holder.textValorData.setText("R$" + gasto.getValor() + " - " + gasto.getData());
        holder.itemView.setOnClickListener(v -> listener.onGastoClick(gasto));
    }

    @Override
    public int getItemCount() {
        return gastos.size();
    }

    public class GastoViewHolder extends RecyclerView.ViewHolder {
        TextView textDescricao, textValorData;

        public GastoViewHolder(View itemView) {
            super(itemView);
            textDescricao = itemView.findViewById(R.id.textDescricao);
            textValorData = itemView.findViewById(R.id.textValorData);
        }
    }
}
