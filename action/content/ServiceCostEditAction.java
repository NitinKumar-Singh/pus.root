/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import com.lib.palette.NumericTextField;
import config.content.ServiceCostEditConfig;
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
public class ServiceCostEditAction {
    
    public static void Close (
        JButton buttonCancel, final Dialog dialog
    ) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceCostEditConfig.Close(dialog);
            }
        });
    }
    
    public static void Price (final NumericTextField textHarga) {
        textHarga.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                ServiceCostEditConfig.PriceToLong(textHarga);
            }
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                ServiceCostEditConfig.PriceToString(textHarga);
            }
        });
    }
    
    public static void Update (
        JButton buttonUpdate, final Dialog dialog,
        final JTextField textLayanan, final JTextField textHarga
    ) {
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceCostEditConfig.Update(dialog, textLayanan, textHarga);
            }
        });
    }
    
}
