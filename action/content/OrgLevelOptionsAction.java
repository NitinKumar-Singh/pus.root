/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import com.lib.palette.button;
import com.lib.palette.link;
import com.lib.views.ViewDialog;
import config.content.OrgLevelOptionsConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class OrgLevelOptionsAction {
    
    public static void Close (
        link linkClose, final Dialog dialog
    ) {
        linkClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ViewDialog.CloseDialog(dialog);
            }
        });
    }
    
    public static void New (
        button buttonNew, final Dialog dialog
    ) {
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrgLevelOptionsConfig.OpenNewInput(dialog);
            }
        });
    }
    
    public static void ViewDatabase (
        button buttonDatabase, final Dialog dialog
    ) {
        buttonDatabase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrgLevelOptionsConfig.OpenDatabase(dialog);
            }
        });
    }
    
}
