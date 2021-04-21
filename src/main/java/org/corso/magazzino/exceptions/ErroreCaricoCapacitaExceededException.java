package org.corso.magazzino.exceptions;

public class ErroreCaricoCapacitaExceededException extends Exception {

    public ErroreCaricoCapacitaExceededException() {
        super("errore in fase di carico, capacità massima superata");
    }

}
