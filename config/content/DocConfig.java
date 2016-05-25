/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.UserActivityLog;
import com.lib.logs.UserLog;
import com.lib.modules.SQLAdapter;
import com.lib.palette.link;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import com.lib.views.ViewTable;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class DocConfig {
    
    /**
     * Start -> set fields
     */
    private static DefaultTableModel model;
    
    private static ResultSet resultSet;
    /**
     * End -> set fields
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
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> set convert
     */
    private static void Convert (Integer i) {
        JFormattedTextField textFormat;
        textFormat = new JFormattedTextField();
        textFormat.setFormatterFactory(
            new DefaultFormatterFactory(
                new NumberFormatter(
                    NumberFormat.getIntegerInstance()
                )
            )
        );
        textFormat.setValue(i);
        
        String value;
        value = textFormat.getText();
        
        UserActivityLog.setConvert(value);
    }
    /**
     * End -> set convert
     */
    
    /**
     * Start -> set count data from table
     */
    private static void CountTable (JTable table, link linkStatus) {
        Integer count;
        count = table.getRowCount();
        
        String convert, message;
        
        switch (count) {
            case 0:
                message = "data kosong";
                break;
            default:
                Convert(count);
                convert = UserActivityLog.getConvert();
                message = convert + " " + "data";
                break;
        }
        
        message = "Status" + " : " + message;
        linkStatus.setText(message);
    }
    /**
     * End -> set count data from table
     */
    
    /**
     * Start -> empty permission
     */
    public static void Empty (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open empty permission
         */
        RootMenuConfig.DocEmpty();
        /**
         * End -> open empty permission
         */
    }
    /**
     * End -> empty permission
     */
    
    /**
     * Start -> load data
     */
    private static void LoadData (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        model = new DefaultTableModel();
        table.setModel(model);
        
        model.addColumn("<html><u>N</u> I P</html>");
        model.addColumn("Nama Lengkap");
        model.addColumn("Kab. / Kota Kelahiran");
        model.addColumn("Tgl. Lahir");
        model.addColumn("Kontak");
        model.addColumn("Kantor");
        model.addColumn("Jabatan");
        
        String search, op_doc, op_bid, sql;
        search = textSearch.getText();
        
        UserActivityLog.setSearch(search);
        
        op_doc = ViewIDE.dokter;
        op_bid = ViewIDE.bidan;
        sql = "SELECT "
                + "tbl_person.nip AS `NIP`, "
                + "tbl_person.nama AS `Nama Lengkap`, "
                + "tbl_person.kelamin AS `Jenis Kelamin`, "
                + "tbl_person.kota AS `Kab. / Kota Kelahiran`, "
                + "tbl_person.tgl_lahir AS `Tgl. Lahir`, "
                + "tbl_person.kontak AS `Kontak`, "
                + "tbl_dinas.dinas AS `Kantor`, "
                + "tbl_jabatan.jabatan AS `Jabatan` "
            + "FROM "
                + "tbl_dinas, tbl_jabatan, tbl_person, "
                + "tbl_user, tbl_user_level, tbl_user_sso "
            + "WHERE "
                + "tbl_person.id_user = tbl_user.id AND "
                + "tbl_person.id_dinas = tbl_dinas.id AND "
                + "tbl_person.id_jabatan = tbl_jabatan.id AND "
                + "tbl_user_sso.id_user = tbl_user.id AND "
                + "tbl_user.id_level = tbl_user_level.id AND "
                + "(tbl_jabatan.jabatan LIKE '%"+ op_bid +"%' OR "
                + "tbl_jabatan.jabatan LIKE '%"+ op_doc +"%') AND "
                + "(tbl_person.nip LIKE '%"+ search +"%' OR "
                + "tbl_person.nama LIKE '%"+ search +"%' OR "
                + "tbl_person.kelamin LIKE '%"+ search +"%' OR "
                + "tbl_person.kota LIKE '%"+ search +"%' OR "
                + "tbl_person.tgl_lahir LIKE '%"+ search +"%' OR "
                + "tbl_person.kontak LIKE '%"+ search +"%' OR "
                + "tbl_dinas.dinas LIKE '%"+ search +"%') "
            + "ORDER BY "
                + "tbl_person.nama ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                Object[] objects;
                objects =  new Object[7];
                
                objects[0] = resultSet.getString("NIP");
                
                /**
                 * Start -> set employer name
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
                
                objects[1] = nama;
                /**
                 * End -> set employer name
                 */
                
                objects[2] = resultSet.getString("Kab. / Kota Kelahiran");
                
                objects[3] = resultSet.getString("Tgl. Lahir");
                
                objects[4] = resultSet.getString("Kontak");
                
                /**
                 * Start -> set kantor
                 */
                String kantor;
                kantor = resultSet.getString("Kantor");
                
                switch (kantor) {
                    case ViewIDE.id_dinas:
                        kantor = "-";
                        break;
                    default:
                        kantor = "" + kantor;
                        break;
                }
                
                objects[5] = kantor;
                /**
                 * End -> set kantor
                 */
                
                /**
                 * Start -> set jabatan field
                 */
                String jabatan;
                jabatan = resultSet.getString("Jabatan");
                
                switch (jabatan) {
                    case ViewIDE.jabatan:
                        jabatan = "-";
                        break;
                    default:
                        jabatan = "" + jabatan;
                        break;
                }
                
                objects[6] = jabatan;
                /**
                 * End -> set jabatan field
                 */
                
                model.addRow(objects);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SetTableConfig(table);
            CountTable(table, linkStatus);
        }
    }
    /**
     * End -> load data
     */
    
    /**
     * Start -> set variables when you get popup action
     */
    public static void PopupTable (
        JTable table,
        JMenuItem miView, JMenuItem miBlocked
    ) {
        Integer row, SelectRowCount;
        row = table.getSelectedRow();
        SelectRowCount = table.getSelectedRowCount();
        
        switch (SelectRowCount) {
            case 0:
                /**
                 * Start -> set hide active popup menu item
                 */
                miView.setVisible(false);
                /**
                 * End -> set hide active popup menu item
                 */
                
                BlockedMessage(true, miBlocked);
                break;
            default:
                if (row == -1) {
                    return;
                }
                String nip, nip_default, nama, kelamin, kota, tglLahir, kontak;
                String dinas, jabatan, message;
                
                nip_default = UserLog.getNip();
                nip = (String) table.getModel().getValueAt(row, 0);
                nama = (String) table.getModel().getValueAt(row, 1);
                
                /**
                 * Start -> set message
                 */
                message = ""
                + "<html>"
                    + "Hapus `<b>" + nama + "</b>` dari database?"
                + "</html>";
                MessageLog.setMessage(message);
                /**
                 * End -> set message
                 */
                
                nama = nama.substring(4);
                
                /**
                 * Start -> set kelamin
                 */
                kelamin = (String) table.getModel().getValueAt(row, 1)
                    .toString().substring(0, 3);
                
                switch (kelamin) {
                    case "Ny.":
                        kelamin = ViewIDE.female;
                        break;
                    default:
                        kelamin = ViewIDE.male;
                        break;
                }
                
                /**
                 * End -> set kelamin
                 */
                
                kota = (String) table.getModel().getValueAt(row, 2);
                
                tglLahir = (String) table.getModel().getValueAt(row, 3);
                
                kontak = (String) table.getModel().getValueAt(row, 4);
                
                dinas = (String) table.getModel().getValueAt(row, 5);
                
                jabatan = (String) table.getModel().getValueAt(row, 6);
                
                /**
                 * Start -> set variables into memory options
                 */
                UserActivityLog.setNip(nip);
                UserActivityLog.setNama(nama);
                UserActivityLog.setKelamin(kelamin);
                UserActivityLog.setKota(kota);
                UserActivityLog.setTglLahir(tglLahir);
                UserActivityLog.setKontak(kontak);
                UserActivityLog.setDinas(dinas);
                UserActivityLog.setJabatan(jabatan);
                /**
                 * End -> set variables into memory options
                 */
                
                /**
                 * Start -> set hide active popup menu item
                 */
                miView.setVisible(true);
                
                /**
                 * Start -> switch object when nip was the same on log
                 */
                if (nip.equals(nip_default) == true) {
                    miView.setText("View My Profile");
                } else {
                    miView.setText("See Information About This Person");
                }
                /**
                 * End -> switch object when nip was the same on log
                 */
                
                /**
                 * End -> set hide active popup menu item
                 */
                
                BlockedMessage(false, miBlocked);
                break;
        }
    }
    /**
     * End -> set variables when you get popup action
     */
    
    /**
     * Start -> reload data from database
     */
    public static void Refresh (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        LoadData(table, textSearch, linkStatus);
        textSearch.requestFocus();
    }
    /**
     * End -> reload data from database
     */
    
    /**
     * Start -> find data from database
     */
    public static void Search (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String message;
        if (textSearch.getText().isEmpty() == true) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
            
            textSearch.requestFocus();
        } else {
            LoadData(table, textSearch, linkStatus);
            textSearch.requestFocus();
        }
    }
    /**
     * End -> find data from database
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle, JTable table,
        JTextField textSearch, link linkStatus
    ) {
        AddTitle(labelTitle);
        Refresh(table, textSearch, linkStatus);
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set table config
     */
    private static void SetTableConfig (JTable table) {
        ViewTable.autoResizeColumn(table);
        
        ViewTable.SetResizeColumn(table, 0, false);
        ViewTable.SetResizeColumn(table, 1, false);
        ViewTable.SetResizeColumn(table, 2, false);
        ViewTable.SetResizeColumn(table, 3, false);
        ViewTable.SetResizeColumn(table, 4, false);
        ViewTable.SetResizeColumn(table, 5, false);
        ViewTable.SetResizeColumn(table, 6, false);
    }
    /**
     * End -> set table config
     */
    
    /**
     * Start -> view person
     */
    public static void ViewPerson (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open view person
         */
        RootMenuConfig.Person();
        /**
         * End -> open view person
         */
    }
    /**
     * End -> view person
     */
    
}
