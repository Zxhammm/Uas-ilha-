package serviceHP;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ServiceHP katalog = new ServiceHP();
        katalog.tambahKerusakan(new Kerusakan("Ganti LCD", 280000, 350000, 420000));
        katalog.tambahKerusakan(new Kerusakan("Ganti Baterai", 180000, 250000, 320000));
        katalog.tambahKerusakan(new Kerusakan("Flash", 150000, 250000, 300000));

        CabangService[] cabang = {
            new CabangJakarta(),
            new CabangBandung(),
            new CabangBanjarMasin()
        };

        String[] riwayat = new String[20];
        int jumlahRiwayat = 0;

        System.out.println("==================================");
        System.out.println(" Service HP - Cek dan Booking Biaya");
        System.out.println(" Jakarta | Bandung | Banjarmasin");
        System.out.println("==================================");

        boolean lanjut = true;

        while (lanjut) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Lihat Daftar Biaya Service");
            System.out.println("2. Booking Service");
            System.out.println("3. Keluar");
            System.out.print("Pilih : ");

            int pilihan;

            try {
                pilihan = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {

                case 1:
                    katalog.tampilkanKatalog();

                    System.out.print("Pilih nomor kerusakan : ");
                    int nomor1 = Integer.parseInt(sc.nextLine().trim());

                    Kerusakan k1 = katalog.getKerusakan(nomor1);

                    if (k1 != null) {
                        System.out.println();

                        for (CabangService c : cabang) {
                            c.tampilkanInfo(k1);
                            System.out.println();
                        }
                    }

                    break;

                case 2:

                    katalog.tampilkanKatalog();

                    System.out.print("Pilih nomor kerusakan : ");
                    int nomor2 = Integer.parseInt(sc.nextLine().trim());

                    Kerusakan k2 = katalog.getKerusakan(nomor2);

                    if (k2 != null) {

                        System.out.print("Pilih Cabang (1=Jakarta, 2=Bandung, 3=Banjarmasin) : ");
                        int pilihCabang = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Jumlah Unit HP : ");
                        int qty = Integer.parseInt(sc.nextLine().trim());

                        if (pilihCabang < 1 || pilihCabang > 3) {

                            System.out.println("Cabang tidak valid!");

                        } else {

                            double harga = cabang[pilihCabang - 1].getHarga(k2);
                            double total = harga * qty;

                            System.out.printf(
                                    "%nTotal : Rp %,.0f x %d = Rp %,.0f%n",
                                    harga, qty, total);

                            if (jumlahRiwayat < riwayat.length) {

                                riwayat[jumlahRiwayat] =
                                        k2.getNamaKerusakan()
                                        + " | "
                                        + cabang[pilihCabang - 1].namaCabang
                                        + " | "
                                        + qty
                                        + " unit x Rp "
                                        + String.format("%,.0f", harga)
                                        + " = Rp "
                                        + String.format("%,.0f", total);

                                jumlahRiwayat++;
                            }
                        }
                    }

                    System.out.print("\nMau booking lagi? (y/n) : ");
                    String jawab = sc.nextLine().trim().toLowerCase();

                    if (jawab.equals("n")) {

                        System.out.println("\n=====================================");
                        System.out.println("RIWAYAT BOOKING");
                        System.out.println("=====================================");

                        if (jumlahRiwayat == 0) {

                            System.out.println("Belum ada transaksi.");

                        } else {

                            for (int i = 0; i < jumlahRiwayat; i++) {
                                System.out.println((i + 1) + ". " + riwayat[i]);
                            }

                        }

                        System.out.println("=====================================");
                        System.out.println("Terima kasih telah menggunakan layanan kami.");

                        lanjut = false;
                    }

                    break;

                case 3:

                    System.out.println("\n=====================================");
                    System.out.println("RIWAYAT BOOKING");
                    System.out.println("=====================================");

                    if (jumlahRiwayat == 0) {

                        System.out.println("Belum ada transaksi.");

                    } else {

                        for (int i = 0; i < jumlahRiwayat; i++) {
                            System.out.println((i + 1) + ". " + riwayat[i]);
                        }

                    }

                    System.out.println("=====================================");
                    System.out.println("Terima kasih telah menggunakan layanan kami.");

                    lanjut = false;
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        }

        sc.close();
    }
}