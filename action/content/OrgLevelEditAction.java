/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import config.content.OrgLevelEditConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class OrgLevelEditAction {
    
    public static void Close (
        JButton buttonCancel, final Dialog dialog
    ) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrgLevelEditConfig.Close(dialog);
            }
        });
    }
    
    public static void Update (
        JButton buttonUpdate,
        final Dialog dialog, final JTextField textID,
        final JTextField textJabatan, final JEditorPane textKeterangan
    ) {
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrgLevelEditConfig.Update(
                    dialog, textID, textJabatan, textKeterangan
                );
            }
        });
    }
    
}
