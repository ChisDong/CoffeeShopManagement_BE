package CoffeeShopManagement.example.CoffeeShopManagement.Respository;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface LichResponsitory extends JpaRepository<Lich, String> {
    List<Lich> findByNgayBDBetween(String ngayBD, String NgayKT);
}
