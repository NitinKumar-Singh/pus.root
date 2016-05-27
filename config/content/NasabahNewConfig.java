/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.UserActivityLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Console;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import com.lib.views.ViewPanel;
import com.lib.views.ViewTable;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class NasabahNewConfig {
    
    /**
     * Start -> set fields
     */
    private static DefaultTableModel model;
    
    private static ResultSet resultSet;
    /**
     * End -> set fields
     */
    
    /**
     * Start -> add panel
     */
    private static void AddPanel (
        JPanel PanelMain, JPanel panel
    ) {
        ViewPanel.AddPanel(PanelMain, panel);
    }
    /**
     * End -> add panel
     */
    
    /**
     * Start -> add panel
     */
    private static void AddPanel (
        JPanel PanelMain, JPanel panel, JTextField text
    ) {
        ViewPanel.AddPanel(PanelMain, panel);
        text.requestFocus();
    }
    /**
     * End -> add panel
     */
    
    /**
     * Start -> set title
     */
    private static void AddTitle (JLabel labelTitle) {
        String value;
        value = MessageLog.getTitle();
        labelTitle.setText(value);
    }
    /**
     * End -> set title
     */
    
    /**
     * Start -> go back to browse data pegawai
     */
    public static void BackToBrowsePegawai (
        Dialog dialog, JPanel PanelMain,
        JPanel PanelBrowsePegawai, JTextField textSearch
    ) {
        /**
         * Start -> set dialog size
         */
        int height, width;
        height = 450;
        width = 350;
        ViewDialog.SetDialog(dialog, width, height);
        /**
         * End -> set dialog size
         */
        
        /**
         * Start -> set panel
         */
        AddPanel(PanelMain, PanelBrowsePegawai, textSearch);
        /**
         * End -> set panel
         */
    }
    /**
     * End -> go back to browse data pegawai
     */
    
    /**
     * Start -> go back to data pegawai
     */
    public static void BackToDataPegawai (
        Dialog dialog, JPanel PanelMain, JPanel PanelDataPegawai
    ) {
        /**
         * Start -> set dialog size
         */
        int height, width;
        height = 500;
        width = 350;
        ViewDialog.SetDialog(dialog, width, height);
        /**
         * End -> set dialog size
         */
        
        /**
         * Start -> set panel
         */
        AddPanel(PanelMain, PanelDataPegawai);
        /**
         * End -> set panel
         */
    }
    /**
     * End -> go back to data pegawai
     */
    
    /**
     * Start -> go back to panel kantor
     */
    public static void BackToPanelKantor (
        Dialog dialog, JPanel PanelMain, JPanel PanelKantor
    ) {
        /**
         * Start -> set dialog size
         */
        int height, width;
        height = 325;
        width = 350;
        ViewDialog.SetDialog(dialog, width, height);
        /**
         * End -> set dialog size
         */
        
        /**
         * Start -> set panel
         */
        AddPanel(PanelMain, PanelKantor);
        /**
         * End -> set panel
         */
    }
    /**
     * End -> go back to panel kantor
     */
    
    /**
     * Start -> set blocked message
     */
    private static void BlockedMessage (
        Boolean confirm, JMenuItem miBlocked
    ) {
        if (confirm == true) {
            String icon, message;
            icon = ViewIDE.delete_url_icon;
            message = ViewIDE.pesan_error_popup_disabled;
            
            miBlocked.setIcon(new ImageIcon(
                miBlocked.getClass().getResource(icon)
            ));
            miBlocked.setText(message);
            miBlocked.setVisible(true);
            miBlocked.setEnabled(false);
        } else {
            miBlocked.setVisible(false);
        }
    }
    /**
     * End -> set blocked message
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
         * Start -> go back to the options
         */
        RootMenuConfig.NasabahOptions();
        /**
         * End -> go back to the options
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> get data pegawai
     */
    private static void GetDataPegawai () {
        String nip, sql;
        nip = UserActivityLog.getNip();
        sql = "SELECT "
                + "tbl_person.nip AS `NIP`, "
                + "tbl_person.kota AS `Kota`, "
                + "tbl_person.tgl_lahir AS `Tgl. Lahir`, "
                + "tbl_person.kontak AS `No. Telepon`, "
                + "LEFT(tbl_person.alamat, 100) AS `Alamat Rumah`, "
                + "tbl_dinas.alamat AS `Alamat Kantor` "
            + "FROM "
                + "tbl_dinas, tbl_person "
            + "WHERE "
                + "tbl_person.id_dinas = tbl_dinas.id AND "
                + "tbl_person.nip = '"+ nip +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                String kota, tglLahir, kontak, alamat_rumah, alamat_kantor;
                kota = resultSet.getString("Kota");
                tglLahir = resultSet.getString("Tgl. Lahir");
                kontak = resultSet.getString("No. Telepon");
                alamat_rumah = resultSet.getString("Alamat Rumah");
                alamat_kantor = resultSet.getString("Alamat Kantor");
                
                UserActivityLog.setKota(kota);
                UserActivityLog.setTglLahir(tglLahir);
                UserActivityLog.setKontak(kontak);
                UserActivityLog.setAlamat(alamat_rumah);
                UserActivityLog.setDinasAlamat(alamat_kantor);
            } else {
                Console.Message("Data tidak ditemukan.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> get data pegawai
     */
    
    /**
     * Start -> open page data bank
     */
    public static void GoToDataBank (
        Dialog dialog, JPanel PanelMain, JPanel PanelBank,
        JComboBox<String> comboBank
    ) {
        /**
         * Start -> set dialog size
         */
        int height, width;
        height = 350;
        width = 350;
        ViewDialog.SetDialog(dialog, width, height);
        /**
         * End -> set dialog size
         */
        
        /**
         * Start -> set panel
         */
        AddPanel(PanelMain, PanelBank);
        /**
         * End -> set panel
         */
        
        /**
         * Start -> load data bank
         */
        comboBank.requestFocus();
        /**
         * End -> load data bank
         */
    }
    /**
     * End -> open page data bank
     */
    
    private static void GoToDataPegawai (
        Dialog dialog, JPanel PanelMain, JPanel PanelDataPegawai,
        JLabel labelNama, JLabel labelKelamin, JLabel labelKota,
        JLabel labelTglLahir, JLabel labelKontak, JLabel labelAlamat
    ) {
        /**
         * Start -> set dialog size
         */
        int height, width;
        height = 500;
        width = 350;
        ViewDialog.SetDialog(dialog, width, height);
        /**
         * End -> set dialog size
         */
        
        /**
         * Start -> set panel
         */
        SetPanelDataPegawai(
            PanelMain, PanelDataPegawai,
            labelNama, labelKelamin, labelKota,
            labelTglLahir, labelKontak, labelAlamat
        );
        /**
         * End -> set panel
         */
    }
    
    /**
     * Start -> open page data kantor
     */
    public static void GoToPanelKantor (
        Dialog dialog, JPanel PanelMain, JPanel PanelKantor,
        JLabel labelKantor, JLabel labelAlamatKantor
    ) {
        /**
         * Start -> set dialog size
         */
        int height, width;
        height = 325;
        width = 350;
        ViewDialog.SetDialog(dialog, width, height);
        /**
         * End -> set dialog size
         */
        
        /**
         * Start -> set panel
         */
        AddPanel(PanelMain, PanelKantor);
        /**
         * End -> set panel
         */
        
        /**
         * Start -> set data kantor
         */
        SetDataKantor(labelKantor, labelAlamatKantor);
        /**
         * End -> set data kantor
         */
    }
    /**
     * End -> open page data kantor
     */
    
    /**
     * Start -> load data bank into combo box
     */
    private static void LoadBank (JComboBox<String> comboBank) {
        comboBank.removeAllItems();
        comboBank.addItem("Pilih");
        
        String bank_unknwon_id, sql;
        bank_unknwon_id = ViewIDE.bank_id;
        sql = "SELECT "
                + "tbl_bank.nama_bank AS `Bank` "
            + "FROM "
                + "tbl_bank, tbl_bank_type "
            + "WHERE "
                + "LEFT(tbl_bank.id, 2) = tbl_bank_type.id AND "
                + "tbl_bank.id != '"+ bank_unknwon_id +"' "
            + "ORDER BY "
                + "tbl_bank.nama_bank ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                String bank;
                bank = resultSet.getString("Bank");
                
                comboBank.addItem(bank);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> load data bank into combo box
     */
    
    /**
     * Start -> load data
     */
    private static void LoadData (
        JTable table, JTextField textSearch
    ) {
        model = new DefaultTableModel();
        table.setModel(model);
        
        model.addColumn("Nama Lengkap");
        model.addColumn("Keterangan");
        
        String search, sql;
        search = textSearch.getText();
        
        UserActivityLog.setSearch(search);
        
        sql = "SELECT "
                + "tbl_person.nip AS `NIP`, "
                + "tbl_person.nama AS `Nama Lengkap`, "
                + "tbl_person.kelamin AS `Jenis Kelamin`, "
                + "tbl_dinas.dinas AS `Kantor` "
            + "FROM "
                + "tbl_dinas, tbl_jabatan, tbl_person "
            + "WHERE "
                + "tbl_person.id_dinas = tbl_dinas.id AND "
                + "tbl_person.id_jabatan = tbl_jabatan.id AND "
                + "(tbl_person.nip LIKE '%"+ search +"%' OR "
                + "tbl_person.nama LIKE '%"+ search +"%' OR "
                + "tbl_person.kelamin LIKE '%"+ search +"%' OR "
                + "tbl_person.kota LIKE '%"+ search +"%' OR "
                + "tbl_person.kontak LIKE '%"+ search +"%' OR "
                + "tbl_person.alamat LIKE '%"+ search +"%' OR "
                + "tbl_dinas.dinas LIKE '%"+ search +"%') "
            + "ORDER BY "
                + "tbl_person.nama ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                Object[] objects;
                objects = new Object[2];
                
                /**
                 * Start -> set nama lengkap
                 */
                String nama, kelamin;
                nama = resultSet.getString("Nama Lengkap");
                kelamin = resultSet.getString("Jenis Kelamin");
                
                switch (kelamin) {
                    case ViewIDE.female:
                        nama = "Ny." + " " + nama;
                        break;
                    default:
                        nama = "Tn." + " " + nama;
                        break;
                }
                
                objects[0] = nama;
                /**
                 * End -> set nama lengkap
                 */
                
                /**
                 * Start -> set keterangan
                 */
                String keterangan, nip, kantor;
                nip = resultSet.getString("NIP");
                kantor = resultSet.getString("Kantor");
                keterangan = "[" + nip + "]" + " " + "@" + " " + kantor;
                
                objects[1] = keterangan;
                /**
                 * End -> set keterangan
                 */
                
                model.addRow(objects);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SetTableConfig(table);
        }
    }
    /**
     * End -> load data
     */
    
    /**
     * Start -> set popup table
     */
    public static void PopupTable (
        JTable table,
        JMenuItem miUsePegawai, JMenuItem miClose, JMenuItem miBlocked
    ) {
        Integer row, SelectRowCount;
        row = table.getSelectedRow();
        SelectRowCount = table.getSelectedRowCount();
        
        switch (SelectRowCount) {
            case 0:
                /**
                 * Start -> set hide active popup menu item
                 */
                miUsePegawai.setVisible(false);
                miClose.setVisible(true);
                /**
                 * End -> set hide active popup menu item
                 */
                
                BlockedMessage(true, miBlocked);
                break;
            default:
                if (row == -1) {
                    return;
                }
                String nama, kelamin, nip, kantor;
                
                nama = (String) table.getModel().getValueAt(row, 0)
                        .toString().substring(4);
                
                /**
                 * Start -> set kelamin
                 */
                kelamin = (String) table.getModel().getValueAt(row, 0)
                        .toString().substring(0, 3);
                
                switch (kelamin) {
                    case "Ny.":
                        kelamin = ViewIDE.female;
                        break;
                    default:
                        kelamin = ViewIDE.male;
                        break;
                }
                
                kelamin = "" + kelamin;
                /**
                 * End -> set kelamin
                 */
                
                nip = (String) table.getModel().getValueAt(row, 1)
                        .toString().substring(1, 13);
                
                kantor = (String) table.getModel().getValueAt(row, 1)
                        .toString().substring(17);
                
                /**
                 * Start -> set variables into memory options
                 */
                UserActivityLog.setNama(nama);
                UserActivityLog.setKelamin(kelamin);
                UserActivityLog.setNip(nip);
                UserActivityLog.setDinas(kantor);
                /**
                 * End -> set variables into memory options
                 */
                
                /**
                 * Start -> set hide active popup menu item
                 */
                miUsePegawai.setVisible(true);
                miClose.setVisible(true);
                /**
                 * End -> set hide active popup menu item
                 */
                
                BlockedMessage(false, miBlocked);
                break;
        }
    }
    /**
     * End -> set popup table
     */
    
    /**
     * Start -> reload data from database into table
     */
    public static void Refresh (
        JTable table, JTextField textSearch
    ) {
        LoadData(table, textSearch);
        textSearch.requestFocus();
    }
    /**
     * End -> reload data from database into table
     */
    
    /**
     * Start -> find data on table
     */
    public static void Search (
        JTable table, JTextField textSearch
    ) {
        String message;
        if (textSearch.getText().isEmpty() == true) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
            
            textSearch.requestFocus();
        } else {
            LoadData(table, textSearch);
            textSearch.requestFocus();
        }
    }
    /**
     * End -> find data on table
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle,
        JPanel PanelMain, JPanel PanelBrowsePegawai,
        JTable table, JTextField textSearch, JComboBox<String> comboBank
    ) {
        AddTitle(labelTitle);
        
        LoadBank(comboBank);
        
        SetPanelBrowsePegawai(
            PanelMain, PanelBrowsePegawai, table, textSearch
        );
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set data kantor referenced by selected employer
     */
    private static void SetDataKantor (
        JLabel labelKantor, JLabel labelAlamatKantor
    ) {
        String kantor, alamat_kantor;
        kantor = UserActivityLog.getDinas();
        alamat_kantor = UserActivityLog.getDinasAlamat();
        
        labelKantor.setText(kantor);
        labelAlamatKantor.setText(alamat_kantor);
    }
    /**
     * End -> set data kantor referenced by selected employer
     */
    
    /**
     * Start -> set data pegawai
     */
    private static void SetDataPegawai (
        JLabel labelNama, JLabel labelKelamin, JLabel labelKota,
        JLabel labelTglLahir, JLabel labelKontak, JLabel labelAlamat
    ) {
        /**
         * Start -> get data pegawai from database
         */
        GetDataPegawai();
        /**
         * End -> get data pegawai from database
         */
        
        /**
         * Start -> create variables data type
         */
        String nama, kelamin, kota, tglLahir, kontak, alamat;
        /**
         * End -> create variables data type
         */
        
        /**
         * Start -> get data from memory options
         */
        nama = UserActivityLog.getNama();
        kelamin = UserActivityLog.getKelamin();
        kota = UserActivityLog.getKota();
        tglLahir = UserActivityLog.getTglLahir();
        kontak = UserActivityLog.getKontak();
        alamat = UserActivityLog.getAlamat();
        /**
         * End -> get data from memory options
         */
        
        /**
         * Start -> set data into objects
         */
        labelNama.setText(nama);
        labelKelamin.setText(kelamin);
        labelKota.setText(kota);
        labelKontak.setText(kontak);
        labelTglLahir.setText(tglLahir);
        labelAlamat.setText(alamat);
        /**
         * End -> set data into objects
         */
    }
    /**
     * End -> set data pegawai
     */
    
    /**
     * Start -> set panel browse pegawai
     */
    private static void SetPanelBrowsePegawai (
        JPanel PanelMain, JPanel PanelBrowsePegawai,
        JTable table, JTextField textSearch
    ) {
        LoadData(table, textSearch);
        AddPanel(PanelMain, PanelBrowsePegawai, textSearch);
    }
    /**
     * End -> set panel browse pegawai
     */
    
    /**
     * Start -> set panel data pegawai
     */
    private static void SetPanelDataPegawai (
        JPanel PanelMain, JPanel PanelDataPegawai,
        JLabel labelNama, JLabel labelKelamin, JLabel labelKota,
        JLabel labelTglLahir, JLabel labelKontak, JLabel labelAlamat
    ) {
        AddPanel(PanelMain, PanelDataPegawai);
        SetDataPegawai(
            labelNama, labelKelamin, labelKota,
            labelTglLahir, labelKontak, labelAlamat
        );
    }
    /**
     * End -> set panel data pegawai
     */
    
    /*
     * Start -> set table config
     */
    private static void SetTableConfig (JTable table) {
        ViewTable.autoResizeColumn(table);
        
        ViewTable.SetResizeColumn(table, 0, false);
        ViewTable.SetResizeColumn(table, 1, true);
    }
    /**
     * End -> set table config
     */
    
    /**
     * Start -> use this employer
     */
    public static void UseThisEmployer (
        Dialog dialog, JPanel PanelMain, JPanel PanelDataPegawai,
        JLabel labelNama, JLabel labelKelamin, JLabel labelKota,
        JLabel labelTglLahir, JLabel labelKontak, JLabel labelAlamat
    ) {
        ValidateDataChooser(
            dialog,
            PanelMain, PanelDataPegawai,
            labelNama, labelKelamin, labelKota,
            labelTglLahir, labelKontak, labelAlamat
        );
    }
    /**
     * End -> use this employer
     */
    
    /**
     * Start -> validate data chooser
     */
    private static void ValidateDataChooser (
        Dialog dialog, JPanel PanelMain, JPanel PanelDataPegawai,
        JLabel labelNama, JLabel labelKelamin, JLabel labelKota,
        JLabel labelTglLahir, JLabel labelKontak, JLabel labelAlamat
    ) {
        String nip, sql;
        nip = UserActivityLog.getNip();
        
        switch (nip) {
            case "-":
                GoToDataPegawai(
                    dialog,
                    PanelMain, PanelDataPegawai,
                    labelNama, labelKelamin, labelKota,
                    labelTglLahir, labelKontak, labelAlamat
                );
                break;
            default:
                
                break;
        }
    }
    /**
     * End -> validate data chooser
     */
    
}
