/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjelasan;

/**
 *
 * @author USER
 */
public class UserLogin {
    String usename;
    String password;
    
    public UserLogin(){
        
    }
    public UserLogin(String username,String password){
        this.usename=username;
        this.password=password;
    }

    public String getUsename() {
        return usename;
    }

    public String getPassword() {
        return password;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
