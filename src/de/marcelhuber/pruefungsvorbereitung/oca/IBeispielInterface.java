package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public interface IBeispielInterface {
//    private int variable = 3; // private würde keinen Sinn machen

    int variable = 3; // Variablen eines Interfaces sind final und public und STATIC
//    void ichBinEineMethode(){ // Methoden sind automatisch public und abstract
//  }

    void ichBinAutomatischEineAbstrakteMethode();
}
