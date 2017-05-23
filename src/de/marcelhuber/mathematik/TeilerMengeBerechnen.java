package de.marcelhuber.mathematik;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class TeilerMengeBerechnen {

    private long zahl;
    private List<Long> teilerDerZahl = new ArrayList<>();

    public List<Long> berechneTeilerDerZahl(long zahl) {
        teilerDerZahl.clear();
        if (zahl > 0) {
            for (long k = 0; k < zahl; k++) {
                if (zahl % (k + 1) == 0) {
                    teilerDerZahl.add(k + 1);
                }
            }
        }
        return teilerDerZahl;
    }

    public List<Long> berechneTeilerDerZahl() {
        teilerDerZahl.clear();
        if (zahl > 0) {
            for (long k = 0; k < zahl; k++) {
                if (zahl % (k + 1) == 0) {
                    teilerDerZahl.add(k + 1);
                }
            }
        }
        return teilerDerZahl;
    }

    public List<Long> getTeilerDerZahl() {
        return teilerDerZahl;
    }

    public void setTeilerDerZahl(List<Long> teilerDerZahl) {
        this.teilerDerZahl = teilerDerZahl;
    }

    public long getZahl() {
        return zahl;
    }

    public void setZahl(long zahl) {
        this.zahl = zahl;
    }
}
