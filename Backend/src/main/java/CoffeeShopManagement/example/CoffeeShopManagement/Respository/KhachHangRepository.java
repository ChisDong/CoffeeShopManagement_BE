package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
/*tương tác với DBMS xử lý logic trong DBMS*/
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
    public KhachHang findByMaKh(String maKh);
    public KhachHang findBySdt(String sdt);
    public KhachHang findByTenKh(String tenKh);
}
