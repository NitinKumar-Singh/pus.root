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
public class ServiceCostOptionsConfig {
    
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
     * Start -> open database dialog
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
         * Start -> open database
         */
        RootMenuConfig.ServiceCostDb();
        /**
         * End -> open database
         */
    }
    /**
     * End -> open database dialog
     */
    
    /**
     * Start -> open new input dialog
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
        RootMenuConfig.ServiceCostNew();
        /**
         * End -> open new input
         */
    }
    /**
     * End -> open new input dialog
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
