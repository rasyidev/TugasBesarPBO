/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToDb;

/**
 *
 * @author Mahasiswa
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import penjelasan.Connect;

public abstract class Masuk {
    protected String sql;
    private final Connection conn = new Connect().getKoneksi();
    private ResultSet  rs;
    private Statement st;
    
    
    public abstract void setSQL(String username);
    
    //Menngambil password User
    public String getPasswordUser(){
        String pass = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                pass = rs.getString("password");
            }
            return pass;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    //konveri password ke md5
    public String Password(String p){
        
        String pass = null;
        try {
            st = conn.createStatement();
            String sqlConversi = " SELECT md5('"+p+"') as pass";
            rs = st.executeQuery(sqlConversi);
            while(rs.next()){
                pass = rs.getString("pass");
            }
            return pass;
        } catch (SQLException ex) {
            
        }
     
        
        return "";
    }
    
    public boolean passwordCocok(String password){
        if(getPasswordUser()!=null){
            if(getPasswordUser().equals(md5Password(password))){
                return true;
            }
        }
        return false;
    }
    
    public boolean validasiUser(String u,String p){
        setSQL(u);
        return (
                    !u.isEmpty() && !p.isEmpty() &&
                    passwordCocok(p)
                );
    }
    
//    SIGN UP
    
   public  abstract boolean  validasiData();
   
   public void Pesan(String text){
       JOptionPane.showMessageDialog(null, text);
   }
   
   public void Daftar(){
       setSQL();
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            Pesan("Berhasil ditambahkan");
        } catch (SQLException ex) {

            if(ex.getErrorCode()==1062){
                Pesan(
                    "Gagal Mendaftar \n"+
                            "Username Sudah Ditambah,\n"
                            + "Gunakan Username Lain!");   
            }else{
                Pesan(
                    "Gagal Mendaftar \n"+
                            ex.getMessage());   
            }
        
        }
   
   }
   public abstract  void setSQL();

    private Object md5Password(String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}