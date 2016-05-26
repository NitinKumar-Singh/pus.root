/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.BankLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class BankEditConfig {
    
    /**
     * Start -> set fields
     */
    private static ResultSet resultSet;
    /**
     * End -> set fields
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
        RootMenuConfig.BankDb();
        /**
         * End -> go back to database
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> check bank id
     */
    private static void CheckBankID (Dialog dialog) {
        String id_change, message, sql;
        id_change = BankLog.getIdChange();
        sql = "SELECT "
                + "id AS `ID Bank` "
            + "FROM "
                + "tbl_bank "
            + "WHERE "
                + "id = '"+ id_change +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                message = ViewIDE.pesan_warning_incorrect_id;
                Pesan.Warning(message);
            } else {
                UpdateData(dialog);
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
        String id_default, id_change, find_id, message, sql;
        id_default = BankLog.getId();
        id_change = BankLog.getIdChange();
        find_id = BankLog.getIdChange().substring(0, 2);
        sql = "SELECT "
                + "id AS `Type of Bank ID` "
            + "FROM "
                + "tbl_bank_type "
            + "WHERE "
                + "id = '"+ find_id +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                if (id_change.equals(id_default) == true) {
                    UpdateData(dialog);
                } else {
                    CheckBankID(dialog);
                }
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
     * Start -> set config
     */
    public static void SetConfig (
        JTextField textID, JTextField textNama, JTextField textKota,
        JTextField textKontak, JTextField textAlamat
    ) {
        SetData(textID, textNama, textKota, textKontak, textAlamat);
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set data
     */
    private static void SetData (
        JTextField textID, JTextField textNama, JTextField textKota,
        JTextField textKontak, JTextField textAlamat
    ) {
        String id, nama, kota, kontak, alamat;
        id = BankLog.getId();
        nama = BankLog.getNama();
        kota = BankLog.getKota();
        kontak = BankLog.getKontak();
        alamat = BankLog.getAlamat();
        
        textID.setText(id);
        textNama.setText(nama);
        textKota.setText(kota);
        textKontak.setText(kontak);
        textAlamat.setText(alamat);
        
        textID.requestFocus();
    }
    /**
     * End -> set data
     */
    
    /**
     * Start -> prepared update
     */
    public static void Update (
        Dialog dialog, JTextField textID, JTextField textNama,
        JTextField textKota, JTextField textKontak, JTextField textAlamat
    ) {
        String id_change, nama, kota, kontak, alamat, message;
        id_change = textID.getText();
        nama = textNama.getText();
        kota = textKota.getText();
        kontak = textKontak.getText();
        alamat = textAlamat.getText();
        
        if (id_change.isEmpty() == true || nama.isEmpty() == true ||
            kota.isEmpty() == true || kontak.isEmpty() == true ||
            alamat.isEmpty() == true
        ) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            /**
             * Start -> set variables into memory options
             */
            BankLog.setIdChange(id_change);
            BankLog.setNama(nama);
            BankLog.setKota(kota);
            BankLog.setKontak(kontak);
            BankLog.setAlamat(alamat);
            /**
             * End -> set variables into memory options
             */
            
            /**
             * Start -> check type of bank
             */
            CheckTypeOfBank(dialog);
            /**
             * End- > check type of bank
             */
        }
    }
    /**
     * End -> prepared update
     */
    
    /**
     * Start -> update data
     */
    private static void UpdateData (Dialog dialog) {
        String id_default, id_change, nama, kota, kontak, alamat;
        String message, sql;
        
        /**
         * Start -> get variables from memory options
         */
        id_default = BankLog.getId();
        id_change = BankLog.getIdChange();
        nama = BankLog.getNama();
        kota = BankLog.getKota();
        kontak = BankLog.getKontak();
        alamat = BankLog.getAlamat();
        /**
         * End -> get variables from memory options
         */
        
        if (id_change.equals(id_default) == true) {
            sql = "UPDATE "
                    + "tbl_bank "
                + "SET "
                    + "nama = '"+ nama +"', "
                    + "kota = '"+ kota +"', "
                    + "kontak = '"+ kontak +"', "
                    + "alamat = '"+ alamat +"' "
                + "WHERE "
                    + "id = '"+ id_default +"';";
        } else {
            sql = "UPDATE "
                    + "tbl_bank "
                + "SET "
                    + "id = '"+ id_change +"', "
                    + "nama = '"+ nama +"', "
                    + "kota = '"+ kota +"', "
                    + "kontak = '"+ kontak +"', "
                    + "alamat = '"+ alamat +"' "
                + "WHERE "
                    + "id = '"+ id_default +"';";
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
             * Start -> go back to database
             */
            ViewDialog.AddAnimationRightToRight(dialog);
            Close(dialog);
            /**
             * End -> go back to database
             */
        }
    }
    /**
     * End -> update data
     */
    
}
