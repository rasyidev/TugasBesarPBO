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
public class Labolaturium {
    int kapasitas;
    String kodelab,namalab,ruang;

    public Labolaturium(String kode,String nama,String ruang,int kapasitas) {
        this.kodelab=kode;
        this.namalab = nama;
        this.ruang = ruang;
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public String getKodelab() {
        return kodelab;
    }

    public String getNamalab() {
        return namalab;
    }

    public String getRuang() {
        return ruang;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setKodelab(String kodelab) {
        this.kodelab = kodelab;
    }

    public void setNamalab(String namalab) {
        this.namalab = namalab;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }
    
}
