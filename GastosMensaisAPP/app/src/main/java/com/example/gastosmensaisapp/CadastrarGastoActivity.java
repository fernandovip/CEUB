package com.example.gastosmensaisapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastrarGastoActivity extends AppCompatActivity {
    private EditText editDescricao, editValor, editData;
    private Button btnSalvar, btnExcluir;
    private DatabaseHelper databaseHelper;
    private Gasto gasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_gasto);

        databaseHelper = new DatabaseHelper(this);

        editDescricao = findViewById(R.id.editDescricao);
        editValor = findViewById(R.id.editValor);
        editData = findViewById(R.id.editData);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnExcluir = findViewById(R.id.btnExcluir);

        if (getIntent().hasExtra("gasto")) {
            gasto = (Gasto) getIntent().getSerializableExtra("gasto");
            preencherCampos();
            btnSalvar.setText("Editar");
            btnExcluir.setVisibility(View.VISIBLE); // Mostra o botão "Excluir" para registros existentes
        } else {
            gasto = new Gasto();
            btnExcluir.setVisibility(View.GONE); // Oculta o botão "Excluir" para novos registros
        }

        btnSalvar.setOnClickListener(v -> salvarGasto());
        btnExcluir.setOnClickListener(v -> excluirGasto());
    }

    private void preencherCampos() {
        editDescricao.setText(gasto.getDescricao());
        editValor.setText(String.valueOf(gasto.getValor()));
        editData.setText(gasto.getData());
    }

    private void salvarGasto() {
        String descricao = editDescricao.getText().toString().trim();
        String valorStr = editValor.getText().toString().trim();
        String data = editData.getText().toString().trim();

        // Validações
        if (descricao.isEmpty() || descricao.length() > 50) {
            Toast.makeText(this, "Descrição inválida!", Toast.LENGTH_SHORT).show();
            return;
        }

        double valor;
        try {
            valor = Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valor inválido!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (data.length() == 10) { // Verifica se o formato da data é dd/MM/yyyy
            if (databaseHelper.existeGastoNoMes(descricao, data) && (gasto == null || gasto.getId() == 0)) {
                Toast.makeText(this, "Gasto já cadastrado neste mês!", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(this, "Data inválida! Use o formato dd/MM/yyyy.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Cria um novo Gasto se não estiver instanciado
        if (gasto == null) {
            gasto = new Gasto();
        }

        gasto.setDescricao(descricao);
        gasto.setValor(valor);
        gasto.setData(data);

        // Verifica se o gasto é novo ou está sendo atualizado
        if (gasto.getId() > 0) {
            databaseHelper.atualizarGasto(gasto);
            Toast.makeText(this, "Gasto atualizado!", Toast.LENGTH_SHORT).show();
        } else {
            databaseHelper.inserirGasto(gasto);
            Toast.makeText(this, "Gasto cadastrado!", Toast.LENGTH_SHORT).show();
        }

        finish(); // Fecha a Activity após cadastrar ou atualizar o gasto
    }


    private void excluirGasto() {
        if (gasto.getId() > 0) {
            databaseHelper.excluirGasto(gasto.getId());
            Toast.makeText(this, "Gasto excluído!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erro ao excluir o gasto!", Toast.LENGTH_SHORT).show();
        }
    }
}
