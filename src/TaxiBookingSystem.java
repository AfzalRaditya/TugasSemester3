import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas TaxiBookingSystem menyediakan cara sederhana untuk mengelola dan menghitung pesanan taksi,
 * termasuk mencatat jenis taksi, jarak tempuh, dan harga untuk setiap pesanan.
 */
public class TaxiBookingSystem {
    /**
     * Daftar jenis taksi untuk setiap pesanan.
     */
    private ArrayList<String> taxiTypes;

    /**
     * Daftar jarak tempuh untuk setiap pesanan dalam kilometer.
     */
    private ArrayList<Double> tripDistances;

    /**
     * Daftar harga untuk setiap pesanan.
     */
    private ArrayList<Double> farePrices;

    /**
     * Membuat instance dari TaxiBookingSystem, menginisialisasi daftar untuk menyimpan
     * jenis taksi, jarak tempuh, dan harga.
     */
    public TaxiBookingSystem() {
        taxiTypes = new ArrayList<>();
        tripDistances = new ArrayList<>();
        farePrices = new ArrayList<>();
    }

    /**
     * Menambahkan pesanan taksi ke dalam sistem dengan jenis taksi, jarak tempuh, dan harga.
     *
     * @param taxiType     Jenis taksi untuk pesanan (misalnya, "Sedan", "SUV").
     * @param tripDistance Jarak tempuh perjalanan dalam kilometer.
     * @param farePrice    Harga untuk perjalanan tersebut.
     */
    public void addTaxiBooking(String taxiType, double tripDistance, double farePrice) {
        taxiTypes.add(taxiType);
        tripDistances.add(tripDistance);
        farePrices.add(farePrice);
    }

    /**
     * Menampilkan semua pesanan taksi dengan detail termasuk jenis taksi, jarak tempuh, dan harga.
     */
    public void displayTaxiBookings() {
        System.out.println("Daftar Pesanan Taksi:");
        for (int i = 0; i < taxiTypes.size(); i++) {
            System.out.println(taxiTypes.get(i) + " - " + tripDistances.get(i) + " km - Rp" + farePrices.get(i));
        }
    }

    /**
     * Menghitung total harga untuk semua pesanan.
     *
     * @return Total harga sebagai nilai double.
     */
    public double calculateTotalFare() {
        double totalFare = 0;
        for (double farePrice : farePrices) {
            totalFare += farePrice;
        }
        return totalFare;
    }

    /**
     * Metode utama menjalankan aplikasi pemesanan taksi, memungkinkan pengguna untuk menambah
     * beberapa pesanan dan melihat total harga.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaxiBookingSystem bookingSystem = new TaxiBookingSystem();

        System.out.println("Masukkan jumlah pesanan taksi:");
        int bookingCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < bookingCount; i++) {
            System.out.println("Masukkan jenis kendaraan:");
            String taxiType = sc.nextLine();
            System.out.println("Masukkan jarak tempuh (dalam km):");
            double tripDistance = sc.nextDouble();
            System.out.println("Masukkan harga per km:");
            double pricePerKm = sc.nextDouble();
            sc.nextLine();
            double totalFare = tripDistance * pricePerKm;
            bookingSystem.addTaxiBooking(taxiType, tripDistance, totalFare);
        }

        bookingSystem.displayTaxiBookings();
        System.out.println("Total Harga: Rp" + bookingSystem.calculateTotalFare());
    }
}
