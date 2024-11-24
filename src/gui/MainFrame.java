package gui;

import model.Bahan;
import model.Kategori;
import model.Unit;
import repository.BahanRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;

/**
 * MainFrame adalah jendela utama untuk aplikasi.
 * Ini berisi komponen UI dan menginisialisasi pengaturan frame utama.
 */
public class MainFrame extends JFrame {

    // Komponen UI
    private JPanel panel1;
    private JTable table1;
    private JButton tambahButton;
    private JButton editButton;
    private JButton hapusButton;
    private JTextField namaField;
    private JComboBox kategoriComboBox;
    private JComboBox unitComboBox;
    private JTextField hargaField;
    private JTextField stokField;
    private JButton blurButton;

    // Daftar variabel
    private DefaultTableModel tableModel;
    private BahanRepository bahanRepository;

    // Number formatter
    NumberFormat numberFormat = NumberFormat.getInstance();

    /**
     * Membuat frame utama baru.
     */
    public MainFrame() {
        // Inisialisasi frame
        setTitle("Aplikasi Pengelolaan Stok Bahan");
        setContentPane(panel1);
        setSize(800, 600);
        setMinimumSize(getSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi komponen
        kategoriComboBox.addItem(null);
        unitComboBox.addItem(null);

        for (Kategori kategori : Kategori.values()) {
            kategoriComboBox.addItem(kategori);
        }

        for (Unit unit : Unit.values()) {
            unitComboBox.addItem(unit);
        }

        // Inisialisasi model tabel
        String[] columnNames = {"Nama", "Kategori", "Unit", "Harga", "Stok", "Total"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table1.setModel(tableModel);

        bahanRepository = new BahanRepository();

        tambahButton.addActionListener(e -> {
            try {
                String nama = namaField.getText();
                Kategori kategori = (Kategori) kategoriComboBox.getSelectedItem();
                Unit unit = (Unit) unitComboBox.getSelectedItem();
                double harga = Double.parseDouble(hargaField.getText());
                int stok = Integer.parseInt(stokField.getText());
                Bahan bahan = new Bahan(nama, kategori, unit, harga, stok);
                bahanRepository.addBahan(bahan);
                updateTable();
                clearFields();
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Input tidak valid");
            }
        });

        table1.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                tambahButton.setEnabled(false);
                Bahan bahan = bahanRepository.getBahanByIndex(selectedRow);
                namaField.setText(bahan.getNama());
                kategoriComboBox.setSelectedItem(bahan.getKategori());
                unitComboBox.setSelectedItem(bahan.getUnit());
                hargaField.setText(String.valueOf(bahan.getHarga()));
                stokField.setText(String.valueOf(bahan.getStok()));
            }
        });

        editButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                try {
                    Bahan bahan = bahanRepository.getBahanByIndex(selectedRow);
                    bahan.setNama(namaField.getText());
                    bahan.setKategori((Kategori) kategoriComboBox.getSelectedItem());
                    bahan.setUnit((Unit) unitComboBox.getSelectedItem());
                    bahan.setHarga(Double.parseDouble(hargaField.getText()));
                    bahan.setStok(Integer.parseInt(stokField.getText()));
                    updateTable();
                    clearFields();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Input tidak valid");
                }
            }
        });

        hapusButton.addActionListener(e -> {
            int[] selectedRow = table1.getSelectedRows();

            for (int i = selectedRow.length - 1; i >= 0; i--) {
                if (selectedRow[i] != -1) {
                    bahanRepository.removeBahanByIndex(selectedRow[i]);
                    updateTable();
                    clearFields();
                }
            }
        });

        blurButton.addActionListener(e -> {
            table1.clearSelection();
            clearFields();
        });

    }

    private void updateTable() {
        tableModel.setRowCount(0);

        for (Bahan bahan : bahanRepository.getBahanList()) {
            tableModel.addRow(new Object[]{
                    bahan.getNama(),
                    bahan.getKategori(),
                    bahan.getUnit(),
                    numberFormat.format(bahan.getHarga()),
                    numberFormat.format(bahan.getStok()),
                    numberFormat.format(bahan.getHarga() * bahan.getStok())
            });
        }
    }

    private void clearFields() {
        tambahButton.setEnabled(true);
        namaField.setText("");
        kategoriComboBox.setSelectedIndex(0);
        unitComboBox.setSelectedIndex(0);
        hargaField.setText("");
        stokField.setText("");
    }
}
