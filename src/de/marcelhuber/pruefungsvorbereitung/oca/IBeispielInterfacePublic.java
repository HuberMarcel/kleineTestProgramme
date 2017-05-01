package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public interface IBeispielInterfacePublic {
//    private int variable = 3; // private würde keinen Sinn machen

    int variable = 3; // Variablen eines Interfaces sind final und public und STATIC
//    void ichBinEineMethode(){ // Methoden sind automatisch public und abstract
//  }

    void ichBinAutomatischEineAbstrakteMethode();

//    default void michGibtEsSeiJava8() {
//        System.out.println("mich kann man ab Java "
//                + "8 benutzen");
//    }

}
