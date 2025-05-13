package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.NhanVienCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.NhanVienResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @PostMapping("/nhanviens")
    NhanVien createNhanVien(@RequestBody NhanVienCreationRequest request){
        return nhanVienService.createRequest(request);
    }

    @GetMapping("nhanviens")
    List<NhanVienResponse> findAll(){
     return nhanVienService.getAllNhanVien();
    }
}
