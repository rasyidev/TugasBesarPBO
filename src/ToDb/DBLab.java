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
    
    public DBLab(){
        
    }
    
    public DBLab(JTable table){
        this.table=table;
    }

    public void lab(Labolaturium lab){
           this.lab=lab;
       }
    
    public void setLab(Labolaturium lab){
        this.lab=lab;
    }
    
    public void delete(){ //menghapus data
        try(
            Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String delete = "delete from lab where kode_lab = '"+lab.getKodelab()+"'";
            stmt.executeUpdate(delete);
        }catch (SQLException ex) {
            
        }
    }
    public void update(String kode){ //merubah data
        try(
                Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String update = "update lab set kode_lab='"+lab.getKodelab()+"',nama_lab='"+lab.getNamalab()+"',nama_ruang='"+lab.getRuang()+
                    "',kapasitas="+lab.getKapasitas()+" where kode_lab='"+kode+"'";
            stmt.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "update data berhasil");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "gagal update data");
        }
        if (kode==null){
            JOptionPane.showMessageDialog(null, "pilih kolom yang ingin di update");
        }
    }
    
    public void add(){ //tambah data
        
        try(
            Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String insert = "insert into lab values ('"+lab.getKodelab()+"','"+lab.getNamalab()+"','"+lab.getRuang()+"',"+
                    lab.getKapasitas()+")";
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "tambah data berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "gagal tambah data");
        }
    }
    
    public void tampil(){ //menampilkan data
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
    
    public void urut(String kolom){ //urutkan data
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
    
    public void cari(String kolom){ //mencari nilai
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
