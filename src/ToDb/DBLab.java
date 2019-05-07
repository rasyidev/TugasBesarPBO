/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import penjelasan.Connect;
import penjelasan.Labolaturium;

/**
 *
 * @author USER
 */
public class DBLab {
    JTable table;
    Labolaturium lab;
    
    public DBLab(Labolaturium Lab){
        this.lab=Lab;
    }
    
    public DBLab(JTable table){
        this.table=table;
    }

    public void lab(Labolaturium lab){
           this.lab=lab;
       }
    
    
    public void tampil(){
        DefaultTableModel x = new DefaultTableModel();
        x.addColumn("KODE LAB");
        x.addColumn("NAMA LAB");
        x.addColumn("RUANG LAB");
        x.addColumn("KAPASITAS");
        try(
            Connection y = new Connect().getKoneksi();
            Statement stmt = y.createStatement();
        ){
            String strSelect = "select * from lab";
            
            ResultSet rset=stmt.executeQuery(strSelect);
            
            while(rset.next()){
                x.addRow(new Object[] {rset.getString("kode_lab"),rset.getString("nama_lab"),rset.getString("nama_ruang"),rset.getString("kapasitas")});
            }
            table.setModel(x);
        }catch(SQLException ex){
          
        }
    }
    
    public void urut(String kolom){
        DefaultTableModel x = new DefaultTableModel();
        x.addColumn("KODE LAB");
        x.addColumn("NAMA LAB");
        x.addColumn("RUANG LAB");
        x.addColumn("KAPASITAS");
        try(
                Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String strSelect = "select * from lab order by "+kolom+" asc";
            ResultSet rset=stmt.executeQuery(strSelect);
            while(rset.next()){
                x.addRow(new Object[] {rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4)});
            }
            table.setModel(x);
        }catch(SQLException ex){
            
        }
    }
    
    public void cari(String kolom){
        DefaultTableModel x = new DefaultTableModel();
        x.addColumn("KODE LAB");
        x.addColumn("NAMA LAB");
        x.addColumn("RUANG LAB");
        x.addColumn("KAPASITAS");
        try(
                Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String strSelect = "select * from lab where kode_lab like '%"+kolom+"%' or "+
                    "nama_lab like '%"+kolom+"%' or nama_ruang like '%"+kolom+"%' or kapasitas like '%"+kolom+"%'";
            ResultSet rset=stmt.executeQuery(strSelect);
            while(rset.next()){
                x.addRow(new Object[] {rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4)});
            }
            table.setModel(x);
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "gagal cari");
        }
    }
}
