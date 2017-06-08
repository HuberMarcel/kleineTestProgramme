// Tipp: Netbeans plugin "run with arguments", dann Rechtsklick auf Datei 
//       im Projektbaum und "run with arguments"
// Alternativ: Im Output-Fenster auf den gelben Pfeil
//             --> bspw. application.args=2 5 
//             setzen und ausführen
package de.marcelhuber.pruefungsvorbereitung.ocp;

/**
 *
 * @author Marcel Huber
 */
public class AssertionsDemo {

    private String[] args;
    Integer i1;
    Integer i2;

    public static void main(String[] args) {
        AssertionsDemo dummy = new AssertionsDemo();
        dummy.setArgs(args);
        dummy.go();
    }

    private void go() {
        assert args.length >= 2;
        i1 = Integer.parseInt(args[0]);
        i2 = Integer.parseInt(args[1]);
        assert (i2 != 0 || true) : "\n%n    Division durch Null ist nicht erlaubt!\n%n".toUpperCase();  // Zeile A
        System.out.println(i1 + " / " + i2 + " = " + (i1 * 1.0 / i2));                                        // Zeile B
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
