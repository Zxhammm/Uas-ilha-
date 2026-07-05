/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceHP;

/**
 *
 * @author H4mm._
 */
public class ServiceHP {
    private final Kerusakan[] daftarkerusakan = new Kerusakan[5];
    private int jumlah = 0 ;
    
    public void tambahKerusakan (Kerusakan k) {
        
        try {
            if (jumlah >= daftarkerusakan.length)
                throw new Exception ("katalog penuh");
            daftarkerusakan[jumlah++] = k;
        }catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
                
        }
    }
    
    public void tampilkanKatalog(){
        System.out.println("\n == daftar jenis kerusakan & service hp ====");
        for (int i = 0; i < jumlah; i++){
            System.out.printf("%d. %s%n",(i+1),daftarkerusakan[i].getNamaKerusakan());
        }
    }
    public Kerusakan getKerusakan(int nomor){
        if (nomor < 1 || nomor > jumlah){
            System.out.println("Nomor kerusakan tidak valid");
            return null;
        }
        return daftarkerusakan [nomor - 1];
    }
    public int getJumlah() {return jumlah;}
}
