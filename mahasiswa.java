public class mahasiswa {
    int nim;
    String nama;
    int umur;
    double ipk;

    mahasiswa(int ni, String n, int u, double i) {
        nim = ni;
        nama = n;
        umur = u;
        ipk = i;
    }

    void tampil() {
        System.out.println("Nim\t: " + nim);
        System.out.println("Nama\t: " + nama);
        System.out.println("Umur\t: " + umur);
        System.out.println("IPK\t: " + ipk);
    }
}