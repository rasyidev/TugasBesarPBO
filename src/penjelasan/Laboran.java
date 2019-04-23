/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjelasan;

/**
 *
 * @author asus
 */
public class Laboran extends User{
    
    String username;
    String password;

    public Laboran(String username, String password, int id, String nama, String email, String jkel) {
        super(id, nama, email, jkel);
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
