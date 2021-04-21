package org.corso.magazzino;

import org.corso.magazzino.exceptions.ErroreCaricoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MagazzinoTest {

    @InjectMocks
    private Magazzino magazzino;
    @Mock
    private DepositoAlimentare depositoAlimentari;
    @Mock
    private DepositoNonAlimentare depositoNonAlimentari;

    @Before
    public void setUp() {
        depositoAlimentari = new DepositoAlimentare(Magazzino.DEPOSITO_ALIMENTARI, 20);
        depositoNonAlimentari = new DepositoNonAlimentare(Magazzino.DEPOSITO_NON_ALIMENTARI, 50);
        magazzino = new Magazzino(depositoAlimentari, depositoNonAlimentari);
        MockitoAnnotations.openMocks(this);
    }

    @Test(expected = ErroreCaricoException.class)
    public void eccezioneSeProdottoNullo_carico() {
        // cosa dobbiamo fare per testare il metodo aspettandoci che se passiamo
        // un null come prodotto deve essere generata una eccezione
        // magazzino.carico(prodotto, quantita);
    }

    /**
     * una ulteriore verifica che si potrebbe fare é quella di capire se il metodo
     * carico di Magazzino chiami effetivamente il caricoDeposito corretto o no. Ma
     * per fare questo occorre utilizzare una spy. Ai fini di Salesforce non é
     * necessario conoscere questa tecnica. Una spy é una funzione particolare di
     * Mockito che fa si che l'oggetto spiato si comporti normalmente tranne per il
     * fatto che mockito riesce a tracciare la sua esecuzione per capire se alcuni
     * dei suoi metodi sono, per esempio, chiamati, quante volte sono chiamati,
     * ecc..
     *
     * @throws ErroreCaricoException
     */
    @Test
    public void verificaSelezioneCorrettoDepositoAlimentari_carico() throws ErroreCaricoException {
        Prodotto prodottoAlimentareDaCaricare = new ProdottoAlimentare("Spaghetti", "Barilla", 100,
                LocalDate.of(2021, 04, 28));

        // decido di spiare l'oggetto depositoAlimentare...
        DepositoAlimentare depositoAlimentareSpiato = Mockito
                .spy(new DepositoAlimentare(Magazzino.DEPOSITO_ALIMENTARI, 50));
        // ...lo passo al magazzino...
        Magazzino mag = new Magazzino(depositoAlimentareSpiato, depositoNonAlimentari);
        // lancio il metodo da testare...
        mag.carico(prodottoAlimentareDaCaricare, 30);
        // e siccome ho necessitá di sapere se effettivamente verrá chiamato (almeno una
        // volta) chiedo a mockito di farlo tramite questa istruzione
        verify(depositoAlimentareSpiato, atLeastOnce()).caricoDeposito(prodottoAlimentareDaCaricare, 30);
    }

    // provare a fare una cosa per il deposito non alimentari
    @Test
    public void verificaSelezioneCorrettoDepositoNonAlimentari_carico() throws ErroreCaricoException {

    }

}
