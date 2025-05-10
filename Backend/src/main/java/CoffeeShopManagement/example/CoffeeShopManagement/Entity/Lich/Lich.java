package CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "lichlamviec")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lich {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "NVTAOLICH")
    String maNv;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "NGAYBATDAU")
    Date ngayBD;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "NGAYKETTHUC")
    Date ngayKT;
    @Column(name = "THOIGIANBATDAU")
    String thoiGianBD;
    @Column(name = "THOIGIANKETHUC")
    String thoiGianKT;
    @Column(name = "SOLUONG")
    Integer soLuong;
}
