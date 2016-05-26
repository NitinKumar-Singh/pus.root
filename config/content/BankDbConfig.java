/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.BankLog;
import com.lib.logs.MessageLog;
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
import javax.swing.JRootPane;
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
public class BankDbConfig {
    
    /**
     * Start -> set fields
     */
    private static DefaultTableModel model;
    
    private static ResultSet resultSet;
    
    private static JRootPane rootPane;
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
        
        /**
         * Start -> go back to the options
         */
        RootMenuConfig.BankOptions();
        /**
         * End -> go back to the options
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
        
        BankLog.setConvert(value);
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
                convert = BankLog.getConvert();
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
     * Start -> delete permission
     */
    public static void Delete (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String message, title;
        message = MessageLog.getMessage();
        title = ViewIDE.pesan_question_title;
        
        if (Pesan.showConfirmDialog(
            rootPane, message, title,
            Pesan.YES_NO_OPTION, Pesan.QUESTION_MESSAGE
        ) == Pesan.YES_OPTION
        ) {
            DeleteData(table, textSearch, linkStatus);
        }
    }
    /**
     * End -> delete permission
     */
    
    /**
     * Start -> delete data
     */
    private static void DeleteData (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String id, sql;
        id = BankLog.getId();
        sql = "DELETE FROM tbl_bank WHERE id = '"+ id +"';";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            /**
             * Start -> reload data from database into table
             */
            Refresh(table, textSearch, linkStatus);
            /**
             * End -> reload data from database into table
             */
        }
    }
    /**
     * End -> delete data
     */
    
    /**
     * Start -> open edit form
     */
    public static void Edit (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open edit form
         */
        
        /**
         * End -> open edit form
         */
    }
    /**
     * End -> open edit form
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
         * Start -> open empty dialog
         */
        
        /**
         * End -> open empty dialog
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
        
        model.addColumn("<html><u>I</u>D Bank</html>");
        model.addColumn("Nama Perbankan");
        model.addColumn("Kab. / Kota");
        model.addColumn("No. Telepon");
        model.addColumn("Alamat");
        model.addColumn("Keterangan");
        
        String search, sql, bank_unknown_id;
        search = textSearch.getText();
        
        BankLog.setSearch(search);
        
        bank_unknown_id = ViewIDE.bank_id;
        sql = "SELECT "
                + "tbl_bank.id AS `ID Bank`, "
                + "tbl_bank.nama_bank AS `Nama Perbankan`, "
                + "tbl_bank.kota AS `Kab. / Kota`, "
                + "tbl_bank.kontak AS `No. Telepon`, "
                + "tbl_bank.alamat AS `Alamat`, "
                + "tbl_bank_type.tipe AS `KP / KC` "
            + "FROM "
                + "tbl_bank, tbl_bank_type "
            + "WHERE "
                + "LEFT(tbl_bank.id, 2) = tbl_bank_type.id AND "
                + "tbl_bank.id != '"+ bank_unknown_id +"' "
            + "ORDER BY "
                + "tbl_bank.nama_bank ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                Object[] objects;
                objects = new Object[6];
                
                objects[0] = resultSet.getString("ID Bank");
                
                objects[1] = resultSet.getString("Nama Perbankan");
                
                objects[2] = resultSet.getString("Kab. / Kota");
                
                objects[3] = resultSet.getString("No. Telepon");
                
                objects[4] = resultSet.getString("Alamat");
                
                objects[5] = resultSet.getString("KP / KC");
                
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
     * Start -> set popup table
     */
    public static void PopupTable (
        JTable table,
        JMenuItem miEdit, JMenuItem miDelete, JMenuItem miBlocked
    ) {
        Integer row, SelectRowCount;
        row = table.getSelectedRow();
        SelectRowCount = table.getSelectedRowCount();
        
        switch (SelectRowCount) {
            case 0:
                /**
                 * Start -> set hide active popup menu item
                 */
                miEdit.setVisible(false);
                miDelete.setVisible(false);
                /**
                 * End -> set hide active popup menu item
                 */
                
                BlockedMessage(true, miBlocked);
                break;
            default:
                if (row == -1) {
                    return;
                }
                String id, nama, kota, kontak, alamat;
                String bank_type, bank_type_id;
                String message;
                
                id = (String) table.getModel().getValueAt(row, 0);
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
                
                kota = (String) table.getModel().getValueAt(row, 2);
                
                kontak = (String) table.getModel().getValueAt(row, 3);
                
                alamat = (String) table.getModel().getValueAt(row, 4);
                
                bank_type_id = id.substring(0, 2);
                
                bank_type = (String) table.getModel().getValueAt(row, 5);
                
                /**
                 * Start -> set variables into memory options
                 */
                BankLog.setId(id);
                BankLog.setNama(nama);
                BankLog.setKota(kota);
                BankLog.setKontak(kontak);
                BankLog.setAlamat(alamat);
                BankLog.setTypeID(bank_type_id);
                BankLog.setType(bank_type);
                /**
                 * End -> set variables into memory options
                 */
                
                /**
                 * Start -> set hide active popup menu item
                 */
                miEdit.setVisible(true);
                miDelete.setVisible(true);
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
    
    /*
     * Start -> set table config
     */
    private static void SetTableConfig (JTable table) {
        ViewTable.autoResizeColumn(table);
        
        ViewTable.SetResizeColumn(table, 0, false);
        ViewTable.SetResizeColumn(table, 1, false);
        ViewTable.SetResizeColumn(table, 2, false);
        ViewTable.SetResizeColumn(table, 3, false);
        ViewTable.SetResizeColumn(table, 4, true);
    }
    /**
     * End -> set table config
     */
    
}
