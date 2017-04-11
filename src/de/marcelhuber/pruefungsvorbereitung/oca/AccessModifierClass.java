package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
// eine Klasse, die privat wäre, kann nur sich selbst sehen und daher gar
// nicht benutzt werden, daher gibt es diesen Modifier nicht
//private class AccessModifierClass {
//    
//}
// default-Klasse sind nur in ihrem Package sichtbar, s.u. 
public class AccessModifierClass {
    // der Dateiname muss identisch mit dem Klassennamen der Klasse sein, welche
    // public ist, wenn es denn eine gibt, die public ist

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new AccessModifierClass().go();
    }

    private void go() {
        AccessModifierClass dummyObjekt = new AccessModifierClass();
        IchBinSchonKlasse ichBinEinKlasseDummyObjekt = new IchBinSchonKlasse();
        ichBinEinKlasseDummyObjekt.objektAusgabe("Hallo, ich wurde übergeben!");
    }
}

// der Modifier protected würde bei einer Klasse wenig Sinn machen: 
// erweiter man eine Klasse mit Default-Access, so muss diese sichtbar
// sein und damit im gleichen Package liegen. Wäre sie von außerhalb ihres
// Packages erweiterbar, so müsste sie auch von überall zu sehen sein und
// wäre damit vom Status her public
//protected TestClass {
//}
// Access-Modifier public ist natürlich erlaubt, allerdings muss diese mit
// dem Dateinamen synchron sein, deswegen ist das hier nicht erlaubt, 
// da wir schon eine Klasse haben, die public ist
//public class ichBinEineAndereKlasseHierInDerDatei{
//}
class IchBinSchonKlasse {

    {
        ausgabe(s);
    }
// offenbar werden statische Attribute (und Methoden) bei dem Laden der
// Klasse zuerst erzeugt

    static void ausgabe(String s) {
        System.out.println(s);
    }
    static String s = "Ein Objekt, das wirklich klasse ist, wird erzeugt!";
//    String s = "Haha"; // doppelte Variablenbelegung geht nicht    

    static {
        System.out.println("(Klasse wird geladen!) Ich bin wirklich schon klasse!");
    }

    void objektAusgabe(String s) {
//        System.out.println(this.s); 
// hier würde aus this.s automatisch 
//        System.out.println(IchBinSchonKlasse.s);
// gemacht werden
        System.out.println(s);
    }
}
