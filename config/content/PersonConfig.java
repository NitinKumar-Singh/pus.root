/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.UserActivityLog;
import com.lib.modules.SQLAdapter;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class PersonConfig {
    
    /**
     * Start -> set fields
     */
    private static ResultSet resultSet;
    /**
     * End -> set fields
     */
    
    /**
     * Start -> set data penting
     */
    private static void AddDataPenting (
        JLabel labelNIP, JLabel labelKTP,
        JLabel labelNorek, JLabel labelBank
    ) {
        String nip, ktp, norek, bank;
        nip = UserActivityLog.getNip();
        ktp = UserActivityLog.getKtp();
        norek = UserActivityLog.getNorek();
        bank = UserActivityLog.getBank();
        
        labelNIP.setText(nip);
        labelKTP.setText(ktp);
        labelNorek.setText(norek);
        
        /**
         * Start -> set bank
         */
        switch (bank) {
            case ViewIDE.bank:
                bank = ViewIDE.bank_desc;
                break;
            default:
                bank = "" + bank;
                break;
        }
        
        labelBank.setText(bank);
        /**
         * End -> set bank
         */
    }
    /**
     * End -> set data penting
     */
    
    /**
     * Start -> set jabatan
     */
    private static void AddJabatan (
        JLabel labelJabatan, JEditorPane textJabatanDesc
    ) {
        String jabatan, jabatan_desc;
        jabatan = UserActivityLog.getJabatan();
        jabatan_desc = UserActivityLog.getJabatanDesc();
        
        labelJabatan.setText(jabatan);
        textJabatanDesc.setText(jabatan_desc);
    }
    /**
     * End -> set jabatan
     */
    
    /**
     * Start -> set kantor
     */
    private static void AddKantor (
        JLabel labelKantor, JLabel labelAlamatKantor
    ) {
        String dinas, dinas_alamat;
        dinas = UserActivityLog.getDinas();
        dinas_alamat = UserActivityLog.getDinasAlamat();
        
        labelKantor.setText(dinas);
        labelAlamatKantor.setText(dinas_alamat);
    }
    /**
     * End -> set kantor
     */
    
    /**
     * Start -> set profile
     */
    private static void AddProfile (
        JLabel labelNama, JLabel labelKelamin, JLabel labelKota,
        JLabel labelTglLahir, JLabel labelKontak, JLabel labelAlamatRumah
    ) {
        String nama, kelamin, kota, tglLahir, kontak, alamat;
        nama = UserActivityLog.getNama();
        kelamin = UserActivityLog.getKelamin();
        kota = UserActivityLog.getKota();
        tglLahir = UserActivityLog.getTglLahir();
        kontak = UserActivityLog.getKontak();
        alamat = UserActivityLog.getAlamat();
        
        labelNama.setText(nama);
        labelKelamin.setText(kelamin);
        labelKota.setText(kota);
        labelTglLahir.setText(tglLahir);
        labelKontak.setText(kontak);
        labelAlamatRumah.setText(alamat);
    }
    /**
     * End -> set profile
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
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> get data
     */
    private static void GetData () {
        String nip, sql;
        nip = UserActivityLog.getNip();
        sql = "SELECT "
                + "tbl_person.no_ktp AS `No. KTP`, "
                + "tbl_person.no_rekening AS `No. Rekening`, "
                + "tbl_bank.nama_bank AS `Nama Bank`, "
                + "tbl_person.alamat AS `Alamat Rumah`, "
                + "tbl_jabatan.keterangan AS `JabatanDesc`, "
                + "tbl_dinas.alamat AS `Alamat Kantor` "
            + "FROM "
                + "tbl_bank, tbl_bank_member, "
                + "tbl_dinas, tbl_jabatan, tbl_person "
            + "WHERE "
                + "tbl_bank_member.id_bank = tbl_bank.id AND "
                + "tbl_person.id_dinas = tbl_dinas.id AND "
                + "tbl_person.id_jabatan = tbl_jabatan.id AND "
                + "tbl_person.no_rekening = tbl_bank_member.no_rekening AND "
                + "tbl_person.nip = '"+ nip +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                String ktp, AlamatRumah, JabatanDesc, AlamatKantor;
                String norek, bank;
                
                ktp = resultSet.getString("No. KTP");
                AlamatRumah = resultSet.getString("Alamat Rumah");
                JabatanDesc = resultSet.getString("JabatanDesc");
                AlamatKantor = resultSet.getString("Alamat Kantor");
                norek = resultSet.getString("No. Rekening");
                bank = resultSet.getString("Nama Bank");
                
                UserActivityLog.setKtp(ktp);
                UserActivityLog.setAlamat(AlamatRumah);
                UserActivityLog.setJabatanDesc(JabatanDesc);
                UserActivityLog.setDinasAlamat(AlamatKantor);
                UserActivityLog.setNorek(norek);
                UserActivityLog.setBank(bank);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> get data
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle,
        JLabel labelNama, JLabel labelKelamin, JLabel labelKota,
        JLabel labelTglLahir, JLabel labelKontak, JLabel labelAlamatRumah,
        JLabel labelJabatan, JEditorPane textJabatanDesc,
        JLabel labelKantor, JLabel labelAlamatKantor,
        JLabel labelNIP, JLabel labelKTP,
        JLabel labelNorek, JLabel labelBank
    ) {
        AddTitle(labelTitle);
        
        GetData();
        
        AddProfile(
            labelNama, labelKelamin, labelKota,
            labelTglLahir, labelKontak, labelAlamatRumah
        );
        
        AddJabatan(labelJabatan, textJabatanDesc);
        
        AddKantor(labelKantor, labelAlamatKantor);
        
        AddDataPenting(labelNIP, labelKTP, labelNorek, labelBank);
    }
    /**
     * End -> set config
     */
    
}
