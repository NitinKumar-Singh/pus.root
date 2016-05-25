/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.ChooserLog;
import com.lib.logs.MessageLog;
import com.lib.logs.UserActivityLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Pesan;
import com.lib.views.ViewChooser;
import com.lib.views.ViewDate;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import com.lib.views.ViewPanel;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpNewConfig {
    
    /**
     * Start -> set fields
     */
    private static ResultSet resultSet;
    /**
     * End -> set fields
     */
    
    /**
     * Start -> set panel
     */
    private static void AddPanel (
        JPanel PanelMaster, JPanel panel, JTextField text
    ) {
        ViewPanel.AddPanel(PanelMaster, panel);
        text.requestFocus();
    }
    /**
     * End -> set panel
     */
    
    /**
     * Start -> set title
     */
    private static void AddTitle (JLabel labelTitle) {
        String value;
        value = MessageLog.getTitle();
        labelTitle.setText(value);
    }
    /**
     * End -> set title
     */
    
    /**
     * Start -> set auto generate nip
     */
    private static void AutoGenerateNIP () {
        /**
         * Start -> count person
         */
        CountPerson();
        /**
         * End -> count person
         */
        
        Integer count, countIncrement;
        count = UserActivityLog.getCount();
        countIncrement = count + 1;
        
        String nipAutoGenerateID, nipToday;
        nipToday = UserActivityLog.getNipToday();
        if (count == 0) {
            nipAutoGenerateID = nipToday + "000" + countIncrement;
        } else {
            MaxPerson();
            
            Integer max, maxIncrement;
            max = UserActivityLog.getMax();
            maxIncrement = max + 1;
            
            if (max >= 1 && max < 10) {
                nipAutoGenerateID = nipToday + "000" + maxIncrement;
            } else {
                if (max >= 10 && max < 100) {
                    nipAutoGenerateID = nipToday + "00" + maxIncrement;
                } else {
                    if (max >= 100 && max < 1000) {
                        nipAutoGenerateID = nipToday + "0" + maxIncrement;
                    } else {
                        if (max >= 1000 && max < 10000) {
                            nipAutoGenerateID = nipToday + maxIncrement;
                        } else {
                            nipAutoGenerateID = "";
                        }
                    }
                }
            }
        }
        
        UserActivityLog.setNipAutoGenerateID(nipAutoGenerateID);
    }
    /**
     * End -> set auto generate nip
     */
    
    /**
     * Start -> go back to the panel info
     */
    public static void Back (
        Dialog dialog,
        JPanel PanelMaster, JPanel PanelInfo, JTextField textNama
    ) {
        AddPanel(PanelMaster, PanelInfo, textNama);
        
        /**
         * Start -> set dialog size
         */
        ViewDialog.SetDialog(dialog, 350, 490);
        /**
         * End -> set dialog size
         */
    }
    /**
     * End -> go back to the panel info
     */
    
    /**
     * Start -> check ktp
     */
    private static void CheckKTP (
        Dialog dialog, JPanel PanelMaster, JPanel PanelID, JTextField textID
    ) {
        String ktp, message, sql;
        ktp = UserActivityLog.getKtp();
        sql = "SELECT "
                + "no_ktp AS `No. KTP` "
            + "FROM "
                + "tbl_person "
            + "WHERE "
                + "no_ktp = '"+ ktp +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                message = ViewIDE.pesan_warning_incorrect_ktp;
                Pesan.Warning(message);
            } else {
                /**
                 * Note : if no fail, page will go to the next.
                 */
                
                /**
                 * Start -> next form
                 */
                Next(dialog, PanelMaster, PanelID, textID);
                /**
                 * End -> next form
                 */
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> check ktp
     */
    
    /**
     * Start -> check login id or username
     */
    private static void CheckUsername (Dialog dialog) {
        String id, message, sql;
        id = UserActivityLog.getId();
        sql = "SELECT "
                + "id AS `ID` "
            + "FROM "
                + "tbl_user "
            + "WHERE "
                + "id = '"+ id +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                message = ViewIDE.pesan_warning_incorrect_id;
                Pesan.Warning(message);
            } else {
                /**
                 * Note : if no fail, system will save data.
                 */
                
                /**
                 * Start -> save data into tbl_user
                 */
                Save_to_tblUser(dialog);
                /**
                 * End -> save data into tbl-user
                 */
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> check login id or username
     */
    
    /**
     * Start -> close current page
     */
    public static void Close (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> go back to the options
         */
        RootMenuConfig.EmpOptions();
        /**
         * End -> go back to the options
         */
    }
    /**
     * End -> close current page
     */
    
    /**
     * Start -> count person
     */
    private static void CountPerson () {
        String nipToday, ClassName, var;
        
        /**
         * Start -> set date options
         */
        ClassName = "UserActivityLog";
        var = "nipToday";
        ViewDate.DateOptions(var, ClassName);
        /**
         * End -> set date options
         */
        
        nipToday = UserActivityLog.getNipToday();
        
        String sql;
        sql = "SELECT "
                + "COUNT(nip) AS `Count NIP` "
            + "FROM "
                + "tbl_person "
            + "WHERE "
                + "LEFT(nip, 8) LIKE '%"+ nipToday +"%';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                Integer count;
                count = resultSet.getInt("Count NIP");
                
                UserActivityLog.setCount(count);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> count person
     */
    
    /**
     * Start -> load data of official into combo box
     */
    private static void LoadOfficial (JComboBox<String> comboDinas) {
        comboDinas.removeAllItems();
        comboDinas.addItem("Pilih");
        
        String id_unknown, unknown_dinas, sql;
        id_unknown = ViewIDE.id_dinas;
        unknown_dinas = ViewIDE.dinas;
        sql = "SELECT "
                + "dinas AS `Dinas` "
            + "FROM "
                + "tbl_dinas "
            + "WHERE "
                + "id != '"+ id_unknown +"' OR "
                + "dinas != '"+ unknown_dinas +"' "
            + "ORDER BY "
                + "dinas ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                String dinas;
                dinas = resultSet.getString("Dinas");
                
                comboDinas.addItem(dinas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> load data of official into combo box
     */
    
    /**
     * Start -> load data of organization level into combo box
     */
    private static void LoadOrganizationLevel (
        JComboBox<String> comboJabatan
    ) {
        comboJabatan.removeAllItems();
        comboJabatan.addItem("Pilih");
        
        String unknown_id, unknown_jabatan, sql;
        unknown_id = ViewIDE.jabatan_id;
        unknown_jabatan = ViewIDE.jabatan;
        sql = "SELECT "
                + "jabatan AS `Jabatan` "
            + "FROM "
                + "tbl_jabatan "
            + "WHERE "
                + "id != '"+ unknown_id +"' OR "
                + "jabatan != '"+ unknown_jabatan +"' "
            + "ORDER BY "
                + "jabatan ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                String jabatan;
                jabatan = resultSet.getString("Jabatan");
                
                comboJabatan.addItem(jabatan);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> load data of organization level into combo box
     */
    
    /**
     * Start -> load data of user level into combo box
     */
    private static void LoadUserLevel (JComboBox<String> comboLevel) {
        comboLevel.removeAllItems();
        comboLevel.addItem("Pilih");
        
        String id_root, id_unknown, sql;
        id_root = ViewIDE.level_id_root;
        id_unknown = ViewIDE.id_level;
        sql = "SELECT "
                + "level AS `Level` "
            + "FROM "
                + "tbl_user_level "
            + "WHERE "
                + "id != '"+ id_root +"' AND "
                + "id != '"+ id_unknown +"' "
            + "ORDER BY "
                + "level ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                String level;
                level = resultSet.getString("Level");
                
                comboLevel.addItem(level);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> load data of user level into combo box
     */
    
    /**
     * Start -> get max person
     */
    private static void MaxPerson () {
        String nipToday;
        nipToday = UserActivityLog.getNipToday();
        
        String sql;
        sql = "SELECT "
                + "MAX(RIGHT(nip, 4)) AS `Max NIP` "
            + "FROM "
                + "tbl_person "
            + "WHERE "
                + "LEFT(nip, 8) LIKE '%"+ nipToday +"%';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                Integer max;
                max = resultSet.getInt("Max NIP");
                
                UserActivityLog.setMax(max);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> get max person
     */
    
    /**
     * Start -> set next
     */
    public static void Next (
        Dialog dialog,
        JPanel PanelMaster, JPanel PanelID, JTextField textID,
        JTextField textKTP, JTextField textNama,
        JRadioButton radioLakilaki, JRadioButton radioPerempuan,
        JComboBox<String> comboDinas, JComboBox<String> comboJabatan
    ) {
        String message;
        String ktp, nama;
        Integer iDinas, iJabatan;
        
        ktp = textKTP.getText();
        nama = textNama.getText();
        iDinas = comboDinas.getSelectedIndex();
        iJabatan = comboJabatan.getSelectedIndex();
        
        if (ktp.isEmpty() == true || nama.isEmpty() == true ||
            (radioLakilaki.isSelected() == false &&
            radioPerempuan.isSelected() == false) ||
            iDinas.equals(0) == true || iJabatan.equals(0) == true
        ) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            /**
             * Start -> set variables
             */
            UserActivityLog.setKtp(ktp);
            UserActivityLog.setNama(nama);
            /**
             * End -> set variables
             */
            
            /**
             * Start -> check ktp
             */
            CheckKTP(dialog, PanelMaster, PanelID, textID);
            /**
             * End -> check ktp
             */
        }
    }
    /**
     * End -> set next
     */
    
    /**
     * Start -> set next
     */
    private static void Next (
        Dialog dialog, JPanel PanelMaster, JPanel PanelID, JTextField textID
    ) {
        AddPanel(PanelMaster, PanelID, textID);
        
        /**
         * Start -> set dialog size
         */
        ViewDialog.SetDialog(dialog, 350, 380);
        /**
         * End -> set dialog size
         */
    }
    /**
     * End -> set next
     */
    
    /**
     * Start -> save reg. emp
     */
    public static void  Save (
        Dialog dialog, JTextField textID,
        JPasswordField textPassword, JComboBox<String> comboLevel
    ) {
        String message;
        String id, password;
        Integer iLevel;
        
        id = textID.getText();
        password = String.valueOf(textPassword.getPassword());
        iLevel = comboLevel.getSelectedIndex();
        
        if (id.isEmpty() == true ||
            password.isEmpty() == true ||
            iLevel.equals(0) == true
        ) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            /**
             * Start -> set variable
             */
            UserActivityLog.setId(id);
            UserActivityLog.setPassword(password);
            /**
             * End -> set variable
             */
            
            /**
             * Start -> check login id or username
             */
            CheckUsername(dialog);
            /**
             * End -> check login id or username
             */
        }
    }
    /**
     * End -> save reg. emp
     */
    
    /**
     * Start -> save data into tbl_person
     */
    private static void Save_to_tblPerson (Dialog dialog) {
        String nip, ktp, nama, kelamin, id_user, id_dinas, id_jabatan, sql;
        nip = UserActivityLog.getNip();
        ktp = UserActivityLog.getKtp();
        nama = UserActivityLog.getNama();
        kelamin = UserActivityLog.getKelamin();
        id_user = UserActivityLog.getId();
        id_dinas = UserActivityLog.getDinasID();
        id_jabatan = UserActivityLog.getJabatanID();
        sql = "INSERT INTO "
            + "tbl_person"
            + "("
                + "nip, no_ktp, nama, kelamin, "
                + "id_user, id_dinas, id_jabatan"
            + ") "
            + "VALUES"
            + "("
                + "'"+ nip +"', '"+ ktp +"', '"+ nama +"', '"+ kelamin +"', "
                + "'"+ id_user +"', '"+ id_dinas +"', '"+ id_jabatan +"'"
            + ");";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            /**
             * Start -> save data into tbl_user_sso
             */
            Save_to_tblUserSSO(dialog);
            /**
             * End -> save data into tbl_user_sso
             */
        }
    }
    /**
     * End -> save data into tbl_person
     */
    
    /**
     * Start -> save data into tbl_user
     */
    private static void Save_to_tblUser (Dialog dialog) {
        String id, password, levelID, sql;
        id = UserActivityLog.getId();
        password = UserActivityLog.getPassword();
        levelID = UserActivityLog.getLevelID();
        sql = "INSERT INTO "
                + "tbl_user(id, pass1, pass2, id_level) "
            + "VALUES"
            + "("
                + "'"+ id +"', "
                + "PASSWORD('"+ password +"'), "
                + "'"+ password +"', "
                + "'"+ levelID +"'"
            + ");";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            /**
             * Start -> save data into tbl_person
             */
            Save_to_tblPerson(dialog);
            /**
             * End -> save data into tbl_person
             */
        }
    }
    /**
     * End -> save data into tbl_user
     */
    
    /**
     * Start -> save into tbl_user_sso
     */
    private static void Save_to_tblUserSSO (Dialog dialog) {
        String ClassName, id, tglRegistrasi, dRegistrasi, tanggal;
        String message, sql;
        
        ClassName = "UserActivityLog";
        id = UserActivityLog.getId();
        
        ViewDate.DateOptions("tglRegistrasi", ClassName);
        tglRegistrasi = UserActivityLog.getTglRegistrasi();
        
        ViewDate.DateOptions("dRegistrasi", ClassName);
        dRegistrasi = UserActivityLog.getdRegistrasi();
        tanggal = dRegistrasi;
        
        sql = "INSERT INTO "
                + "tbl_user_sso(id_user, tgl_reg, d_reg, tanggal) "
            + "VALUES"
            + "("
                + "'"+ id +"', "
                + "'"+ tglRegistrasi +"', "
                + "'"+ dRegistrasi +"', "
                + "'"+ tanggal +"'"
            + ")";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            message = ViewIDE.pesan_info_signup_success;
            Pesan.Information(message);
            
            /**
             * Start -> go back to the options
             */
            Close(dialog);
            /**
             * End -> go back to the options
             */
        }
    }
    /**
     * End -> save into tbl_user_sso
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        Dialog dialog,
        JPanel PanelMaster, JPanel PanelInfo, JTextField textNama,
        JLabel labelTitle, JComboBox<String> comboDinas,
        JComboBox<String> comboJabatan, JComboBox<String> comboLevel
    ) {
        AddTitle(labelTitle);
        AddPanel(PanelMaster, PanelInfo, textNama);
        
        /**
         * Start -> generate nip
         */
        AutoGenerateNIP();
        
        String nip, nipAutoGenerateID;
        nipAutoGenerateID = UserActivityLog.getNipAutoGenerateID();
        
        if (nipAutoGenerateID.isEmpty() == true) {
            WarningRegistrationFull(dialog);
        } else {
            nip = nipAutoGenerateID;
            
            /**
             * Start -> set variable
             */
            UserActivityLog.setNip(nip);
            /**
             * End -> set variable
             */
            
            /**
             * Start -> load data into combo box
             */
            LoadOfficial(comboDinas);
            LoadOrganizationLevel(comboJabatan);
            LoadUserLevel(comboLevel);
            /**
             * End -> load data into combo box
             */
        }
        /**
         * End -> generate nip
         */
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set gender
     */
    public static void SetGender (
        Boolean confirm,
        JRadioButton radioLakilaki, JRadioButton radioPerempuan
    ) {
        /**
         * Start -> set class name
         */
        String ClassName;
        ClassName = "UserActivityLog";
        
        ChooserLog.setClassName(ClassName);
        /**
         * End -> set class name
         */
        
        ViewChooser.Gender(confirm, radioLakilaki, radioPerempuan);
    }
    /**
     * End -> set gender
     */
    
    /**
     * Start -> set official
     */
    public static void SetOfficial (JComboBox<String> comboDinas) {
        Integer index;
        index = comboDinas.getSelectedIndex();
        
        switch (index) {
            case 0:
                /**
                 * No action
                 */
                break;
            default:
                String dinas;
                dinas = String.valueOf(comboDinas.getSelectedItem());
                
                /**
                 * Start -> set variable
                 */
                UserActivityLog.setDinas(dinas);
                /**
                 * End -> set variable
                 */
                
                /**
                 * Start -> get & set official id
                 */
                SetOfficialID();
                /**
                 * End -> get & set official id
                 */
                break;
        }
    }
    /**
     * End -> set official
     */
    
    /**
     * Start -> set official id
     */
    private static void SetOfficialID () {
        String dinas, sql;
        dinas = UserActivityLog.getDinas();
        sql = "SELECT "
                + "id AS `ID` "
            + "FROM "
                + "tbl_dinas "
            + "WHERE "
                + "dinas = '"+ dinas +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                String dinasID;
                dinasID = resultSet.getString("ID");
                
                UserActivityLog.setDinasID(dinasID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> set official id
     */
    
    /**
     * Start -> set organization level
     */
    public static void SetOrgLevel (JComboBox<String> comboJabatan) {
        Integer index;
        index = comboJabatan.getSelectedIndex();
        
        switch (index) {
            case 0:
                /**
                 * No action
                 */
                break;
            default:
                String jabatan;
                jabatan = String.valueOf(comboJabatan.getSelectedItem());
                
                /**
                 * Start -> set variable
                 */
                UserActivityLog.setJabatan(jabatan);
                /**
                 * End -> set variable
                 */
                
                /**
                 * Start -> get & set organization level id
                 */
                SetOrgLevelID();
                /**
                 * End -> get & set organization level id
                 */
                break;
        }
    }
    /**
     * End -> set organization level
     */
    
    /**
     * Start -> set organization level id
     */
    private static void SetOrgLevelID () {
        String jabatan, sql;
        jabatan = UserActivityLog.getJabatan();
        sql = "SELECT "
                + "id AS `ID` "
            + "FROM "
                + "tbl_jabatan "
            + "WHERE "
                + "jabatan = '"+ jabatan +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                String jabatanID;
                jabatanID = resultSet.getString("ID");
                
                UserActivityLog.setJabatanID(jabatanID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> set organization level id
     */
    
    /**
     * Start -> set user level
     */
    public static void SetUserLevel (JComboBox<String> comboLevel) {
        Integer index;
        index = comboLevel.getSelectedIndex();
        
        switch (index) {
            case 0:
                /**
                 * No action
                 */
                break;
            default:
                String level;
                level = String.valueOf(comboLevel.getSelectedItem());
                
                /**
                 * Start -> set variable
                 */
                UserActivityLog.setLevel(level);
                /**
                 * End -> set variable
                 */
                
                /**
                 * Start -> get & set user level id
                 */
                SetUserLevelID();
                /**
                 * End -> get & set user level id
                 */
                break;
        }
    }
    /**
     * End -> set user level
     */
    
    /**
     * Start -> set user level id
     */
    private static void SetUserLevelID () {
        String level, sql;
        level = UserActivityLog.getLevel();
        sql = "SELECT "
                + "id AS `ID` "
            + "FROM "
                + "tbl_user_level "
            + "WHERE "
                + "level = '"+ level +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                String levelID;
                levelID = resultSet.getString("ID");
                
                UserActivityLog.setLevelID(levelID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> set user level id
     */
    
    /**
     * Start -> registration full and show the notice
     */
    private static void WarningRegistrationFull (Dialog dialog) {
        String message;
        message = ViewIDE.pesan_warning_signup_full;
        Pesan.Warning(message);
        
        /**
         * Start -> close reg. dialog
         */
        Close(dialog);
        /**
         * End -> close reg. dialog
         */
    }
    /**
     * End -> registration full and show the notice
     */
    
}
