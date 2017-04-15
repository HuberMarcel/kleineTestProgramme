/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.marcelhuber.mathematik;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Marcel
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
        jPanel2 = new javax.swing.JPanel();
        jTextZahl1 = new javax.swing.JTextField();
        jLabelZahl1 = new javax.swing.JLabel();
        jLabelZahl2 = new javax.swing.JLabel();
        jTextZahl2 = new javax.swing.JTextField();
        jLabelGGT = new javax.swing.JLabel();
        jTextGGT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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
        jTextZahl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextZahl2ActionPerformed(evt);
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

        jButton1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextZahl1)
                                    .addComponent(jLabelZahl1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabelZahl2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextZahl2))))
                            .addComponent(jLabelGGT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextGGT, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelZahl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelZahl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextZahl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextZahl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGGT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextGGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabelZahl2.getAccessibleContext().setAccessibleName("2. Zahl");

        jTabbedPane2.addTab("GgT Zweier Zahlen", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        long a, b, x, y, d;
        long[] ggTFeld;
        initializeEmptyJTextField(jTextZahl1);
        initializeEmptyJTextField(jTextZahl2);
        try {
            a = Long.parseLong(jTextZahl1.getText());
        } catch (NumberFormatException nFex) {
            showWarningEingabeFehler(1);
            jTextZahl1.setText("0");
            a = Long.parseLong(jTextZahl1.getText());
        }
        try {
            b = Long.parseLong(jTextZahl2.getText());
        } catch (NumberFormatException nFex) {
            showWarningEingabeFehler(2);
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showWarningEingabeFehler(long k) {
        JOptionPane.showMessageDialog(jDialogFehleingabe, "Eingabe-Fehler, die "
                + k + ". Zahl wird gleich automatisch auf 0 gesetzt", k + ". Zahl",
                JOptionPane.WARNING_MESSAGE);
    }

    private String makeVariableToStringMitVorzeichenbeachtung(long r) {
        if (r >= 0) {
            return "" + r;
        } else {
            return "(" + r + ")";
        }
    }

    private void jTextZahl2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextZahl2FocusGained
        jTextZahl2.selectAll();
    }//GEN-LAST:event_jTextZahl2FocusGained

    private void jTextZahl1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextZahl1FocusGained
        jTextZahl1.selectAll();
    }//GEN-LAST:event_jTextZahl1FocusGained

    private void jTextGGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextGGTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextGGTActionPerformed

    private void jTextZahl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextZahl2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextZahl2ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialogFehleingabe;
    private javax.swing.JLabel jLabelGGT;
    private javax.swing.JLabel jLabelZahl1;
    private javax.swing.JLabel jLabelZahl2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextGGT;
    private javax.swing.JTextField jTextZahl1;
    private javax.swing.JTextField jTextZahl2;
    // End of variables declaration//GEN-END:variables
}
