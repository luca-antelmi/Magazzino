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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCostoProdotto() {
        return costoProdotto;
    }

    public void setCostoProdotto(int costoProdotto) {
        this.costoProdotto = costoProdotto;
    }

}
