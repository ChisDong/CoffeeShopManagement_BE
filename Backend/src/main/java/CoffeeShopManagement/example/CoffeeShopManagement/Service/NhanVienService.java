package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.NhanVienCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.NhanVienRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRespository nhanVienRespository;
    private String generateMaNhanVien(){
        return "NV" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    private String generateMatKhau(){
        return UUID.randomUUID().toString().substring(0,4).toUpperCase();
    }
    public NhanVien createRequest(NhanVienCreationRequest request){
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNv(generateMaNhanVien());
        nhanVien.setHoTenNv(request.getHoTenNv());
        nhanVien.setMatKhau(generateMatKhau());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setSoCccd(request.getSoCccd());
        nhanVien.setViTriLam(request.getViTriLam());
        return nhanVienRespository.save(nhanVien);
    }

}
