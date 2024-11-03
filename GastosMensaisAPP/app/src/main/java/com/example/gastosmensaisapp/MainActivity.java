package com.example.gastosmensaisapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewGastos;
    private TextView textTotalGasto;
    private Button btnCadastrar;
    private DatabaseHelper databaseHelper;
    private List<Gasto> listaGastos;
    private GastoAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        carregarGastos(); // Recarrega a lista de gastos
        atualizarTotalGasto(); // Atualiza o total gasto ao retornar à Activity
    }

    private void carregarGastos() {
        listaGastos = databaseHelper.getAllGastos();

        if (adapter == null) {
            // Inicializa o adaptador apenas uma vez
            adapter = new GastoAdapter(listaGastos, this::abrirDetalhesGasto);
            recyclerViewGastos.setAdapter(adapter);
        } else {
            // Atualiza a lista de dados do adaptador
            adapter.atualizarGastos(listaGastos);
        }
    }

    private void abrirDetalhesGasto(Gasto gasto) {
        Intent intent = new Intent(MainActivity.this, DetalhesGastoActivity.class);
        intent.putExtra("gasto", gasto);
        startActivity(intent);
    }

    private void atualizarTotalGasto() {
        double total = databaseHelper.getTotalGastos();
        textTotalGasto.setText(String.format("Total Gasto: R$%.2f", total));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        recyclerViewGastos = findViewById(R.id.recyclerViewGastos);
        recyclerViewGastos.setLayoutManager(new LinearLayoutManager(this));

        textTotalGasto = findViewById(R.id.textTotalGasto); // Novo TextView para mostrar o total gasto
        atualizarTotalGasto(); // Atualiza o total gasto na inicialização

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastrarGastoActivity.class);
            startActivity(intent);
        });
    }
}
