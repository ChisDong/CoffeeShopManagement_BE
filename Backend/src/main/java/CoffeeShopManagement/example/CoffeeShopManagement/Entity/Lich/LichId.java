package CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Table(name = "lichlamviec")
public class LichId implements Serializable {
    @Column(name = "MALLV")
    private String maLlv;
    @Column(name = "THOIGIANBATDAU")
    private String thoiGianBD;
    @Column(name = "THOIGIANKETHUC")
    private String thoiGianKT;

    public LichId() {}

    public LichId(String maLlv, String thoiGianBD, String thoiGianKT){
        this.maLlv = maLlv;
        this.thoiGianBD = thoiGianBD;
        this.thoiGianKT = thoiGianKT;
    }

    public String getMaLlv() { return maLlv; }
    public void setMaLlv(String maLlv) { this.maLlv = maLlv; }

    public String getThoiGianBD() { return thoiGianBD; }
    public void setThoiGianBD(String thoiGianBD) { this.thoiGianBD = thoiGianBD; }

    public String getThoiGianKT() { return thoiGianKT; }
    public void setThoiGianKT(String thoiGianKT) { this.thoiGianKT = thoiGianKT; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LichId that)) return false;
        return Objects.equals(maLlv, that.maLlv) &&
                Objects.equals(thoiGianBD, that.thoiGianBD) &&
                Objects.equals(thoiGianKT, that.thoiGianKT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLlv, thoiGianBD, thoiGianKT);
    }
}
