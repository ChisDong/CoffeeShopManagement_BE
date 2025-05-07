package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LichResponsitory extends JpaRepository<Lich, String> {
}
