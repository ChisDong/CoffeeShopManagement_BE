package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;

@Repository
public interface ThongKeRepository extends JpaRepository<HoaDon, String> {
    // Doanh thu theo ngày trong tháng
    @Query(value = "SELECT DATE(NGAYMUA) as label, SUM(TONGTIEN) as tongDoanhThu FROM hoadon WHERE MONTH(NGAYMUA) = :month AND YEAR(NGAYMUA) = :year GROUP BY DATE(NGAYMUA) ORDER BY label", nativeQuery = true)
    List<Object[]> thongKeDoanhThuTheoNgay(int month, int year);

    // Doanh thu theo tháng trong năm
    @Query(value = "SELECT MONTH(NGAYMUA) as label, SUM(TONGTIEN) as tongDoanhThu FROM hoadon WHERE YEAR(NGAYMUA) = :year GROUP BY MONTH(NGAYMUA) ORDER BY label", nativeQuery = true)
    List<Object[]> thongKeDoanhThuTheoThang(int year);

    // Doanh thu theo từng món ăn (đồ uống)
    @Query(value = "SELECT d.TENDOUONG as tenDoUong, SUM(c.THANHTIEN) as tongDoanhThu " +
            "FROM chitiethoadon c " +
            "JOIN douong d ON c.MADOUONG = d.MADOUONG " +
            "GROUP BY d.TENDOUONG " +
            "ORDER BY tongDoanhThu DESC", nativeQuery = true)
    List<Object[]> thongKeDoanhThuTheoMonAn();

    // Doanh thu theo nhóm món ăn (loại đồ uống)
    @Query(value = "SELECT d.LOAIDOUONG as loaiDoUong, SUM(c.THANHTIEN) as tongDoanhThu " +
            "FROM chitiethoadon c " +
            "JOIN douong d ON c.MADOUONG = d.MADOUONG " +
            "GROUP BY d.LOAIDOUONG " +
            "ORDER BY tongDoanhThu DESC", nativeQuery = true)
    List<Object[]> thongKeDoanhThuTheoNhomMonAn();

    // Số lượng hóa đơn theo ngày trong tháng
    @Query(value = "SELECT DATE(NGAYMUA) as ngay, COUNT(*) as soLuongHoaDon " +
            "FROM hoadon " +
            "WHERE MONTH(NGAYMUA) = :month AND YEAR(NGAYMUA) = :year " +
            "GROUP BY DATE(NGAYMUA) " +
            "ORDER BY ngay", nativeQuery = true)
    List<Object[]> thongKeSoLuongHoaDonTheoNgay(int month, int year);

    // Số lượng hóa đơn theo tháng trong năm
    @Query(value = "SELECT MONTH(NGAYMUA) as thang, COUNT(*) as soLuongHoaDon " +
            "FROM hoadon " +
            "WHERE YEAR(NGAYMUA) = :year " +
            "GROUP BY MONTH(NGAYMUA) " +
            "ORDER BY thang", nativeQuery = true)
    List<Object[]> thongKeSoLuongHoaDonTheoThang(int year);
}
