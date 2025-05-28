package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.KhachHangService;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRespository extends JpaRepository<NhanVien, String> {
    NhanVien findByMaNv(String maNv);
}
