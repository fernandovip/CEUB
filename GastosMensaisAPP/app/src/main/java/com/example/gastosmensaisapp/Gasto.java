package com.example.gastosmensaisapp;

import java.io.Serializable;

public class Gasto implements Serializable {
    private int id;
    private String descricao;
    private double valor;
    private String data;

    public Gasto() {
    }

    public Gasto(int id, String descricao, double valor, String data) {
        this.id = id;
        this.descricao = descricao; // `this.descricao` refere-se ao campo da classe
        this.valor = valor;
        this.data = data;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
