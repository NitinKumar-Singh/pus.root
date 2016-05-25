/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.content;

import com.lib.logs.MessageLog;
import com.lib.logs.UserActivityLog;
import com.lib.logs.UserLog;
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
public class EmpDbConfig {
    
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
     * Start -> change dinas of emp.
     */
    public static void ChangeDinas (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open change dinas of emp.
         */
        RootMenuConfig.EmpChangeDinas();
        /**
         * End -> open change dinas of emp.
         */
    }
    /**
     * End -> change dinas of emp.
     */
    
    /**
     * Start -> change jabatan of emp.
     */
    public static void ChangeJabatan (Dialog dialog) {
        /**
         * Start -> close active dialog
         */
        ViewDialog.CloseDialog(dialog);
        /**
         * End -> close active dialog
         */
        
        /**
         * Start -> open change jabatan of emp.
         */
        RootMenuConfig.EmpChangeJabatan();
        /**
         * End -> open change jabatan of emp.
         */
    }
    /**
     * End -> change jabatan of emp.
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
         * Start -> go back to the options
         */
        RootMenuConfig.EmpOptions();
        /**
         * End -> go back to the options
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
        
        UserActivityLog.setConvert(value);
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
                convert = UserActivityLog.getConvert();
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
     * Start -> delete person
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
     * End -> delete person
     */
    
    /**
     * Start -> delete data on multiple table
     */
    private static void DeleteData (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        String nip, sql;
        nip = UserActivityLog.getNip();
        sql = "DELETE "
                + "tbl_dinas, tbl_jabatan, tbl_person, "
                + "tbl_user, tbl_user_level, tbl_user_sso "
            + "FROM "
                + "tbl_dinas, tbl_jabatan, tbl_person, "
                + "tbl_user, tbl_user_level, tbl_user_sso "
            + "WHERE "
                + "tbl_person.id_user = tbl_user.id AND "
                + "tbl_person.id_dinas = tbl_dinas.id AND"
                + "tbl_person.id_jabatan = tbl_jabatan.id AND "
                + "tbl_user_sso.id_user = tbl_user.id AND "
                + "tbl_user.id_level = tbl_user_level.id AND "
                + "tbl_person.nip = '"+ nip +"';";
        
        Integer operation;
        operation = SQLAdapter.dataOperation(1, sql);
        
        if (operation == 1) {
            /**
             * Start -> reload data from database
             */
            Refresh(table, textSearch, linkStatus);
            /**
             * End -> reload data from database
             */
        }
    }
    /**
     * End -> delete data on multiple table
     */
    
    /**
     * Start -> open edit form
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
         * Start -> open edit form
         */
        RootMenuConfig.EmpEdit();
        /**
         * End -> open edit form
         */
    }
    /**
     * End -> open edit form
     */
    
    /**
     * Start -> delete data from tables except root
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
         * Start -> empty permission
         */
        RootMenuConfig.EmpEmpty();
        /**
         * End -> empty permission
         */
    }
    /**
     * End -> delete data from tables except root
     */
    
    /**
     * Start -> export mysql data tables into excel file
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
            case 1:
                message = ViewIDE.pesan_warning_export_exception;
                Pesan.Warning(message);
                break;
            default:
                String root_id, sql;
                root_id = UserLog.getId();
                sql = "SELECT "
                        + "tbl_person.nip AS `NIP`, "
                        + "tbl_person.no_ktp AS `No. KTP`, "
                        + "tbl_person.nama AS `Nama Lengkap`, "
                        + "tbl_person.kelamin AS `Jenis Kelamin`, "
                        + "tbl_person.kota AS `Kab. / Kota Kelahiran`, "
                        + "tbl_person.tgl_lahir AS `Tgl. Lahir`, "
                        + "tbl_person.d_lahir AS `dLahir`, "
                        + "tbl_person.kontak AS `Kontak`, "
                        + "tbl_person.alamat AS `Alamat Rumah`, "
                        + "tbl_person.id_dinas AS `ID Dinas`, "
                        + "tbl_dinas.dinas AS `Dinas`, "
                        + "tbl_person.id_jabatan AS `ID Jabatan`, "
                        + "tbl_jabatan.jabatan AS `Jabatan`, "
                        + "tbl_user.id AS `User ID`, "
                        + "tbl_user.pass1 AS `User Password 1`, "
                        + "tbl_user.pass2 AS `User Password 2`, "
                        + "tbl_user.status AS `User Status`, "
                        + "tbl_user.id_level AS `User Level ID`, "
                        + "tbl_user_sso.tgl_reg AS `SSO Tgl. Reg`, "
                        + "tbl_user_sso.d_reg AS `SSO dReg`, "
                        + "tbl_user_sso.tgl_update AS `SSO Tgl. Update`, "
                        + "tbl_user_sso.d_update AS `SSO dUpdate`, "
                        + "tbl_user_sso.tgl_sso AS `SSO Tgl. Login`, "
                        + "tbl_user_sso.d_sso AS `SSO dLogin`, "
                        + "tbl_user_sso.status AS `SSO Status`, "
                        + "tbl_user_sso.tanggal AS `SSO Tanggal` "
                    + "FROM "
                        + "tbl_dinas, tbl_jabatan, tbl_person, "
                        + "tbl_user, tbl_user_level, tbl_user_sso "
                    + "WHERE "
                        + "tbl_person.id_user = tbl_user.id AND "
                        + "tbl_person.id_dinas = tbl_dinas.id AND "
                        + "tbl_person.id_jabatan = tbl_jabatan.id AND "
                        + "tbl_user_sso.id_user = tbl_user.id AND "
                        + "tbl_user.id_level = tbl_user_level.id AND "
                        + "tbl_user.id != '"+ root_id +"' "
                    + "ORDER BY "
                        + "tbl_person.nama ASC;";
                
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
                        file = ViewIDE.mysql_export_tbl_pegawai;
                        File path;
                        path = new File(uri);

                        FileOutputStream fileOutputStream;
                        fileOutputStream = new FileOutputStream(path + file);

                        HSSFWorkbook workbook;
                        workbook = new HSSFWorkbook();

                        HSSFSheet ws_person, ws_user, ws_user_sso;
                        ws_person = workbook.createSheet("tbl_person");
                        ws_user = workbook.createSheet("tbl_user");
                        ws_user_sso = workbook.createSheet("tbl_user_sso");

                        Row rh_person, rh_user, rh_user_sso;
                        rh_person = ws_person.createRow((short)0);
                        rh_person.createCell(0).setCellValue("nip");
                        rh_person.createCell(1).setCellValue("no_ktp");
                        rh_person.createCell(2).setCellValue("nama");
                        rh_person.createCell(3).setCellValue("kelamin");
                        rh_person.createCell(4).setCellValue("kota");
                        rh_person.createCell(5).setCellValue("tgl_lahir");
                        rh_person.createCell(6).setCellValue("d_lahir");
                        rh_person.createCell(7).setCellValue("kontak");
                        rh_person.createCell(8).setCellValue("alamat");
                        rh_person.createCell(9).setCellValue("id_user");
                        rh_person.createCell(10).setCellValue("id_dinas");
                        rh_person.createCell(11).setCellValue("id_jabatan");
                        
                        rh_user = ws_user.createRow((short)0);
                        rh_user.createCell(0).setCellValue("id");
                        rh_user.createCell(1).setCellValue("pass1");
                        rh_user.createCell(2).setCellValue("pass2");
                        rh_user.createCell(3).setCellValue("status");
                        rh_user.createCell(4).setCellValue("id_level");
                        
                        rh_user_sso = ws_user_sso.createRow((short)0);
                        rh_user_sso.createCell(0).setCellValue("id_user");
                        rh_user_sso.createCell(1).setCellValue("tgl_reg");
                        rh_user_sso.createCell(2).setCellValue("d_reg");
                        rh_user_sso.createCell(3).setCellValue("tgl_update");
                        rh_user_sso.createCell(4).setCellValue("d_update");
                        rh_user_sso.createCell(5).setCellValue("tgl_sso");
                        rh_user_sso.createCell(6).setCellValue("d_sso");
                        rh_user_sso.createCell(7).setCellValue("status");
                        rh_user_sso.createCell(8).setCellValue("tanggal");
                        
                        Row rv_person, rv_user, rv_user_sso;

                        while (resultSet.next()) {
                            int i;
                            i = resultSet.getRow();

                            rv_person = ws_person.createRow((short)i);
                            rv_user = ws_user.createRow((short)i);
                            rv_user_sso = ws_user_sso.createRow((short)i);

                            Double person_nip, person_no_ktp;
                            String person_nama, person_kelamin, person_kota;
                            String person_tgl_lahir, person_d_lahir;
                            String person_kontak, person_alamat;
                            String person_id_dinas, person_id_jabatan;
                            String user_id, user_pass1, user_pass2;
                            String user_status, user_level_id;
                            String sso_tgl_reg, sso_d_reg;
                            String sso_tgl_update, sso_d_update;
                            String sso_tgl_login, sso_d_login;
                            String sso_status, sso_tanggal;
                            
                            person_nip = resultSet.getDouble("NIP");
                            person_no_ktp = resultSet.getDouble("No. KTP");
                            person_nama = resultSet.getString("Nama Lengkap");
                            person_kelamin = resultSet.getString("Jenis Kelamin");
                            person_kota = resultSet.getString("Kab. / Kota Kelahiran");
                            person_tgl_lahir = resultSet.getString("Tgl. Lahir");
                            person_d_lahir = resultSet.getString("dLahir");
                            person_kontak = "*" + resultSet.getString("Kontak");
                            person_alamat = resultSet.getString("Alamat Rumah");
                            person_id_dinas = resultSet.getString("ID Dinas");
                            person_id_jabatan = resultSet.getString("ID Jabatan");
                            
                            user_id = resultSet.getString("User ID");
                            user_pass1 = resultSet.getString("User Password 1");
                            user_pass2 = "*" + resultSet.getString("User Password 2");
                            user_status = resultSet.getString("User Status");
                            user_level_id = resultSet.getString("User Level ID");
                            
                            sso_tgl_reg = resultSet.getString("SSO Tgl. Reg");
                            sso_d_reg = resultSet.getString("SSO dReg");
                            sso_tgl_update = resultSet.getString("SSO Tgl. Update");
                            sso_d_update = resultSet.getString("SSO dUpdate");
                            sso_tgl_login = resultSet.getString("SSO Tgl. Login");
                            sso_d_login = resultSet.getString("SSO dLogin");
                            sso_status = resultSet.getString("SSO Status");
                            sso_tanggal = resultSet.getString("SSO Tanggal");
                            
                            rv_person.createCell(0).setCellValue(person_nip);
                            rv_person.createCell(1).setCellValue(person_no_ktp);
                            rv_person.createCell(2).setCellValue(person_nama);
                            rv_person.createCell(3).setCellValue(person_kelamin);
                            rv_person.createCell(4).setCellValue(person_kota);
                            rv_person.createCell(5).setCellValue(person_tgl_lahir);
                            rv_person.createCell(6).setCellValue(person_d_lahir);
                            rv_person.createCell(7).setCellValue(person_kontak);
                            rv_person.createCell(8).setCellValue(person_alamat);
                            rv_person.createCell(9).setCellValue(user_id);
                            rv_person.createCell(10).setCellValue(person_id_dinas);
                            rv_person.createCell(11).setCellValue(person_id_jabatan);
                            
                            rv_user.createCell(0).setCellValue(user_id);
                            rv_user.createCell(1).setCellValue(user_pass1);
                            rv_user.createCell(2).setCellValue(user_pass2);
                            rv_user.createCell(3).setCellValue(user_status);
                            rv_user.createCell(4).setCellValue(user_level_id);
                            
                            rv_user_sso.createCell(0).setCellValue(user_id);
                            rv_user_sso.createCell(1).setCellValue(sso_tgl_reg);
                            rv_user_sso.createCell(2).setCellValue(sso_d_reg);
                            rv_user_sso.createCell(3).setCellValue(sso_tgl_update);
                            rv_user_sso.createCell(4).setCellValue(sso_d_update);
                            rv_user_sso.createCell(5).setCellValue(sso_tgl_login);
                            rv_user_sso.createCell(6).setCellValue(sso_d_login);
                            rv_user_sso.createCell(7).setCellValue(sso_status);
                            rv_user_sso.createCell(8).setCellValue(sso_tanggal);
                        }

                        workbook.write(fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        
                        message = ViewIDE.pesan_info_export_success;
                        Pesan.Information(message);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }
    /**
     * Start -> export mysql data tables into excel file
     */
    
    /**
     * Start -> import excel data tables into mysql
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
                
                HSSFSheet ws_person, ws_user, ws_user_sso;
                ws_person = workbook.getSheet("tbl_person");
                ws_user = workbook.getSheet("tbl_user");
                ws_user_sso = workbook.getSheet("tbl_user_sso");
                
                Row row;
                row = null;
                
                String message;
                ImportTo_tblPerson(ws_person, row);
                ImportTo_tblUser(ws_user, row);
                ImportTo_tblUserSSO(ws_user_sso, row);
                
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
     * End -> import excel data tables into mysql
     */
    
    /**
     * Start -> insert data while import
     */
    private static void ImportTo_tblPerson (HSSFSheet sheet, Row row) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);

            Double person_nip, person_no_ktp;
            String person_nama, person_kelamin, person_kota;
            String person_tgl_lahir, person_d_lahir;
            String kontak, person_kontak, person_alamat;
            String person_id_dinas, person_id_jabatan;
            String user_id;
            
            person_nip = row.getCell(0).getNumericCellValue();
            person_no_ktp = row.getCell(1).getNumericCellValue();
            person_nama = row.getCell(2).getStringCellValue();
            person_kelamin = row.getCell(3).getStringCellValue();
            person_kota = row.getCell(4).getStringCellValue();
            person_tgl_lahir = row.getCell(5).getStringCellValue();
            person_d_lahir = row.getCell(6).getStringCellValue();
            
            kontak = row.getCell(7).getStringCellValue().substring(1, 1);
            switch (kontak) {
                case "-":
                    person_kontak = kontak;
                    break;
                default:
                    person_kontak = row.getCell(7).getStringCellValue()
                                    .substring(1);
                    break;
            }
            
            person_alamat = row.getCell(8).getStringCellValue();
            user_id = row.getCell(9).getStringCellValue();
            person_id_dinas = row.getCell(10).getStringCellValue();
            person_id_jabatan = row.getCell(11).getStringCellValue();

            String sql;
            sql = "INSERT INTO "
                    + "tbl_person"
                    + "("
                        + "nip, no_ktp, nama, kelamin, "
                        + "kota, tgl_lahir, d_lahir, kontak, alamat, "
                        + "id_user, id_dinas, id_jabatan"
                    + ") "
                + "VALUES"
                    + "("
                        + "'"+ person_nip.longValue() +"', "
                        + "'"+ person_no_ktp.longValue() +"', "
                        + "'"+ person_nama +"', "
                        + "'"+ person_kelamin +"', "
                        + "'"+ person_kota +"', "
                        + "'"+ person_tgl_lahir +"', "
                        + "'"+ person_d_lahir +"', "
                        + "'"+ person_kontak +"', "
                        + "'"+ person_alamat +"', "
                        + "'"+ user_id +"', "
                        + "'"+ person_id_dinas +"', "
                        + "'"+ person_id_jabatan +"'"
                    + ");";

            SQLAdapter.dataOperation(1, sql);
            
            String message;
            message = "Import " + String.valueOf(i) + " rows.";
            MessageLog.setMessage(message);
        }
    }
    /**
     * End -> insert data while import
     */
    
    /**
     * Start -> insert data while import
     */
    private static void ImportTo_tblUser (HSSFSheet sheet, Row row) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            
            String user_id, user_pass1, user_pass2;
            String user_status, user_level_id;
            
            user_id = row.getCell(0).getStringCellValue();
            user_pass1 = row.getCell(1).getStringCellValue();
            user_pass2 = row.getCell(2).getStringCellValue().substring(1);
            user_status = row.getCell(3).getStringCellValue();
            user_level_id = row.getCell(4).getStringCellValue();

            String sql;
            sql = "INSERT INTO "
                    + "tbl_user(id, pass1, pass2, status, id_level) "
                + "VALUES"
                    + "("
                        + "'"+ user_id +"', "
                        + "'"+ user_pass1 +"', "
                        + "'"+ user_pass2 +"', "
                        + "'"+ user_status +"', "
                        + "'"+ user_level_id +"'"
                    + ");";

            SQLAdapter.dataOperation(1, sql);
            
            String message;
            message = "Import " + String.valueOf(i) + " rows.";
            MessageLog.setMessage(message);
        }
    }
    /**
     * End -> insert data while import
     */
    
    /**
     * Start -> insert data while import
     */
    private static void ImportTo_tblUserSSO (HSSFSheet sheet, Row row) {
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            
            String user_id;
            String sso_tgl_reg, ssod_reg;
            String sso_tgl_update, sso_d_update;
            String sso_tgl_login, sso_d_login;
            String sso_status, sso_tanggal;
            
            user_id = row.getCell(0).getStringCellValue();
            sso_tgl_reg = row.getCell(1).getStringCellValue();
            ssod_reg = row.getCell(2).getStringCellValue();
            sso_tgl_update = row.getCell(3).getStringCellValue();
            sso_d_update = row.getCell(4).getStringCellValue();
            sso_tgl_login = row.getCell(5).getStringCellValue();
            sso_d_login = row.getCell(6).getStringCellValue();
            sso_status = row.getCell(7).getStringCellValue();
            sso_tanggal = row.getCell(8).getStringCellValue();

            String sql;
            sql = "INSERT INTO "
                    + "tbl_user_sso"
                    + "("
                        + "id_user, tgl_reg, d_reg, tgl_update, d_update, "
                        + "tgl_sso, d_sso, status, tanggal"
                    + ") "
                + "VALUES"
                    + "("
                        + "'"+ user_id +"', "
                        + "'"+ sso_tgl_reg +"', "
                        + "'"+ ssod_reg +"', "
                        + "'"+ sso_tgl_update +"', "
                        + "'"+ sso_d_update +"', "
                        + "'"+ sso_tgl_login +"', "
                        + "'"+ sso_d_login +"', "
                        + "'"+ sso_status +"', "
                        + "'"+ sso_tanggal +"'"
                    + ");";

            SQLAdapter.dataOperation(1, sql);
            
            String message;
            message = "Import " + String.valueOf(i) + " rows.";
            MessageLog.setMessage(message);
        }
    }
    /**
     * End -> insert data while import
     */
    
    /**
     * Start -> load employer data
     */
    private static void LoadData (
        JTable table, JTextField textSearch, link linkStatus
    ) {
        model = new DefaultTableModel();
        table.setModel(model);
        
        model.addColumn("<html><u>N</u> I P</html>");
        model.addColumn("Nama Lengkap");
        model.addColumn("Kab. / Kota Kelahiran");
        model.addColumn("Tgl. Lahir");
        model.addColumn("Kontak");
        model.addColumn("Kantor");
        model.addColumn("Jabatan");
        
        String search, sql;
        search = textSearch.getText();
        
        UserActivityLog.setSearch(search);
        
        sql = "SELECT "
                + "tbl_person.nip AS `NIP`, "
                + "tbl_person.nama AS `Nama Lengkap`, "
                + "tbl_person.kelamin AS `Jenis Kelamin`, "
                + "tbl_person.kota AS `Kab. / Kota Kelahiran`, "
                + "tbl_person.tgl_lahir AS `Tgl. Lahir`, "
                + "tbl_person.kontak AS `Kontak`, "
                + "tbl_dinas.dinas AS `Kantor`, "
                + "tbl_jabatan.jabatan AS `Jabatan` "
            + "FROM "
                + "tbl_dinas, tbl_jabatan, tbl_person, "
                + "tbl_user, tbl_user_level, tbl_user_sso "
            + "WHERE "
                + "tbl_person.id_user = tbl_user.id AND "
                + "tbl_person.id_dinas = tbl_dinas.id AND "
                + "tbl_person.id_jabatan = tbl_jabatan.id AND "
                + "tbl_user_sso.id_user = tbl_user.id AND "
                + "tbl_user.id_level = tbl_user_level.id AND "
                + "(tbl_person.nip LIKE '%"+ search +"%' OR "
                + "tbl_person.nama LIKE '%"+ search +"%' OR "
                + "tbl_person.kelamin LIKE '%"+ search +"%' OR "
                + "tbl_person.kota LIKE '%"+ search +"%' OR "
                + "tbl_person.tgl_lahir LIKE '%"+ search +"%' OR "
                + "tbl_person.kontak LIKE '%"+ search +"%' OR "
                + "tbl_dinas.dinas LIKE '%"+ search +"%' OR "
                + "tbl_jabatan.jabatan LIKE '%"+ search +"%') "
            + "ORDER BY "
                + "tbl_person.nama ASC;";
        
        resultSet = SQLAdapter.getData(sql);
        
        try {
            while (resultSet.next()) {
                Object[] objects;
                objects =  new Object[7];
                
                objects[0] = resultSet.getString("NIP");
                
                /**
                 * Start -> set employer name
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
                
                objects[1] = nama;
                /**
                 * End -> set employer name
                 */
                
                objects[2] = resultSet.getString("Kab. / Kota Kelahiran");
                
                objects[3] = resultSet.getString("Tgl. Lahir");
                
                objects[4] = resultSet.getString("Kontak");
                
                /**
                 * Start -> set kantor
                 */
                String kantor;
                kantor = resultSet.getString("Kantor");
                
                switch (kantor) {
                    case ViewIDE.id_dinas:
                        kantor = "-";
                        break;
                    default:
                        kantor = "" + kantor;
                        break;
                }
                
                objects[5] = kantor;
                /**
                 * End -> set kantor
                 */
                
                /**
                 * Start -> set jabatan field
                 */
                String jabatan;
                jabatan = resultSet.getString("Jabatan");
                
                switch (jabatan) {
                    case ViewIDE.jabatan:
                        jabatan = "-";
                        break;
                    default:
                        jabatan = "" + jabatan;
                        break;
                }
                
                objects[6] = jabatan;
                /**
                 * End -> set jabatan field
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
     * End -> load employer data
     */
    
    /**
     * Start -> set variables when you get popup action
     */
    public static void PopupTable (
        JTable table,
        JMenuItem miEdit, JMenuItem miDelete, JMenuItem miBlocked,
        JMenuItem miChangeJabatan, JMenuItem miChangeDinas
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
                miChangeJabatan.setVisible(false);
                miChangeDinas.setVisible(false);
                /**
                 * End -> set hide active popup menu item
                 */
                
                BlockedMessage(true, miBlocked);
                break;
            default:
                if (row == -1) {
                    return;
                }
                String nip, nip_default, nama, kelamin, kota, tglLahir, kontak;
                String dinas, jabatan, message;
                
                nip_default = UserLog.getNip();
                nip = (String) table.getModel().getValueAt(row, 0);
                nama = (String) table.getModel().getValueAt(row, 1);
                
                /**
                 * Start -> set message
                 */
                message = ""
                + "<html>"
                    + "Hapus `<b>" + nama + "</b>` dari database?"
                + "</html>";
                MessageLog.setMessage(message);
                /**
                 * End -> set message
                 */
                
                nama = nama.substring(4);
                
                /**
                 * Start -> set kelamin
                 */
                kelamin = (String) table.getModel().getValueAt(row, 1)
                    .toString().substring(0, 3);
                
                switch (kelamin) {
                    case "Ny.":
                        kelamin = ViewIDE.female;
                        break;
                    default:
                        kelamin = ViewIDE.male;
                        break;
                }
                
                /**
                 * End -> set kelamin
                 */
                
                kota = (String) table.getModel().getValueAt(row, 2);
                
                tglLahir = (String) table.getModel().getValueAt(row, 3);
                
                kontak = (String) table.getModel().getValueAt(row, 4);
                
                dinas = (String) table.getModel().getValueAt(row, 5);
                
                jabatan = (String) table.getModel().getValueAt(row, 6);
                
                /**
                 * Start -> set variables into memory options
                 */
                UserActivityLog.setNip(nip);
                UserActivityLog.setNama(nama);
                UserActivityLog.setKelamin(kelamin);
                UserActivityLog.setKota(kota);
                UserActivityLog.setTglLahir(tglLahir);
                UserActivityLog.setKontak(kontak);
                UserActivityLog.setDinas(dinas);
                UserActivityLog.setJabatan(jabatan);
                /**
                 * End -> set variables into memory options
                 */
                
                /**
                 * Start -> set hide active popup menu item
                 */
                
                miEdit.setVisible(true);
                miChangeJabatan.setVisible(true);
                miChangeDinas.setVisible(true);
                
                /**
                 * Start -> switch object when nip was the same on log
                 */
                if (nip.equals(nip_default) == true) {
                    miEdit.setText("Edit My Profile");
                    miDelete.setVisible(false);
                } else {
                    miEdit.setText("Edit Selected Person");
                    miDelete.setVisible(true);
                }
                /**
                 * End -> switch object when nip was the same on log
                 */
                
                /**
                 * Start -> switch dinas & jabatan
                 * when one of the both was null
                 */
                switch (jabatan) {
                    case ViewIDE.jabatan:
                        miChangeJabatan.setText("Pilih Jabatan");
                        break;
                    default:
                        miChangeJabatan.setText("Ganti Jabatan");
                        break;
                }
                
                switch (dinas) {
                    case ViewIDE.dinas:
                        miChangeDinas.setText("Pilih Kantor");
                        break;
                    default:
                        miChangeDinas.setText("Ganti Kantor");
                        break;
                }
                /**
                 * End -> switch dinas & jabatan
                 * when one of the both was null
                 */
                
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
        JLabel labelTitle, JTable table,
        JTextField textSearch, link linkStatus
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
        ViewTable.SetResizeColumn(table, 4, false);
        ViewTable.SetResizeColumn(table, 5, false);
        ViewTable.SetResizeColumn(table, 6, false);
    }
    /**
     * End -> set table config
     */
    
}
