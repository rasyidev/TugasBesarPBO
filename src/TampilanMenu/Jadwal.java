/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TampilanMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Jadwal extends javax.swing.JFrame {
  
     private void tampilkandata(){
        DefaultTableModel x = new DefaultTableModel();
        x.addColumn("id jadwal");
        x.addColumn("program studi");
        x.addColumn("mata kuliah");
        x.addColumn("hari");
        x.addColumn("jam");
        x.addColumn("kode lab");
        
        try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/labkom_itera1",
                    "root",
                    "");
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select * from jadwal";
            
            ResultSet rset=stmt.executeQuery(strSelect);
            
            while(rset.next()){
                x.addRow(new Object[] {rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(5),rset.getString(6),rset.getString(4)});
            }
            tbljadwal.setModel(x);
        }catch(SQLException ex){
            
        }
    }
     private void tampilkandata(String kolom){
        DefaultTableModel x = new DefaultTableModel();
        x.addColumn("id jadwal");
        x.addColumn("program studi");
        x.addColumn("mata kuliah");
        x.addColumn("hari");
        x.addColumn("jam");
        x.addColumn("kode lab");
        
        try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/labkom_itera1",
                    "root",
                    "");
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select * from jadwal order by "+kolom+" asc";
            
            ResultSet rset=stmt.executeQuery(strSelect);
            
            while(rset.next()){
                x.addRow(new Object[] {rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(5),rset.getString(6),rset.getString(4)});
            }
            tbljadwal.setModel(x);
        }catch(SQLException ex){
            
        }
    }
     
     private void tampilkancari(String kolom){
        DefaultTableModel x = new DefaultTableModel();
        x.addColumn("id jadwal");
        x.addColumn("program studi");
        x.addColumn("mata kuliah");
        x.addColumn("hari");
        x.addColumn("jam");
        x.addColumn("kode lab");
        
        try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/labkom_itera1",
                    "root",
                    "");
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select * from jadwal where id_jadwal like '%"+kolom+"%' or "+
                    "prodi like '%"+kolom+"%' or mata_kuliah like '%"+kolom+"%' or "+
                    "hari like '%"+kolom+"%' or jam like '%"+kolom+"%' or kode_lab like '%"+kolom+"%'";
            
            ResultSet rset=stmt.executeQuery(strSelect);
            
            while(rset.next()){
                x.addRow(new Object[] {rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(5),rset.getString(6),rset.getString(4)});
            }
            tbljadwal.setModel(x);
        }catch(SQLException ex){
            TFPESAN.setText("gagal cari");
            ex.printStackTrace();
        }
    }
    /**
     * Creates new form Jadwal
     */
    public Jadwal() {
        initComponents();
        tampilkandata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbljadwal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFCARI = new javax.swing.JTextField();
        BTNCARI = new javax.swing.JButton();
        BTNBATAL = new javax.swing.JButton();
        TFPESAN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmburut = new javax.swing.JComboBox();
        btnubah = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbljadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id jadwal", "program studi", "mata kuliah", "hari", "jam", "kode lab"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbljadwal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 326, 1013, 139));

        jLabel1.setText("JADWAL LAB KOMPUTER ITERA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, 42));

        jLabel2.setText("CARI JADWAL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 95, -1, 27));
        getContentPane().add(TFCARI, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 128, 243, -1));

        BTNCARI.setText("CARI");
        BTNCARI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCARIActionPerformed(evt);
            }
        });
        getContentPane().add(BTNCARI, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 166, -1, -1));

        BTNBATAL.setText("BATAL");
        BTNBATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBATALActionPerformed(evt);
            }
        });
        getContentPane().add(BTNBATAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 166, -1, -1));
        getContentPane().add(TFPESAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 207, 243, 51));

        jLabel3.setText("URUTKAN JADWAL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 95, -1, 27));

        jLabel4.setText("BERDASARKAN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 129, -1, 20));

        cmburut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "id jadwal", "program studi", "mata kuliah", "hari", "jam", "kode lab" }));
        cmburut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmburutActionPerformed(evt);
            }
        });
        getContentPane().add(cmburut, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 190, -1));

        btnubah.setText("UBAH DATA");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });
        getContentPane().add(btnubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(791, 128, -1, -1));

        btnkembali.setText("KEMBALI");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(791, 169, 89, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNBATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBATALActionPerformed
       TFCARI.setText(null);
    }//GEN-LAST:event_BTNBATALActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        menuJadwal x = new menuJadwal();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        MenuUtama x = new MenuUtama();
        x.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void cmburutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmburutActionPerformed
        String kolom;
        
        if (cmburut.getSelectedItem()=="id jadwal"){
           tampilkandata("id_jadwal");
        }
        else if (cmburut.getSelectedItem()=="program studi"){
            tampilkandata("prodi");
        }
        else if (cmburut.getSelectedItem()=="mata kuliah"){
            tampilkandata("matkul");
        }
        else if (cmburut.getSelectedItem()=="hari"){
            tampilkandata("hari");
        }
        else if (cmburut.getSelectedItem()=="jam"){
            tampilkandata("jam");
        }
        else if (cmburut.getSelectedItem()=="kode lab"){
            tampilkandata("kode_lab");
        }
    }//GEN-LAST:event_cmburutActionPerformed

    private void BTNCARIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCARIActionPerformed
        String kolom=TFCARI.getText();
        tampilkancari(kolom);
    }//GEN-LAST:event_BTNCARIActionPerformed

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
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBATAL;
    private javax.swing.JButton BTNCARI;
    private javax.swing.JTextField TFCARI;
    private javax.swing.JTextField TFPESAN;
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox cmburut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbljadwal;
    // End of variables declaration//GEN-END:variables
}
