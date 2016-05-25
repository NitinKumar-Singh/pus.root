/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import config.content.EmpChangeDinasConfig;
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
public class EmpChangeDinasAction {
    
    public static void Close (
        JButton buttonCancel, final Dialog dialog
    ) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpChangeDinasConfig.Close(dialog);
            }
        });
    }
    
    public static void SetDinas (final JComboBox<String> comboDinas) {
        comboDinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpChangeDinasConfig.SetDinas(comboDinas);
            }
        });
    }
    
    public static void Update (
        JButton buttonUpdate, final Dialog dialog,
        final JTextField textNama, final JComboBox<String> comboDinas
    ) {
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpChangeDinasConfig.Update(dialog, textNama, comboDinas);
            }
        });
    }
    
}
