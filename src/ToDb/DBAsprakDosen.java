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
public class DBAsprakDosen extends Masuk {

    private DBAsprakDosen mp;
    public DBAsprakDosen (){
        DBAsprakDosen mp = new DBAsprakDosen();
    }
    
    public DBAsprakDosen (DBAsprakDosen mp) {
        this.mp = mp;
    }

    @Override
    public void setSQL(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validasiData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
