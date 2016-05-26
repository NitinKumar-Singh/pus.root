/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.BankLog;
import com.lib.logs.MessageLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class BankNewConfig {
    
    /**
     * Start -> set fields
     */
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
     * Start -> check bank id
     */
    private static void CheckBankID (Dialog dialog) {
        String id, message, sql;
        id = BankLog.getId();
        sql = "SELECT "
                + "id AS `ID Bank` "
            + "FROM "
                + "tbl_bank "
            + "WHERE "
                + "id = '"+ id +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                message = ViewIDE.pesan_warning_incorrect_id;
                Pesan.Warning(message);
            } else {
                SaveData(dialog);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> check bank id
     */
    
    /**
     * Start -> check type of bank
     */
    private static void CheckTypeOfBank (Dialog dialog) {
        String id, message, sql;
        id = BankLog.getId().substring(0, 2);
        sql = "SELECT "
                + "id AS `Type of Bank ID` "
            + "FROM "
                + "tbl_bank_type "
            + "WHERE "
                + "id = '"+ id +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                CheckBankID(dialog);
            } else {
                message = ViewIDE.pesan_warning_incorrect_type_id;
                Pesan.Warning(message);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> check type of bank
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
     * Start -> prepared save data
     */
    public static void Save (
        Dialog dialog, JTextField textID, JTextField textNama,
        JTextField textKota, JTextField textKontak, JTextField textAlamat
    ) {
        String message;
        if (textID.getText().isEmpty() == true ||
            textNama.getText().isEmpty() == true ||
            textKota.getText().isEmpty() == true ||
            textKontak.getText().isEmpty() == true ||
            textAlamat.getText().isEmpty() == true
        ) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            String id, nama, kota, kontak, alamat;
            id = textID.getText();
            nama = textNama.getText();
            kota = textKota.getText();
            kontak = textKontak.getText();
            alamat = textAlamat.getText();
            
            BankLog.setId(id);
            BankLog.setNama(nama);
            BankLog.setKota(kota);
            BankLog.setKontak(kontak);
            BankLog.setAlamat(alamat);
            
            CheckTypeOfBank(dialog);
        }
    }
    /**
     * End -> prepared save data
     */
    
    /**
     * Stat -> save data
     */
    private static void SaveData (Dialog dialog) {
        String id, nama, kota, kontak, alamat, message, sql;
        id = BankLog.getId();
        nama = BankLog.getNama();
        kota = BankLog.getKota();
        kontak = BankLog.getKontak();
        alamat = BankLog.getAlamat();
        sql = "INSERT INTO "
                + "tbl_bank"
                + "("
                    + "id, nama_bank, kota, kontak, alamat"
                + ") "
            + "VALUES"
                + "("
                    + "'"+ id +"', "
                    + "'"+ nama +"', "
                    + "'"+ kota +"', "
                    + "'"+ kontak +"', "
                    + "'"+ alamat +"'"
                + ");";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            /**
             * Start -> message
             */
            message = ViewIDE.pesan_info_bank_success;
            Pesan.Information(message);
            /**
             * End -> message
             */
            
            /**
             * Start -> close active dialog
             */
            ViewDialog.AddAnimationLeftToRight(dialog);
            Close(dialog);
            /**
             * End -> close active dialog
             */
        }
    }
    /**
     * End -> save data
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (JLabel labelTitle) {
        AddTitle(labelTitle);
    }
    /**
     * End -> set config
     */
    
}
