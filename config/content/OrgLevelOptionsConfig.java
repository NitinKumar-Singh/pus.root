/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.views.ViewDialog;
import config.menu.RootMenuConfig;
import javax.swing.JLabel;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class OrgLevelOptionsConfig {
    
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
     * Start -> open database of organization level
     */
    public static void OpenDatabase (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open database of organization level
         */
        RootMenuConfig.OrgLevelDb();
        /**
         * End -> open database of organization level
         */
    }
    /**
     * End -> open database of organization level
     */
    
    /**
     * Start -> open new input
     */
    public static void OpenNewInput (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open new input
         */
        RootMenuConfig.OrgLevelNew();
        /**
         * End -> open new input
         */
    }
    /**
     * End -> open new input
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle
    ) {
        AddTitle(labelTitle);
    }
    /**
     * End -> set config
     */
    
}
