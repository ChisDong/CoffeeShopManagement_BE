package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietHoaDonResponsitory extends JpaRepository<ChiTietHoaDon, String> {
    public ChiTietHoaDon findByMaHd(String maHd);
}
