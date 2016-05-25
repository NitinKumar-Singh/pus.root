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
public class OrgLevelNewConfig {
    
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
     * Start -> check organization level id
     */
    private static void CheckID (Dialog dialog) {
        String id, message, sql;
        id = JabatanLog.getId();
        sql = "SELECT "
                + "id AS `ID` "
            + "FROM "
                + "tbl_jabatan "
            + "WHERE "
                + "id = '"+ id +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                message = ViewIDE.pesan_warning_incorrect_id;
                Pesan.Warning(message);
            } else {
                /**
                 * Start -> save data
                 */
                Save(dialog);
                /**
                 * End -> save data
                 */
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> check organization level id
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
         * Start -> go back to options
         */
        RootMenuConfig.OrgLevelOptions();
        /**
         * End -> go back to options
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> save new organization level
     */
    public static void Save (
        Dialog dialog,
        JTextField textID, JTextField textJabatan,
        JEditorPane textKeterangan
    ) {
        String message, id, jabatan, keterangan;
        id = textID.getText();
        jabatan = textJabatan.getText();
        keterangan = textKeterangan.getText();
        
        if (id.isEmpty() == true || jabatan.isEmpty() == true) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            /**
             * Start -> switch value of keterangan
             */
            if (keterangan.isEmpty() == true) {
                keterangan = "-";
            }
            /**
             * End-> switch alue of keterangan
             */
            
            /**
             * Start -> set variables into memory options
             */
            JabatanLog.setId(id);
            JabatanLog.setJabatan(jabatan);
            JabatanLog.setKeterangan(keterangan);
            /**
             * End -> set variables into memory options
             */
            
            /**
             * Start -> check organization level id
             */
            CheckID(dialog);
            /**
             * End -> check organization level id
             */
        }
    }
    /**
     * End -> save new organization level
     */
    
    /**
     * Start -> save data
     */
    private static void Save (Dialog dialog) {
        String id, jabatan, keterangan, message, sql;
        id = JabatanLog.getId();
        jabatan = JabatanLog.getJabatan();
        keterangan = JabatanLog.getKeterangan();
        sql = "INSERT INTO "
                + "tbl_jabatan(id, jabatan, keterangan) "
            + "VALUES"
            + "("
                + "'"+ id +"', "
                + "'"+ jabatan +"', "
                + "'"+ keterangan +"'"
            + ");";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            message = ViewIDE.pesan_info_org_level_success;
            Pesan.Information(message);
            
            /**
             * Start -> go back to options
             */
            ViewDialog.AddAnimationLeftToRight(dialog);
            Close(dialog);
            /**
             * End -> go back to options
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
