/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import com.lib.palette.link;
import config.content.BankDbConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JMenuItem;
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
public class BankDbAction {
    
    public static void Close (
        JButton buttonClose, final Dialog dialog
    ) {
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankDbConfig.Close(dialog);
            }
        });
    }
    
    public static void Delete (
        JMenuItem miDelete,
        final JTable table, final JTextField textSearch, final link linkStatus
    ) {
        miDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankDbConfig.Delete(table, textSearch, linkStatus);
            }
        });
    }
    
    public static void Edit (
        JMenuItem miEdit, final Dialog dialog
    ) {
        miEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankDbConfig.Edit(dialog);
            }
        });
    }
    
    public static void Empty (
        link linkEmpty, final Dialog dialog
    ) {
        linkEmpty.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BankDbConfig.Empty(dialog);
            }
        });
    }
    
    public static void PopupTable (
        JPopupMenu popupTable,
        final JTable table, final JMenuItem miEdit,
        final JMenuItem miDelete, final JMenuItem miBlocked
    ) {
        popupTable.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                BankDbConfig.PopupTable(table, miEdit, miDelete, miBlocked);
            }
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });
    }
    
    public static void Refresh (
        JButton buttonRefresh,
        final JTable table, final JTextField textSearch, final link linkStatus
    ) {
        buttonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankDbConfig.Refresh(table, textSearch, linkStatus);
            }
        });
    }
    
    public static void Refresh (
        JMenuItem miRefresh,
        final JTable table, final JTextField textSearch, final link linkStatus
    ) {
        miRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankDbConfig.Refresh(table, textSearch, linkStatus);
            }
        });
    }
    
    public static void Search (
        JButton buttonSearch,
        final JTable table, final JTextField textSearch, final link linkStatus
    ) {
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankDbConfig.Search(table, textSearch, linkStatus);
            }
        });
    }
    
}
