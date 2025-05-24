package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HoaDonRespository extends JpaRepository<HoaDon, String> {
    HoaDon findByMaHd(String maHd);
    List<HoaDon> findByMaKh(String maKh);
}
