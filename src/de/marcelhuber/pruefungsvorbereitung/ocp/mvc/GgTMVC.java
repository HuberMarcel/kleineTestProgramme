package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

/**
 *
 * @author Marcel Huber
 */
public class GgTMVC {

    private GgTModel ggtModel;
    private GgTView ggtViewConsole, ggTViewGui;
    private GgTController ggtControllerConsole, ggTControllerGUI;

    public static void main(String[] args) {
        new GgTMVC().go();
    }

    void go() {
        ggtModel = new GgTModel();

        GgTViewSelection viewChooser = GgTViewSelection.GUI;
//        GgTViewSelection viewChooser = GgTViewSelection.CONSOLE;
//        GgTViewSelection viewChooser = GgTViewSelection.DEFAULT;

        switch (viewChooser) {
            case CONSOLE:
                ggtViewConsole = new GgTViewConsole();
                ggtControllerConsole = new GgTController(ggtModel, ggtViewConsole);
                ggtControllerConsole.showView();
                break;
            case GUI:
                ggTViewGui = new GgTViewGUI();
                ggTControllerGUI = new GgTController(ggtModel, ggTViewGui);
                ggTControllerGUI.showView();
                break;
            default:
                System.out.println("Keine Auswahl getroffen: Prgramm-ABBRUCH!");
                System.exit(0);
        }
    }

}

enum GgTViewSelection {
    CONSOLE, GUI,;//, DEFAULT,;
}
