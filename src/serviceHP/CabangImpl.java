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
class CabangJakarta extends CabangService {
    public CabangJakarta() {super("jakarta","JKT");}
    
    @Override
    public double getHarga (Kerusakan kerusakan) {return kerusakan.getHargaCabangA();}
}

class CabangBandung extends CabangService {
    public CabangBandung() {super("Bandung","BDG");}
    
    @Override
    public double getHarga (Kerusakan kerusakan) {return kerusakan.getHargaCabangB();}
}

class CabangBanjarMasin extends CabangService {
    public CabangBanjarMasin() {super("BanjarMasin","BJM");}
    
    @Override
    public double getHarga (Kerusakan kerusakan) {return kerusakan.getHargaCabangC();}
}