package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon.ChiTietHoaDonId;

public interface ChiTietHoaDonResponsitory extends JpaRepository<ChiTietHoaDon, String> {
    List<ChiTietHoaDon> findByMaHd(String maHd);
}
