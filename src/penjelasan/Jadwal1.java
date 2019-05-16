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
public class Jadwal1 {
    int id_jadwal;
    String prodi,matkul,hari,jam,kodelab;

    public Jadwal1(int id_jadwal, String prodi, String matkul, String kodelab,String hari, String jam) {
        this.id_jadwal = id_jadwal;
        this.prodi = prodi;
        this.matkul = matkul;
        this.hari = hari;
        this.jam = jam;
        this.kodelab = kodelab;
    }
   
    public void setId_jadwal(int id_jadwal){
        this.id_jadwal=id_jadwal;
    }
    public int getId_jadwal(){
        return this.id_jadwal;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public void setTanggal(String hari) {
        this.hari= hari;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public void setKode_lab(String kodelab) {
        this.kodelab = kodelab;
    }

    public String getProdi() {
        return prodi;
    }

    public String getMatkul() {
        return matkul;
    }

    public String getHari() {
        return hari;
    }

    public String getJam() {
        return jam;
    }

    public String getKode_lab() {
        return kodelab;
    }
    
    
}
