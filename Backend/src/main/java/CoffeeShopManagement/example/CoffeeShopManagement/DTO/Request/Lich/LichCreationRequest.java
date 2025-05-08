package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LichCreationRequest {
    private String maLlv;
    private String maNv;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date ngayBD;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date ngayKT;
    private String thoiGianBD;
    private String thoiGianKT;
    private Integer soLuong;

    public String getMaLlv() {
        return maLlv;
    }

    public String getMaNv() {
        return maNv;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public String getThoiGianBD() {
        return thoiGianBD;
    }

    public String getThoiGianKT() {
        return thoiGianKT;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setMaLlv(String maLlv) {
        this.maLlv = maLlv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public void setThoiGianBD(String thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public void setThoiGianKT(String thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
