/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.UserActivityLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpChangeJabatanConfig {
    
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
     * Start -> get data
     */
    private static void GetData (
        JTextField textNama, JComboBox<String> comboJabatan
    ) {
        String nama, jabatan;
        nama = UserActivityLog.getNama();
        jabatan = UserActivityLog.getJabatan();
        
        textNama.setText(nama);
        comboJabatan.setSelectedItem(jabatan);
        SetJabatan(comboJabatan);
        textNama.requestFocus();
    }
    /**
     * End -> get data
     */
    
    /**
     * Start -> load jabatan
     */
    private static void LoadJabatan (JComboBox<String> comboJabatan) {
        comboJabatan.removeAllItems();
        comboJabatan.addItem("Pilih");
        
        String sql, unknown_id;
        unknown_id = ViewIDE.jabatan_id;
        sql = "SELECT "
                + "jabatan AS `Jabatan` "
            + "FROM "
                + "tbl_jabatan "
            + "WHERE "
                + "id != '"+ unknown_id +"' "
            + "ORDER BY "
                + "jabatan ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                String jabatan;
                jabatan = resultSet.getString("Jabatan");
                
                comboJabatan.addItem(jabatan);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> load jabatan
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle, JTextField textNama, JComboBox<String> comboJabatan
    ) {
        AddTitle(labelTitle);
        LoadJabatan(comboJabatan);
        GetData(textNama, comboJabatan);
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set jabatan
     */
    public static void SetJabatan (JComboBox<String> comboJabatan) {
        Integer index;
        index = comboJabatan.getSelectedIndex();
        
        switch (index) {
            case 0:
                /**
                 * No action required
                 */
                break;
            default:
                String jabatan;
                jabatan = String.valueOf(comboJabatan.getSelectedItem());
                
                UserActivityLog.setJabatan(jabatan);
                
                SetJabatanID();
                break;
        }
    }
    /**
     * End -> set jabatan
     */
    
    /**
     * Start -> set jabatan id
     */
    private static void SetJabatanID () {
        String jabatan, sql;
        jabatan = UserActivityLog.getJabatan();
        sql = "SELECT "
                + "id AS `Jabatan ID` "
            + "FROM "
                + "tbl_jabatan "
            + "WHERE "
                + "jabatan = '"+ jabatan +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                String JabatanID;
                JabatanID = resultSet.getString("Jabatan ID");
                
                UserActivityLog.setJabatanID(JabatanID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> set jabatan id
     */
    
    /**
     * Start -> update
     */
    public static void Update (
        Dialog dialog, JTextField textNama, JComboBox<String> comboJabatan
    ) {
        String message;
        if (comboJabatan.getSelectedIndex() == 0 ||
            textNama.getText().isEmpty() == true
        ) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            SetJabatan(comboJabatan);
            
            String jabatan_id, nama, nip, sql;
            jabatan_id = UserActivityLog.getJabatanID();
            nama = textNama.getText();
            nip = UserActivityLog.getNip();
            sql = "UPDATE "
                    + "tbl_person "
                + "SET "
                    + "nama = '"+ nama +"', "
                    + "id_jabatan = '"+ jabatan_id +"' "
                + "WHERE "
                    + "nip = '"+ nip +"';";

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
    }
    /**
     * End -> update
     */
    
}
