/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.menu;

import com.alee.laf.WebLookAndFeel;
import com.lib.logs.DialogLog;
import com.lib.logs.MessageLog;
import com.lib.views.ViewIDE;
import design.dialog.RootDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Fadhli
 */
public class RootMenuConfig {
    
    /**
     * Start -> change password
     */
    public static void ChangePassword () {
        String OpenPanel, title;
        OpenPanel = "ChangePassword";
        title = "Change Password";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> change password
     */
    
    /**
     * Start -> open db dokter and bidan
     */
    public static void Doc () {
        String OpenPanel, title;
        OpenPanel = "Doc";
        title = "Daftar Dokter & Bidan";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> open db dokter and bidan
     */
    
    /**
     * Start -> return all data about dokter and bidan to default or unknown
     */
    public static void DocEmpty () {
        String OpenPanel, message, title;
        OpenPanel = "DocEmpty";
        title = "Empty Table";
        message = ViewIDE.pesan_question_doc_empty;
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setMessage(message);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> return all data about dokter and bidan to default or unknown
     */
    
    /**
     * Start -> edit dinas of emp.
     */
    public static void EmpChangeDinas () {
        String OpenPanel, title;
        OpenPanel = "EmpChangeDinas";
        title = "Edit Pegawai";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> edit dinas of emp.
     */
    
    /**
     * Start -> edit jabatan of emp.
     */
    public static void EmpChangeJabatan () {
        String OpenPanel, title;
        OpenPanel = "EmpChangeJabatan";
        title = "Edit Pegawai";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> edit jabatan of emp.
     */
    
    /**
     * Start -> open database of employer
     */
    public static void EmpDb () {
        String OpenPanel, title;
        OpenPanel = "EmpDb";
        title = "Daftar Pegawai";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> open database of employer
     */
    
    /**
     * Start -> edit employer
     */
    public static void EmpEdit () {
        String OpenPanel, title;
        OpenPanel = "EmpEdit";
        title = "Edit Pegawai";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> edit employer
     */
    
    /**
     * Start -> empty employer
     */
    public static void EmpEmpty () {
        String OpenPanel, message, title;
        OpenPanel = "EmpEmpty";
        title = "Empty Table";
        message = ViewIDE.pesan_question_emp_empty;
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setMessage(message);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> empty employer
     */
    
    /**
     * Start -> new employer
     */
    public static void EmpNew () {
        String OpenPanel, title;
        OpenPanel = "EmpNew";
        title = "Reg. Pegawai";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> new employer
     */
    
    /**
     * Start -> employer options
     */
    public static void EmpOptions () {
        String OpenPanel, title;
        OpenPanel = "EmpOptions";
        title = "Pegawai";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogNimbusLookAndFeel();
    }
    /**
     * End -> employer options
     */
    
    /**
     * Start -> open database of organization level
     */
    public static void OrgLevelDb () {
        String OpenPanel, title;
        OpenPanel = "OrgLevelDb";
        title = "Daftar Tingkat Organisasi";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> open database of organization level
     */
    
    /**
     * Start -> edit organization level
     */
    public static void OrgLevelEdit () {
        String OpenPanel, title;
        OpenPanel = "OrgLevelEdit";
        title = "Tingkat Organisasi";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> edit organization level
     */
    
    /**
     * Start -> empty organization level
     */
    public static void OrgLevelEmpty () {
        String OpenPanel, message, title;
        OpenPanel = "OrgLevelEmpty";
        title = "Empty Table";
        message = ViewIDE.pesan_question_org_level_empty;
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setMessage(message);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> empty organization level
     */
    
    /**
     * Start -> new organization level
     */
    public static void OrgLevelNew () {
        String OpenPanel, title;
        OpenPanel = "OrgLevelNew";
        title = "Tingkat Organisasi";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> new organization level
     */
    
    /**
     * Start -> organization level options
     */
    public static void OrgLevelOptions () {
        String OpenPanel, title;
        OpenPanel = "OrgLevelOptions";
        title = "Daftar Tingkat Organisasi";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogNimbusLookAndFeel();
    }
    /**
     * End -> organization level options
     */
    
    /**
     * Start -> person
     */
    public static void Person () {
        String OpenPanel, title;
        OpenPanel = "Person";
        title = "Data Pribadi";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> person
     */
    
    /**
     * Start -> run dialog nimbus look and feel
     */
    private static void RunDialogNimbusLookAndFeel () {
        try {
            NimbusLookAndFeel nimbus;
            nimbus = new NimbusLookAndFeel();
            UIManager.setLookAndFeel(nimbus);
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } finally {
            RootDialog rootDialog;
            rootDialog = new RootDialog();
            rootDialog.setVisible(true);
        }
    }
    /**
     * End -> run dialog nimbus look and feel
     */
    
    /**
     * Start -> run dialog web look and feel
     */
    private static void RunDialogWebLookAndFeel () {
        try {
            WebLookAndFeel web;
            web = new WebLookAndFeel();
            UIManager.setLookAndFeel(web);
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } finally {
            RootDialog rootDialog;
            rootDialog = new RootDialog();
            rootDialog.setVisible(true);
        }
    }
    /**
     * End -> run dialog web look and feel
     */
    
    /**
     * Start -> open database of service cost
     */
    public static void ServiceCostDb () {
        String OpenPanel, title;
        OpenPanel = "ServiceCostDb";
        title = "Daftar Harga & Layanan";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> open database of service cost
     */
    
    /**
     * Start -> edit service cost
     */
    public static void ServiceCostEdit () {
        String OpenPanel, title;
        OpenPanel = "ServiceCostEdit";
        title = "Harga & Layanan";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> edit service cost
     */
    
    /**
     * Start -> empty service cost
     */
    public static void ServiceCostEmpty () {
        String OpenPanel, title;
        OpenPanel = "ServiceCostEmpty";
        title = "Empty Table";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> empty service cost
     */
    
    /**
     * Start -> new service cost
     */
    public static void ServiceCostNew () {
        String OpenPanel, title;
        OpenPanel = "ServiceCostNew";
        title = "Harga & Layanan";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogWebLookAndFeel();
    }
    /**
     * End -> new service cost
     */
    
    /**
     * Start -> service cost options
     */
    public static void ServiceCostOptions () {
        String OpenPanel, title;
        OpenPanel = "ServiceCostOptions";
        title = "Daftar Harga & Layanan";
        
        DialogLog.setOpenPanel(OpenPanel);
        MessageLog.setTitle(title);
        
        RunDialogNimbusLookAndFeel();
    }
    /**
     * End -> service cost options
     */
    
}
