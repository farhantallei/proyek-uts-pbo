package model;

/**
 * Kelas ini merepresentasikan bahan yang akan digunakan dalam pembuatan makanan.
 * Bahan memiliki nama, kategori, unit, harga, dan stok.
 */
public class Bahan {

    // Atribut yang dimiliki oleh kelas Bahan.
    private String nama;
    private Kategori kategori;
    private Unit unit;
    private double harga;
    private int stok;

    /**
     * Konstruktor dari kelas Bahan.
     * @param nama nama dari bahan.
     * @param kategori kategori dari bahan.
     * @param unit unit dari bahan.
     * @param harga harga dari bahan.
     * @param stok stok dari bahan.
     */
    public Bahan(String nama, Kategori kategori, Unit unit, double harga, int stok) {
        this.nama = nama;
        this.kategori = kategori;
        this.unit = unit;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public Unit getUnit() {
        return unit;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
