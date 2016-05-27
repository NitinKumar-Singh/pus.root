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
public class NasabahOptionsConfig {
    
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
     * Start -> open database of daftar nasabah bank
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
         * Start -> open database of daftar nasabah bank
         */
        RootMenuConfig.NasabahDb();
        /**
         * End -> open database of daftar nasabah bank
         */
    }
    /**
     * End -> open database of daftar nasabah bank
     */
    
    /**
     * Start -> open new entry of reg. nasabah bank
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
         * Start -> open new entry of reg. nasabah bank
         */
        RootMenuConfig.NasabahNew();
        /**
         * End -> open new entry of reg. nasabah bank
         */
    }
    /**
     * End -> open new entry of reg. nasabah bank
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
