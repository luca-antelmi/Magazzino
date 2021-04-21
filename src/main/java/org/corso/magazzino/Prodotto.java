package org.corso.magazzino;

import java.time.LocalDate;

public abstract class Prodotto {

    private String nomeProdotto;
    private String marca;
    private int costoProdotto;
    private LocalDate data;

    public Prodotto() {

    }

    public Prodotto(String nomeProdotto, String marca, int costoProdotto, LocalDate data) {
        this.nomeProdotto = nomeProdotto;
        this.marca = marca;
        this.costoProdotto = costoProdotto;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public String getMarca() {
        return marca;
    }

    public int getCostoProdotto() {
        return costoProdotto;
    }

}
