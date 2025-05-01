package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class DatHangCreationRequest {
   private String maNv;
   private String soDienThoai;
   private String tenKhachHang;
   private Map<String, Integer> gioHang;
   private String hinhThucThanhToan;

    public String getMaNv() {
        return maNv;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public Map<String, Integer> getGioHang() {
        return gioHang;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setGioHang(Map<String, Integer> gioHang) {
        this.gioHang = gioHang;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }
}
