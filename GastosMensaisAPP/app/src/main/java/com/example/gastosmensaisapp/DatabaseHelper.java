package com.example.gastosmensaisapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "gastos.db";
    private static final int DATABASE_VERSION = 2; // Atualize a versão do banco se necessário

    public static final String TABLE_GASTOS = "gastos";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DESCRICAO = "descricao";
    public static final String COLUMN_VALOR = "valor";
    public static final String COLUMN_DATA = "data";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DatabaseHelper", "onCreate chamado - criando a tabela");
        String CREATE_TABLE_GASTOS = "CREATE TABLE " + TABLE_GASTOS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_DESCRICAO + " TEXT,"
                + COLUMN_VALOR + " REAL,"
                + COLUMN_DATA + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_GASTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GASTOS);
        onCreate(db);
    }

    public void inserirGasto(Gasto gasto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRICAO, gasto.getDescricao());
        values.put(COLUMN_VALOR, gasto.getValor());
        values.put(COLUMN_DATA, gasto.getData());

        db.insert(TABLE_GASTOS, null, values);
        db.close();
    }

    public void atualizarGasto(Gasto gasto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRICAO, gasto.getDescricao());
        values.put(COLUMN_VALOR, gasto.getValor());
        values.put(COLUMN_DATA, gasto.getData());

        db.update(TABLE_GASTOS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(gasto.getId())});
        db.close();
    }

    public boolean excluirGasto(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(TABLE_GASTOS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        Log.d("DatabaseHelper", "Linhas deletadas: " + rowsDeleted + " para o ID: " + id);
        db.close();
        return rowsDeleted > 0; // Retorna true se uma linha foi excluída, false caso contrário
    }



    public boolean existeGastoNoMes(String descricao, String data) {
        SQLiteDatabase db = this.getReadableDatabase();
        String mesAno = data.substring(3); // Extrai o mês e ano (assumindo formato dd/MM/yyyy)
        String query = "SELECT * FROM " + TABLE_GASTOS + " WHERE "
                + COLUMN_DESCRICAO + " = ? AND substr(" + COLUMN_DATA + ", 4) = ?";
        Cursor cursor = db.rawQuery(query, new String[]{descricao, mesAno});
        boolean existe = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return existe;
    }

    public double getTotalGastos() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(" + COLUMN_VALOR + ") FROM " + TABLE_GASTOS;
        Cursor cursor = db.rawQuery(query, null);
        double total = 0;
        if (cursor.moveToFirst()) {
            total = cursor.getDouble(0);
        }
        cursor.close();
        db.close();
        return total;
    }

    public List<Gasto> getAllGastos() {
        List<Gasto> listaGastos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_GASTOS, null);
        if (cursor.moveToFirst()) {
            do {
                Gasto gasto = new Gasto();
                gasto.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                gasto.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRICAO)));
                gasto.setValor(cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_VALOR)));
                gasto.setData(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATA)));
                listaGastos.add(gasto);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaGastos;
    }

}
