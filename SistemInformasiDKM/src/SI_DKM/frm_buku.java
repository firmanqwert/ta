/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SI_DKM;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import junit.framework.TestCase;

/**
 *
<<<<<<< HEAD
 * @author Led Zepplin
=======
 * @author snobi
>>>>>>> 3b8188fa2ec34ef6680170599139a74243e49f23
 */



public class frm_buku extends javax.swing.JFrame {
    
    private DefaultTableModel model;
    ResultSet rs=null;
    /**
     * Creates new form frm_buku
     */
      
        
    void autonumber(){
    try{
            Connection c = koneksi.getkoneksi();
            Statement s = c.createStatement();
            String sql="select max(right(kode,2))as cno from buku";
////            String sql="Select right(kode,3)as no_trakhir from buku";
////            String sql="select kode from buku order by kode DESC";
            ResultSet r =s.executeQuery(sql);
//            
////            if(r.next()){
////                int auto_kode=Integer.parseInt(r.getString("kode"))+1;
////                kdBuku.setText(Integer.toString(auto_kode));
////                
////                
////                
////            }else{
////                int auto_kode=1;
////                kdBuku.setText(Integer.toString(auto_kode));
////            
////            }
//            r.close();
            
            if(r.first()==false ){
            kdBuku.setText("NP001");
            }
            else{
            r.last();
            int no=r.getInt(1)+1;
            String cno=String.valueOf(no);
            int pjg_cno=cno.length();
            
            for(int i=0; i<3-pjg_cno; i++){
            cno="00"+cno;
            }
            kdBuku.setText("NP"+cno);
            }
            }catch(SQLException e){
             System.out.println(e);
      }
            
//            ResultSet rs=s.executeQuery(sql);
//            while(rs.next()){
//                int a=rs.getInt(1);
//                kdBuku.setText("B000"+Integer.toString(a+1));
//                rs.close();
//                c.close();
//            
//            
//            }
//    }catch(SQLException e){
//            System.out.println(e);
//      }
    }

    
    
    public frm_buku() {
           initComponents();
        setLocationRelativeTo(null);
        autonumber();
              
        model = new DefaultTableModel();
        tabelbuku.setShowGrid(true);
	tabelbuku.setShowVerticalLines(true);
	tabelbuku.setGridColor(Color.RED);
        tabelbuku.setModel(model);
        model.addColumn("Kode Buku");
        model.addColumn("Judul");
        model.addColumn("Kategori");
        model.addColumn("Penerbit");
        model.addColumn("Pengarang");
        model.addColumn("Terbit");
        model.addColumn("STOK");
        loadData();
    }

    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            Connection c = koneksi.getkoneksi();
            Statement t = c.createStatement();
            String sql = "select * from buku";
            ResultSet r = t.executeQuery(sql);
            while (r.next()){
                Object[] o = new Object[7];
                o[0] = r.getString("kode");
                o[1] = r.getString("judul");
                o[2] = r.getString("kategori");
                o[3] = r.getString("pengarang");
                o[4] = r.getString("penerbit");
                o[5] = r.getString("thn_terbit");
                o[6] = r.getString("stok");
                model.addRow(o);
            }
            r.close();
            t.close();
        }catch(SQLException e){
            System.out.print(e);
        }
     }
    
    void tblKeForm(){
        kdBuku.setText(model.getValueAt(tabelbuku.getSelectedRow(),0)+"");
        judul.setText(model.getValueAt(tabelbuku.getSelectedRow(),1)+"");
        kategori.setText(model.getValueAt(tabelbuku.getSelectedRow(),2)+"");
        pengarang.setText(model.getValueAt(tabelbuku.getSelectedRow(),3)+"");
        penerbit.setText(model.getValueAt(tabelbuku.getSelectedRow(),4)+"");
        terbit.setText(model.getValueAt(tabelbuku.getSelectedRow(),5)+"");
        stok.setText(model.getValueAt(tabelbuku.getSelectedRow(),6)+"");
    }
    
    void kosongkanForm(){
        kdBuku.setText("");
        judul.setText("");
        kategori.setText("");
        pengarang.setText("");
        penerbit.setText("");
        terbit.setText("");
        stok.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kdBuku = new javax.swing.JTextField();
        judul = new javax.swing.JTextField();
        pengarang = new javax.swing.JTextField();
        penerbit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbuku = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        terbit = new javax.swing.JTextField();
        kategori = new javax.swing.JTextField();
        stok = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Data Buku");

        jLabel3.setText("Kode Buku");

        jLabel4.setText("Judul");

        jLabel6.setText("Kategori");

        jLabel7.setText("Penerbit");

        jLabel8.setText("Pengarang");
        jLabel8.setToolTipText("");

        jLabel9.setText("Stok");

        kdBuku.setEditable(false);
        kdBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdBukuActionPerformed(evt);
            }
        });

        tabelbuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabelbuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbuku);

        jButton1.setText("Add");
        jButton1.setToolTipText("tambah buku");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.setToolTipText("hapus buku");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.setToolTipText("update data buku");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("cari");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Kembali");
        jButton5.setToolTipText("menu utama");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setText("Thn Terbit");

        jButton6.setText("Refresh");
        jButton6.setToolTipText("Data Baru");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(307, 307, 307))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(kdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(terbit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jButton4)))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(207, 207, 207)
                                                .addComponent(jLabel10)))
                                        .addGap(104, 104, 104)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9))
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(kdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(terbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-702)/2, (screenSize.height-405)/2, 702, 405);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        frm_menu f=new frm_menu();
                f.show();
                this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
            Connection c = koneksi.getkoneksi();
            String sql = "Insert into buku values (?,?,?,?,?,?,?)";
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            	
                p.setString(1, kdBuku.getText());
                p.setString(2, judul.getText());
                p.setString(3, kategori.getText());
                p.setString(4, pengarang.getText());
                p.setString(5, penerbit.getText());
                p.setString(6, terbit.getText());
                p.setString(7, stok.getText());
                             
            p.executeUpdate();
            p.close();
               JOptionPane.showMessageDialog(rootPane, "data berhasil dimasukan");
               loadData();
               kosongkanForm();
        }   catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, "data belum komplit");
            System.out.println("Terjadi kesalahan");
        }       // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Connection c = koneksi.getkoneksi();
            String sql = "update buku set stok=? where kode=?";
       
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            	p.setString(1, stok.getText());
                p.setString(2, kdBuku.getText());

            p.executeUpdate();
            p.close();
               loadData();
               kosongkanForm();
        }   catch(SQLException e){
            System.out.println("Terjadi kesalahan");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabelbukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbukuMouseClicked
        tblKeForm();
    }//GEN-LAST:event_tabelbukuMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        kosongkanForm();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Connection c = koneksi.getkoneksi();
            String sql = "delete from buku where kode=?";
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            	p.setString(1, kdBuku.getText());
            p.executeUpdate();
            p.close();
               loadData();
               kosongkanForm();
        }   catch(SQLException e){
            System.out.println("Terjadi kesalahan");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         try{
         
        Connection c = koneksi.getkoneksi();     
        Statement stm=c.createStatement();
        model.getDataVector().removeAllElements();
        rs=stm.executeQuery("select * from buku where judul like '%"+judul.getText()+"%'");
        while (rs.next()){
        Object [] data={rs.getString("kode"),
                        rs.getString("judul"),
                        rs.getString("kategori"),
                        rs.getString("pengarang"),
                        rs.getString("penerbit"),
                        rs.getString("thn_terbit"),
                        rs.getString("stok")
            };
        model.addRow(data);
        }

    
    }catch(Exception e){
           e.printStackTrace();
     }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void kdBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdBukuActionPerformed
        // TODO add your handling code here:
        autonumber();
    }//GEN-LAST:event_kdBukuActionPerformed

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
            java.util.logging.Logger.getLogger(frm_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_buku().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kategori;
    private javax.swing.JTextField kdBuku;
    private javax.swing.JTextField penerbit;
    private javax.swing.JTextField pengarang;
    private javax.swing.JTextField stok;
    private javax.swing.JTable tabelbuku;
    private javax.swing.JTextField terbit;
    // End of variables declaration//GEN-END:variables
}
