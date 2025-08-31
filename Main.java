// Class Barang
class Barang {
    private String kode;
    private String nama;
    private int jumlah;

    public Barang(String kode, String nama, int jumlah) {
        this.kode = kode;
        this.nama = nama;
        this.jumlah = jumlah;
    }

    // Getter
    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    // Setter untuk mengurangi jumlah barang
    public void kurangiStok(int jumlahPinjam) {
        if (jumlahPinjam > 0 && jumlahPinjam <= jumlah) {
            this.jumlah -= jumlahPinjam;
        } else {
            System.out.println("Jumlah barang tidak mencukupi!");
        }
    }
}

// Class Peminjaman
class Peminjaman {
    private String namaPeminjam;
    private Barang barang;
    private int jumlahPinjam;

    // Constructor
    public Peminjaman(String namaPeminjam, Barang barang, int jumlahPinjam) {
        this.namaPeminjam = namaPeminjam;
        this.barang = barang;
        this.jumlahPinjam = jumlahPinjam;
        barang.kurangiStok(jumlahPinjam);
    }

    public void infoPeminjaman() {
        System.out.println("Peminjam: " + namaPeminjam);
        System.out.println("Barang  : " + barang.getNama());
        System.out.println("Jumlah  : " + jumlahPinjam);
    }
}

// Main class untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Buat objek barang
        Barang laptop = new Barang("B001", "Laptop Acer", 5);
        Barang proyektor = new Barang("B002", "Proyektor Epson", 3);

        // Peminjaman barang
        Peminjaman p1 = new Peminjaman("Naufal", laptop, 2);
        Peminjaman p2 = new Peminjaman("Viona", proyektor, 1);

        // Tampilkan informasi peminjaman
        System.out.println("=== Data Peminjaman ===");
        p1.infoPeminjaman();
        System.out.println();
        p2.infoPeminjaman();

        // Cek stok barang tersisa
        System.out.println("\n=== Sisa Stok Barang ===");
        System.out.println(laptop.getNama() + " : " + laptop.getJumlah());
        System.out.println(proyektor.getNama() + " : " + proyektor.getJumlah());
    }
}
