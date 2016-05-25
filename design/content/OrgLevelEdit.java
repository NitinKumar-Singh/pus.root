/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.content;

import action.content.OrgLevelEditAction;
import config.content.OrgLevelEditConfig;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class OrgLevelEdit extends javax.swing.JPanel {

    /**
     * Creates new form OrgLevelEdit
     */
    public OrgLevelEdit(Dialog dialog) {
        initComponents();
        action(dialog);
        config();
    }
    
    private void action (Dialog dialog) {
        OrgLevelEditAction.Close(buttonCancel, dialog);
        OrgLevelEditAction.Update(
            buttonUpdate, dialog, textID, textJabatan, textKeterangan
        );
    }
    
    private void config () {
        OrgLevelEditConfig.SetConfig(
            labelTitle, textID, textJabatan, textKeterangan
        );
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
        labelJabatan = new javax.swing.JLabel();
        textJabatan = new javax.swing.JTextField();
        labelKeterangan = new javax.swing.JLabel();
        scrollPaneKeterangan = new javax.swing.JScrollPane();
        textKeterangan = new javax.swing.JEditorPane();
        buttonCancel = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();

        labelTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image32/blank-file.png"))); // NOI18N
        labelTitle.setText("{ TITLE }");
        labelTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelTitle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        labelID.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelID.setText("<html>\n<u>K</u>ode Jabatan&nbsp;|&nbsp;<i>* tanpa spasi & huruf kapital</i>\n</html>");

        textID.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelJabatan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelJabatan.setText("<html>\n<u>J</u>abatan\n</html>");

        textJabatan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelKeterangan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelKeterangan.setText("<html>\nDeskripsi Jabatan&nbsp;|&nbsp;<i>* kosongkan jika tidak tahu</i>\n</html>");

        textKeterangan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        scrollPaneKeterangan.setViewportView(textKeterangan);

        buttonCancel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        buttonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image16/arrow-left.png"))); // NOI18N
        buttonCancel.setText("Kembali");

        buttonUpdate.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image16/arrow-right.png"))); // NOI18N
        buttonUpdate.setText("Update");
        buttonUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

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
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separatorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(labelJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JLabel labelFooter;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelJabatan;
    private javax.swing.JLabel labelKeterangan;
    private javax.swing.JLabel labelLeft;
    private javax.swing.JLabel labelRight;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JScrollPane scrollPaneKeterangan;
    private javax.swing.JSeparator separatorTitle;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textJabatan;
    private javax.swing.JEditorPane textKeterangan;
    // End of variables declaration//GEN-END:variables
}