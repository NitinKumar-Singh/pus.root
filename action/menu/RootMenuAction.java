/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.menu;

import com.lib.palette.button;
import config.menu.RootMenuConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Fadhli
 */
public class RootMenuAction {
    
    public static void BankOptions (
        button buttonDaftarPerbankan
    ) {
        buttonDaftarPerbankan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootMenuConfig.BankOptions();
            }
        });
    }
    
    public static void ChangePassword (
        button buttonChangePassword
    ) {
        buttonChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootMenuConfig.ChangePassword();
            }
        });
    }
    
    public static void Doc (
        button buttonDaftarDokterBidan
    ) {
        buttonDaftarDokterBidan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootMenuConfig.Doc();
            }
        });
    }
    
    public static void EmpOptions (
        button buttonDaftarPegawai
    ) {
        buttonDaftarPegawai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootMenuConfig.EmpOptions();
            }
        });
    }
    
    public static void OrgLevelOptions (
        button buttonDaftarTingkatOrganisasi
    ) {
        buttonDaftarTingkatOrganisasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootMenuConfig.OrgLevelOptions();
            }
        });
    }
    
    public static void ServiceCostOptions (
        button buttonDaftarHargaLayanan
    ) {
        buttonDaftarHargaLayanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RootMenuConfig.ServiceCostOptions();
            }
        });
    }
    
}
