/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import config.content.EmpNewConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpNewAction {
    
    public static void Back (
        JButton buttonBack, final Dialog dialog, final JPanel PanelMaster,
        final JPanel PanelInfo, final JTextField textNama
    ) {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.Back(dialog, PanelMaster, PanelInfo, textNama);
            }
        });
    }
    
    public static void Close (
        JButton buttonCancel, final Dialog dialog
    ) {
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.Close(dialog);
            }
        });
    }
    
    public static void Gender (
        final JRadioButton radioLakilaki, final JRadioButton radioPerempuan
    ) {
        radioLakilaki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.SetGender(true, radioLakilaki, radioPerempuan);
            }
        });
        radioPerempuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.SetGender(false, radioLakilaki, radioPerempuan);
            }
        });
    }
    
    public static void Next (
        JButton buttonNext, final Dialog dialog,
        final JPanel PanelMaster, final JPanel PanelID, final JTextField textID,
        final JTextField textKTP, final JTextField textNama,
        final JRadioButton radioLakilaki, final JRadioButton radioPerempuan,
        final JComboBox<String> comboDinas, final JComboBox<String> comboJabatan
    ) {
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.Next(
                    dialog,
                    PanelMaster, PanelID, textID,
                    textKTP, textNama,
                    radioLakilaki, radioPerempuan,
                    comboDinas, comboJabatan
                );
            }
        });
    }
    
    public static void Save (
        JButton buttonSave,
        final Dialog dialog, final JTextField textID,
        final JPasswordField textPassword, final JComboBox<String> comboLevel
    ) {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.Save(dialog, textID, textPassword, comboLevel);
            }
        });
    }
    
    public static void SetOfficial (final JComboBox<String> comboDinas) {
        comboDinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.SetOfficial(comboDinas);
            }
        });
    }
    
    public static void SetOrgLevel (final JComboBox<String> comboJabatan) {
        comboJabatan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.SetOrgLevel(comboJabatan);
            }
        });
    }
    
    public static void SetUserLevel (final JComboBox<String> comboLevel) {
        comboLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpNewConfig.SetUserLevel(comboLevel);
            }
        });
    }
    
}
