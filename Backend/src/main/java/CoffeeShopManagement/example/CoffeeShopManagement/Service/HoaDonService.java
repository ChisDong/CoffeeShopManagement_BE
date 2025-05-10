package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.HoaDonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HoaDonService{
    @Autowired
    HoaDonRespository hoaDonRespository;
    public String generateMaHoaDon(){
        return "HD" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }

    public HoaDon updateHoaDon(String maHD, double tongTien){
        HoaDon existing = hoaDonRespository.findByMaHd(maHD);
        existing.setTongTien(tongTien);
        return hoaDonRespository.save(existing);
    }
}

