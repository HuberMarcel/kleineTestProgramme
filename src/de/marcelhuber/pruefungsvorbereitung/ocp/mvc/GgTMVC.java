package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

/**
 *
 * @author Marcel Huber
 */
public class GgTMVC {
    private GgTModel ggtModel;
    private GgTView ggtView;
    private GgTController ggtController;
    
    public static void main(String[] args) {
        new GgTMVC().go();
    }
    
    void go() {
        ggtModel = new GgTModel();
        
//        ggtView = new GgTViewConsole();
        ggtView = new GgTViewGUI();
        
        ggtController = new GgTController(ggtModel, ggtView);
        ggtController.showView();
    }
}
