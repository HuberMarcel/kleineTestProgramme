package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Marcel
 */
public class GgTViewGUI extends JFrame implements GgTView {

    private long calculationCounter;

    private GgTController ggTController;

    private JLabel labelEingabeA;
    private JLabel labelEingabeB;
    private JLabel labelAusgabeX;
    private JLabel labelAusgabeY;
    private JLabel labelAusgabeResultGgT;
    private JLabel labelKontrollrechnung;
    private JDialog dialogFehleingabe;

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

    private boolean textEingabeIsALong;

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
//        setSize(1350, 150);
        setSize(1350, 500);

        initializeLabels();
        labelKontrollrechnung = new JLabel("Kontrolle");
        textKontrollRechnung = new JTextField();
        initializeJTextfields();
        initializeButtons();
        addToFrameJLabelsAndJTextFieldsAndJButtons();
        dialogFehleingabe = new javax.swing.JDialog();
        javax.swing.GroupLayout dialogFehleingabeLayout = new javax.swing.GroupLayout(dialogFehleingabe.getContentPane());
        dialogFehleingabeLayout.setHorizontalGroup(
                dialogFehleingabeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        dialogFehleingabeLayout.setVerticalGroup(
                dialogFehleingabeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
        dialogFehleingabe.getContentPane().setLayout(dialogFehleingabeLayout);

        buttonBerechneGgT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCalculation();
            }
        });

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ggTController.reset();
            }
        });

        buttonReset.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    ggTController.reset();
                }
            }

            @Override
            public void keyTyped(KeyEvent ke) {
                this.keyPressed(ke);
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                this.keyPressed(ke);
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        buttonBerechneGgT.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    startCalculation();
                }
            }

            @Override
            public void keyTyped(KeyEvent ke) {
//                return;
                keyPressed(ke);
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
//                return;
                keyPressed(ke);
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        textEingabeA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textEingabeB.requestFocus();
            }
        });

        textEingabeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCalculation();
            }
        });

        pressEnterTochangeFocusToButtonBerechneGgT(textAusgabeX);
        pressEnterTochangeFocusToButtonBerechneGgT(textAusgabeY);
        pressEnterTochangeFocusToButtonBerechneGgT(textAusgabeResultGgT);
        pressEnterTochangeFocusToButtonBerechneGgT(textKontrollRechnung);
        textKontrollRechnung.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                keyPressed(ke);
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    buttonBerechneGgT.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                keyPressed(ke);
            }
        });

        showView();
        textEingabeA.requestFocus();
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(GgTViewGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.exit(0);
    }

    private void pressEnterTochangeFocusToButtonBerechneGgT(JTextField jTextField) {
        jTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                keyPressed(ke);
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    buttonBerechneGgT.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                keyPressed(ke);
            }
        });
    }
            
    private void kontrollRechnung() {
        str = "Es gilt:   "
                + x + " * " + klammerNegLong(a)
                + " + " + klammerNegLong(y) + " * " + klammerNegLong(b)
                + " = " + (x * a + y * b);

        add(labelKontrollrechnung);
        textKontrollRechnung.setText(str);
        add(textKontrollRechnung);
        textKontrollRechnung.setEditable(false);
    }

    private String klammerNegLong(long h) {
        // diese Methode liefert einen long
        // als String zurück, wobei negative
        // Werte geklammert werden (nur diese)
        if (h < 0) {
            return "(" + h + ")";
        } else {
            return "" + h;
        }
    }

    private void addToFrameJLabelsAndJTextFieldsAndJButtons() {
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

    private void initializeButtons() {
        buttonBerechneGgT = new JButton("GGT berechnen");
        buttonReset = new JButton("RESET");
    }

    private void initializeLabels() {
        labelEingabeA = new JLabel("Zahl a:");
        labelEingabeB = new JLabel("Zahl b:");
        labelAusgabeX = new JLabel("Ausgabe x:");
        labelAusgabeY = new JLabel("Ausgabe y:");
        labelAusgabeResultGgT = new JLabel("Ausgabe ggT:");
    }

    private void initializeJTextfields() {
        textEingabeA = new JTextField(10);
        textEingabeA.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                textEingabeA.selectAll();
            }
        });
        textEingabeB = new JTextField(10);
        textEingabeB.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                textEingabeB.selectAll();
            }
        });
        textAusgabeX = new JTextField(10);
//        textAusgabeX.setEnabled(false);
        textAusgabeX.setEditable(false);
        textAusgabeY = new JTextField(10);
        textAusgabeY.setEditable(false);
        textAusgabeResultGgT = new JTextField(10);
        textAusgabeResultGgT.setEditable(false);
    }

    private void clear(JTextField jText) {
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
        a = 0;
        b = 0;
        ggTController.newGgTCalculation(a, b);
        clear(textEingabeA);
        clear(textEingabeB);
        clear(textAusgabeX);
        clear(textAusgabeY);
        clear(textAusgabeResultGgT);
//        System.out.println("RESET durchgeführt");
//        marker();
        textEingabeA.requestFocus();
        // Warum muss man hier das JFrame aktualisieren???
        reloadJFrame();
        showView();
    }

    private void reloadJFrame() {
//        setSize(1250, 50);
//        setSize(1350, 150);
        this.repaint();
    }

    @Override
    public long getEingabeA() {
        return getEingabe(textEingabeA);
    }

    @Override
    public long getEingabeB() {
        return getEingabe(textEingabeB);
    }

    private long getEingabe(JTextField jTextField) throws NumberFormatException {
        textEingabeIsALong = false;
        try {
            textEingabeIsALong = true;
            return readTextToLong(jTextField.getText());
        } catch (NumberFormatException nFex) {
            textEingabeIsALong = false;
            JOptionPane.showMessageDialog(dialogFehleingabe, "Sie haben "
                    + "in dem aktuellen Textfeld keinen long-Wert eingegeben!!",
                    "Eingabe-Fehler!!", JOptionPane.WARNING_MESSAGE);
            jTextField.requestFocus();
        }
        return 0;
    }

    @Override
    public void getEingabenAB() throws NumberFormatException {
        if (!textEingabeIsALong) {
            a = getEingabe(textEingabeA);
            if (textEingabeIsALong) {
                textEingabeA.setText("" + a);                   // sinnvoll, um Eingaben wie 00835 als 835 anzuzeigen
            }
        }
        if (textEingabeIsALong) {
            textEingabeB.requestFocus();
            b = getEingabeB();
            if (textEingabeIsALong) {
                textEingabeB.setText("" + b);                  // sinnvoll, um Eingaben wie 00835 als 835 anzuzeigen
            }
        } else {
            return;
        };
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
        textEingabeA.selectAll();
        textEingabeB.selectAll();
        textEingabeA.requestFocus();
        reloadJFrame();
        showView();
    }

    private long readTextToLong(String txt) {
        return Long.parseLong(txt);
    }

    private void startCalculation() {
        getEingabenAB();
        if (textEingabeIsALong) {    // falls ALLE Texteingaben korrekt sind
//            System.out.println(++calculationCounter);
            this.setTitle(++calculationCounter + ". Berechnung des ggT's zweier Zahlen a und b!");
            ggTController.newGgTCalculation(a, b);
            x = ggTController.getX();
            y = ggTController.getY();
            resultGgT = ggTController.getGgT();
            kontrollRechnung();
            showResults();
            textEingabeIsALong = false;
            textKontrollRechnung.requestFocus();
        }
//        } catch (NumberFormatException nFex) {
//            JOptionPane.showMessageDialog(dialogFehleingabe, "Sie haben "
//                    + "in einem der Textfelder keinen long-Wert "
//                    + "eingegeben!!",
//                    "Eingabe-Fehler!!", JOptionPane.WARNING_MESSAGE);
//            ggTController.reset();
    }

    private void pause(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException ex) {
            Logger.getLogger(GgTViewGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void marker() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
}
