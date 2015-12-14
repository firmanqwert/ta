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
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author snobi
 */
public class frm_anggota extends javax.swing.JFrame {
     private DefaultTableModel model;
     String tanggal1;
     ResultSet rs=null;
    /**
     * Creates new form
     */
    public frm_anggota() {
        initComponents();
        setLocationRelativeTo(null);
        autonumber();
              
        model = new DefaultTableModel();
        dataAnggota.setShowGrid(true);
	dataAnggota.setShowVerticalLines(true);
	dataAnggota.setGridColor(Color.RED);
        dataAnggota.setModel(model);
        model.addColumn("ID Anggota");
        model.addColumn("Nama");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Alamat");
        model.addColumn("Kontak");
        loadData();
    }
    
//    
//      public void auto_number(){
//    try{
//            Connection c = koneksi.getkoneksi();
//            Statement s = c.createStatement();
//            String sql="select max(right(id_anggota, 3))as cno from buku";
////            String sql="Select right(id_anggota,3)as cno from buku";
////            String sql="select kode from buku order by kode DESC";
//            ResultSet r =s.executeQuery(sql);
////            
////            if(r.next()){
////                int auto_kode=Integer.parseInt(r.getString("kode"))+1;
////                kdBuku.setText(Integer.toString(auto_kode));
////                               
////            }else{
////                int auto_kode=1;
////                kdBuku.setText(Integer.toString(auto_kode));
////            
////            }
////            r.close();
//            
//            if(r.first()==false ){
//            txtId.setText("M01");
//            }
//            else{
//            r.last();
//            int no=r.getInt(1)+1;
//            String cno=String.valueOf(no);
//            int pjg_cno=cno.length();
//            
//            for(int i=0; i<3-pjg_cno; i++){
//            cno="0"+cno;
//            }
//            txtId.setText("M"+cno);
//            }
//            }catch(SQLException e){
//             System.out.println(e);
//      }
//    }
    
           
    void autonumber(){
    try{
            Connection c = koneksi.getkoneksi();
            Statement s = c.createStatement();
            String sql="select max(right(id_anggota,2))as cno from anggota";
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
            txtId.setText("NP001");
            }
            else{
            r.last();
            int no=r.getInt(1)+1;
            String cno=String.valueOf(no);
            int pjg_cno=cno.length();
            
            for(int i=0; i<3-pjg_cno; i++){
            cno="00"+cno;
            }
            txtId.setText("NP"+cno);
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

    
    
    
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            Connection c = koneksi.getkoneksi();
            Statement t = c.createStatement();
            String sql = "select * from anggota";
            ResultSet r = t.executeQuery(sql);
            while (r.next()){
                Object[] o = new Object[5];
                o[0] = r.getString("id_anggota");
                o[1] = r.getString("nama");
                o[2] = r.getString("tanggal_lahir");
                o[3] = r.getString("alamat");
                o[4] = r.getString("kontak");
                model.addRow(o);
            }
            r.close();
            t.close();
        }catch(SQLException e){
            System.out.print(e);
        }
     }
    
    void tblKeForm(){   
        txtId.setText(model.getValueAt(dataAnggota.getSelectedRow(),0)+"");
        txtNama.setText(model.getValueAt(dataAnggota.getSelectedRow(),1)+"");
       
        try {
            String a = dataAnggota.getModel().getValueAt(dataAnggota.getSelectedRow(),2).toString();
            SimpleDateFormat mat = new SimpleDateFormat("yyyy-MM-dd");
            Date oa = mat.parse(a);
            txtcalen.setDate(oa);
        }
        catch(Exception a){}
        
        txtAlamat.setText(model.getValueAt(dataAnggota.getSelectedRow(),3)+"");
        txtKontak.setText(model.getValueAt(dataAnggota.getSelectedRow(),4)+"");
    }
    
    void kosongkanForm(){
        txtId.setText("");
        txtNama.setText("");
        txtcalen.setDate(null);
        txtAlamat.setText("");
        txtKontak.setText("");
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
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtKontak = new javax.swing.JTextField();
        txtcalen = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataAnggota = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtcalen.setDateFormatString("yyyy-MM-dd");
        txtcalen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtcalenPropertyChange(evt);
            }
        });

        jLabel2.setText("ID Anggota");
        jLabel2.setToolTipText("");

        jLabel3.setText("Nama");

        jLabel4.setText("Tgl Lahir");

        jLabel5.setText("Kontak");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Data Anggota");

        dataAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataAnggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataAnggota);

        jButton1.setText("cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.setToolTipText("edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.setToolTipText("delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Save");
        jButton4.setToolTipText("save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("kembali");
        jButton5.setToolTipText("menu utama");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("New Data");
        jButton6.setToolTipText("data baru");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel9.setText("Alamat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1))))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcalen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(218, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtcalen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-513)/2, (screenSize.height-473)/2, 513, 473);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        frm_menu f=new frm_menu();
                f.show();
                this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
         
        Connection c = koneksi.getkoneksi();     
        Statement stm=c.createStatement();
        model.getDataVector().removeAllElements();
        rs=stm.executeQuery("select * from anggota where nama like '%"+txtNama.getText()+"%'");
        while (rs.next()){
        Object [] data={rs.getString("id_anggota"),
                        rs.getString("nama"),
                        rs.getString("tanggal_lahir"),
                        rs.getString("alamat"),
                        rs.getString("kontak"),
            };
        model.addRow(data);
        }

    
    }catch(Exception e){
           e.printStackTrace();
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dataAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataAnggotaMouseClicked
       tblKeForm();
    }//GEN-LAST:event_dataAnggotaMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        kosongkanForm();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         try {
            Connection c = koneksi.getkoneksi();
            String sql = "Insert into anggota values (?,?,?,?,?)";
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            	
                p.setString(1, txtId.getText());
                p.setString(2, txtNama.getText());
                p.setString(3, tanggal1);
                p.setString(4, txtAlamat.getText());
                p.setString(5, txtKontak.getText());
                             
            p.executeUpdate();
            p.close();
               JOptionPane.showMessageDialog(rootPane, "data berhasil dimasukan");
               loadData();
               kosongkanForm();
        }   catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, "data belum komplit");
            System.out.println("Terjadi kesalahan");
        }       // TODO add your handling code here:

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtcalenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtcalenPropertyChange
       if (txtcalen.getDate()!=null){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        tanggal1=format.format(txtcalen.getDate());
        }
    }//GEN-LAST:event_txtcalenPropertyChange

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
                autonumber();
    }//GEN-LAST:event_txtIdActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try {
            Connection c = koneksi.getkoneksi();
            String sql = "update anggota set nama=?, tanggal_lahir=?, alamat=?, kontak=? where id_anggota=?";
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            	p.setString(1, txtNama.getText());
                p.setString(2, tanggal1);
                p.setString(3, txtAlamat.getText());
                p.setString(4, txtKontak.getText());
                p.setString(5, txtId.getText());

            p.executeUpdate();
            p.close();
               loadData();
               kosongkanForm();
        }   catch(SQLException e){
            System.out.println("Terjadi kesalahan");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Connection c = koneksi.getkoneksi();
            String sql = "delete from anggota where id_anggota=?";
            PreparedStatement p=(PreparedStatement) c.prepareStatement(sql);
            	p.setString(1, txtId.getText());
            p.executeUpdate();
            p.close();
               loadData();
               kosongkanForm();
        }   catch(SQLException e){
            System.out.println("Terjadi kesalahan");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

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
            java.util.logging.Logger.getLogger(frm_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_anggota().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataAnggota;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKontak;
    private javax.swing.JTextField txtNama;
    private com.toedter.calendar.JDateChooser txtcalen;
    // End of variables declaration//GEN-END:variables
}