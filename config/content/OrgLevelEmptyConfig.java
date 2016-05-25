/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.modules.SQLAdapter;
import com.lib.views.ViewDialog;
import config.menu.RootMenuConfig;
import javax.swing.JLabel;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class OrgLevelEmptyConfig {
    
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
        RootMenuConfig.OrgLevelDb();
        /**
         * End -> go back to database
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> empty organization level
     */
    public static void Empty (Dialog dialog) {
        String sql;
        sql = "TRUNCATE tbl_jabatan;";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            /**
             * Start -> close active dialog
             */
            ViewDialog.AddAnimationRightToRight(dialog);
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
    }
    /**
     * End -> empty organization level
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
