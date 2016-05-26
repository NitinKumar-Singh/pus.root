/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.content;

import action.content.BankNewAction;
import config.content.BankNewConfig;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class BankNew extends javax.swing.JPanel {

    /**
     * Creates new form BankNew
     */
    public BankNew(Dialog dialog) {
        initComponents();
        action(dialog);
        config();
    }
    
    private void action (Dialog dialog) {
        BankNewAction.Close(buttonCancel, dialog);
        BankNewAction.Save(
            buttonSave,
            dialog, textID, textNama,
            textKota, textKontak, textAlamat
        );
    }
    
    private void config () {
        BankNewConfig.SetConfig(labelTitle);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelHeader = new javax.swing.JLabel();
        labelFooter = new javax.swing.JLabel();
        labelLeft = new javax.swing.JLabel();
        labelRight = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        separatorTitle = new javax.swing.JSeparator();
        labelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        labelNama = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        labelKota = new javax.swing.JLabel();
        textKota = new javax.swing.JTextField();
        labelKontak = new javax.swing.JLabel();
        textKontak = new javax.swing.JTextField();
        labelAlamat = new javax.swing.JLabel();
        textAlamat = new javax.swing.JTextField();
        buttonCancel = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();

        labelTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image32/blank-file.png"))); // NOI18N
        labelTitle.setText("{ TITLE }");
        labelTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelTitle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        labelID.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelID.setText("<html>\n<p align=\"center\">\n.:: <u>I</u>D Bank ::.<br/>\nKode \"KP-\" untuk kantor pusat.&nbsp;\nKode \"KC-\" (kantor cabang).<br/>\nContoh : KP-MDRJKT\n</p>\n</html>");

        textID.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        textID.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelNama.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelNama.setText("Nama Perbankan");

        textNama.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelKota.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelKota.setText("Kab. / Kota");

        textKota.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelKontak.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelKontak.setText("No. Telepon");

        textKontak.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelAlamat.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelAlamat.setText("Alamat Kantor");

        textAlamat.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        buttonCancel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        buttonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image16/arrow-left.png"))); // NOI18N

        buttonSave.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        buttonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image16/arrow-right.png"))); // NOI18N
        buttonSave.setText("<html>\n<u>S</u>impan Informasi Bank\n</html>");
        buttonSave.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separatorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKota, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textKota, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRight, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelKota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textKota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelKontak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAlamat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel labelAlamat;
    private javax.swing.JLabel labelFooter;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelKontak;
    private javax.swing.JLabel labelKota;
    private javax.swing.JLabel labelLeft;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelRight;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JSeparator separatorTitle;
    private javax.swing.JTextField textAlamat;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textKontak;
    private javax.swing.JTextField textKota;
    private javax.swing.JTextField textNama;
    // End of variables declaration//GEN-END:variables
}
