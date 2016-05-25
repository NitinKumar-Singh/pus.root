/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import config.content.EmpEditConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpEditAction {
    
    public static void Close (
        JButton buttonClose, final Dialog dialog
    ) {
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpEditConfig.Close(dialog);
            }
        });
    }
    
    public static void Gender (
        final JRadioButton radioLakilaki, final JRadioButton radioPerempuan
    ) {
        radioLakilaki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpEditConfig.SetGender(true, radioLakilaki, radioPerempuan);
            }
        });
        radioPerempuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpEditConfig.SetGender(false, radioLakilaki, radioPerempuan);
            }
        });
    }
    
    public static void Month (final JComboBox<String> comboBulan) {
        comboBulan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpEditConfig.DateMax(comboBulan);
            }
        });
    }
    
    public static void Update (
        JButton buttonUpdate,
        final Dialog dialog, final JTextField textKTP, final JTextField textNama,
        final JRadioButton radioLakilaki, final JRadioButton radioPerempuan,
        final JTextField textKota, final JTextField textTanggal,
        final JComboBox<String> comboBulan, final JTextField textTahun,
        final JTextField textKontak, final JEditorPane textAlamat
    ) {
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpEditConfig.Update(
                    dialog,
                    textKTP, textNama,
                    radioLakilaki, radioPerempuan,
                    textKota, textTanggal, comboBulan, textTahun,
                    textKontak, textAlamat
                );
            }
        });
    }
    
}
