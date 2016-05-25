/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.UserActivityLog;
import com.lib.modules.SQLAdapter;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class EmpChangeDinasConfig {
    
    /**
     * Start -> set fields
     */
    private static ResultSet resultSet;
    /**
     * End -> set fields
     */
    
    /**
     * Start -> set title
     */
    private static void AddTitle (JLabel labelTitle) {
        String value, kelamin, icon;
        value = MessageLog.getTitle();
        kelamin = UserActivityLog.getKelamin();
        
        switch (kelamin) {
            case ViewIDE.female:
                icon = ViewIDE.female_url_icon;
                break;
            default:
                icon = ViewIDE.male_url_icon;
                break;
        }
        
        labelTitle.setIcon(new ImageIcon(
            labelTitle.getClass().getResource(icon)
        ));
        labelTitle.setText(value);
    }
    /**
     * End -> set title
     */
    
    /**
     * Start -> close
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
         * Start -> go back to the database
         */
        RootMenuConfig.EmpDb();
        /**
         * End -> go back to the database
         */
    }
    /**
     * End -> close
     */
    
    /**
     * Start -> get data
     */
    private static void GetData (
        JTextField textNama, JComboBox<String> comboDinas
    ) {
        String nama, dinas;
        nama = UserActivityLog.getNama();
        dinas = UserActivityLog.getDinas();
        
        textNama.setText(nama);
        comboDinas.setSelectedItem(dinas);
        SetDinas(comboDinas);
        textNama.requestFocus();
    }
    /**
     * End -> get data
     */
    
    /**
     * Start -> load dinas
     */
    private static void LoadDinas (JComboBox<String> comboDinas) {
        comboDinas.removeAllItems();
        comboDinas.addItem("Pilih");
        
        String dinas_unk_id, sql;
        dinas_unk_id = ViewIDE.id_dinas;
        sql = "SELECT "
                + "dinas AS `Dinas` "
            + "FROM "
                + "tbl_dinas "
            + "WHERE "
                + "id != '"+ dinas_unk_id +"';";
        
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
     * End -> load dinas
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle, JTextField textNama, JComboBox<String> comboDinas
    ) {
        AddTitle(labelTitle);
        LoadDinas(comboDinas);
        GetData(textNama, comboDinas);
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set dinas
     */
    public static void SetDinas (JComboBox<String> comboDinas) {
        Integer index;
        index = comboDinas.getSelectedIndex();
        
        switch (index) {
            case 0:
                /**
                 * No action required
                 */
                break;
            default:
                String dinas;
                dinas = String.valueOf(comboDinas.getSelectedItem());
                
                UserActivityLog.setDinas(dinas);
                
                SetDinasID();
                break;
        }
    }
    /**
     * End -> set dinas
     */
    
    /**
     * Start -> set dinas id
     */
    private static void SetDinasID () {
        String dinas, sql;
        dinas = UserActivityLog.getDinas();
        sql = "SELECT "
                + "id AS `Dinas ID` "
            + "FROM "
                + "tbl_dinas "
            + "WHERE "
                + "dinas = '"+ dinas +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                String DinasID;
                DinasID = resultSet.getString("Dinas ID");
                
                UserActivityLog.setDinasID(DinasID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> set dinas id
     */
    
    /**
     * Start -> update
     */
    public static void Update (
        Dialog dialog, JTextField textNama, JComboBox<String> comboDinas
    ) {
        String message;
        if (textNama.getText().isEmpty() == true ||
            comboDinas.getSelectedIndex() == 0
        ) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            String nama, DinasID, nip, sql;
            nama = textNama.getText();
            DinasID = UserActivityLog.getDinasID();
            nip = UserActivityLog.getNip();
            sql = "UPDATE "
                    + "tbl_person "
                + "SET "
                    + "nama = '"+ nama +"', "
                    + "id_dinas = '"+ DinasID +"' "
                + "WHERE "
                    + "nip = '"+ nip +"';";
            
            Integer operation;
            operation = SQLAdapter.dataOperation(1, sql);
            
            if (operation == 1) {
                /**
                 * Start -> message
                 */
                message = ViewIDE.pesan_info_update_success_default;
                Pesan.Information(message);
                /**
                 * End -> message
                 */
                
                /**
                 * Start -> close
                 */
                Close(dialog);
                /**
                 * End -> close
                 */
            }
        }
    }
    /**
     * End -> update
     */
    
}
