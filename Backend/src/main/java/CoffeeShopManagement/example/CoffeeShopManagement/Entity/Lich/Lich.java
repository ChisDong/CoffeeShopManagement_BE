package CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "lichlamviec")
public class Lich {
    @EmbeddedId
    private LichId id;
    @Column(name = "NVTAOLICH")
    private String maNv;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "NGAYBATDAU")
    private Date ngayBD;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "NGAYKETTHUC")
    private Date ngayKT;
    @Column(name = "SOLUONG")
    private Integer soLuong;

    public Lich(){}

    public Integer getSoLuong() {
        return soLuong;
    }

    public LichId getId() {
        return id;
    }

    public void setId(LichId id) {
        this.id = id;
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

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
