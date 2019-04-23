package penjelasan;
public class Asprak {
    int nim;
    String nama;
    int id_jadwal;

    public int getNim() {
        return nim;
    }
    
    
    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(int id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public Asprak(int nim, String nama, int id_jadwal) {
        this.nim = nim;
        this.nama = nama;
        this.id_jadwal = id_jadwal;
    }
    
}
