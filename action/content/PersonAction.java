/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.content;

import config.content.PersonConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class PersonAction {
    
    public static void Close (
        JButton buttonClose, final Dialog dialog
    ) {
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonConfig.Close(dialog);
            }
        });
    }
    
}
