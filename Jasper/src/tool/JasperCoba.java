/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author WINDOWS 10
 */
public class JasperCoba {

    static void print(String file, int employee_id) {
        DBConnection connection = new DBConnection();

        try {
            String namafile = "src/report/" + file + ".jasper";
            File report = new File(namafile);
            JasperReport jr = (JasperReport) JRLoader.loadObject(report);
            HashMap parameter = new HashMap();
            parameter.put("employee_id", employee_id);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, connection.getConnection());
            JasperViewer.viewReport(jp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    }

    public static void main(String[] args) {
        print("employee", 100);

    }
}
