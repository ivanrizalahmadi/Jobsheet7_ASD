import java.util.Arrays;
import java.util.Comparator;

public class pencarianMhs {
    mahasiswa listMhs[];
    int idx;

    void tambah(mahasiswa m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data Sudah Penuh !!");
        }
    }

    void tampil() {
        for (mahasiswa m : listMhs) {
            m.tampil();
            System.out.println("-----------------------");
        }
    }

    public int[] findBinarySearch(String cari, int left, int right) {
        int mid;
        int count = 0;
        int[] posisi = new int[listMhs.length];

        while (right >= left) {
            mid = (left + right) / 2;
            if (cari.equals(listMhs[mid].nama)) {
                posisi[count++] = mid;
                // Cek ke kiri
                int temp = mid - 1;
                while (temp >= left && cari.equals(listMhs[temp].nama)) {
                    posisi[count++] = temp;
                    temp--;
                }
                // Cek ke kanan
                temp = mid + 1;
                while (temp <= right && cari.equals(listMhs[temp].nama)) {
                    posisi[count++] = temp;
                    temp++;
                }
                return posisi;
            } else if (listMhs[mid].nama.compareTo(cari) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] { -1 };
    }

    public void tampilPosisi(String x, int[] pos) {
        if (pos[0] != -1) {
            System.out.println("Data '" + x + "' ditemukan pada indeks : ");
            for (int i = 0; i < pos.length && pos[i] != -1; i++) {
                System.out.println(pos[i]);
            }
        } else {
            System.out.println("Data '" + x + "' tidak ditemukan");
        }
    }

    public void tampilData(String x, int[] pos) {
        if (pos[0] != -1) {
            System.out.println("Detail Mahasiswa dengan Nama '" + x + "':");
            for (int i = 0; i < pos.length && pos[i] != -1; i++) {
                System.out.println("Nim\t: " + listMhs[pos[i]].nim);
                System.out.println("Umur\t: " + listMhs[pos[i]].umur);
                System.out.println("IPK\t: " + listMhs[pos[i]].ipk);
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("Data '" + x + "' tidak ditemukan");
        }
    }
}