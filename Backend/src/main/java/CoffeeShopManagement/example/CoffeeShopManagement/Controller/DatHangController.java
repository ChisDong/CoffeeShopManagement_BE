package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.DatHangCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.DatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DatHangController {

    @Autowired
    private DatHangService datHangService;

    //chưa check để từ từ
    @PostMapping("/dathangs")
    public HoaDon datHang(@RequestBody DatHangCreationRequest request) {
        return datHangService.taoHoaDon(request);
    }
}
