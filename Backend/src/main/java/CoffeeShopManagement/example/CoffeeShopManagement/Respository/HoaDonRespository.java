package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HoaDonRespository extends JpaRepository<HoaDon, String> {
    HoaDon findByMaHd(String maHd);
    List<HoaDon> findByMaKh(String maKh);

    @Query("SELECT COUNT(h), COALESCE(SUM(h.tongTien), 0) FROM HoaDon h WHERE h.maKh = :maKh")
    Object thongKeTheoKhachHang(@Param("maKh") String maKh);

}
