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
import penjelasan.Jadwal1;

/**
 *
 * @author USER
 */
public class DBJadwal {
    JTable table;//=tbljadwal
    Jadwal1 jad;

   
    public DBJadwal(){
        
    }
    public DBJadwal(JTable table){
        this.table=table;
    }
    public void setJadwal(Jadwal1 jad){
        this.jad=jad;
    }
    public void table(){
        DefaultTableModel x = new DefaultTableModel();
        x.addColumn("id jadwal");
        x.addColumn("program studi");
        x.addColumn("mata kuliah");
        x.addColumn("hari");
        x.addColumn("jam");
        x.addColumn("kode lab");
        
        try(
            Connection y = new Connect().getKoneksi();
            Statement stmt = y.createStatement();
        ){
            String strSelect = "select * from jadwal";
            
            ResultSet rset=stmt.executeQuery(strSelect);
            
            while(rset.next()){
                x.addRow(new Object[] {rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(5),rset.getString(6),rset.getString(4)});
            }
            table.setModel(x);
        }catch(SQLException ex){
            
        }
    }
    
    public void urut(String kolom){
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
            table.setModel(x);
        }catch(SQLException ex){
            
        }
    }
    
    public void cari(String kolom){
        DefaultTableModel x = new DefaultTableModel();
        x.addColumn("id jadwal");
        x.addColumn("program studi");
        x.addColumn("mata kuliah");
        x.addColumn("hari");
        x.addColumn("jam");
        x.addColumn("kode lab");
        
        try(
            Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String strSelect = "select * from jadwal where id_jadwal like '%"+kolom+"%' or "+
                    "prodi like '%"+kolom+"%' or mata_kuliah like '%"+kolom+"%' or "+
                    "hari like '%"+kolom+"%' or jam like '%"+kolom+"%' or kode_lab like '%"+kolom+"%'";
            
            ResultSet rset=stmt.executeQuery(strSelect);
            
            while(rset.next()){
                x.addRow(new Object[] {rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(5),rset.getString(6),rset.getString(4)});
            }
            table.setModel(x);
        }catch(SQLException ex){
        }
    }
    
    public void update(int idjadwal){
        try(
            Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String update = "update jadwal set id_jadwal="+jad.getId_jadwal()+",prodi='"+jad.getProdi()+"',mata_kuliah='"+jad.getMatkul()+
                    "',kode_lab='"+jad.getKode_lab()+"',hari='"+jad.getHari()+"',jam='"+jad.getJam()+"' where id_jadwal = "+idjadwal;
            stmt.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "update data berhasil");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"gagal update data");
        }
    }
    
    public void add(){
        try(
            Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String insert = "insert into jadwal values ("+jad.getId_jadwal()+",'"+jad.getProdi()+"','"+jad.getMatkul()+"','"+
                    jad.getKode_lab()+"','"+jad.getHari()+"','"+jad.getJam()+"')";
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null,"tambah data berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"gagal tambah data");
        }
    }
    
    public void delete(){
        try(
            Connection y = new Connect().getKoneksi();
                Statement stmt = y.createStatement();
        ){
            String delete = "delete from jadwal where id_jadwal = '"+jad.getId_jadwal()+"'";
            stmt.executeUpdate(delete);
        }catch (SQLException ex) {

        }
        
    }
}
