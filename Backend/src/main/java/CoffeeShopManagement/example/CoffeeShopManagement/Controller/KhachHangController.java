package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHangCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHangFindRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHangUpdateRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @PostMapping("/khachhangs")
    KhachHang createKhachHang(@RequestBody @Valid KhachHangCreationRequest request){
        return khachHangService.createRequest(request);
    }
    @PutMapping("/khachhangs")
    KhachHang updateKhachhang(@RequestBody KhachHangUpdateRequest request){
        return khachHangService.updateRequest(request);
    }
    @GetMapping("/khachhangs")
    KhachHang findKhachhang(@RequestBody KhachHangFindRequest request){
        return  khachHangService.findRequest(request);
    }
    @DeleteMapping("/khachhangs")
    KhachHang deleteKhachHang(@RequestBody KhachHangFindRequest request){
        return  khachHangService.deleteRequest(request);
    }
}
