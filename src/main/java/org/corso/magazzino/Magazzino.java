package org.corso.magazzino;

import org.corso.magazzino.exceptions.ErroreCaricoException;
import org.corso.magazzino.exceptions.ErroreScaricoException;

import java.util.HashMap;
import java.util.Map;

public class Magazzino {

    private Map<String, Deposito> depositi;
    public final static String DEPOSITO_ALIMENTARI = "DEPOSITO_ALIMENTARI";
    public final static String DEPOSITO_NON_ALIMENTARI = "DEPOSITO_NON_ALIMENTARI";

    public Magazzino() {
    }

    /**
     * E' preferibile che il magazzino riceva da un chiamante le istanze dei
     * depositi da gestire. In tal caso il Magazzino é in grado di gestire meglio
     * implementazioni eventualmente differenti dei depositi.
     *
     * @param depositoAlimentari
     * @param depositoNonAlimentari
     */
    public Magazzino(DepositoAlimentare depositoAlimentari, DepositoNonAlimentare depositoNonAlimentari) {
        depositi = new HashMap<>();
        depositi.put(depositoAlimentari.getNome(), depositoAlimentari);
        depositi.put(depositoNonAlimentari.getNome(), depositoNonAlimentari);
    }

    public void carico(Prodotto prodotto, int quantita) throws ErroreCaricoException {
        if (prodotto == null) {
            throw new ErroreCaricoException();
        }
        if (prodotto.getData() != null) {
            depositi.get(DEPOSITO_ALIMENTARI).caricoDeposito(prodotto, quantita);
        } else {
            depositi.get(DEPOSITO_NON_ALIMENTARI).caricoDeposito(prodotto, quantita);
        }
    }

    public void scarico(Prodotto prodotto, int quantita) throws ErroreScaricoException {

    }

    public void inventario(int quantita) {

    }

}
