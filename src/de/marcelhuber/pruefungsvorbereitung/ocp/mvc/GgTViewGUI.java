package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel labelKontrollrechnung;

    private JTextField textEingabeA;
    private JTextField textEingabeB;
    private JTextField textAusgabeX;
    private JTextField textAusgabeY;
    private JTextField textAusgabeResultGgT;
    private JTextField textKontrollRechnung;

    private JButton buttonBerechneGgT;
    private JButton buttonReset;

    private long a;
    private long b;
    private long x;
    private long y;
    private long resultGgT;

    private String str;

//    public static void main(String[] args) {
//        new GgTViewGUI();
//    }
    public GgTViewGUI() {
        super("Berechnung des ggT's zweier Zahlen a und b!");  // 1. Frame Erzeugen
        initForm();
    }

    private void initForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // 2. Programm beenden
        setLayout(new FlowLayout());
        setSize(1350, 200);

        initializeLabels();
        labelKontrollrechnung = new JLabel("Kontrolle");
        textKontrollRechnung = new JTextField();
        initializeJTextfields();
        initializeButtons();
        addToFrameJLabelsAndJTextFieldsAndJButtons();

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ggTController.reset();
            }
        });

        buttonBerechneGgT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getEingabenAB();
                ggTController.newGgTCalculation(a, b);
                x = ggTController.getX();
                y = ggTController.getY();
                resultGgT = ggTController.getGgT();
                kontrollRechnung();
                showResults();
            }
        });

        showView();
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(GgTViewGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.exit(0);
    }

    void kontrollRechnung() {
        str = "Es gilt:   " 
                + x + " * " + klammerNegLong(a) 
                + " + " + klammerNegLong(y) + " * " +klammerNegLong(b) 
                + " = " + (x * a + y * b);

        add(labelKontrollrechnung);
        textKontrollRechnung.setText(str);
        add(textKontrollRechnung);
    }
    
    public String klammerNegLong(long h) {
        // diese Methode liefert einen long
        // als String zurück, wobei negative
        // Werte geklammert werden (nur diese)
        if (h < 0) {
            return "(" + h + ")";
        } else {
            return "" + h;
        }
    }

    void addToFrameJLabelsAndJTextFieldsAndJButtons() {
        add(buttonBerechneGgT);
        add(buttonReset);

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

    void initializeButtons() {
        buttonBerechneGgT = new JButton("GGT berechnen");
        buttonReset = new JButton("RESET");
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

    void clear(JTextField jText) {
        jText.setText("");
    }

    @Override
    public void setController(GgTController controller) {
        ggTController = controller;
    }

    @Override
    public void showView() {
        setVisible(true);
    }

    @Override
    public void reset() {
        str = "";
        remove(labelKontrollrechnung);
        remove(textKontrollRechnung);
        a=0;
        b=0;
        ggTController.newGgTCalculation(a, b);
        clear(textEingabeA);
        clear(textEingabeB);
        clear(textAusgabeX);
        clear(textAusgabeY);
        clear(textAusgabeResultGgT);
        textEingabeA.requestFocus();
        showView();
    }

    @Override
    public long getEingabeA() {
        return readTextToLong(textEingabeA.getText());
    }

    @Override
    public long getEingabeB() {
        return readTextToLong(textEingabeB.getText());
    }

    @Override
    public void getEingabenAB() {
        a = getEingabeA();
        b = getEingabeB();
    }

    @Override
    public void showResultX(long x) {
        textAusgabeX.setText("" + x);
    }

    @Override
    public void showResultY(long y) {
        textAusgabeY.setText("" + y);
    }

    @Override
    public void showResultGgT(long resultGgT) {
        textAusgabeResultGgT.setText("" + resultGgT);
    }

    @Override
    public void showResults() {
        showResultX(x);
        showResultY(y);
        showResultGgT(resultGgT);
        showView();
    }

    public long readTextToLong(String txt) {
        return Long.parseLong(txt);
    }

}
