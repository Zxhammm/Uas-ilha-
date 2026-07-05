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
public class Kerusakan {
    private String namaKerusakan;
    private double hargacabangA;
    private double hargacabangB;
    private double hargacabangC;
    
    
    // Constructor
    public Kerusakan (String namaKerusakan, double hargacabangA, double hargacabangB, double hargacabangC ){
        this.namaKerusakan = namaKerusakan;
        this.hargacabangA = hargacabangA;
        this.hargacabangB = hargacabangB;
        this.hargacabangC = hargacabangC;
    }
    
    //acessor
    public String getNamaKerusakan() { return namaKerusakan; }
    public double getHargaCabangA() { return hargacabangA; }
   public double getHargaCabangB() { return hargacabangB; }
   public double getHargaCabangC() { return hargacabangC; }
   
   //mutator
   public void setHargaCabangA(double h) {hargacabangA = h;}
   public void setHargaCabangB(double h) {hargacabangB = h;}
   public void setHargaCabangC(double h) {hargacabangC = h;}
   
}
