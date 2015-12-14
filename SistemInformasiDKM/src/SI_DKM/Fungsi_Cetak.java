/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SI_DKM;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Led Zepplin
 */
public class Fungsi_Cetak {
//         public Fungsi_Cetak(String laporanpeminjam){
//             
            JasperReport jasRep;
             JasperPrint jasPri;
            Map<String, Object> no=new HashMap<String, Object>();
            JasperDesign jasDes;
//        try{
//            Connection c = koneksi.getkoneksi();
//        Statement t = c.createStatement();
//        
//        File report_file=new File("src/SI_DKM/laporanpeminjam.jrxml");
//        jasDes =JRXmLoader.load(report);
//        no.clear();
//                 net.sf.jasperreports.engine.JasperReport JasRep = JasperCompileManager.compileReport(jasDes);
//                 jasPri=JasperFillManager.fillReport(jasRep,no,c);
//                 JasperViewer.viewReport(jasPri,false);
//        
//        
////        JasperReport jasperReport=(JasperReport)JRLoader.loadObject(report_file.getPath());
////        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,c);
////        
////        JasperViewer.viewReport(jasperPrint,false);
//        
//        }catch(Exception e){
//        e.printStackTrace();
//    }
//        }
}
