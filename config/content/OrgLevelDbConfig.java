/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.JabatanLog;
import com.lib.logs.MessageLog;
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
public class OrgLevelDbConfig {
    
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
         * Start -> go back to options
         */
        RootMenuConfig.OrgLevelOptions();
        /**
         * End -> go back to options
         */
    }
    /**
     * End -> close
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
        
        JabatanLog.setConvert(value);
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
                convert = JabatanLog.getConvert();
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
     * Start -> set delete data
     */
    public static void Delete (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String message, title;
        message = MessageLog.getMessage();
        title = ViewIDE.pesan_question_title;
        
        if (Pesan.showConfirmDialog(
            rootPane, message, title, Pesan.YES_NO_OPTION, Pesan.QUESTION_MESSAGE
        ) == Pesan.YES_OPTION
        ) {
            DeleteData(table, textSearch, linkStatus);
        }
    }
    /**
     * End -> set delete data
     */
    
    /**
     * Start -> delete data from database
     */
    private static void DeleteData (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String id, sql;
        id = JabatanLog.getId();
        sql = "DELETE FROM tbl_jabatan WHERE id = '"+ id +"';";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            Refresh(table, textSearch, linkStatus);
        }
    }
    /**
     * End -> delete data from database
     */
    
    /**
     * Start -> edit organization level
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
         * Start -> open edit organization level
         */
        RootMenuConfig.OrgLevelEdit();
        /**
         * End -> open edit organization level
         */
    }
    /**
     * End -> edit organization level
     */
    
    /**
     * Start -> empty organization level
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
         * Start -> open empty organization level
         */
        RootMenuConfig.OrgLevelEmpty();
        /**
         * End -> open empty organization level
         */
    }
    /**
     * End -> empty organization level
     */
    
    /**
     * Start -> export mysql data of tbl_jabatan into excel file
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
                        + "jabatan AS `Jabatan`, "
                        + "keterangan AS `Keterangan` "
                    + "FROM "
                        + "tbl_jabatan;";

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
                        file = ViewIDE.mysql_export_tbl_jabatan;

                        File path;
                        path = new File(uri);

                        FileOutputStream fileOutputStream;
                        fileOutputStream = new FileOutputStream(path + file);

                        HSSFWorkbook workbook;
                        workbook = new HSSFWorkbook();

                        HSSFSheet worksheet;
                        worksheet = workbook.createSheet("tbl_jabatan");

                        Row rowHeader;
                        rowHeader = worksheet.createRow((short)0);
                        rowHeader.createCell(0).setCellValue("id");
                        rowHeader.createCell(1).setCellValue("jabatan");
                        rowHeader.createCell(2).setCellValue("keterangan");

                        Row rowValues;

                        while (resultSet.next()) {
                            int i;
                            i = resultSet.getRow();

                            rowValues = worksheet.createRow((short)i);

                            String id, jabatan, keterangan;
                            id = resultSet.getString("ID");
                            jabatan = resultSet.getString("Jabatan");
                            keterangan = resultSet.getString("Keterangan");

                            rowValues.createCell(0).setCellValue(id);
                            rowValues.createCell(1).setCellValue(jabatan);
                            rowValues.createCell(2).setCellValue(keterangan);
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
     * End -> export mysql data of tbl_jabatan into excel file
     */
    
    /**
     * Start -> import excel data of tbl_jabatan into mysql
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
                sheet = workbook.getSheet("tbl_jabatan");
                
                Row row;
                
                String message;
                
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);
                    
                    String id, jabatan, keterangan;
                    id = row.getCell(0).getStringCellValue();
                    jabatan = row.getCell(1).getStringCellValue();
                    keterangan = row.getCell(2).getStringCellValue();
                    
                    String sql;
                    sql = "INSERT INTO "
                            + "tbl_jabatan(id, jabatan, keterangan) "
                        + "VALUES"
                            + "("
                                + "'"+ id +"', "
                                + "'"+ jabatan +"', "
                                + "'"+ keterangan +"'"
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
     * End -> import excel data of tbl_jabatan into mysql
     */
    
    /**
     * Start -> load database into table
     */
    private static void LoadData (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        model = new DefaultTableModel();
        table.setModel(model);
        
        model.addColumn(""
        + "<html>"
            + "<u>K</u>ode Jabatan"
        + "</html>");
        model.addColumn("Jabatan");
        model.addColumn("Keterangan");
        
        String search, sql, unknown_id, unknown_jabatan;
        search = textSearch.getText();
        JabatanLog.setSearch(search);
        unknown_id = ViewIDE.jabatan_id;
        unknown_jabatan = ViewIDE.jabatan;
        sql = "SELECT "
                + "id AS `ID`, "
                + "jabatan AS `Jabatan`, "
                + "keterangan AS `Keterangan` "
            + "FROM "
                + "tbl_jabatan "
            + "WHERE "
                + "(id != '"+ unknown_id +"' OR "
                + "jabatan != '"+ unknown_jabatan +"') AND "
                + "(id LIKE '%"+ search +"%' OR "
                + "jabatan LIKE '%"+ search +"%' OR "
                + "keterangan LIKE '%"+ search +"%') "
            + "ORDER BY "
                + "jabatan ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                Object[] objects;
                objects = new Object[3];
                
                objects[0] = resultSet.getString("ID");
                
                objects[1] = resultSet.getString("Jabatan");
                
                objects[2] = resultSet.getString("Keterangan");
                
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
     * End -> load database into table
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
                String id, jabatan, keterangan, message;
                id = (String) table.getModel().getValueAt(row, 0);
                jabatan = (String) table.getModel().getValueAt(row, 1);
                keterangan = (String) table.getModel().getValueAt(row, 2);
                
                /**
                 * Start -> set variables into memory options
                 */
                JabatanLog.setId(id);
                JabatanLog.setJabatan(jabatan);
                JabatanLog.setKeterangan(keterangan);
                /**
                 * End -> set variables into memory options
                 */
                
                /**
                 * Start -> set message
                 */
                message = ""
                + "<html>"
                    + "Hapus jabatan `<b>" + jabatan + "</b>` dari database?"
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
     * Start -> reload data from database
     */
    public static void Refresh (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        textSearch.setText(null);
        LoadData(table, textSearch, linkStatus);
        textSearch.requestFocus();
    }
    /**
     * End -> reload data from database
     */
    
    /**
     * Start -> find data from database
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
     * End -> find data from database
     */
    
    /**
     * Start -> set config
     */
    public static void SetConfig (
        JLabel labelTitle,
        JTable table, JTextField textSearch, link linkStatus
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
        ViewTable.SetResizeColumn(table, 2, true);
    }
    /**
     * End -> set table config
     */
    
}
