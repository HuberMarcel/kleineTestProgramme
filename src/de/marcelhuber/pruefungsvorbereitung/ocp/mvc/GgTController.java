package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Marcel Huber
 */
public class GgTController implements Observer {

    private GgTModel ggTmodel;
    private GgTView ggTView;

    public GgTController(GgTModel ggTModel, GgTView ggTView) {
        this.ggTmodel = ggTModel;
        ggTModel.addObserver(this);
        this.ggTView = ggTView;
        ggTView.setController(this);
    }

    public void showView() {
        ggTView.showView();
    }

    public void reset() {
        ggTView.reset();
    }

    public void newGgTCalculation(long a, long b) {
//        System.out.println("a:"+a);
//        System.out.println("b:"+b);
        ggTmodel.ggTEuclidExtended(a, b);
    }

    public void update(Observable o, Object arg) {
//        ggTView.showResultX(ggTmodel.getX());
//        ggTView.showResultY(ggTmodel.getY());
//        ggTView.showResultGgT(ggTmodel.getResultGgT());
        ggTView.showResults();
    }

    public long getX() {
        return ggTmodel.getX();
    }

    public long getY() {
        return ggTmodel.getY();
    }

    public long getGgT() {
        return ggTmodel.getResultGgT();
    }

}
