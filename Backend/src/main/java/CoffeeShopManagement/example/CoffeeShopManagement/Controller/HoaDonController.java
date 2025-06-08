package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.ChiTiettHoaDonResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @GetMapping("/laychitiethoadons/{maHd}")
    List<ChiTiettHoaDonResponse> findChiTietHoaDon(@PathVariable String maHd){
        return hoaDonService.response(maHd);
    }
    
}
