package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.Service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/thongke")
public class ThongKeController {
    @Autowired
    private ThongKeService thongKeService;

    @GetMapping("/doanhthu/ngay")
    public List<Object[]> thongKeTheoNgay(@RequestParam int month, @RequestParam int year) {
        return thongKeService.thongKeDoanhThuTheoNgay(month, year);
    }

    @GetMapping("/doanhthu/thang")
    public List<Object[]> thongKeTheoThang(@RequestParam int year) {
        return thongKeService.thongKeDoanhThuTheoThang(year);
    }

    @GetMapping("/doanhthu/monan")
    public List<Object[]> thongKeTheoMonAn() {
        return thongKeService.thongKeDoanhThuTheoMonAn();
    }

    @GetMapping("/doanhthu/nhommonan")
    public List<Object[]> thongKeTheoNhomMonAn() {
        return thongKeService.thongKeDoanhThuTheoNhomMonAn();
    }

    @GetMapping("/soluonghoadon/ngay")
    public List<Object[]> thongKeSoLuongHoaDonTheoNgay(@RequestParam int month, @RequestParam int year) {
        return thongKeService.thongKeSoLuongHoaDonTheoNgay(month, year);
    }

    @GetMapping("/soluonghoadon/thang")
    public List<Object[]> thongKeSoLuongHoaDonTheoThang(@RequestParam int year) {
        return thongKeService.thongKeSoLuongHoaDonTheoThang(year);
    }
}