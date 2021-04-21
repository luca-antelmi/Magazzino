package org.corso.magazzino;

import java.util.*;

import org.corso.magazzino.exceptions.ErroreCaricoCapacitaExceededException;
import org.corso.magazzino.exceptions.ErroreScaricoProdottoNegativoException;
import org.corso.magazzino.exceptions.ErroreScaricoProdottoNonEsistenteException;

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

    public void caricoDeposito(Prodotto prodotto, int quantita) throws ErroreCaricoCapacitaExceededException {
        if (capacitaMassima < capacitaMassima + quantita)
            throw new ErroreCaricoCapacitaExceededException();
        int nuovaEsistenza = quantita;
        if (prodotti.get(prodotto) != null)
            nuovaEsistenza = prodotti.get(prodotto) + quantita;

        prodotti.put(prodotto, nuovaEsistenza);
        capacitaMassima += nuovaEsistenza;
    }

    public void scaricoDeposito(Prodotto prodotto, int quantita)
            throws ErroreScaricoProdottoNonEsistenteException, ErroreScaricoProdottoNegativoException {
        if (prodotti.get(prodotto) == null)
            throw new ErroreScaricoProdottoNonEsistenteException();
        if (prodotti.get(prodotto) - quantita < 0)
            throw new ErroreScaricoProdottoNegativoException();
        if (prodotti.get(prodotto) - quantita == 0)
            prodotti.remove(prodotto);
        else
            prodotti.put(prodotto, prodotti.get(prodotto) - quantita);

    }

    public String inventario() {
        String stringa = new String();
        Set<Prodotto> products = prodotti.keySet();
        for(Prodotto item : products)
            stringa = item.getNomeProdotto() + " " + item.getCostoProdotto() + " " + this.getNome() + "\n";
        return stringa;
    }

    public int getCapacitaMassima() {
        return capacitaMassima;
    }

    public String getNome() {
        return nome;
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
