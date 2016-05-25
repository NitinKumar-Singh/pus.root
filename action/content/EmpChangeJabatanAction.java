/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import config.content.EmpChangeJabatanConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpChangeJabatanAction {
    
    public static void Close (
        JButton buttonCancel, final Dialog dialog
    ) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpChangeJabatanConfig.Close(dialog);
            }
        });
    }
    
    public static void SetJabatan (
        final JComboBox<String> comboJabatan
    ) {
        comboJabatan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpChangeJabatanConfig.SetJabatan(comboJabatan);
            }
        });
    }
    
    public static void Update (
        JButton buttonUpdate, final Dialog dialog,
        final JTextField textNama, final JComboBox<String> comboJabatan
    ) {
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpChangeJabatanConfig.Update(dialog, textNama, comboJabatan);
            }
        });
    }
    
}
