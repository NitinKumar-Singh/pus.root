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
public class BankOptionsConfig {
    
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
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> open db bank
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
         * Start -> open db bank
         */
        RootMenuConfig.BankDb();
        /**
         * End -> open db bank
         */
    }
    /**
     * End -> open db bank
     */
    
    /**
     * Start -> new bank
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
         * Start -> new bank
         */
        RootMenuConfig.BankNew();
        /**
         * End -> new bank
         */
    }
    /**
     * End -> new bank
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
