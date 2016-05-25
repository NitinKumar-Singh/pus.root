/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.ServiceCostLog;
import com.lib.logs.UserLog;
import com.lib.modules.SQLAdapter;
import com.lib.palette.NumericTextField;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import com.lib.views.ViewText;
import config.menu.RootMenuConfig;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class ServiceCostNewConfig {
    
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
        String value;
        value = MessageLog.getTitle();
        
        labelTitle.setText(value);
    }
    /**
     * End -> set title
     */
    
    /**
     * Start -> go back to options
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
         * Start -> open service cost options
         */
        RootMenuConfig.ServiceCostOptions();
        /**
         * End -> open service cost options
         */
    }
    /**
     * End -> go back to options
     */
    
    /**
     * Start -> get count of service cost id
     */
    private static void GetCountID () {
        String id, sql;
        id = ViewIDE.service_cost_id;
        sql = "SELECT "
                + "COUNT(id) AS `Count ID` "
            + "FROM "
                + "tbl_layanan "
            + "WHERE "
                + "LEFT(id, 2) LIKE '%"+ id +"%';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                Integer count;
                count = resultSet.getInt("Count ID");
                
                ServiceCostLog.setCount(count);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> get count of service cost id
     */
    
    /**
     * Start -> get service cost id
     */
    private static void GetID (Dialog dialog) {
        GetCountID();
        
        Integer count, countIncrement;
        count = ServiceCostLog.getCount();
        countIncrement = count + 1;
        
        String id, message;
        id = ViewIDE.service_cost_id;
        
        if (count == 0) {
            message = id + "00" + countIncrement;
        } else {
            GetMaxID();
            
            Integer max, maxIncrement;
            max = ServiceCostLog.getMax();
            maxIncrement = max + 1;
            
            if (max >= 1 && max < 10) {
                message = id + "00" + maxIncrement;
            } else {
                if (max >= 10 && max < 100) {
                    message = id + "0" + maxIncrement;
                } else {
                    if (max >= 100 && max < 1000) {
                        message = id + maxIncrement;
                    } else {
                        message = ViewIDE.pesan_warning_id_overload_100;
                        Pesan.Warning(message);
                        
                        Close(dialog);
                    }
                }
            }
        }
        
        ServiceCostLog.setId(message);
    }
    /**
     * End -> get service cost id
     */
    
    /**
     * Start -> get max of service cost id
     */
    private static void GetMaxID () {
        String id, sql;
        id = ViewIDE.service_cost_id;
        sql = "SELECT "
                + "MAX(RIGHT(id, 3)) AS `Max ID` "
            + "FROM "
                + "tbl_layanan "
            + "WHERE "
                + "LEFT(id, 2) LIKE '%"+ id +"%';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                Integer max;
                max = resultSet.getInt("Max ID");
                
                ServiceCostLog.setMax(max);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> get max of service cost id
     */
    
    /**
     * Start -> get pegawai id
     */
    private static void GetPegawaiID () {
        String ktp;
        ktp = UserLog.getKtp();
        
        ServiceCostLog.setKtp(ktp);
    }
    /**
     * End -> get pegawai id
     */
    
    /**
     * Start -> set price to long
     */
    public static void PriceToLong (NumericTextField textHarga) {
        String harga;
        harga = textHarga.getText();
        
        if (harga.isEmpty() == true) {
            /**
             * you need to type the number
             */
        } else {
            Long longHarga;
            longHarga = ServiceCostLog.getLongHarga();
            
            harga = longHarga.toString();
            
            textHarga.setText(harga);
        }
    }
    /**
     * End -> set price to long
     */
    
    /**
     * Start -> set price to string
     */
    public static void PriceToString (NumericTextField textHarga) {
        String ClassName, harga;
        ClassName = "ServiceCostLog";
        harga = textHarga.getText();
        ViewText.ValidateNumeric(ClassName, harga);
        
        harga = ServiceCostLog.getStringHarga();
        textHarga.setText(harga);
    }
    /**
     * End -> set price to string
     */
    
    /**
     * Start -> save service cost
     */
    public static void Save (
        Dialog dialog, JTextField textLayanan, JTextField textHarga
    ) {
        String message, layanan, harga;
        layanan = textLayanan.getText();
        harga = textHarga.getText();
        
        if (layanan.isEmpty() == true || harga.isEmpty() == true) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
        } else {
            ServiceCostLog.setLayanan(layanan);
            
            /**
             * Start -> save
             */
            SaveServiceCost(dialog);
            /**
             * End -> save
             */
        }
    }
    /**
     * End -> save service cost
     */
    
    /**
     * Start -> save service cost
     */
    private static void SaveServiceCost (Dialog dialog) {
        String id, layanan, harga, id_pegawai, message, sql;
        id = ServiceCostLog.getId();
        layanan = ServiceCostLog.getLayanan();
        id_pegawai = ServiceCostLog.getKtp();
        
        Long longHarga;
        longHarga = ServiceCostLog.getLongHarga();
        
        harga = longHarga.toString();
        sql = "INSERT INTO "
                + "tbl_layanan(id, layanan, harga, id_pegawai) "
            + "VALUES"
            + "("
                + "'"+ id +"', "
                + "'"+ layanan +"', "
                + "'"+ harga +"', "
                + "'"+ id_pegawai +"'"
            + ");";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            message = ViewIDE.pesan_info_service_cost_success;
            Pesan.Information(message);
            
            /**
             * Start -> go to the options
             */
            ViewDialog.AddAnimationLeftToRight(dialog);
            Close(dialog);
            /**
             * End -> go to the options
             */
        }
    }
    /**
     * End -> save service cost
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        Dialog dialog, JLabel labelTitle
    ) {
        AddTitle(labelTitle);
        GetID(dialog);
        GetPegawaiID();
    }
    /**
     * End -> set config
     */
    
}
