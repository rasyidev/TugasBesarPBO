package penjelasan;
public class Asprak_atau_Dosen {
    char NIMorNIK;
    String nama;
    int id_jadwal;

    public char getNIMorNIK() {
        return NIMorNIK;
    }

    public void setNIMorNIK(char NIMorNIK) {
        this.NIMorNIK = NIMorNIK;
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

    public Asprak_atau_Dosen(char NIMorNIK, String nama, int id_jadwal) {
        this.NIMorNIK = NIMorNIK;
        this.nama = nama;
        this.id_jadwal = id_jadwal;
    }

    
}
