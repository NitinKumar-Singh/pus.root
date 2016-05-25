/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.ChooserLog;
import com.lib.logs.MessageLog;
import com.lib.logs.UserActivityLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Pesan;
import com.lib.views.ViewChooser;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import com.lib.views.ViewPanel;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpEditConfig {
    
    /**
     * Start -> set fields
     */
    private static ResultSet resultSet;
    /**
     * End -> set fields
     */
    
    /**
     * Start -> set panel
     */
    private static void AddPanel (
        JPanel PanelMaster, JPanel panel, JTextField text
    ) {
        ViewPanel.AddPanel(PanelMaster, panel);
        text.requestFocus();
    }
    /**
     * End -> set panel
     */
    
    /**
     * Start -> set title
     */
    private static void AddTitle (JLabel labelTitle) {
        String value, kelamin, icon;
        value = MessageLog.getTitle();
        kelamin = UserActivityLog.getKelamin();
        
        switch (kelamin) {
            case ViewIDE.female:
                icon = ViewIDE.female_url_icon;
                break;
            default:
                icon = ViewIDE.male_url_icon;
                break;
        }
        
        labelTitle.setIcon(new ImageIcon(
            labelTitle.getClass().getResource(icon)
        ));
        labelTitle.setText(value);
    }
    /**
     * End -> set title
     */
    
    /**
     * Start -> check different personal id
     */
    private static void CheckPersonalID (Dialog dialog) {
        String ktp_change, message, sql;
        ktp_change = UserActivityLog.getKtpChange();
        sql = "SELECT "
                + "no_ktp AS `No. KTP` "
            + "FROM "
                + "tbl_person "
            + "WHERE "
                + "no_ktp = '"+ ktp_change +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                message = ViewIDE.pesan_warning_incorrect_ktp;
                Pesan.Warning(message);
            } else {
                UpdateData(dialog);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> check different personal id
     */
    
    /**
     * Start -> close
     */
    public static void Close (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> go back to database
         */
        RootMenuConfig.EmpDb();
        /**
         * End -> go back to database
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> set date max
     */
    public static void DateMax (JComboBox<String> comboBulan) {
        Integer index;
        index = comboBulan.getSelectedIndex();
        
        String tglMax, tglMid;
        
        switch (index) {
            case 1:
                tglMax = ViewIDE.tgl_max_31;
                break;
            case 2:
                tglMax = ViewIDE.tgl_max_29;
                break;
            case 3:
                tglMax = ViewIDE.tgl_max_31;
                break;
            case 4:
                tglMax = ViewIDE.tgl_max_30;
                break;
            case 5:
                tglMax = ViewIDE.tgl_max_31;
                break;
            case 6:
                tglMax = ViewIDE.tgl_max_30;
                break;
            case 7:
                tglMax = ViewIDE.tgl_max_31;
                break;
            case 8:
                tglMax = ViewIDE.tgl_max_31;
                break;
            case 9:
                tglMax = ViewIDE.tgl_max_30;
                break;
            case 10:
                tglMax = ViewIDE.tgl_max_31;
                break;
            case 11:
                tglMax = ViewIDE.tgl_max_30;
                break;
            case 12:
                tglMax = ViewIDE.tgl_max_31;
                break;
            default:
                tglMax = "0";
                break;
        }
        UserActivityLog.setTglMax(tglMax);
        
        if (index >= 0 && index < 10) {
            tglMid = "0" + index.toString();
        } else {
            tglMid = index.toString();
        }
        UserActivityLog.setTglMid(tglMid);
    }
    /**
     * End -> set date max
     */
    
    /**
     * Start -> get data
     */
    private static void GetData (
        JTextField textKTP, JTextField textNama,
        JRadioButton radioLakilaki, JRadioButton radioPerempuan,
        JTextField textKota, JTextField textTanggal,
        JComboBox<String> comboBulan, JTextField textTahun,
        JTextField textKontak, JEditorPane textAlamat
    ) {
        LoadMonth(comboBulan);
        
        /**
         * Start -> get ktp
         */
        GetPersonData();
        /**
         * End -> get ktp
         */
        
        String ktp, nama, kelamin, kota, tglLahir;
        String tglLeft, tglMid, tglRight, kontak, alamat;
        
        /**
         * Start -> set ktp
         */
        ktp = UserActivityLog.getKtp();
        textKTP.setText(ktp);
        /**
         * End -> set ktp
         */
        
        /**
         * Start -> set person name
         */
        nama = UserActivityLog.getNama();
        textNama.setText(nama);
        /**
         * End -> set person name
         */
        
        /**
         * Start -> switch jenis kelamin
         */
        kelamin = UserActivityLog.getKelamin();
        
        switch (kelamin) {
            case ViewIDE.female:
                SetGender(false, radioLakilaki, radioPerempuan);
                break;
            default:
                SetGender(true, radioLakilaki, radioPerempuan);
                break;
        }
        /**
         * End -> switch jenis kelamin
         */
        
        /**
         * Start -> set kota
         */
        kota = UserActivityLog.getKota();
        textKota.setText(kota);
        /**
         * End -> set kota
         */
        
        /**
         * Start -> set tanggal lahir
         */
        tglLahir = UserActivityLog.getTglLahir();
        
        switch (tglLahir) {
            case "-":
                textTanggal.setText(null);
                
                Integer defaultIndex;
                defaultIndex = 0;
                comboBulan.setSelectedIndex(defaultIndex);
                
                textTahun.setText(null);
                break;
            default:
                tglLeft = UserActivityLog.getTglLeft();
                tglMid = UserActivityLog.getTglMid();
                tglRight = UserActivityLog.getTglRight();
                
                Integer monthIndex;
                monthIndex = Integer.parseInt(tglMid);
                
                textTanggal.setText(tglRight);
                comboBulan.setSelectedIndex(monthIndex);
                DateMax(comboBulan);
                textTahun.setText(tglLeft);
                break;
        }
        /**
         * End -> set tanggal lahir
         */
        
        /**
         * Start -> set kontak
         */
        kontak = UserActivityLog.getKontak();
        textKontak.setText(kontak);
        /**
         * End -> set kontak
         */
        
        /**
         * Start -> set alamat
         */
        alamat = UserActivityLog.getAlamat();
        textAlamat.setText(alamat);
        /**
         * End -> set alamat
         */
    }
    /**
     * End -> get data
     */
    
    /**
     * Start -> get ktp
     */
    private static void GetPersonData () {
        String nip, sql;
        nip = UserActivityLog.getNip();
        sql = "SELECT "
                + "tbl_person.no_ktp AS `No. KTP`, "
                + "tbl_person.tgl_lahir AS `Tgl. Lahir`, "
                + "LEFT(tbl_person.d_lahir, 4) AS `Tgl. Left`, "
                + "MID(tbl_person.d_lahir, 6, 2) AS `Tgl. Mid`, "
                + "RIGHT(tbl_person.d_lahir, 2) AS `Tgl. Right`, "
                + "tbl_person.alamat AS `Alamat Rumah` "
            + "FROM "
                + "tbl_dinas, tbl_jabatan, tbl_person, "
                + "tbl_user, tbl_user_level, tbl_user_sso "
            + "WHERE "
                + "tbl_person.id_user = tbl_user.id AND "
                + "tbl_person.id_dinas = tbl_dinas.id AND "
                + "tbl_person.id_jabatan = tbl_jabatan.id AND "
                + "tbl_user_sso.id_user = tbl_user.id AND "
                + "tbl_user.id_level = tbl_user_level.id AND "
                + "tbl_person.nip = '"+ nip +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                String ktp, tglLahir, tglLeft, tglMid, tglRight;
                String alamat;
                
                ktp = resultSet.getString("No. KTP");
                tglLahir = resultSet.getString("Tgl. Lahir");
                tglLeft = resultSet.getString("Tgl. Left");
                tglMid = resultSet.getString("Tgl. Mid");
                tglRight = resultSet.getString("Tgl. Right");
                alamat = resultSet.getString("Alamat Rumah");
                
                UserActivityLog.setKtp(ktp);
                UserActivityLog.setTglLahir(tglLahir);
                
                switch (tglLahir) {
                    case "-":
                        /**
                         * Blocked
                         */
                        break;
                    default:
                        UserActivityLog.setTglLeft(tglLeft);
                        UserActivityLog.setTglMid(tglMid);
                        UserActivityLog.setTglRight(tglRight);
                        break;
                }
                
                UserActivityLog.setAlamat(alamat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> get ktp
     */
    
    /**
     * Start -> load month
     */
    private static void LoadMonth (JComboBox<String> comboBulan) {
        comboBulan.removeAllItems();
        comboBulan.addItem("Pilih");
        comboBulan.addItem("Januari");
        comboBulan.addItem("Februari");
        comboBulan.addItem("Maret");
        comboBulan.addItem("April");
        comboBulan.addItem("Mei");
        comboBulan.addItem("Juni");
        comboBulan.addItem("Juli");
        comboBulan.addItem("Agustus");
        comboBulan.addItem("September");
        comboBulan.addItem("Oktober");
        comboBulan.addItem("Nopember");
        comboBulan.addItem("Desember");
    }
    /**
     * End -> load month
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JPanel PanelMaster, JPanel PanelInfo,
        JLabel labelTitle,
        JTextField textKTP, JTextField textNama,
        JRadioButton radioLakilaki, JRadioButton radioPerempuan,
        JTextField textKota, JTextField textTanggal,
        JComboBox<String> comboBulan, JTextField textTahun,
        JTextField textKontak, JEditorPane textAlamat
    ) {
        AddTitle(labelTitle);
        AddPanel(PanelMaster, PanelInfo, textKTP);
        GetData(
            textKTP, textNama, radioLakilaki, radioPerempuan,
            textKota, textTanggal, comboBulan, textTahun,
            textKontak, textAlamat
        );
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set gender
     */
    public static void SetGender (
        Boolean confirm,
        JRadioButton radioLakilaki, JRadioButton radioPerempuan
    ) {
        /**
         * Start -> set class name
         */
        String ClassName;
        ClassName = "UserActivityLog";
        
        ChooserLog.setClassName(ClassName);
        /**
         * End -> set class name
         */
        
        ViewChooser.Gender(confirm, radioLakilaki, radioPerempuan);
    }
    /**
     * End -> set gender
     */
    
    /**
     * Start -> update
     */
    public static void Update (
        Dialog dialog, JTextField textKTP, JTextField textNama,
        JRadioButton radioLakilaki, JRadioButton radioPerempuan,
        JTextField textKota, JTextField textTanggal,
        JComboBox<String> comboBulan, JTextField textTahun,
        JTextField textKontak, JEditorPane textAlamat
    ) {
        String message;
        if (textKTP.getText().isEmpty() == true ||
            textNama.getText().isEmpty() == true ||
            (radioLakilaki.isSelected() == false &&
            radioPerempuan.isSelected() == false) ||
            textKota.getText().isEmpty() == true ||
            textTanggal.getText().isEmpty() == true ||
            comboBulan.getSelectedIndex() == 0 ||
            textTahun.getText().isEmpty() == true ||
            textKontak.getText().isEmpty() == true ||
            textAlamat.getText().isEmpty() == true
        ) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            Integer iTglMax, iTanggal;
            String ktp_default, ktp_change;
            String nama, kota, bulan, tglLahir, dLahir;
            String tglRight, tglMid, tglLeft, tglMax;
            String kontak, alamat;
            
            ktp_default = UserActivityLog.getKtp();
            ktp_change = textKTP.getText();
            nama = textNama.getText();
            kota = textKota.getText();
            tglMax = UserActivityLog.getTglMax();
            tglRight = textTanggal.getText();
            tglMid = UserActivityLog.getTglMid();
            tglLeft = textTahun.getText();
            bulan = String.valueOf(comboBulan.getSelectedItem());
            tglLahir = tglRight + " " + bulan + " " + tglLeft;
            dLahir = tglLeft + "-" + tglMid + "-" + tglRight;
            kontak = textKontak.getText();
            alamat = textAlamat.getText();
            
            iTglMax = Integer.parseInt(tglMax);
            iTanggal = Integer.parseInt(tglRight);
            
            if (iTanggal > iTglMax) {
                message = ViewIDE.pesan_warning_max_date + iTglMax;
                Pesan.Warning(message);
                
                textTanggal.requestFocus();
            } else {
                UserActivityLog.setKtpChange(ktp_change);
                UserActivityLog.setNama(nama);
                UserActivityLog.setKota(kota);
                UserActivityLog.setTglLahir(tglLahir);
                UserActivityLog.setdLahir(dLahir);
                UserActivityLog.setKontak(kontak);
                UserActivityLog.setAlamat(alamat);
                
                if (ktp_change.equals(ktp_default) == true) {
                    UpdateData(dialog);
                } else {
                    CheckPersonalID(dialog);
                }
            }
        }
    }
    /**
     * End -> update
     */
    
    /**
     * Start -> update data
     */
    private static void UpdateData (Dialog dialog) {
        String ktp_default, ktp_change;
        String nama, kelamin, kota, tglLahir, dLahir;
        String kontak, alamat;
        
        ktp_change = UserActivityLog.getKtpChange();
        ktp_default = UserActivityLog.getKtp();
        nama = UserActivityLog.getNama();
        kelamin = UserActivityLog.getKelamin();
        kota = UserActivityLog.getKota();
        tglLahir = UserActivityLog.getTglLahir();
        dLahir = UserActivityLog.getdLahir();
        kontak = UserActivityLog.getKontak();
        alamat = UserActivityLog.getAlamat();
        
        String message, sql;
        if (ktp_change.equals(ktp_default) == true) {
            sql = "UPDATE "
                    + "tbl_person "
                + "SET "
                    + "nama = '"+ nama +"', "
                    + "kelamin = '"+ kelamin +"', "
                    + "kota = '"+ kota +"', "
                    + "tgl_lahir = '"+ tglLahir +"', "
                    + "d_lahir = '"+ dLahir +"', "
                    + "kontak = '"+ kontak +"', "
                    + "alamat = '"+ alamat +"' "
                + "WHERE "
                    + "no_ktp = '"+ ktp_default +"';";
        } else {
            sql = "UPDATE "
                    + "tbl_person "
                + "SET "
                    + "no_ktp = '"+ ktp_change +"', "
                    + "nama = '"+ nama +"', "
                    + "kelamin = '"+ kelamin +"', "
                    + "kota = '"+ kota +"', "
                    + "tgl_lahir = '"+ tglLahir +"', "
                    + "d_lahir = '"+ dLahir +"', "
                    + "kontak = '"+ kontak +"', "
                    + "alamat = '"+ alamat +"' "
                + "WHERE "
                    + "no_ktp = '"+ ktp_default +"';";
        }
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            /**
             * Start -> message
             */
            message = ViewIDE.pesan_info_update_success_default;
            Pesan.Information(message);
            /**
             * End -> message
             */
            
            /**
             * Start -> close
             */
            Close(dialog);
            /**
             * End -> close
             */
        }
    }
    /**
     * End -> update data
     */
    
}
