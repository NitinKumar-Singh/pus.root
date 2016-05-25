/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.UserLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class ChangePasswordConfig {
    
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
     * Start -> set config
     */
    public static void SetConfig (JLabel labelTitle) {
        AddTitle(labelTitle);
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> update password
     */
    public static void Update (
        Dialog dialog, JPasswordField textOldPassword,
        JPasswordField textNewPassword, JPasswordField textRepeatNewPassword
    ) {
        String message;
        String DefaultPassword, OldPassword, NewPassword, RepeatNewPassword;
        DefaultPassword = UserLog.getPassword();
        OldPassword = String.valueOf(textOldPassword.getPassword());
        NewPassword = String.valueOf(textNewPassword.getPassword());
        RepeatNewPassword = String.valueOf(textRepeatNewPassword.getPassword());
        
        int minPassword, lengthOldPassword;
        int lengthNewPassword, lengthRepeatNewPassword;
        minPassword = ViewIDE.min_password;
        lengthOldPassword = OldPassword.length();
        lengthNewPassword = NewPassword.length();
        lengthRepeatNewPassword = RepeatNewPassword.length();
        
        if (OldPassword.isEmpty() == true || NewPassword.isEmpty() == true ||
            RepeatNewPassword.isEmpty() == true
        ) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            if (lengthOldPassword < minPassword ||
                lengthNewPassword < minPassword ||
                lengthRepeatNewPassword < minPassword
            ) {
                message = ViewIDE.pesan_warning_min_password_length;
                Pesan.Warning(message);
            } else {
                if (OldPassword.equals(DefaultPassword) == true) {
                    if (NewPassword.equals(OldPassword) == true) {
                        message = ViewIDE.pesan_warning_incorrect_new_password;
                        Pesan.Warning(message);
                        
                        textNewPassword.requestFocus();
                    } else {
                        if (RepeatNewPassword.equals(NewPassword) == true) {
                            String password;
                            password = NewPassword;
                            
                            UserLog.setPassword(password);
                            
                            UpdatePassword(dialog);
                        } else {
                            message = ViewIDE.pesan_warning_incorrect_repeated_password;
                            Pesan.Warning(message);
                            
                            textRepeatNewPassword.requestFocus();
                        }
                    }
                } else {
                    message = ViewIDE.pesan_warning_incorrect_old_password;
                    Pesan.Warning(message);
                    
                    textOldPassword.requestFocus();
                }
            }
        }
    }
    /**
     * End -> update password
     */
    
    /**
     * Start -> update new password
     */
    private static void UpdatePassword (Dialog dialog) {
        String id, password, message, sql;
        id = UserLog.getId();
        password = UserLog.getPassword();
        sql = "UPDATE "
                + "tbl_user "
            + "SET "
                + "pass1 = PASSWORD('"+ password +"'), "
                + "pass2 = '"+ password +"' "
            + "WHERE "
                + "id = '"+ id +"';";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            message = ViewIDE.pesan_info_update_password_success;
            Pesan.Information(message);
            
            /**
             * Start -> close active dialog
             */
            ViewDialog.AddAnimationLeftToRight(dialog);
            ViewDialog.CloseDialog(dialog);
            /**
             * End -> close active dialog
             */
        }
    }
    /**
     * End -> update new password
     */
    
}
