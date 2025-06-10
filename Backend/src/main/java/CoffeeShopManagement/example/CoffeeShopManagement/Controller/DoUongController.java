package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu.DoUongCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu.DoUongUpdateRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.DoUong;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.DoUongService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController

public class DoUongController {
    @Autowired
    private DoUongService doUongService;

    // Thêm đồ uống
    // đã xong
    @PostMapping("/themdouongs")
    public DoUong createDoUong(@RequestBody DoUongCreationRequest request) {
        return doUongService.createRquest(request);
    }

    // Sửa đồ uống
    //đã xong
    @PutMapping("/suadouongs")
    public DoUong updateDoUong(@RequestBody DoUongUpdateRequest request) {
        return doUongService.updateRequest(request);
    }

    // Xoá đồ uống
    //đã xong
    @DeleteMapping("/xoadouongs/{maDoUong}")
    public void deleteDoUong(@PathVariable String maDoUong) {
        doUongService.deleteRequest(maDoUong);
    }

    // Xem tất cả menu
    //đã xong
    @GetMapping("/menus")
    public List<DoUong> getAllDoUong() {
        return doUongService.findAll();
    }
}
