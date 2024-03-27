import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class mahasiswaMain {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        pencarianMhs data = new pencarianMhs();
        System.out.print("Masukkan jumlah data Mahasiswa : ");
        int jumMhs = s.nextInt();
        mahasiswa[] inputan = new mahasiswa[jumMhs];
        data.listMhs = inputan;

        System.out.println("-----------------------------------------------------");
        System.out.println("Masukkan data mahasiswa secara urut dari Nama terkecil");
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("-----------------------------------------------------");
            System.out.print("Nim\t: ");
            int nim = s.nextInt();
            System.out.print("Nama\t: ");
            String nama = s.next();
            System.out.print("Umur\t: ");
            int umur = s.nextInt();
            System.out.print("IPK\t: ");
            double ipk = s.nextDouble();

            mahasiswa m = new mahasiswa(nim, nama, umur, ipk);
            data.tambah(m);
        }

        Arrays.sort(data.listMhs, Comparator.comparing(m -> m.nama));

        System.out.println("________________________________________________________");
        System.out.println("Data Keseluruhan Mahasiswa : ");
        data.tampil();

        System.out.println("______________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan Nama Mahasiswa yang dicari : ");
        System.out.print("Nama\t: ");
        String cari = s.next();
        System.out.println("Menggunakan Binary Search");
        int[] posisi = data.findBinarySearch(cari, 0, jumMhs - 1);

        data.tampilPosisi(cari, posisi);
        data.tampilData(cari, posisi);
    }
}