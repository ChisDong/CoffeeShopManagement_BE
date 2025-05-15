package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.NhanVienCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.NhanVienResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.LichService;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private LichService lichService;

    // 1. Xem danh sách nhân viên
    @GetMapping
    public List<NhanVien> getAllNhanViens() {
        return nhanVienService.findAll();
    }

    // 2. Xem lịch làm việc của nhân viên
    @GetMapping("/{maNv}/lich")
    public List<Lich> getLichByNhanVien(@PathVariable String maNv) {
        return lichService.findByMaNv(maNv);
    }

    // 3. Tính tổng giờ làm và lương cơ bản theo giờ làm trong tháng
    @GetMapping("/{maNv}/tonggio")
    public double getTongGioLam(
            @PathVariable String maNv) {
        return nhanVienService.tinhTongGioLam(maNv);
    }

    // 4. Thêm nhân viên
    @PostMapping
    public NhanVien addNhanVien(@RequestBody NhanVienCreationRequest request) {
        return nhanVienService.createRequest(request);
    }
}
