package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLichId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DangKyLichRespository extends JpaRepository<DangKyLich, DangKyLichId>{
    List<DangKyLich> findAllByMaNv(String maNv);
}
