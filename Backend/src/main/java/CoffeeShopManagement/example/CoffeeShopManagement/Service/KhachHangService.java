package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangFindRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang.KhachHangUpdateRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
/*Mapping dữ liệu của người dùng nhập vào với thuộc tính trong DBMS get lấy từ request, còn set vào DBMS*/
@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    public String generateMaKhachHang(){
        return "KH" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    public KhachHang createRequest(KhachHangCreationRequest request){
        /*if(khachHangRepository.existsByTenDangNhap(request.getTenDangNhap())){
            throw new RuntimeException("Tên đăng nhập đã tồn tại, vui lòng chọn tên khác!");
        }*/
        KhachHang khachHang = new KhachHang();
        khachHang.setMaKh(generateMaKhachHang());
        khachHang.setTenKh(request.getTenKh());
        return khachHangRepository.save(khachHang);
    }

    public KhachHang updateRequest(KhachHangUpdateRequest request) {
        KhachHang existing = khachHangRepository.findByMaKh(request.getMaKh());
        if (existing == null) {
            throw new RuntimeException("Không tìm thấy khách hàng với mã: " + request.getMaKh());
        }
        existing.setTenKh(request.getTenKH());
        return khachHangRepository.save(existing);
    }

    public KhachHang findRequest(KhachHangFindRequest request){
        KhachHang existing = khachHangRepository.findByTenKh(request.getTenKh());
        if(existing == null){
            throw new RuntimeException("Không tìm thấy khách hàng với tên " + request.getTenKh());
        }
        return existing;
    }
    public KhachHang deleteRequest(KhachHangFindRequest request){
        KhachHang existing = khachHangRepository.findByMaKh(request.getMaKh());
        if(existing == null){
            throw new RuntimeException("Không tìm thấy khách hàng với mã " + request.getMaKh());
        }
        khachHangRepository.delete(existing);
        return existing;
    }
}
