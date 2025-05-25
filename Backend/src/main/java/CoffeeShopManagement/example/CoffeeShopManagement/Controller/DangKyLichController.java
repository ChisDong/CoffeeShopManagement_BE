package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.DangKyLichRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.DangKyLichReponse;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.LichDaDangKyResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.NhanVienDangKyLichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLich;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.DangKyLichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DangKyLichController {
    @Autowired
    private DangKyLichService dangKyLichService;
    @PostMapping("/dangkylichs")
    DangKyLich createDangKyLich(@RequestBody DangKyLichRequest request){
        return dangKyLichService.createRequest(request);
    }
    @DeleteMapping("/dangkylichs")
    void deleteDangKyLich(@RequestBody DangKyLichRequest request){
        dangKyLichService.deleteRequest(request);
    }

    @GetMapping("/laynhanvientronglichs")
    List<NhanVienDangKyLichResponse> findDangKyLich(@RequestBody String maLlv){
       return dangKyLichService.getAllNhanVienInLich(maLlv);
    }

    @GetMapping("/laylichcuanhanviens")
    List<LichDaDangKyResponse> findLichDaDangKyCuaNhanVien(@RequestBody String maNv){
        return  dangKyLichService.getAllLichDaDangKy(maNv);
    }

    @GetMapping("/laytonggiolam")
    Integer getTongGioLam(@RequestBody String maNv){
        return dangKyLichService.getGioLam(maNv);
    }
}
