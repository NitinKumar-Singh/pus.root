/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.ServiceCostLog;
import com.lib.modules.SQLAdapter;
import com.lib.palette.link;
import com.lib.system.Pesan;
import com.lib.views.ViewDialog;
import com.lib.views.ViewIDE;
import com.lib.views.ViewTable;
import config.menu.RootMenuConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import usu.widget.Dialog;

/**
 *
 * @author Fadhli
 */
public class ServiceCostDbConfig {
    
    /**
     * Start -> set fields
     */
    private static DefaultTableModel model;
    
    private static JRootPane rootPane;
    
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
     * Start -> set blocked message
     */
    private static void BlockedMessage (
        Boolean confirm, JMenuItem miBlocked
    ) {
        if (confirm == true) {
            String icon, message;
            icon = ViewIDE.delete_url_icon;
            message = ViewIDE.pesan_error_popup_disabled;
            
            miBlocked.setIcon(new ImageIcon(
                miBlocked.getClass().getResource(icon)
            ));
            miBlocked.setText(message);
            miBlocked.setVisible(true);
            miBlocked.setEnabled(false);
        } else {
            miBlocked.setVisible(false);
        }
    }
    /**
     * End -> set blocked message
     */
    
    /**
     * Start -> go back to the options
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
        RootMenuConfig.ServiceCostOptions();
        /**
         * End -> go back to the options
         */
    }
    /**
     * End -> go back to the options
     */
    
    /**
     * Start -> set convert
     */
    private static void Convert (Integer i) {
        JFormattedTextField textFormat;
        textFormat = new JFormattedTextField();
        textFormat.setFormatterFactory(
            new DefaultFormatterFactory(
                new NumberFormatter(
                    NumberFormat.getIntegerInstance()
                )
            )
        );
        textFormat.setValue(i);
        
        String value;
        value = textFormat.getText();
        
        ServiceCostLog.setConvert(value);
    }
    /**
     * End -> set convert
     */
    
    /**
     * Start -> set convert
     */
    private static void ConvertToCurrency (Long l) {
        JFormattedTextField textFormat;
        textFormat = new JFormattedTextField();
        textFormat.setFormatterFactory(
            new DefaultFormatterFactory(
                new NumberFormatter(
                    new DecimalFormat("Rp #,##0.00;(Rp #,##0.00)")
                )
            )
        );
        textFormat.setValue(l);
        
        String value;
        value = textFormat.getText();
        
        ServiceCostLog.setConvert(value);
    }
    /**
     * End -> set convert
     */
    
    /**
     * Start -> set count data from table
     */
    private static void CountTable (JTable table, link linkStatus) {
        Integer count;
        count = table.getRowCount();
        
        String convert, message;
        
        switch (count) {
            case 0:
                message = "data kosong";
                break;
            default:
                Convert(count);
                convert = ServiceCostLog.getConvert();
                message = convert + " " + "data";
                break;
        }
        
        message = "Status" + " : " + message;
        linkStatus.setText(message);
    }
    /**
     * End -> set count data from table
     */
    
    /**
     * Start -> delete dialog
     */
    public static void Delete (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String message, title;
        message = MessageLog.getMessage();
        title = ViewIDE.pesan_question_title;
        
        if (Pesan.showConfirmDialog(
            rootPane, message, title,
            Pesan.YES_NO_OPTION, Pesan.QUESTION_MESSAGE
        ) == Pesan.YES_OPTION
        ) {
            DeleteData(table, textSearch, linkStatus);
        }
    }
    /**
     * End -> delete dialog
     */
    
    /**
     * Start -> delete data
     */
    private static void DeleteData (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String id, sql;
        id = ServiceCostLog.getId();
        sql = "DELETE FROM tbl_layanan WHERE id = '"+ id +"';";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            Refresh(table, textSearch, linkStatus);
        }
    }
    /**
     * End ->
     */
    
    /**
     * Start -> open edit service cost
     */
    public static void Edit (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open edit service cost
         */
        RootMenuConfig.ServiceCostEdit();
        /**
         * End -> open edit service cost
         */
    }
    /**
     * End -> open edit service cost
     */
    
    /**
     * Start -> open empty dialog of service cost
     */
    public static void Empty (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open empty dialog of service cost
         */
        RootMenuConfig.ServiceCostEmpty();
        /**
         * End -> open empty dialog of service cost
         */
    }
    /**
     * End -> open empty dialog of service cost
     */
    
    /**
     * Start -> export mysql data of tbl_layanan into excel file
     */
    public static void Export (JTable table) {
        Integer count;
        count = table.getRowCount();
        
        String message;
        
        switch (count) {
            case 0:
                message = ViewIDE.pesan_warning_export_empty;
                Pesan.Warning(message);
                break;
            default:
                String sql;
                sql = "SELECT "
                        + "id AS `ID`, "
                        + "layanan AS `Layanan`, "
                        + "harga AS `Harga`, "
                        + "id_pegawai AS `ID Pegawai` "
                    + "FROM "
                        + "tbl_layanan;";

                resultSet = SQLAdapter.getData(sql);

                try {
                    JFileChooser fileChooser;
                    fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Select Directory to Save");
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);

                    int iOpen;
                    iOpen = fileChooser.showSaveDialog(rootPane);

                    if (iOpen == JFileChooser.APPROVE_OPTION) {
                        URI uri;
                        uri = fileChooser.getSelectedFile().toURI();

                        String file;
                        file = ViewIDE.mysql_export_tbl_layanan;

                        File path;
                        path = new File(uri);

                        FileOutputStream fileOutputStream;
                        fileOutputStream = new FileOutputStream(path + file);

                        HSSFWorkbook workbook;
                        workbook = new HSSFWorkbook();

                        HSSFSheet worksheet;
                        worksheet = workbook.createSheet("tbl_layanan");
                        
                        Row rowHeader;
                        rowHeader = worksheet.createRow((short)0);
                        rowHeader.createCell(0).setCellValue("id");
                        rowHeader.createCell(1).setCellValue("layanan");
                        rowHeader.createCell(2).setCellValue("harga");
                        rowHeader.createCell(3).setCellValue("id_pegawai");

                        Row rowValues;

                        while (resultSet.next()) {
                            int i;
                            i = resultSet.getRow();

                            rowValues = worksheet.createRow((short)i);

                            String id, layanan;
                            Double harga, id_pegawai;
                            id = resultSet.getString("ID");
                            layanan = resultSet.getString("Layanan");
                            harga = resultSet.getDouble("Harga");
                            id_pegawai = resultSet.getDouble("ID Pegawai");
                            

                            rowValues.createCell(0).setCellValue(id);
                            rowValues.createCell(1).setCellValue(layanan);
                            rowValues.createCell(2).setCellValue(harga);
                            rowValues.createCell(3).setCellValue(id_pegawai);
                        }

                        workbook.write(fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        
                        message = ViewIDE.pesan_info_export_success;
                        Pesan.Information(message);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }
    /**
     * End -> export mysql data of tbl_layanan into excel file
     */
    
    /**
     * Start -> get long harga
     */
    private static void GetHarga () {
        String id, sql;
        id = ServiceCostLog.getId();
        sql = "SELECT "
                + "harga AS `Harga` "
            + "FROM "
                + "tbl_layanan "
            + "WHERE "
                + "id = '"+ id +"';";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            if (resultSet.next()) {
                Long harga;
                harga = resultSet.getLong("Harga");
                
                ServiceCostLog.setLongHarga(harga);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> get long harga
     */
    
    /**
     * Start -> import excel data of tbl_layanan into mysql
     */
    public static void Import (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        try {
            JFileChooser fileChooser;
            fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Open Backup File");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            
            int iOpen;
            iOpen = fileChooser.showOpenDialog(rootPane);
            
            if (iOpen == JFileChooser.APPROVE_OPTION) {
                URI uri;
                uri = fileChooser.getSelectedFile().toURI();
                
                File file;
                file = new File(uri);
                
                FileInputStream fileInputStream;
                fileInputStream = new FileInputStream(file);
                
                POIFSFileSystem poifsFileSystem;
                poifsFileSystem = new POIFSFileSystem(fileInputStream);
                
                HSSFWorkbook workbook;
                workbook = new HSSFWorkbook(poifsFileSystem);
                
                HSSFSheet sheet;
                sheet = workbook.getSheet("tbl_layanan");
                
                Row row;
                
                String message;
                
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);
                    
                    String id, layanan;
                    Double harga, id_pegawai;
                    id = row.getCell(0).getStringCellValue();
                    layanan = row.getCell(1).getStringCellValue();
                    harga = row.getCell(2).getNumericCellValue();
                    id_pegawai = row.getCell(3).getNumericCellValue();
                    
                    String sql;
                    sql = "INSERT INTO "
                            + "tbl_layanan(id, layanan, harga, id_pegawai) "
                        + "VALUES"
                            + "("
                                + "'"+ id +"', "
                                + "'"+ layanan +"', "
                                + "'"+ harga.longValue() +"', "
                                + "'"+ id_pegawai.longValue() +"'"
                            + ");";
                    
                    SQLAdapter.dataOperation(1, sql);
                    
                    message = "Import " + String.valueOf(i) + " rows.";
                    MessageLog.setMessage(message);
                }
                fileInputStream.close();
                
                message = MessageLog.getMessage();
                message = message + "\n" + ViewIDE.pesan_info_import_success;
                Pesan.Information(message);
                
                Refresh(table, textSearch, linkStatus);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * End -> import excel data of tbl_layanan into mysql
     */
    
    /**
     * Start -> load data
     */
    private static void LoadData (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        model = new DefaultTableModel();
        table.setModel(model);
        
        model.addColumn("<html><u>K</u>ode</html>");
        model.addColumn("Layanan");
        model.addColumn("Harga");
        model.addColumn("Posted By");
        
        String search, sql;
        search = textSearch.getText();
        
        ServiceCostLog.setSearch(search);
        
        sql = "SELECT "
                + "tbl_layanan.id AS `ID`, "
                + "tbl_layanan.layanan AS `Layanan`, "
                + "tbl_layanan.harga AS `Harga`, "
                + "tbl_person.nama AS `Nama Lengkap`, "
                + "tbl_person.kelamin AS `Jenis Kelamin` "
            + "FROM "
                + "tbl_layanan, tbl_person "
            + "WHERE "
                + "tbl_person.no_ktp = tbl_layanan.id_pegawai AND "
                + "(tbl_layanan.id LIKE '%"+ search +"%' OR "
                + "tbl_layanan.layanan LIKE '%"+ search +"%' OR "
                + "tbl_layanan.harga LIKE '%"+ search +"%' OR "
                + "tbl_person.nama LIKE '%"+ search +"%' OR "
                + "tbl_person.kelamin LIKE '%"+ search +"%') "
            + "ORDER BY "
                + "tbl_layanan.id ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                Object[] objects;
                objects = new Object[4];
                
                objects[0] = resultSet.getString("ID");
                
                objects[1] = resultSet.getString("Layanan");
                
                /**
                 * Start -> set currency
                 */
                Long longHarga;
                longHarga = resultSet.getLong("Harga");
                
                ConvertToCurrency(longHarga);
                
                String harga;
                harga = ServiceCostLog.getConvert();
                
                objects[2] = harga;
                /**
                 * End -> set currency
                 */
                
                /**
                 * Start -> set person
                 */
                String nama, kelamin;
                nama = resultSet.getString("Nama Lengkap");
                kelamin = resultSet.getString("Jenis Kelamin");
                
                switch (kelamin) {
                    case ViewIDE.female:
                        nama = "Ny." + " " + nama;
                        break;
                    default:
                        nama = "Tn." + " " + nama;
                        break;
                }
                
                objects[3] = nama;
                /**
                 * End -> set person
                 */
                model.addRow(objects);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SetTableConfig(table);
            CountTable(table, linkStatus);
        }
    }
    /**
     * End -> load data
     */
    
    /**
     * Start -> set variables when you get popup action
     */
    public static void PopupTable (
        JTable table,
        JMenuItem miEdit, JMenuItem miDelete, JMenuItem miBlocked
    ) {
        Integer row, SelectRowCount;
        row = table.getSelectedRow();
        SelectRowCount = table.getSelectedRowCount();
        
        switch (SelectRowCount) {
            case 0:
                /**
                 * Start -> set hide active popup menu item
                 */
                miEdit.setVisible(false);
                miDelete.setVisible(false);
                /**
                 * End -> set hide active popup menu item
                 */
                
                BlockedMessage(true, miBlocked);
                break;
            default:
                if (row == -1) {
                    return;
                }
                String id, layanan, harga, message;
                id = (String) table.getModel().getValueAt(row, 0);
                layanan = (String) table.getModel().getValueAt(row, 1);
                harga = (String) table.getModel().getValueAt(row, 2);
                
                /**
                 * Start -> set variables into memory options
                 */
                ServiceCostLog.setId(id);
                ServiceCostLog.setLayanan(layanan);
                ServiceCostLog.setStringHarga(harga);
                GetHarga();
                /**
                 * End -> set variables into memory options
                 */
                
                /**
                 * Start -> set message
                 */
                message = ""
                + "<html>"
                    + "Hapus layanan `<b>" + layanan + "</b>` dari database?"
                + "</html>";
                MessageLog.setMessage(message);
                /**
                 * End -> set message
                 */
                
                /**
                 * Start -> set hide active popup menu item
                 */
                miEdit.setVisible(true);
                miDelete.setVisible(true);
                /**
                 * End -> set hide active popup menu item
                 */
                
                BlockedMessage(false, miBlocked);
                break;
        }
    }
    /**
     * End -> set variables when you get popup action
     */
    
    /**
     * Start -> reload data
     */
    public static void Refresh (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        LoadData(table, textSearch, linkStatus);
        textSearch.requestFocus();
    }
    /**
     * End -> reload data
     */
    
    /**
     * Start -> find data
     */
    public static void Search (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String message;
        if (textSearch.getText().isEmpty() == true) {
            message = ViewIDE.pesan_warning_completed_fields;
            Pesan.Warning(message);
            
            textSearch.requestFocus();
        } else {
            LoadData(table, textSearch, linkStatus);
            textSearch.requestFocus();
        }
    }
    /**
     * End -> find data
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle, JTable table, JTextField textSearch,
        link linkStatus
    ) {
        AddTitle(labelTitle);
        Refresh(table, textSearch, linkStatus);
    }
    /**
     * End -> set config
     */
    
    /**
     * Start -> set table config
     */
    private static void SetTableConfig (JTable table) {
        ViewTable.autoResizeColumn(table);
        
        ViewTable.SetResizeColumn(table, 0, false);
        ViewTable.SetResizeColumn(table, 1, false);
        ViewTable.SetResizeColumn(table, 2, false);
        ViewTable.SetResizeColumn(table, 3, false);
    }
    /**
     * End -> set table config
     */
    
}
