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
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
<<<<<<< HEAD
 * @author Led Zepplin
=======
 * @author snobi
>>>>>>> 3b8188fa2ec34ef6680170599139a74243e49f23
 */
public class frm_menu extends javax.swing.JFrame {

    /**
     * Creates new
     */
<<<<<<< HEAD
    JasperReport JasRep;
    JasperPrint JasPri;
    Map param=new HashMap();
    JasperDesign JasDes;
=======
     JasperReport JasRep;
             JasperPrint JasPri;
            Map param=new HashMap();
            JasperDesign JasDes;
>>>>>>> 3b8188fa2ec34ef6680170599139a74243e49f23
    
    public frm_menu() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));

        jMenu3.setText("Perpustakaan");
        jMenu3.setToolTipText("");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jMenuItem1.setText("Buku");
        jMenuItem1.setToolTipText("data buku");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuItem1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItem1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jMenuItem2.setText("Anggota");
        jMenuItem2.setToolTipText("data anggota");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jMenuItem3.setText("Peminjaman");
        jMenuItem3.setToolTipText("data peminjaman buku");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jMenuItem5.setText("Laporan");
        jMenuItem5.setToolTipText("laporan peminjaman buku");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-406)/2, (screenSize.height-343)/2, 406, 343);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        frm_buku f=new frm_buku();
                f.show();
                this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItem1MenuKeyPressed

    }//GEN-LAST:event_jMenuItem1MenuKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        frm_anggota f=new frm_anggota();
                f.show();
                this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        frm_peminjaman f=new frm_peminjaman();
                f.show();
                this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

          
        //        frm_laporan f=new frm_laporan();
//                f.show();
//                this.dispose();
//        JasperReport jasRep;
//             JasperPrint jasPri;
//             Map<String, Object> no=new HashMap<String, Object>();
//             JasperDesign jasDes;
<<<<<<< HEAD
        
        java.io.File namaFile=new java.io.File("./report1.jasper");
                    try{
        Connection c = koneksi.getkoneksi();
        Statement t = c.createStatement();
        
//        File report=new File("report1.jrxml");
//        JasDes =JRXmlLoader.load(report);
//        param.clear();
//        
//        JasRep=JasperCompileManager.compileReport(JasDes);
//        JasPri=JasperFillManager.fillReport(JasRep,param,c);
//        JasperViewer.viewReport(JasPri,false);
        
        net.sf.jasperreports.engine.JasperReport jasper;
            jasper=(net.sf.jasperreports.engine.JasperReport)
                    net.sf.jasperreports.engine.util.JRLoader.loadObject(namaFile.getPath());
            net.sf.jasperreports.engine.JasperPrint jp;
            jp=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, null,c);
            net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
=======
                    try{
            Connection c = koneksi.getkoneksi();
        Statement t = c.createStatement();
        
        File report=new File("laporanpeminjam.jrxml");
        JasDes =JRXmlLoader.load(report);
        param.clear();
        
        JasRep=JasperCompileManager.compileReport(JasDes);
        JasPri=JasperFillManager.fillReport(JasRep,param,c);
        JasperViewer.viewReport(JasPri,false);
>>>>>>> 3b8188fa2ec34ef6680170599139a74243e49f23
        
        
//                 net.sf.jasperreports.engine.JasperReport JasRep = JasperCompileManager.compileReport(jasDes);
//                 jasPri=JasperFillManager.fillReport(jasRep,no,c);
//                 JasperViewer.viewReport(jasPri,false);
//        
//        
////        JasperReport jasperReport=(JasperReport)JRLoader.loadObject(report_file.getPath());
////        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,c);
////        
////        JasperViewer.viewReport(jasperPrint,false);        
        }catch(Exception e){
        e.printStackTrace();
    }
   
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
