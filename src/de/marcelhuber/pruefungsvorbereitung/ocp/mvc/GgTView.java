package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

/**
 *
 * @author Marcel Huber
 */
public interface GgTView {
    void setController(GgTController controller);              // okay
    void showView();                                           // okay
    void reset();                                          // okay
    long getEingabeA();                                        // okay
    long getEingabeB();                                        // okay
    void getEingabenAB();                                      // okay
    void showResultGgT(long resultGgT);       
    void showResultX(long x);
    void showResultY(long y);
    void showResults();
}
