package org.example.model;

import java.time.LocalDate;

public class Cliente {
    private final int id;
    private final String nome, status;
    private final double valor;
    private final LocalDate vencimento;
    private final String telefone;

    public Cliente (int id, String nome, String telefone, double valor, LocalDate vencimento, String status){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.valor = valor;
        this.vencimento = vencimento;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public double getValor() {
        return valor;
    }
    public LocalDate getVencimento() {
        return vencimento;
    }
    public String getStatus() {
        return status;
    }

}