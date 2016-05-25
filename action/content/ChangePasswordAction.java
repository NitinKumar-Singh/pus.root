/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import com.lib.views.ViewDialog;
import config.content.ChangePasswordConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class ChangePasswordAction {
    
    public static void Close (
        JButton buttonCancel, final Dialog dialog
    ) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewDialog.CloseDialog(dialog);
            }
        });
    }
    
    public static void Update (
        JButton buttonUpdate,
        final Dialog dialog, final JPasswordField textOldPassword,
        final JPasswordField textNewPassword,
        final JPasswordField textRepeatNewPassword
    ) {
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePasswordConfig.Update(
                    dialog, textOldPassword,
                    textNewPassword, textRepeatNewPassword
                );
            }
        });
    }
    
}
