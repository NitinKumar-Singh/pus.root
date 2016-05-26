/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.dialog;

import com.lib.logs.DialogLog;
import com.lib.views.ViewDialog;
import com.lib.views.ViewPanel;
import design.content.BankDb;
import design.content.BankEdit;
import design.content.BankNew;
import design.content.BankOptions;
import design.content.ChangePassword;
import design.content.Doc;
import design.content.DocEmpty;
import design.content.EmpChangeDinas;
import design.content.EmpChangeJabatan;
import design.content.EmpDb;
import design.content.EmpEdit;
import design.content.EmpEmpty;
import design.content.EmpNew;
import design.content.EmpOptions;
import design.content.OrgLevelDb;
import design.content.OrgLevelEdit;
import design.content.OrgLevelEmpty;
import design.content.OrgLevelNew;
import design.content.OrgLevelOptions;
import design.content.Person;
import design.content.ServiceCostDb;
import design.content.ServiceCostEdit;
import design.content.ServiceCostEmpty;
import design.content.ServiceCostNew;
import design.content.ServiceCostOptions;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class RootDialogConfig {
    
    /**
     * Start -> set fields
     */
    private static final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * End -> set fields
     */
    
    /**
     * Start -> open db bank
     */
    private static void OpenBankDb (Dialog dialog, JPanel MainPanel) {
        BankDb bankDb;
        bankDb = new BankDb(dialog);
        ViewPanel.AddPanel(MainPanel, bankDb);
    }
    /**
     * End -> open db bank
     */
    
    /**
     * Start -> open edit form for db_bank
     */
    private static void OpenBankEdit (Dialog dialog, JPanel MainPanel) {
        BankEdit bankEdit;
        bankEdit = new BankEdit(dialog);
        ViewPanel.AddPanel(MainPanel, bankEdit);
    }
    /**
     * End -> open edit form for db_bank
     */
    
    /**
     * Start -> open new entry db_bank
     */
    private static void OpenBankNew (Dialog dialog, JPanel MainPanel) {
        BankNew bankNew;
        bankNew = new BankNew(dialog);
        ViewPanel.AddPanel(MainPanel, bankNew);
    }
    /**
     * End -> open new entry db_bank
     */
    
    /**
     * Start -> open bank's options
     */
    private static void OpenBankOptions (Dialog dialog, JPanel MainPanel) {
        BankOptions bankOptions;
        bankOptions = new BankOptions(dialog);
        ViewPanel.AddPanel(MainPanel, bankOptions);
    }
    /**
     * End -> open bank's options
     */
    
    /**
     * Start -> open change password
     */
    private static void OpenChangePassword (Dialog dialog, JPanel MainPanel) {
        ChangePassword changePassword;
        changePassword = new ChangePassword(dialog);
        ViewPanel.AddPanel(MainPanel, changePassword);
    }
    /**
     * End -> open change password
     */
    
    /**
     * Start -> open db dokter and bidan
     */
    private static void OpenDoc (Dialog dialog, JPanel MainPanel) {
        Doc doc;
        doc = new Doc(dialog);
        ViewPanel.AddPanel(MainPanel, doc);
    }
    /**
     * End -> open db dokter and bidan
     */
    
    /**
     * Start -> open empty permission of dokter and bidan
     */
    private static void OpenDocEmpty (Dialog dialog, JPanel MainPanel) {
        DocEmpty docEmpty;
        docEmpty = new DocEmpty(dialog);
        ViewPanel.AddPanel(MainPanel, docEmpty);
    }
    /**
     * End -> open empty permission of dokter and bidan
     */
    
    /**
     * Start -> open dinas of emp.
     */
    private static void OpenEmpChangeDinas (Dialog dialog, JPanel MainPanel) {
        EmpChangeDinas empChangeDinas;
        empChangeDinas = new EmpChangeDinas(dialog);
        ViewPanel.AddPanel(MainPanel, empChangeDinas);
    }
    /**
     * End -> open dinas of emp.
     */
    
    /**
     * Start -> open jabatan of emp.
     */
    private static void OpenEmpChangeJabatan (Dialog dialog, JPanel MainPanel) {
        EmpChangeJabatan empChangeJabatan;
        empChangeJabatan = new EmpChangeJabatan(dialog);
        ViewPanel.AddPanel(MainPanel, empChangeJabatan);
    }
    /**
     * End -> open jabatan of emp.
     */
    
    /**
     * Start -> open database of employer
     */
    private static void OpenEmpDb (Dialog dialog, JPanel MainPanel) {
        EmpDb empDb;
        empDb = new EmpDb(dialog);
        ViewPanel.AddPanel(MainPanel, empDb);
    }
    /**
     * End -> open database of employer
     */
    
    /**
     * Start -> open edit employer
     */
    private static void OpenEmpEdit (Dialog dialog, JPanel MainPanel) {
        EmpEdit empEdit;
        empEdit = new EmpEdit(dialog);
        ViewPanel.AddPanel(MainPanel, empEdit);
    }
    /**
     * End -> open edit employer
     */
    
    /**
     * Start -> open empty employer
     */
    private static void OpenEmpEmpty (Dialog dialog, JPanel MainPanel) {
        EmpEmpty empEmpty;
        empEmpty = new EmpEmpty(dialog);
        ViewPanel.AddPanel(MainPanel, empEmpty);
    }
    /**
     * End -> open empty employer
     */
    
    /**
     * Start -> open new employer
     */
    private static void OpenEmpNew (Dialog dialog, JPanel MainPanel) {
        EmpNew empNew;
        empNew = new EmpNew(dialog);
        ViewPanel.AddPanel(MainPanel, empNew);
    }
    /**
     * End -> open new employer
     */
    
    /**
     * Start -> open employer options
     */
    private static void OpenEmpOptions (Dialog dialog, JPanel MainPanel) {
        EmpOptions empOptions;
        empOptions = new EmpOptions(dialog);
        ViewPanel.AddPanel(MainPanel, empOptions);
    }
    /**
     * End -> open employer options
     */
    
    /**
     * Start -> open database of organization level
     */
    private static void OpenOrgLevelDb (Dialog dialog, JPanel MainPanel) {
        OrgLevelDb orgLevelDb;
        orgLevelDb = new OrgLevelDb(dialog);
        ViewPanel.AddPanel(MainPanel, orgLevelDb);
    }
    /**
     * End -> open database of organization level
     */
    
    /**
     * Start -> edit organization level
     */
    private static void OpenOrgLevelEdit (Dialog dialog, JPanel MainPanel) {
        OrgLevelEdit orgLevelEdit;
        orgLevelEdit = new OrgLevelEdit(dialog);
        ViewPanel.AddPanel(MainPanel, orgLevelEdit);
    }
    /**
     * End -> edit organization level
     */
    
    /**
     * Start -> empty organization level
     */
    private static void OpenOrgLevelEmpty (Dialog dialog, JPanel MainPanel) {
        OrgLevelEmpty orgLevelEmpty;
        orgLevelEmpty = new OrgLevelEmpty(dialog);
        ViewPanel.AddPanel(MainPanel, orgLevelEmpty);
    }
    /**
     * End -> empty organization level
     */
    
    /**
     * Start -> open new organization level
     */
    private static void OpenOrgLevelNew (Dialog dialog, JPanel MainPanel) {
        OrgLevelNew orgLevelNew;
        orgLevelNew = new OrgLevelNew(dialog);
        ViewPanel.AddPanel(MainPanel, orgLevelNew);
    }
    /**
     * End -> open new organization level
     */
    
    /**
     * Start -> open organization level options
     */
    private static void OpenOrgLevelOptions (Dialog dialog, JPanel MainPanel) {
        OrgLevelOptions orgLevelOptions;
        orgLevelOptions = new OrgLevelOptions(dialog);
        ViewPanel.AddPanel(MainPanel, orgLevelOptions);
    }
    /**
     * End -> open organization level options
     */
    
    /**
     * Start -> open person
     */
    private static void OpenPerson (Dialog dialog, JPanel MainPanel) {
        Person person;
        person = new Person(dialog);
        ViewPanel.AddPanel(MainPanel, person);
    }
    /**
     * End -> open person
     */
    
    /**
     * Start -> open database of service cost
     */
    private static void OpenServiceCostDb (Dialog dialog, JPanel MainPanel) {
        ServiceCostDb serviceCostDb;
        serviceCostDb = new ServiceCostDb(dialog);
        ViewPanel.AddPanel(MainPanel, serviceCostDb);
    }
    /**
     * End -> open database of service cost
     */
    
    /**
     * Start -> open edit service cost
     */
    private static void OpenServiceCostEdit (Dialog dialog, JPanel MainPanel) {
        ServiceCostEdit serviceCostEdit;
        serviceCostEdit = new ServiceCostEdit(dialog);
        ViewPanel.AddPanel(MainPanel, serviceCostEdit);
    }
    /**
     * End -> open edit service cost
     */
    
    /**
     * Start -> open empty service cost
     */
    private static void OpenServiceCostEmpty (Dialog dialog, JPanel MainPanel) {
        ServiceCostEmpty serviceCostEmpty;
        serviceCostEmpty = new ServiceCostEmpty(dialog);
        ViewPanel.AddPanel(MainPanel, serviceCostEmpty);
    }
    /**
     * End -> open empty service cost
     */
    
    /**
     * Start -> open new service cost
     */
    private static void OpenServiceCostNew (Dialog dialog, JPanel MainPanel) {
        ServiceCostNew serviceCostNew;
        serviceCostNew = new ServiceCostNew(dialog);
        ViewPanel.AddPanel(MainPanel, serviceCostNew);
    }
    /**
     * End -> open new service cost
     */
    
    /**
     * Start -> open service cost options
     */
    private static void OpenServiceCostOptions (Dialog dialog, JPanel MainPanel) {
        ServiceCostOptions serviceCostOptions;
        serviceCostOptions = new ServiceCostOptions(dialog);
        ViewPanel.AddPanel(MainPanel, serviceCostOptions);
    }
    /**
     * End -> open service cost options
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        Dialog dialog, JPanel MainPanel
    ) {
        SetWindowConfig(dialog);
        SetPanel(dialog, MainPanel);
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set panel
     */
    private static void SetPanel (Dialog dialog, JPanel MainPanel) {
        String OpenPanel;
        OpenPanel = DialogLog.getOpenPanel();
        
        switch (OpenPanel) {
            case "BankDb":
                OpenBankDb(dialog, MainPanel);
                break;
            case "BankEdit":
                OpenBankEdit(dialog, MainPanel);
                break;
            case "BankNew":
                OpenBankNew(dialog, MainPanel);
                break;
            case "BankOptions":
                OpenBankOptions(dialog, MainPanel);
                break;
            case "ChangePassword":
                OpenChangePassword(dialog, MainPanel);
                break;
            case "Doc":
                OpenDoc(dialog, MainPanel);
                break;
            case "DocEmpty":
                OpenDocEmpty(dialog, MainPanel);
                break;
            case "EmpChangeDinas":
                OpenEmpChangeDinas(dialog, MainPanel);
                break;
            case "EmpChangeJabatan":
                OpenEmpChangeJabatan(dialog, MainPanel);
                break;
            case "EmpDb":
                OpenEmpDb(dialog, MainPanel);
                break;
            case "EmpEdit":
                OpenEmpEdit(dialog, MainPanel);
                break;
            case "EmpEmpty":
                OpenEmpEmpty(dialog, MainPanel);
                break;
            case "EmpNew":
                OpenEmpNew(dialog, MainPanel);
                break;
            case "EmpOptions":
                OpenEmpOptions(dialog, MainPanel);
                break;
            case "OrgLevelDb":
                OpenOrgLevelDb(dialog, MainPanel);
                break;
            case "OrgLevelEdit":
                OpenOrgLevelEdit(dialog, MainPanel);
                break;
            case "OrgLevelEmpty":
                OpenOrgLevelEmpty(dialog, MainPanel);
                break;
            case "OrgLevelNew":
                OpenOrgLevelNew(dialog, MainPanel);
                break;
            case "OrgLevelOptions":
                OpenOrgLevelOptions(dialog, MainPanel);
                break;
            case "Person":
                OpenPerson(dialog, MainPanel);
                break;
            case "ServiceCostDb":
                OpenServiceCostDb(dialog, MainPanel);
                break;
            case "ServiceCostEdit":
                OpenServiceCostEdit(dialog, MainPanel);
                break;
            case "ServiceCostEmpty":
                OpenServiceCostEmpty(dialog, MainPanel);
                break;
            case "ServiceCostNew":
                OpenServiceCostNew(dialog, MainPanel);
                break;
            case "ServiceCostOptions":
                OpenServiceCostOptions(dialog, MainPanel);
                break;
            default:
                break;
        }
    }
    /**
     * End -> set panel
     */
    
    /**
     * Start -> set window config
     */
    private static void SetWindowConfig (Dialog dialog) {
        String OpenPanel;
        OpenPanel = DialogLog.getOpenPanel();
        
        Integer height, width;
        height = dimension.height - (dimension.height/5);
        width = dimension.width - (dimension.width/7);
        
        switch (OpenPanel) {
            case "BankDb":
                ViewDialog.AddAnimationRightToRight(dialog);
                ViewDialog.SetDialog(dialog, width, height);
                break;
            case "BankEdit":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 400, 535);
                break;
            case "BankNew":
                ViewDialog.AddAnimationLeftToLeft(dialog);
                ViewDialog.SetDialog(dialog, 400, 535);
                break;
            case "BankOptions":
                ViewDialog.AddAnimationTopToTop(dialog);
                ViewDialog.SetDialog(dialog, 500, 400);
                break;
            case "ChangePassword":
                ViewDialog.AddAnimationLeftToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 375);
                break;
            case "Doc":
                ViewDialog.AddAnimationLeftToRight(dialog);
                ViewDialog.SetDialog(dialog, width, height);
                break;
            case "DocEmpty":
                ViewDialog.AddAnimationLeftToLeft(dialog);
                ViewDialog.SetDialog(dialog, 450, 400);
                break;
            case "EmpChangeDinas":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 315);
                break;
            case "EmpChangeJabatan":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 315);
                break;
            case "EmpDb":
                ViewDialog.AddAnimationRightToRight(dialog);
                ViewDialog.SetDialog(dialog, width, height);
                break;
            case "EmpEdit":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 675);
                break;
            case "EmpEmpty":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 450, 400);
                break;
            case "EmpNew":
                ViewDialog.AddAnimationLeftToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 490);
                break;
            case "EmpOptions":
                ViewDialog.AddAnimationTopToTop(dialog);
                ViewDialog.SetDialog(dialog, 500, 400);
                break;
            case "OrgLevelDb":
                ViewDialog.AddAnimationRightToRight(dialog);
                ViewDialog.SetDialog(dialog, width, height);
                break;
            case "OrgLevelEdit":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 535);
                break;
            case "OrgLevelEmpty":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 450, 400);
                break;
            case "OrgLevelNew":
                ViewDialog.AddAnimationLeftToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 535);
                break;
            case "OrgLevelOptions":
                ViewDialog.AddAnimationTopToTop(dialog);
                ViewDialog.SetDialog(dialog, 500, 400);
                break;
            case "Person":
                ViewDialog.AddAnimationBottomToTop(dialog);
                ViewDialog.SetDialog(dialog, 722, 527);
                break;
            case "ServiceCostDb":
                ViewDialog.AddAnimationRightToRight(dialog);
                ViewDialog.SetDialog(dialog, width, height);
                break;
            case "ServiceCostEdit":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 315);
                break;
            case "ServiceCostEmpty":
                ViewDialog.AddAnimationRightToLeft(dialog);
                ViewDialog.SetDialog(dialog, 450, 400);
                break;
            case "ServiceCostNew":
                ViewDialog.AddAnimationLeftToLeft(dialog);
                ViewDialog.SetDialog(dialog, 350, 315);
                break;
            case "ServiceCostOptions":
                ViewDialog.AddAnimationTopToTop(dialog);
                ViewDialog.SetDialog(dialog, 500, 400);
                break;
            default:
                break;
        }
    }
    /**
     * End -> set window config
     */
    
}
