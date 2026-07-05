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
public abstract class CabangService {
    protected String namaCabang;
    protected String kodeCabang;
    
    public CabangService (String namaCabang,String kodeCabang ){
        this.namaCabang = namaCabang;
        this.kodeCabang = kodeCabang;    
    }
    
    public abstract double getHarga (Kerusakan kerusakan);
    
    public void tampilkanInfo (Kerusakan kerusakan){
        System.out.println("cabang        : "+ namaCabang);
        System.out.println("Keruskan      : "+ kerusakan.getNamaKerusakan());
        System.out.printf("biaya         :%s Rp %,.0f%n ",kodeCabang, getHarga(kerusakan));
    }
}
