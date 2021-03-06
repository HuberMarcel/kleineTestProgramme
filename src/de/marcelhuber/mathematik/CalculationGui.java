package de.marcelhuber.mathematik;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Marcel Huber
 */
public class CalculationGui extends javax.swing.JFrame {

    /**
     * Creates new form GgTGui
     */
    public CalculationGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogFehleingabe = new javax.swing.JDialog();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelGgT = new javax.swing.JPanel();
        jTextZahl1 = new javax.swing.JTextField();
        jLabelZahl1 = new javax.swing.JLabel();
        jLabelZahl2 = new javax.swing.JLabel();
        jTextZahl2 = new javax.swing.JTextField();
        jLabelGGT = new javax.swing.JLabel();
        jTextGGT = new javax.swing.JTextField();
        jButtonStartGgT = new javax.swing.JButton();
        jPanelKgV = new javax.swing.JPanel();
        jTextZahl3 = new javax.swing.JTextField();
        jLabelZahl3 = new javax.swing.JLabel();
        jLabelZahl4 = new javax.swing.JLabel();
        jTextZahl4 = new javax.swing.JTextField();
        jLabelKgV = new javax.swing.JLabel();
        jTextKgV = new javax.swing.JTextField();
        jButtonStartKgV = new javax.swing.JButton();

        javax.swing.GroupLayout jDialogFehleingabeLayout = new javax.swing.GroupLayout(jDialogFehleingabe.getContentPane());
        jDialogFehleingabe.getContentPane().setLayout(jDialogFehleingabeLayout);
        jDialogFehleingabeLayout.setHorizontalGroup(
            jDialogFehleingabeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialogFehleingabeLayout.setVerticalGroup(
            jDialogFehleingabeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextZahl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextZahl1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextZahl1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextZahl1FocusGained(evt);
            }
        });

        jLabelZahl1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelZahl1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelZahl1.setText("   1. Zahl ");

        jLabelZahl2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelZahl2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelZahl2.setText("2. Zahl ");

        jTextZahl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextZahl2.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextZahl2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextZahl2FocusGained(evt);
            }
        });

        jLabelGGT.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelGGT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGGT.setText("GGT");

        jTextGGT.setEditable(false);
        jTextGGT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextGGT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextGGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextGGTActionPerformed(evt);
            }
        });

        jButtonStartGgT.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jButtonStartGgT.setText("Start");
        jButtonStartGgT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartGgTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGgTLayout = new javax.swing.GroupLayout(jPanelGgT);
        jPanelGgT.setLayout(jPanelGgTLayout);
        jPanelGgTLayout.setHorizontalGroup(
            jPanelGgTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGgTLayout.createSequentialGroup()
                .addGroup(jPanelGgTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGgTLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelGgTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelGgTLayout.createSequentialGroup()
                                .addGroup(jPanelGgTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextZahl1)
                                    .addComponent(jLabelZahl1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                                .addGroup(jPanelGgTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelGgTLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabelZahl2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                                    .addGroup(jPanelGgTLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextZahl2))))
                            .addComponent(jLabelGGT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelGgTLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextGGT, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGgTLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jButtonStartGgT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGgTLayout.setVerticalGroup(
            jPanelGgTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGgTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGgTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelZahl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelZahl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGgTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextZahl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextZahl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGGT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextGGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStartGgT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        jLabelZahl2.getAccessibleContext().setAccessibleName("2. Zahl");

        jTabbedPane2.addTab("GgT zweier Zahlen", jPanelGgT);

        jTextZahl3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextZahl3.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextZahl3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextZahl3FocusGained(evt);
            }
        });

        jLabelZahl3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelZahl3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelZahl3.setText("   1. Zahl ");

        jLabelZahl4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelZahl4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelZahl4.setText("2. Zahl ");

        jTextZahl4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextZahl4.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextZahl4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextZahl4FocusGained(evt);
            }
        });

        jLabelKgV.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelKgV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelKgV.setText("KGV");

        jTextKgV.setEditable(false);
        jTextKgV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextKgV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonStartKgV.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jButtonStartKgV.setText("Start");
        jButtonStartKgV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartKgVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelKgVLayout = new javax.swing.GroupLayout(jPanelKgV);
        jPanelKgV.setLayout(jPanelKgVLayout);
        jPanelKgVLayout.setHorizontalGroup(
            jPanelKgVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKgVLayout.createSequentialGroup()
                .addGroup(jPanelKgVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKgVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelKgVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelKgVLayout.createSequentialGroup()
                                .addGroup(jPanelKgVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextZahl3)
                                    .addComponent(jLabelZahl3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                                .addGroup(jPanelKgVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelKgVLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabelZahl4, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                                    .addGroup(jPanelKgVLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextZahl4))))
                            .addComponent(jLabelKgV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelKgVLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextKgV, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelKgVLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jButtonStartKgV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelKgVLayout.setVerticalGroup(
            jPanelKgVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKgVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKgVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelZahl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelZahl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKgVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextZahl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextZahl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelKgV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextKgV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStartKgV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("KgV zweier Zahlen", jPanelKgV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartGgTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartGgTActionPerformed
        long a, b, x, y, d;
        long[] ggTFeld;
        initializeEmptyJTextField(jTextZahl1);
        initializeEmptyJTextField(jTextZahl2);
        try {
            a = Long.parseLong(jTextZahl1.getText());
        } catch (NumberFormatException nFex) {
            showWarningEingabeFehler(1, " (ggT) ");
            jTextZahl1.setText("0");
            a = Long.parseLong(jTextZahl1.getText());
        }
        try {
            b = Long.parseLong(jTextZahl2.getText());
        } catch (NumberFormatException nFex) {
            showWarningEingabeFehler(2, " (ggT) ");
            jTextZahl2.setText("0");
            b = Long.parseLong(jTextZahl2.getText());
        }
        jLabelZahl1.setText("1. Zahl (aktueller ggT), letzte Eingabe: " + a + " ");
        jLabelZahl2.setText("2. Zahl, letzte Eingabe: " + b + " ");
        GgT ggTDummy = new GgT();
        ggTFeld = ggTDummy.ggTEuclidExtended(a, b);
        x = ggTFeld[0];
        y = ggTFeld[1];
        d = ggTFeld[2];
        String stringX = makeVariableToStringMitVorzeichenbeachtung(x);
        String stringB = makeVariableToStringMitVorzeichenbeachtung(b);
        String stringY = makeVariableToStringMitVorzeichenbeachtung(y);
        jLabelGGT.setText(a + "*" + stringX + "+" + stringB + "*" + stringY
                + " = ggT(" + a + "," + b + ")");
        jTextGGT.setText("" + d);
        jTextZahl1.setText(jTextGGT.getText());
    }//GEN-LAST:event_jButtonStartGgTActionPerformed

    private void jTextGGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextGGTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextGGTActionPerformed

    private void jTextZahl2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextZahl2FocusGained
        jTextZahl2.selectAll();
    }//GEN-LAST:event_jTextZahl2FocusGained

    private void jTextZahl1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextZahl1FocusGained
        jTextZahl1.selectAll();
    }//GEN-LAST:event_jTextZahl1FocusGained

    private void jButtonStartKgVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartKgVActionPerformed
        long a, b, mA, mB, kgV;
        initializeEmptyJTextField(jTextZahl3);
        initializeEmptyJTextField(jTextZahl4);
        try {
            a = Long.parseLong(jTextZahl3.getText());
        } catch (NumberFormatException nFex) {
            showWarningEingabeFehler(1, " (kgV) ");
            jTextZahl3.setText("0");
            a = Long.parseLong(jTextZahl3.getText());
        }
        try {
            b = Long.parseLong(jTextZahl4.getText());
        } catch (NumberFormatException nFex) {
            showWarningEingabeFehler(2, " (kgV) ");
            jTextZahl4.setText("0");
            b = Long.parseLong(jTextZahl4.getText());
        }
        jLabelZahl3.setText("1. Zahl (aktueller kgV), letzte Eingabe: " + a + " ");
        jLabelZahl4.setText("2. Zahl, letzte Eingabe: " + b + " ");
        KgV kgVDummy = new KgV();
        kgV = kgVDummy.kgVNaivFaster(a, b);
        if (a != 0) {
            mA = kgV / a;
        } else {
            mA = 0;
        }
        if (b != 0) {
            mB = kgV / b;
        } else {
            mB = 0;
        }

        String stringA = makeVariableToStringMitVorzeichenbeachtung(a);
        String stringMa = makeVariableToStringMitVorzeichenbeachtung(mA);
        String stringB = makeVariableToStringMitVorzeichenbeachtung(b);
        String stringMb = makeVariableToStringMitVorzeichenbeachtung(mB);
        String stringKGV = makeVariableToStringMitVorzeichenbeachtung(kgV);

        jLabelKgV.setText(a + "*" + stringMa + " = kgV(" + a + "," + b + ") = "
                + b + "*" + stringMb);
        jTextKgV.setText("" + kgV);
        jTextZahl3.setText(jTextKgV.getText());
    }//GEN-LAST:event_jButtonStartKgVActionPerformed

    private void jTextZahl4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextZahl4FocusGained
        jTextZahl4.selectAll();
    }//GEN-LAST:event_jTextZahl4FocusGained

    private void jTextZahl3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextZahl3FocusGained
        jTextZahl3.selectAll();
    }//GEN-LAST:event_jTextZahl3FocusGained

    private void showWarningEingabeFehler(long k, String str) {
        JOptionPane.showMessageDialog(jDialogFehleingabe, "Eingabe-Fehler " + str + ", die "
                + k + ". Zahl wird gleich automatisch auf 0 gesetzt!", k + ". Zahl",
                JOptionPane.WARNING_MESSAGE);
    }

    private String makeVariableToStringMitVorzeichenbeachtung(long r) {
        if (r >= 0) {
            return "" + r;
        } else {
            return "(" + r + ")";
        }
    }

    private void initializeEmptyJTextField(JTextField jText) {
        if (jText.getText().isEmpty()) {
            jText.setText("0");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculationGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculationGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStartGgT;
    private javax.swing.JButton jButtonStartKgV;
    private javax.swing.JDialog jDialogFehleingabe;
    private javax.swing.JLabel jLabelGGT;
    private javax.swing.JLabel jLabelKgV;
    private javax.swing.JLabel jLabelZahl1;
    private javax.swing.JLabel jLabelZahl2;
    private javax.swing.JLabel jLabelZahl3;
    private javax.swing.JLabel jLabelZahl4;
    private javax.swing.JPanel jPanelGgT;
    private javax.swing.JPanel jPanelKgV;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextGGT;
    private javax.swing.JTextField jTextKgV;
    private javax.swing.JTextField jTextZahl1;
    private javax.swing.JTextField jTextZahl2;
    private javax.swing.JTextField jTextZahl3;
    private javax.swing.JTextField jTextZahl4;
    // End of variables declaration//GEN-END:variables
}
