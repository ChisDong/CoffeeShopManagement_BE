package CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "lichlamviec")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lich {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "NVTAOLICH")
    String maNv;

    @Column(name = "NGAYBATDAU")
    String ngayBD;

    @Column(name = "NGAYKETTHUC")
    String ngayKT;
    @Column(name = "THOIGIANBATDAU")
    String thoiGianBD;
    @Column(name = "THOIGIANKETHUC")
    String thoiGianKT;
    @Column(name = "SOLUONG")
    Integer soLuong;
}