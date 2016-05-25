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
import javax.swing.JLabel;
import javax.swing.JTextField;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class ServiceCostEditConfig {
    
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
     * Start -> go back to database
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
         * Start -> go back to database
         */
        RootMenuConfig.ServiceCostDb();
        /**
         * End -> go back to database
         */
    }
    /**
     * End -> go back to database
     */
    
    /**
     * Start -> get data
     */
    private static void GetData (
        JTextField textLayanan, NumericTextField textHarga
    ) {
        String layanan, harga;
        layanan = ServiceCostLog.getLayanan();
        harga = ServiceCostLog.getLongHarga().toString();
        
        textLayanan.setText(layanan);
        textHarga.setText(harga);
        PriceToString(textHarga);
        
        textLayanan.requestFocus();
    }
    /**
     * End -> get data
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
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle, JTextField textLayanan, NumericTextField textHarga
    ) {
        AddTitle(labelTitle);
        GetData(textLayanan, textHarga);
        GetPegawaiID();
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> update service cost
     */
    public static void Update (
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
            UpdateServiceCost(dialog);
            /**
             * End -> save
             */
        }
    }
    /**
     * End -> update service cost
     */
    
    /**
     * Start -> update data
     */
    private static void UpdateServiceCost (Dialog dialog) {
        String id, layanan, harga, message, sql;
        id = ServiceCostLog.getId();
        layanan = ServiceCostLog.getLayanan();
        
        Long longHarga;
        longHarga = ServiceCostLog.getLongHarga();
        
        harga = longHarga.toString();
        sql = "UPDATE "
                + "tbl_layanan "
            + "SET "
                + "layanan = '"+ layanan +"', "
                + "harga = '"+ harga +"' "
            + "WHERE "
                + "id = '"+ id +"';";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            message = ViewIDE.pesan_info_update_success_default;
            Pesan.Information(message);
            
            /**
             * Start -> go back to database
             */
            ViewDialog.AddAnimationLeftToRight(dialog);
            Close(dialog);
            /**
             * End -> go back to database
             */
        }
    }
    /**
     * End -> update data
     */
    
}
