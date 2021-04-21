package org.corso.magazzino;

import java.util.HashMap;
import java.util.Map;

public class Deposito {
    private String nome;
    private int capacitaMassima;
    private Map<Prodotto, Integer> prodotti;

    public Deposito() {
        prodotti = new HashMap<>();
    }

    public Deposito(String nome, int capacitaMassima) {
        this();
        this.nome = nome;
        this.capacitaMassima = capacitaMassima;
    }

    public void caricoDeposito(Prodotto prodotto, int quantita) {
        if (prodotto != null) {
            int nuovaEsistenza = 0;
            if (prodotti.get(prodotto) != null) {
                nuovaEsistenza = prodotti.get(prodotto) + quantita;
            }
            prodotti.put(prodotto, nuovaEsistenza + quantita);
        }
    }

    public int getCapacitaMassima() {
        return capacitaMassima;
    }

    public void setCapacitaMassima(int capacitaMassima) {
        this.capacitaMassima = capacitaMassima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Deposito other = (Deposito) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}
