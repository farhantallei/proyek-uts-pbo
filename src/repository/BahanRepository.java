package repository;

import model.Bahan;

import java.util.ArrayList;

/**
 * BahanRepository adalah kelas yang menyimpan daftar bahan.
 * Kelas ini digunakan untuk menyimpan bahan-bahan yang telah ditambahkan.
 */
public class BahanRepository {
    private final ArrayList<Bahan> bahanList;

    /**
     * Membuat objek BahanRepository.
     */
    public BahanRepository() {
        bahanList = new ArrayList<>();
    }

    public void addBahan(Bahan bahan) {
        bahanList.add(bahan);
    }

    public void removeBahanByIndex(int index) {
        bahanList.remove(index);
    }

    public Bahan getBahanByIndex(int index) {
        return bahanList.get(index);
    }

    public ArrayList<Bahan> getBahanList() {
        return bahanList;
    }
}
