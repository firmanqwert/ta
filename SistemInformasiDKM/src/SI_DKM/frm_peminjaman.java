/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SI_DKM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author snobi
 */
public class frm_peminjaman extends javax.swing.JFrame {

    private DefaultTableModel model;
    SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd"); 
    String tanggal1;
    String tanggal2;
    

    private void autonumb(){
    try{
            Connection c = koneksi.getkoneksi();
            Statement s = c.createStatement();
            String sql="Select right(no_pinjam,3)as cno from histori_peminjam";
            ResultSet r=s.executeQuery(sql);
            
            if(r.first()==false){
            txtNopin.setText("PB0001");
            }
            else{
            r.last();
            int no=r.getInt(1)+1;
            String cno=String.valueOf(no);
            int pjg_cno=cno.length();
            
            for(int i=0; i<3-pjg_cno; i++){
            cno="000"+cno;
            }
            txtNopin.setText("PB"+cno);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void loadcomboBuku(){
        try{
            cmbBuku.removeAllItems();
            Connection c = koneksi.getkoneksi();
            Statement s = c.createStatement();
            String sql="Select kode from buku";
            ResultSet r=s.executeQuery(sql);
            
            while(r.next()){
                cmbBuku.addItem(r.getString("kode"));
            }
            r.close();
            s.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void loadcomboID(){
        try{
            cmbPeminjam.removeAllItems();
            Connection c = koneksi.getkoneksi();
            Statement s = c.createStatement();
            String sql="Select id_anggota from anggota";
            ResultSet r=s.executeQuery(sql);
            
            while(r.next()){
                cmbPeminjam.addItem(r.getString("id_anggota"));
            }
            r.close();
            s.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    
    public frm_peminjaman() {
        initComponents();
        loadcomboID();
        loadcomboBuku();
        setLocationRelativeTo(null);
        
        autonumb();
        
        tgl1.setDate(new java.util.Date());
        tgl1.setDateFormatString("yyyy-MM-dd");
 
        model = new DefaultTableModel();
//        tbBuku.setShowGrid(true);
//	tbBuku.setShowVerticalLines(true);
//	tbBuku.setGridColor(Color.RED);
//        tbBuku.setModel(model);
        model.addColumn("Kode");
        model.addColumn("Judul Buku");
    }
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            Connection c = koneksi.getkoneksi();
            Statement t = c.createStatement();
            String sql = "select pinjam_buku.kode_buku, buku.judul"
                    + "from pinjam_buku inner join buku on pinjam_buku.kode_buku=buku.kode"
                    + "where pinjam_buku.kode_buku=buku.kode";
            ResultSet r = t.executeQuery(sql);
            while (r.next()){
                Object[] o = new Object[2];
                o[0] = r.getString("pinjam_buku.kode_buku");
                o[1] = r.getString("buku.judul");
                model.addRow(o);
            }
            r.close();
            t.close();
        }catch(SQLException e){
            System.out.print(e);
        }
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
        jLabel5 = new javax.swing.JLabel();
        txtNopin = new javax.swing.JTextField();
        txtPeminjam = new javax.swing.JTextField();
        cmbPeminjam = new javax.swing.JComboBox();
        cmbBuku = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tgl2 = new com.toedter.calendar.JDateChooser();
        tgl1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Peminjaman Buku");

        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setText("Nomor Pinjam");

        jLabel4.setText("ID Anggota");

        jLabel5.setText("Peminjam");

        txtNopin.setEditable(false);
        txtNopin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNopinActionPerformed(evt);
            }
        });

        txtPeminjam.setEditable(false);

        cmbPeminjam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPeminjamActionPerformed(evt);
            }
        });

        cmbBuku.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBukuActionPerformed(evt);
            }
        });

        jLabel6.setText("Kode Buku");

        txtJudul.setEditable(false);

        jLabel7.setText("Judul Buku:");

        jButton1.setText("Simpan");
        jButton1.setToolTipText("tambah buku");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Kembali");
        jButton4.setToolTipText("menu utama");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Tanggal Pinjam");

        jLabel9.setText("Tanggal Kembali");

        tgl2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl2PropertyChange(evt);
            }
        });

        tgl1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(109, 109, 109)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNopin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtJudul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 99, Short.MAX_VALUE)))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNopin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try{
        Connection c = koneksi.getkoneksi();
        Statement t = c.createStatement();
//        t.executeUpdate("insert into pinjam_buku set no_pinjam='"+txtNopin.getText()+"',"+
//                            "id_anggota='"+cmbPeminjam.getSelectedItem()+"',"+
//                            "kode_buku='"+cmbBuku.getSelectedItem()+"',"+
//                            "tgl_pinjam=CURDATE(),"+
//                            "tgl_kembali=null,"+
//                            "denda=null;");
         String sql = "Insert into histori_peminjam values"
                 + " ('"+txtNopin.getText()+
                 " ','"+tanggal1+
                   " ','"+tanggal2+
                   " ','"+txtPeminjam.getText()+"')";
                 
                PreparedStatement p=(PreparedStatement) c.prepareStatement(sql); 	
//                p.setString(1, txtNopin.getText());
//                p.setString(2, tanggal1);
//                p.setString(3, tanggal2);
//                p.setString(4, txtPeminjam.getText());
     
                       
           p.executeUpdate();
            p.close();

               JOptionPane.showMessageDialog(rootPane, "data berhasil dimasukan");
               loadData();
         
    }catch(Exception e){
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       frm_menu f=new frm_menu();
                f.show();
                this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cmbPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPeminjamActionPerformed
        int i=cmbPeminjam.getSelectedIndex();
        if(i==-1){
            return;
        }
        try{
            String id=(String) cmbPeminjam.getSelectedItem();
            Connection c = koneksi.getkoneksi();
            Statement s = c.createStatement();
            String sql="Select*from anggota where id_anggota=?";
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            p.setString(1, id);
            ResultSet result=p.executeQuery();
            result.next();
            
            this.txtPeminjam.setText(result.getString("nama"));
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }//GEN-LAST:event_cmbPeminjamActionPerformed

    private void cmbBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBukuActionPerformed
        int i=cmbBuku.getSelectedIndex();
        if(i==-1){
            return;
        }
        try{
            String id=(String) cmbBuku.getSelectedItem();
            Connection c = koneksi.getkoneksi();
            Statement s = c.createStatement();
            String sql="Select*from buku where kode=?";
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            p.setString(1, id);
            ResultSet result=p.executeQuery();
            result.next();

            this.txtJudul.setText(result.getString("judul"));
        }catch(SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_cmbBukuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        autonumb();
    }//GEN-LAST:event_formWindowOpened

    private void txtNopinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNopinActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtNopinActionPerformed

    private void tgl1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl1PropertyChange
        // TODO add your handling code here:
        if (tgl1.getDate()!=null){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        tanggal1=format.format(tgl1.getDate());}
    }//GEN-LAST:event_tgl1PropertyChange

    private void tgl2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl2PropertyChange
        // TODO add your handling code here:
          if (tgl2.getDate()!=null){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        tanggal2=format.format(tgl2.getDate());}
    }//GEN-LAST:event_tgl2PropertyChange

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
            java.util.logging.Logger.getLogger(frm_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_peminjaman().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbBuku;
    private javax.swing.JComboBox cmbPeminjam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser tgl1;
    private com.toedter.calendar.JDateChooser tgl2;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtNopin;
    private javax.swing.JTextField txtPeminjam;
    // End of variables declaration//GEN-END:variables
}