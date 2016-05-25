/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import com.lib.palette.NumericTextField;
import config.content.ServiceCostNewConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class ServiceCostNewAction {
    
    public static void Close (
        JButton buttonCancel, final Dialog dialog
    ) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceCostNewConfig.Close(dialog);
            }
        });
    }
    
    public static void Price (final NumericTextField textHarga) {
        textHarga.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                ServiceCostNewConfig.PriceToLong(textHarga);
            }
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                ServiceCostNewConfig.PriceToString(textHarga);
            }
        });
    }
    
    public static void Save (
        JButton buttonSave, final Dialog dialog,
        final JTextField textLayanan, final JTextField textHarga
    ) {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceCostNewConfig.Save(dialog, textLayanan, textHarga);
            }
        });
    }
    
}
