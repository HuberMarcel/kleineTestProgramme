package de.marcelhuber.pruefungsvorbereitung.oca.selftestseite249;
// Aufruf mit application.args = live2
/**
 *
 * @author Marcel Huber
 */
class Fork {

    public static void main(String[] args) {
        if (args.length == 1 | args[1].equals("test")) {
//        if (args.length == 1 || args[1].equals("test")) {
            System.out.println("test case");
        } else {
            System.out.println("production " + args[0]);
        }
    }
}
