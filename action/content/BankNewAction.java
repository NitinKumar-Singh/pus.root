/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import config.content.BankNewConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class BankNewAction {
    
    public static void Close (
        JButton buttonCancel, final Dialog dialog
    ) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankNewConfig.Close(dialog);
            }
        });
    }
    
    public static void Save (
        JButton buttonSave,
        final Dialog dialog, final JTextField textID,
        final JTextField textNama, final JTextField textKota,
        final JTextField textKontak, final JTextField textAlamat
    ) {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankNewConfig.Save(
                    dialog, textID, textNama,
                    textKota, textKontak, textAlamat
                );
            }
        });
    }
    
}
