/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.UserLog;
import com.lib.modules.SQLAdapter;
import com.lib.views.ViewDialog;
import config.menu.RootMenuConfig;
import javax.swing.JLabel;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpEmptyConfig {
    
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
        RootMenuConfig.EmpDb();
        /**
         * End -> go back to database
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> delete data from tables except root
     */
    public static void Empty (Dialog dialog) {
        String id, sql;
        id = UserLog.getId();
        sql = "DELETE "
                + "tbl_person, tbl_user, tbl_user_sso "
            + "FROM "
                + "tbl_person, tbl_user, tbl_user_sso "
            + "WHERE "
                + "tbl_person.id_user = tbl_user.id AND "
                + "tbl_user_sso.id_user = tbl_user.id AND "
                + "tbl_user.id != '"+ id +"';";
        
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
             * Start -> go back to the options
             */
            RootMenuConfig.EmpOptions();
            /**
             * End -> go back to the options
             */
        }
    }
    /**
     * End -> delete data from tables except root
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
