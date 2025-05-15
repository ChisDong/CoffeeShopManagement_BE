package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.KhachHangService;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NhanVienRespository extends JpaRepository<NhanVien, String> {
    public NhanVien findByMaNv(String maNv);
}
