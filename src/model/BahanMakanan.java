package model;

import java.util.Date;

/**
 * Kelas ini merepresentasikan bahan makanan yang akan digunakan dalam pembuatan makanan.
 * Bahan makanan memiliki nama, kategori, unit, harga, stok, dan tanggal kedaluwarsa.
 */
public class BahanMakanan extends Bahan {
    private Date tanggalKedaluwarsa;

    /**
     * Konstruktor dari kelas BahanMakanan.
     * @param nama nama dari bahan makanan.
     * @param kategori kategori dari bahan makanan.
     * @param unit unit dari bahan makanan.
     * @param harga harga dari bahan makanan.
     * @param stok stok dari bahan makanan.
     * @param tanggalKedaluwarsa tanggal kedaluwarsa dari bahan makanan.
     */
    public BahanMakanan(
            String nama,
            Kategori kategori,
            Unit unit,
            double harga,
            int stok,
            Date tanggalKedaluwarsa
    ) {
        super(nama, kategori, unit, harga, stok);
        this.tanggalKedaluwarsa = tanggalKedaluwarsa;
    }

    public Date getTanggalKedaluwarsa() {
        return tanggalKedaluwarsa;
    }

    public void setTanggalKedaluwarsa(Date tanggalKedaluwarsa) {
        this.tanggalKedaluwarsa = tanggalKedaluwarsa;
    }
}
