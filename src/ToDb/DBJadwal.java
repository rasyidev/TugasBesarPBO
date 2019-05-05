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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class DBJadwal {
    private String table;
    
    public void DBJadwal(JTable table){
        this.table="jadwal";
    }
    
    public void table(JTable table){
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
            table.setModel(x);
        }catch(SQLException ex){
            
        }
    }
    
}
