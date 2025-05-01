package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoaDonRespository extends JpaRepository<HoaDon, String> {
    public HoaDon findByMaHd(String maHd);
}
