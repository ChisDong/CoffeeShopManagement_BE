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
    //nhân viên đăng ký lịch
    //tạo trigger đăng ky lịch tự động trừ so luong xuống
    @PostMapping("/dangkylichs")
    DangKyLich createDangKyLich(@RequestBody DangKyLichRequest request){
        return dangKyLichService.createRequest(request);
    }
    //nhân viên xoá lịch đã đăng ký
    //tạo trigger phục hồi lại số lượng
    //tạo trigger khi số lượng ve 0 thì không được đăng ký nữa
    @DeleteMapping("/xoadangkylichs")
    void deleteDangKyLich(@RequestBody DangKyLichRequest request){
        dangKyLichService.deleteRequest(request);
    }

    //lấy tất cả nhân viên đăng ký trong 1 mã lịch
    @GetMapping("/laynhanvientronglichs/{maLlv}")
    List<NhanVienDangKyLichResponse> findDangKyLich(@PathVariable String maLlv){
       return dangKyLichService.getAllNhanVienInLich(maLlv);
    }
    //lấy tat cả lịch của 1 nhân viên
    @GetMapping("/laylichcuanhanviens/{maNv}")
    List<LichDaDangKyResponse> findLichDaDangKyCuaNhanVien(@PathVariable String maNv){
        return  dangKyLichService.getAllLichDaDangKy(maNv);
    }

    //lấy tổng giờ làm của 1 nhân viên, phần này lỗi cần xem lại
    @GetMapping("/laytonggiolams/{maNv}")
    Integer getTongGioLam(@PathVariable String maNv){
        return dangKyLichService.getGioLam(maNv);
    }

}

