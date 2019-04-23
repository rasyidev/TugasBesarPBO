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
public class Jadwal {
    int id_jadwal;
    String prodi,matkul,tanggal,jam,kode_lab;

    public Jadwal(int id_jadwal, String prodi, String matkul, String tanggal, String jam, String kode_lab) {
        this.id_jadwal = id_jadwal;
        this.prodi = prodi;
        this.matkul = matkul;
        this.tanggal = tanggal;
        this.jam = jam;
        this.kode_lab = kode_lab;
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

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public void setKode_lab(String kode_lab) {
        this.kode_lab = kode_lab;
    }

    public String getProdi() {
        return prodi;
    }

    public String getMatkul() {
        return matkul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public String getKode_lab() {
        return kode_lab;
    }
    
    
}
