/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjelasan;

/**
 *
 * @author Mahasiswa
 */
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connect {
    private  Connection conn;
    
    public Connect(){
        
       MysqlDataSource mds = new MysqlDataSource();
        mds.setUser("root");
        mds.setPassword("");
        mds.setDatabaseName("labkom_itera1");
        
        try {
            conn = mds.getConnection();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"KONEKSI GAGAL "+ex.getMessage());
        }
    }
    public Connection getKoneksi(){
        return this.conn;
    }
    
    public static void main(String[] args) {
        Connect k = new Connect();
    }
    
}
