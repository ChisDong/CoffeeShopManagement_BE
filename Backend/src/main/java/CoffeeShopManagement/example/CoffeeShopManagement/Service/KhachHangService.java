package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangFindRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangUpdateRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
/*Mapping dữ liệu của người dùng nhập vào với thuộc tính trong DBMS get lấy từ request, còn set vào DBMS*/
@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    public String generateMaKhachHang(){
        return "KH" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Tạo mới khách hàng
    public KhachHang createRequest(KhachHangCreationRequest request){
        /*if(khachHangRepository.existsByTenDangNhap(request.getTenDangNhap())){
            throw new RuntimeException("Tên đăng nhập đã tồn tại, vui lòng chọn tên khác!");
        }*/
        KhachHang khachHang = new KhachHang();
        khachHang.setMaKh(generateMaKhachHang());
        khachHang.setTenKh(request.getTenKh());
        return khachHangRepository.save(khachHang);
    }

    // Update khách hàng
    public KhachHang updateRequest(KhachHangUpdateRequest request) {
        KhachHang existing = khachHangRepository.findByMaKh(request.getMaKh());
        if (existing == null) {
            throw new RuntimeException("Không tìm thấy khách hàng với mã: " + request.getMaKh());
        }
        existing.setTenKh(request.getTenKH());
        return khachHangRepository.save(existing);
    }

    // Lấy danh sách tất cả khách hàng
    public List<KhachHang> findAllKhachHangs() {
        return khachHangRepository.findAll();
    }

    // Tìm kiếm khách hàng theo mã
    public KhachHang findByMaKh(String maKh) {
        KhachHang existing = khachHangRepository.findByMaKh(maKh);
        if (existing == null) {
            throw new RuntimeException("Không tìm thấy khách hàng với mã: " + maKh);
        }
        return existing;
    }

    // Tìm kiếm khách hàng theo tên
    public KhachHang findByTenKh(String tenKh) {
        KhachHang existing = khachHangRepository.findByTenKh(tenKh);
        if (existing == null) {
            throw new RuntimeException("Không tìm thấy khách hàng với tên: " + tenKh);
        }
        return existing;
    }

    // Tìm kiếm khách hàng theo số điện thoại
    public KhachHang findBySdt(String sdt) {
        KhachHang existing = khachHangRepository.findBySdt(sdt);
        if (existing == null) {
            throw new RuntimeException("Không tìm thấy khách hàng với số điện thoại: " + sdt);
        }
        return existing;
    }

    // Lấy danh sách hóa đơn của khách hàng
    public List<HoaDon> findHoaDonsByMaKh(String maKh) {
        KhachHang existing = khachHangRepository.findByMaKh(maKh);
        if (existing == null) {
            throw new RuntimeException("Không tìm thấy khách hàng với mã: " + maKh);
        }
        return existing.getHoaDons();
    }

    // Xóa khách hàng theo mã
    public KhachHang deleteRequest(KhachHangFindRequest request){
        KhachHang existing = khachHangRepository.findByMaKh(request.getMaKh());
        if(existing == null){
            throw new RuntimeException("Không tìm thấy khách hàng với mã " + request.getMaKh());
        }
        khachHangRepository.delete(existing);
        return existing;
    }
}
