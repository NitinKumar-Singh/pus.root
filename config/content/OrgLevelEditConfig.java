/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.JabatanLog;
import com.lib.logs.MessageLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class OrgLevelEditConfig {
    
    /**
     * Start -> set fields
     */
    private static ResultSet resultSet;
    /**
     * End -> set fields
     */
    
    /**
     * Start -> set variables into objects
     */
    private static void AddData (
        JTextField textID, JTextField textJabatan, JEditorPane textKeterangan
    ) {
        String id, jabatan, keterangan;
        id = JabatanLog.getId();
        jabatan = JabatanLog.getJabatan();
        keterangan = JabatanLog.getKeterangan();
        
        textID.setText(id);
        textJabatan.setText(jabatan);
        textKeterangan.setText(keterangan);
        textID.requestFocus();
    }
    /**
     * End -> set variables into objects
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
     * Start -> check updated id
     */
    private static void CheckUpdatedID (Dialog dialog) {
        String updatedID, message, sql;
        updatedID = JabatanLog.getUpdatedID();
        sql = "SELECT "
                + "id AS `ID` "
            + "FROM "
                + "tbl_jabatan "
            + "WHERE "
                + "id = '"+ updatedID +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                message = ViewIDE.pesan_warning_incorrect_id;
                Pesan.Warning(message);
            } else {
                Update(dialog);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> check updated id
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
        RootMenuConfig.OrgLevelDb();
        /**
         * End -> go back to database
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle, JTextField textID,
        JTextField textJabatan, JEditorPane textKeterangan
    ) {
        AddTitle(labelTitle);
        AddData(textID, textJabatan, textKeterangan);
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> update
     */
    public static void Update (
        Dialog dialog, JTextField textID,
        JTextField textJabatan, JEditorPane textKeterangan
    ) {
        String default_id, id, jabatan, keterangan, message;
        default_id = JabatanLog.getId();
        id = textID.getText();
        jabatan = textJabatan.getText();
        keterangan = textKeterangan.getText();
        
        if (id.isEmpty() == true || jabatan.isEmpty() == true) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            /**
             * Start -> set variable's value when it became empty
             */
            if (keterangan.isEmpty() == true) {
                keterangan = "-";
            }
            /**
             * End -> set variable's value when it became empty
             */
            
            /**
             * Start -> set variables of organization level
             */
            JabatanLog.setJabatan(jabatan);
            JabatanLog.setKeterangan(keterangan);
            JabatanLog.setUpdatedID(id);
            /**
             * End -> set variables of organization level
             */
            
            if (id.equals(default_id) == true) {
                Update(dialog);
            } else {
                /**
                 * Start -> check updated id
                 */
                CheckUpdatedID(dialog);
                /**
                 * End -> check updated id
                 */
            }
        }
    }
    /**
     * End -> update
     */
    
    /**
     * Start -> update
     */
    private static void Update (Dialog dialog) {
        String default_id, updated_id, jabatan, keterangan, message, sql;
        default_id = JabatanLog.getId();
        updated_id = JabatanLog.getUpdatedID();
        jabatan = JabatanLog.getJabatan();
        keterangan = JabatanLog.getKeterangan();
        
        if (updated_id.equals(default_id) == true) {
            sql = "UPDATE "
                    + "tbl_jabatan "
                + "SET "
                    + "jabatan = '"+ jabatan +"', "
                    + "keterangan = '"+ keterangan +"' "
                + "WHERE "
                    + "id = '"+ default_id +"';";
        } else {
            sql = "UPDATE "
                    + "tbl_jabatan "
                + "SET "
                    + "id = '"+ updated_id +"', "
                    + "jabatan = '"+ jabatan +"', "
                    + "keterangan = '"+ keterangan +"' "
                + "WHERE "
                    + "id = '"+ default_id +"';";
        }
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            message = ViewIDE.pesan_info_update_success_default;
            Pesan.Information(message);
            
            /**
             * Start -> go back to database
             */
            ViewDialog.AddAnimationLeftToRight(dialog);
            Close(dialog);
            /**
             * End -> go back to database
             */
        }
    }
    /**
     * End -> update
     */
    
}
