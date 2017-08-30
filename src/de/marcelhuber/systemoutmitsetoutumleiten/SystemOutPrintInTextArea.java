// Aus "Java 7 - Das Handbuch; Seite 833f.; 31.3.6."
// Wichtig: MeinOutputStream EXTENDS OutputStream
//          MeinPrintStream EXTENDS PrintStream
//          PrintStream hat Konstruktor für OutputStream-Objekte
// HINWEIS: Zusätzlich mit EXIT_ON_CLOSE ausgestattet
package de.marcelhuber.systemoutmitsetoutumleiten;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Marcel Huber
 */
public class SystemOutPrintInTextArea {

    public static void main(String[] args) {
        Fenster fenster = new Fenster("Dieser Text wird nicht wie üblich "
                + "in der Konsole ausgegeben,\nsondern in einer JTextArea!");
        fenster.setVisible(true);
    }
}

class Fenster extends JFrame {

    private JPanel contentPane;
    private BorderLayout borderLayout = new BorderLayout();
    private JTextArea anzeige;

    public Fenster(String text) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(borderLayout);

        anzeige = new JTextArea();
        contentPane.add(anzeige, BorderLayout.CENTER);

        setSize(new Dimension(600, 300));
        setTitle("Umlenken der Standardausgabein eine JTextArea!");

        MeinPrintStream ausgabe = new MeinPrintStream(anzeige);
        System.setOut(ausgabe);
        System.out.println(text);
    }
}

class MeinPrintStream extends PrintStream {

    public MeinPrintStream(JTextArea anzeige) {
        super(new MeinOutputStream(anzeige));
    }
}

class MeinOutputStream extends OutputStream {

    private JTextArea anzeige;

    public MeinOutputStream(JTextArea anzeige) {
        this.anzeige = anzeige;
    }

    @Override
    public void write(int b) throws IOException {
//        anzeige.append(String.valueOf((char) b));
        anzeige.append("" + ((char) b));
    }
}
