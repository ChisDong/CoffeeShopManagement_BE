package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.DoUong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface DoUongRespository extends JpaRepository<DoUong, String> {
    public DoUong findByMaDoUong(String maDoUong);
}
