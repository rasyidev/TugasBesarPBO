
package ToDb;

/**
 *
 * @author Mahasiswa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Masuk {
    
    
    public Masuk(){
        
    }
    
    public String pass(String username){
        String pass = null;    
        try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/labkom_itera1",
                    "root",
                    "");
                Statement stmt = conn.createStatement();
        ){
            String select = "select password from user where username='"+username+"'";
          
            ResultSet rset=stmt.executeQuery(select);
            int i=0;
            while(rset.next()){
                pass=rset.getString("password");
                i++;
            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"username tidak boleh kosong atau username tidak ada");
            }
            return pass;

        }catch(SQLException ex){
            
        }
        return "";
        
    }
    public String md5(String pass){
        String pw = null;
            try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/labkom_itera1",
                    "root",
                    "");
                Statement stmt = conn.createStatement();
        ){
            String select = "select md5('"+pass+"') as pw";
            ResultSet rset=stmt.executeQuery(select);
            
            while(rset.next()){
                pw=rset.getString("pw");
            }
            return pw;
        }catch(SQLException ex){
            
        }
        return "";
    }
    
    public boolean cekstatus(String username,String pass){
        if(pass(username).equals(md5(pass))){
            return true;
        }
        return false;
    }

}