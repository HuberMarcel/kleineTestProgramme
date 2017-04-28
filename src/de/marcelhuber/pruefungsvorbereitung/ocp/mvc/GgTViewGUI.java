package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

import java.awt.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Marcel
 */
public class GgTViewGUI extends JFrame implements GgTView {

    private GgTController ggTController;

    private JLabel labelEingabeA;
    private JLabel labelEingabeB;
    private JLabel labelAusgabeX;
    private JLabel labelAusgabeY;
    private JLabel labelAusgabeResultGgT;

    private JTextField textEingabeA;
    private JTextField textEingabeB;
    private JTextField textAusgabeX;
    private JTextField textAusgabeY;
    private JTextField textAusgabeResultGgT;

    public static void main(String[] args) {
        new GgTViewGUI();
    }

    public GgTViewGUI() {
        super("Berechnung des ggT's zweier Zahlen a und b!");  // 1. Frame Erzeugen
        initForm();
    }

    private void initForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // 2. Programm beenden
        setLayout(new FlowLayout());
        setSize(500, 200);

        initializeLabels();
        initializeJTextfields();
        addToFrameJLabelsAndTextFields();

        setVisible(true);
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(GgTViewGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.exit(0);
    }

    void addToFrameJLabelsAndTextFields() {
        add(labelEingabeA);
        add(textEingabeA);
        add(labelEingabeB);
        add(textEingabeB);
        add(labelAusgabeX);
        add(textAusgabeX);
        add(labelAusgabeY);
        add(textAusgabeY);
        
        add(labelAusgabeResultGgT);
        add(textAusgabeResultGgT);
    }

    void initializeLabels() {
        labelEingabeA = new JLabel("Zahl a:");
        labelEingabeB = new JLabel("Zahl b:");
        labelAusgabeX = new JLabel("Ausgabe x:");
        labelAusgabeY = new JLabel("Ausgabe y:");
        labelAusgabeResultGgT = new JLabel("Ausgabe ggT:");
    }

    void initializeJTextfields() {
        textEingabeA = new JTextField(10);
        textEingabeB = new JTextField(10);
        textAusgabeX = new JTextField(10);
        textAusgabeY = new JTextField(10);
        textAusgabeResultGgT = new JTextField(10);
    }

    @Override
    public void setController(GgTController controller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getEingabeA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getEingabeB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getEingabenAB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showResultGgT(long resultGgT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showResultX(long x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showResultY(long y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
