/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.modules.SQLAdapter;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import config.menu.RootMenuConfig;
import javax.swing.JLabel;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class DocEmptyConfig {
    
    /**
     * Start -> set message
     */
    private static void AddMessage (JLabel labelMessage) {
        String value;
        value = MessageLog.getMessage();
        labelMessage.setText(value);
    }
    /**
     * End -> set message
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
        RootMenuConfig.Doc();
        /**
         * End -> go back to database
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> empty
     */
    public static void Empty (Dialog dialog) {
        String op_bid, op_dok, set_default, sql;
        op_bid = ViewIDE.bidan;
        op_dok = ViewIDE.dokter;
        set_default = ViewIDE.jabatan_id;
        sql = "UPDATE "
                + "tbl_jabatan, tbl_person "
            + "SET "
                + "tbl_person.id_jabatan = '"+ set_default +"' "
            + "WHERE "
                + "tbl_person.id_jabatan = tbl_jabatan.id AND "
                + "(tbl_jabatan.jabatan LIKE '%"+ op_bid +"%' OR "
                + "tbl_jabatan.jabatan LIKE '%"+ op_dok +"%');";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            /**
             * Start -> close active dialog
             */
            ViewDialog.AddAnimationLeftToRight(dialog);
            ViewDialog.CloseDialog(dialog);
            /**
             * End -> close active dialog
             */
            
            /**
             * Start -> go back to database
             */
            RootMenuConfig.Doc();
            /**
             * End -> go back to database
             */
        }
    }
    /**
     * End -> empty
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle, JLabel labelMessage
    ) {
        AddTitle(labelTitle);
        AddMessage(labelMessage);
    }
    /**
     * End -> set config
     */
    
}
