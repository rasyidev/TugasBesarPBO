package penjelasan;
public class Asprak {
    char NIM;
    
    public Asprak(){};

    public Asprak(char NIM, String nama, int id_jadwal) {
        this.NIM = NIM;
        this.nama = nama;
        this.id_jadwal = id_jadwal;
    }

    public char getNIM() {
        return NIM;
    }

    public void setNIM(char NIM) {
        this.NIM = NIM;
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
    String nama;
    int id_jadwal;

}