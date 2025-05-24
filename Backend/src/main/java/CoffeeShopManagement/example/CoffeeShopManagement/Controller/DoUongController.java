package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu.DoUongCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu.DoUongUpdateRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.DoUong;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.DoUongService;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class DoUongController {
    @Autowired
    private DoUongService doUongService;

    // Thêm đồ uống
    @PostMapping
    public DoUong createDoUong(@RequestBody DoUongCreationRequest request) {
        return doUongService.createRquest(request);
    }

    // Sửa đồ uống
    @PutMapping
    public DoUong updateDoUong(@RequestBody DoUongUpdateRequest request) {
        return doUongService.updateRequest(request);
    }

    // Xoá đồ uống
    @DeleteMapping("/{maDoUong}")
    public void deleteDoUong(@PathVariable String maDoUong) {
        doUongService.deleteRequest(maDoUong);
    }

    // Xem tất cả menu
    @GetMapping
    public List<DoUong> getAllDoUong() {
        return doUongService.findAll();
    }
}
