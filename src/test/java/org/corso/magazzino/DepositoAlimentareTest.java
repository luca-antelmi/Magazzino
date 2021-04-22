package org.corso.magazzino;

import java.time.LocalDate;

import org.corso.magazzino.exceptions.ErroreScaricoProdottoNegativoException;
import org.corso.magazzino.exceptions.ErroreScaricoProdottoNonEsistenteException;
import org.junit.Before;
import org.junit.Test;

public class DepositoAlimentareTest {

    private Prodotto prodottoAlimentareDiTest;
    private DepositoAlimentare depositoAlimentareDiTest;

    @Before
    public void setUp(){
        depositoAlimentareDiTest = new DepositoAlimentare("Deposito A", 50);
        prodottoAlimentareDiTest = new ProdottoAlimentare("Gelato", "Algida", 10, LocalDate.of(2021, 04, 28));

    }

    @Test(expected = ErroreScaricoProdottoNonEsistenteException.class)
    public void eccezioneSeScaricoProdottoNonInDeposito() throws ErroreScaricoProdottoNonEsistenteException {
        try {
            depositoAlimentareDiTest.scaricoDeposito(prodottoAlimentareDiTest, 5);
        } catch (ErroreScaricoProdottoNegativoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
