package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangFindRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangUpdateRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.ThongKeKhachHangResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.KhachHangService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/khachhangs")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @PostMapping
    KhachHang createKhachHang(@RequestBody @Valid KhachHangCreationRequest request){
        return khachHangService.createRequest(request);
    }

    // Update khách hàng
    @PutMapping
    KhachHang updateKhachhang(@RequestBody KhachHangUpdateRequest request){
        return khachHangService.updateRequest(request);
    }

    // Lấy danh sách tất cả khách hàng
    @GetMapping
    List<KhachHang> findAllKhachHangs(){
        return khachHangService.findAllKhachHangs();
    }

    // Tìm kiếm khách hàng theo mã, tên hoặc số điện thoại
    @GetMapping("/makh/{makh}")
    KhachHang findKhachHangByMaKh(@PathVariable String makh){
        return khachHangService.findByMaKh(makh);
    }

    @GetMapping("/tenkh/{tenkh}")
    KhachHang findKhachHangByTenKh(@PathVariable String tenkh){
        return khachHangService.findByTenKh(tenkh);
    }

    @GetMapping("/sdt/{sdt}")
    KhachHang findKhachHangBySdt(@PathVariable String sdt){
        return khachHangService.findBySdt(sdt);
    }

    // Lấy danh sách hóa đơn của khách hàng
    @GetMapping("/hoadon/{makh}")
    List<HoaDon> findHoaDonByMaKh(@PathVariable String makh){
        return khachHangService.findHoaDonsByMaKh(makh);
    }

    // Xóa khách hàng
    @DeleteMapping
    KhachHang deleteKhachHang(@RequestBody KhachHangFindRequest request){
        return  khachHangService.deleteRequest(request);
    }

    @GetMapping("/thongke/{maKhachHang}")
    public ResponseEntity<ThongKeKhachHangResponse> thongKeKhachHang(@PathVariable String maKhachHang) {
        ThongKeKhachHangResponse response = khachHangService.thongKeKhachHangResponse(maKhachHang);
        return ResponseEntity.ok(response);
    }
}
