package com.example.gastosmensaisapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetalhesGastoActivity extends AppCompatActivity {
    private TextView textDescricaoDetalhe, textValorDetalhe, textDataDetalhe;
    private Button btnEditar, btnExcluir;
    private DatabaseHelper databaseHelper;
    private Gasto gasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_gasto);

        databaseHelper = new DatabaseHelper(this);

        textDescricaoDetalhe = findViewById(R.id.textDescricaoDetalhe);
        textValorDetalhe = findViewById(R.id.textValorDetalhe);
        textDataDetalhe = findViewById(R.id.textDataDetalhe);
        btnEditar = findViewById(R.id.btnEditar);
        btnExcluir = findViewById(R.id.btnExcluir);

        if (getIntent().hasExtra("gasto")) {
            gasto = (Gasto) getIntent().getSerializableExtra("gasto");
            if (gasto != null) { // Verificação para evitar NullPointerException
                preencherDados();
            } else {
                Toast.makeText(this, "Erro ao carregar os dados do gasto", Toast.LENGTH_SHORT).show();
                finish(); // Fecha a Activity se o objeto Gasto estiver nulo
            }
        } else {
            Toast.makeText(this, "Dados do gasto não encontrados", Toast.LENGTH_SHORT).show();
            finish(); // Fecha a Activity se o extra não estiver presente
        }

        btnEditar.setOnClickListener(v -> editarGasto());
        btnExcluir.setOnClickListener(v -> excluirGasto());
    }

    private void preencherDados() {
        if (gasto != null) {
            textDescricaoDetalhe.setText("Descrição: " + gasto.getDescricao());
            textValorDetalhe.setText("Valor: R$" + gasto.getValor());
            textDataDetalhe.setText("Data: " + gasto.getData());
        }
    }

    private void editarGasto() {
        Intent intent = new Intent(DetalhesGastoActivity.this, CadastrarGastoActivity.class);
        intent.putExtra("gasto", gasto);
        startActivity(intent);
        finish();
    }

    private void excluirGasto() {
        if (gasto != null) {
            boolean sucesso = databaseHelper.excluirGasto(gasto.getId());
            if (sucesso) {
                Toast.makeText(this, "Gasto excluído com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erro ao excluir gasto", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Erro ao excluir gasto", Toast.LENGTH_SHORT).show();
        }
        finish(); // Retorna para a lista principal após a exclusão
    }



}
