/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.content;

import action.content.EmpEditAction;
import config.content.EmpEditConfig;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpEdit extends javax.swing.JPanel {

    /**
     * Creates new form EmpEdit
     */
    public EmpEdit(Dialog dialog) {
        initComponents();
        action(dialog);
        config();
    }
    
    private void action (Dialog dialog) {
        EmpEditAction.Close(buttonClose, dialog);
        EmpEditAction.Gender(radioLakilaki, radioPerempuan);
        EmpEditAction.Month(comboBulan);
        EmpEditAction.Update(
            buttonUpdate, dialog,
            textKTP, textNama, radioLakilaki, radioPerempuan,
            textKota, textTanggal, comboBulan, textTahun,
            textKontak, textAlamat
        );
    }
    
    private void config () {
        EmpEditConfig.SetConfig(
            PanelMaster, PanelInfo, labelTitle,
            textKTP, textNama,
            radioLakilaki, radioPerempuan,
            textKota, textTanggal, comboBulan, textTahun,
            textKontak, textAlamat
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

        PanelInfo = new javax.swing.JPanel();
        labelKTP = new javax.swing.JLabel();
        textKTP = new javax.swing.JTextField();
        labelNama = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        labelJenisKelamin = new javax.swing.JLabel();
        labelSeparatorJenisKelamin = new javax.swing.JLabel();
        radioLakilaki = new javax.swing.JRadioButton();
        radioPerempuan = new javax.swing.JRadioButton();
        labelKota = new javax.swing.JLabel();
        textKota = new javax.swing.JTextField();
        labelTglLahir = new javax.swing.JLabel();
        textTanggal = new javax.swing.JTextField();
        comboBulan = new javax.swing.JComboBox<>();
        textTahun = new javax.swing.JTextField();
        labelKontak = new javax.swing.JLabel();
        textKontak = new javax.swing.JTextField();
        labelAlamat = new javax.swing.JLabel();
        scrollpaneAlamat = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JEditorPane();
        buttonClose = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        labelHeader = new javax.swing.JLabel();
        labelFooter = new javax.swing.JLabel();
        labelLeft = new javax.swing.JLabel();
        labelRight = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        separatorTitle = new javax.swing.JSeparator();
        PanelMaster = new javax.swing.JPanel();

        labelKTP.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelKTP.setText("<html>\nNomor <u>K</u>TP\n</html>");

        textKTP.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelNama.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelNama.setText("Nama Lengkap");

        textNama.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelJenisKelamin.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelJenisKelamin.setText("Jenis Kelamin");

        labelSeparatorJenisKelamin.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelSeparatorJenisKelamin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeparatorJenisKelamin.setText(":");

        radioLakilaki.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        radioLakilaki.setText("Laki-laki");

        radioPerempuan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        radioPerempuan.setText("Perempuan");

        labelKota.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelKota.setText("Kab. / Kota Kelahiran");

        textKota.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelTglLahir.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelTglLahir.setText("Tanggal Lahir");

        textTanggal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        textTanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        comboBulan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        comboBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));

        textTahun.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        textTahun.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        labelKontak.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelKontak.setText("<html>\nNo. Telepon atau HP\n</html>");

        textKontak.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        labelAlamat.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelAlamat.setText("Alamat Rumah");

        scrollpaneAlamat.setViewportView(textAlamat);

        buttonClose.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image16/arrow-left.png"))); // NOI18N

        buttonUpdate.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image16/synchronize.png"))); // NOI18N
        buttonUpdate.setText("<html>\n<u>U</u>pdate\n</html>");

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addComponent(labelJenisKelamin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSeparatorJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioLakilaki)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioPerempuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelKTP, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(textKTP, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(labelKota, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(textKota, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(labelTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(labelKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(textKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(labelAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(scrollpaneAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addComponent(labelKTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textKTP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSeparatorJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioLakilaki, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelKota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textKota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTglLahir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAlamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpaneAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        labelTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lib/image32/male.png"))); // NOI18N
        labelTitle.setText("{ TITLE }");
        labelTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelTitle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout PanelMasterLayout = new javax.swing.GroupLayout(PanelMaster);
        PanelMaster.setLayout(PanelMasterLayout);
        PanelMasterLayout.setHorizontalGroup(
            PanelMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PanelMasterLayout.setVerticalGroup(
            PanelMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

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
                    .addComponent(PanelMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(PanelMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel PanelMaster;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<String> comboBulan;
    private javax.swing.JLabel labelAlamat;
    private javax.swing.JLabel labelFooter;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel labelJenisKelamin;
    private javax.swing.JLabel labelKTP;
    private javax.swing.JLabel labelKontak;
    private javax.swing.JLabel labelKota;
    private javax.swing.JLabel labelLeft;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelRight;
    private javax.swing.JLabel labelSeparatorJenisKelamin;
    private javax.swing.JLabel labelTglLahir;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JRadioButton radioLakilaki;
    private javax.swing.JRadioButton radioPerempuan;
    private javax.swing.JScrollPane scrollpaneAlamat;
    private javax.swing.JSeparator separatorTitle;
    private javax.swing.JEditorPane textAlamat;
    private javax.swing.JTextField textKTP;
    private javax.swing.JTextField textKontak;
    private javax.swing.JTextField textKota;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textTahun;
    private javax.swing.JTextField textTanggal;
    // End of variables declaration//GEN-END:variables
}