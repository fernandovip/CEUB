package com.example.gastosmensaisapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListarGastosActivity extends AppCompatActivity {
    private RecyclerView recyclerViewGastos;
    private DatabaseHelper databaseHelper;
    private List<Gasto> listaGastos;

    @Override
    protected void onResume() {
        super.onResume();
        carregarGastos();
    }

    private void carregarGastos() {
        listaGastos = databaseHelper.getAllGastos();

        if (listaGastos != null && !listaGastos.isEmpty()) {
            GastoAdapter adapter = new GastoAdapter(listaGastos, gasto -> abrirDetalhesGasto(gasto));
            recyclerViewGastos.setAdapter(adapter);
        }
    }

    private void abrirDetalhesGasto(Gasto gasto) {
        Intent intent = new Intent(ListarGastosActivity.this, DetalhesGastoActivity.class);
        intent.putExtra("gasto", gasto);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_gastos);

        databaseHelper = new DatabaseHelper(this);

        recyclerViewGastos = findViewById(R.id.recyclerViewGastos);
        recyclerViewGastos.setLayoutManager(new LinearLayoutManager(this));
    }
}