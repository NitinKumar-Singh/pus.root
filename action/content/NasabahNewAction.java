/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import com.lib.palette.link;
import com.lib.views.ViewIDE;
import config.content.NasabahNewConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class NasabahNewAction {
    
    public static void BackToBrowsePegawai (
        JButton buttonBack1,
        final Dialog dialog, final JPanel PanelMain,
        final JPanel PanelBrowsePegawai, final JTextField textSearch
    ) {
        buttonBack1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NasabahNewConfig.BackToBrowsePegawai(
                    dialog, PanelMain, PanelBrowsePegawai, textSearch
                );
            }
        });
    }
    
    public static void BackToDataPegawai (
        JButton buttonBack2, final Dialog dialog,
        final JPanel PanelMain, final JPanel PanelDataPegawai
    ) {
        buttonBack2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NasabahNewConfig.BackToDataPegawai(
                    dialog, PanelMain, PanelDataPegawai
                );
            }
        });
    }
    
    public static void BackToPanelKantor (
        JButton buttonBack3, final Dialog dialog,
        final JPanel PanelMain, final JPanel PanelKantor
    ) {
        buttonBack3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NasabahNewConfig.BackToPanelKantor(
                    dialog, PanelMain, PanelKantor
                );
            }
        });
    }
    
    public static void Close (
        JMenuItem miClose, final Dialog dialog
    ) {
        miClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NasabahNewConfig.Close(dialog);
            }
        });
    }
    
    public static void GoToDataBank (
        JButton buttonNext2,
        final Dialog dialog,
        final JPanel PanelMain, final JPanel PanelBank,
        final JComboBox<String> comboBank
    ) {
        buttonNext2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NasabahNewConfig.GoToDataBank(
                    dialog, PanelMain, PanelBank, comboBank
                );
            }
        });
    }
    
    public static void GoToPanelKantor (
        JButton buttonNext1,
        final Dialog dialog, final JPanel PanelMain, final JPanel PanelKantor,
        final JLabel labelKantor, final JLabel labelAlamatKantor
    ) {
        buttonNext1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NasabahNewConfig.GoToPanelKantor(
                    dialog,
                    PanelMain, PanelKantor,
                    labelKantor, labelAlamatKantor
                );
            }
        });
    }
    
    public static void PopupTable (
        JPopupMenu popupTable,
        final JTable table, final JMenuItem miUsePegawai,
        final JMenuItem miClose, final JMenuItem miBlocked
    ) {
        popupTable.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                NasabahNewConfig.PopupTable(
                    table, miUsePegawai, miClose, miBlocked
                );
            }
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });
    }
    
    public static void Refresh (
        JMenuItem miRefresh,
        final JTable table, final JTextField textSearch
    ) {
        miRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NasabahNewConfig.Refresh(table, textSearch);
            }
        });
    }
    
    public static void Search (
        link linkSearch,
        final JTable table, final JTextField textSearch
    ) {
        linkSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                NasabahNewConfig.Search(table, textSearch);
            }
        });
    }
    
    public static void Search (
        final JTable table, final JTextField textSearch
    ) {
        textSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                
                int enter, var;
                enter = ViewIDE.keyboard_press_enter;
                var = e.getKeyCode();
                
                if (var == enter) {
                    NasabahNewConfig.Search(table, textSearch);
                }
            }
        });
    }
    
    public static void UseThisEmployer (
        JMenuItem miUsePegawai, final Dialog dialog,
        final JPanel PanelMain, final JPanel PanelDataPegawai,
        final JLabel labelNama, final JLabel labelKelamin,
        final JLabel labelKota, final JLabel labelTglLahir,
        final JLabel labelKontak, final JLabel labelAlamat
    ) {
        miUsePegawai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NasabahNewConfig.UseThisEmployer(
                    dialog, PanelMain, PanelDataPegawai,
                    labelNama, labelKelamin, labelKota,
                    labelTglLahir, labelKontak, labelAlamat
                );
            }
        });
    }
    
}
