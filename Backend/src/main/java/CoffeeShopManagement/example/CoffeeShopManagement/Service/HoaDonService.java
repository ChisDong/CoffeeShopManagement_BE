package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.ChiTiettHoaDonResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.NhanVienDangKyLichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon.ChiTietHoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.DoUong;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.AppExceptionHandler;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.ErrorCode;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.ChiTietHoaDonResponsitory;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.DoUongRespository;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.HoaDonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonService{
    @Autowired
    HoaDonRespository hoaDonRespository;
    @Autowired
    ChiTietHoaDonResponsitory chiTietHoaDonResponsitory;
    @Autowired
    DoUongRespository doUongRespository;
    public String generateMaHoaDon(){
        return "HD" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }

    public HoaDon updateHoaDon(String maHD, double tongTien){
        HoaDon existing = hoaDonRespository.findByMaHd(maHD);
        existing.setTongTien(tongTien);
        return hoaDonRespository.save(existing);
    }

    public List<ChiTiettHoaDonResponse> response(String maHd){
        List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonResponsitory.findByMaHd(maHd);
        List<ChiTiettHoaDonResponse> chiTiettHoaDonResponses = new ArrayList<>();
        for(ChiTietHoaDon chiTietHoaDon : chiTietHoaDons){
            ChiTiettHoaDonResponse chiTiettHoaDonResponse = new ChiTiettHoaDonResponse();
            DoUong doUong = new DoUong();
            doUong = doUongRespository.findByMaDoUong(chiTietHoaDon.getMaDoUong());
            chiTiettHoaDonResponse.setMaDoUong(chiTietHoaDon.getMaDoUong());
            chiTiettHoaDonResponse.setTenDoUong(doUong.getTenDoUong());
            chiTiettHoaDonResponse.setSoLuong(chiTietHoaDon.getSoLuong());
            chiTiettHoaDonResponse.setDonGia(chiTietHoaDon.getDonGia());
            chiTiettHoaDonResponse.setGia(chiTietHoaDon.getThanhTien());
            chiTiettHoaDonResponses.add(chiTiettHoaDonResponse);
        }
        if(chiTiettHoaDonResponses  != null){
            return chiTiettHoaDonResponses;
        }else{
            throw new AppExceptionHandler(ErrorCode.LIST_NOT_EXISTED);
        }
    }

//    public List<NhanVienDangKyLichResponse> getAllNhanVienInLich(String maLlv){
//        List<NhanVienDangKyLichResponse> nhanVienDangKyLichList = new ArrayList<>();
//        for(DangKyLich lich : dangKyLichRespository.findAllByMaLlv(maLlv)){
//            NhanVienDangKyLichResponse nhanVienDangKyLichResponse = new NhanVienDangKyLichResponse();
//            NhanVien nhanVien = new NhanVien();
//            nhanVien = nhanVienRespository.findById(lich.getMaNv()).orElseThrow(()-> new AppExceptionHandler(ErrorCode.USER_NOT_EXISTED));
//            nhanVienDangKyLichResponse.setMaNv(lich.getMaNv());
//            nhanVienDangKyLichResponse.setTenNv(nhanVien.getHoTenNv());
//            nhanVienDangKyLichResponse.setViTriLam(nhanVien.getViTriLam());
//            nhanVienDangKyLichList.add(nhanVienDangKyLichResponse);
//        }
//        if(nhanVienDangKyLichList != null){
//            return nhanVienDangKyLichList;
//        }else{
//            throw new AppExceptionHandler(ErrorCode.LIST_NOT_EXISTED);
//        }
//    }


}

