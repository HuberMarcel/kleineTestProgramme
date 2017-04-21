/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author viona25
 */
public class InterfaceTesterPackageIntern implements IBeispielInterfaceDefault {

    public static void main(String[] args) {
        System.out.println("Ich kann IBeispielInterfaceDefault und "
                + "IBeispielInterfacePublic implementieren, "
                + "benutze aber nur das Default-Interface!");
        new InterfaceTesterPackageIntern().ichBinAutomatischEineAbstrakteMethode();
    }

    @Override
    public void ichBinAutomatischEineAbstrakteMethode() {
        System.out.println("\"ichBinAutomatischEineAbstrakteMethode()\": \n"
                + "Jetzt bin ich gar nicht mehr abstrakt!");
    }
}
