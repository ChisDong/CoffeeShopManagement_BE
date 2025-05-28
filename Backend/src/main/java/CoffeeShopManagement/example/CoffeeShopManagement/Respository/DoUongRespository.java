package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.DoUong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoUongRespository extends JpaRepository<DoUong, String> {
    DoUong findByMaDoUong(String maDoUong);

    List<DoUong> findByTop10ByNameContainingIgnoreCase(String keyword);

}
