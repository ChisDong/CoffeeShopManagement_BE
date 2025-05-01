package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.DatHangCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.DoUong;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.ChiTietHoaDonResponsitory;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.DoUongRespository;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.HoaDonRespository;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class DatHangService {
    @Autowired
    private HoaDonRespository hoaDonRespository;
    @Autowired
    private DoUongRespository doUongRespository;
    @Autowired
    private ChiTietHoaDonResponsitory chiTietHoaDonResponsitory;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;

    /*public HoaDon taoHoaDon(String soDienThoai , Map<String, Integer> gioHang){
        /*HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHd(hoaDonService.generateMaHoaDon());
        KhachHang khachHang = khachHangRepository.findBySdt(soDienThoai); /*tìm xem số điện thoại nhập vào có tồn tại khách hàng không
        if(khachHang == null){
            throw new RuntimeException("Không tìm thấy khách hàng với số điện thoại "+ soDienThoai);
        }
        hoaDon.setMaKh(khachHang.getMaKh());
        hoaDon.setNgayMua(new Date());

        double tongTien = 0;
        for(String maDoUong : gioHang.keySet()){
            DoUong doUong = doUongRespository.findByMaDoUong(maDoUong);
            if(doUong == null){
                throw new RuntimeException("Không tìm thấy "); thường thì cái này không xảy ra
            }
            int s1 = gioHang.get(maDoUong);
            tongTien += s1*doUong.getGiaDoUong();

            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setMaHd(hoaDon.getMaHoaDon());
            chiTietHoaDon.setMaDoUong(maDoUong);
            chiTietHoaDon.setSoLuong(s1);
            chiTietHoaDon.setDonGia(doUong.getGiaDoUong());
            chiTietHoaDon.setThanhTien(s1*doUong.getGiaDoUong());
            chiTietHoaDonResponsitory.save(chiTietHoaDon);
        }
        hoaDon.setTongTien(tongTien);
        return hoaDonRespository.save(hoaDon);
        }*/
    public HoaDon taoHoaDon(DatHangCreationRequest request){
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHd(hoaDonService.generateMaHoaDon());
        hoaDon.setMaNv(request.getMaNv());
        hoaDon.setNgayMua(new Date());

        KhachHang khachHang = khachHangRepository.findBySdt(request.getSoDienThoai());
        if(khachHang == null){
            khachHang = new KhachHang();
            khachHang.setMaKh(khachHangService.generateMaKhachHang());
            khachHang.setTenKh(request.getTenKhachHang());
            khachHang.setSdt(request.getSoDienThoai());
            khachHangRepository.save(khachHang);
        }
        hoaDon.setMaKh(khachHang.getMaKh());
        hoaDonRespository.save(hoaDon);
        String maHd = hoaDon.getMaHoaDon();
        double tongTien = 0;
        for(Map.Entry<String, Integer> entry : request.getGioHang().entrySet()){
            String maDoUong = entry.getKey();
            Integer soLuong = entry.getValue();
            DoUong doUong = doUongRespository.findByMaDoUong(maDoUong);
            if(doUong == null){
                throw new RuntimeException("Không tìm thấy đồ uống với mã " + maDoUong);
            }
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setMaHd(hoaDon.getMaHoaDon());
            chiTietHoaDon.setMaDoUong(maDoUong);
            chiTietHoaDon.setSoLuong(soLuong);
            chiTietHoaDon.setDonGia(doUong.getGiaDoUong());
            chiTietHoaDon.setThanhTien(soLuong*doUong.getGiaDoUong());
            tongTien += chiTietHoaDon.getThanhTien();
            System.out.println("Sắp lưu chi tiết hóa đơn: " + chiTietHoaDon.getMaDoUong());
            chiTietHoaDonResponsitory.save(chiTietHoaDon);
        }
        return hoaDonService.updateHoaDon(maHd, tongTien);
    }
}