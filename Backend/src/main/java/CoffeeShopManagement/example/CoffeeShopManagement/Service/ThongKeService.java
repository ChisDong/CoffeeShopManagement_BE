package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.Respository.ThongKeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ThongKeService {
    @Autowired
    private ThongKeRepository thongKeRepository;

    public List<Object[]> thongKeDoanhThuTheoNgay(int month, int year) {
        return thongKeRepository.thongKeDoanhThuTheoNgay(month, year);
    }

    public List<Object[]> thongKeDoanhThuTheoThang(int year) {
        return thongKeRepository.thongKeDoanhThuTheoThang(year);
    }

    public List<Object[]> thongKeDoanhThuTheoMonAn() {
        return thongKeRepository.thongKeDoanhThuTheoMonAn();
    }

    public List<Object[]> thongKeDoanhThuTheoNhomMonAn() {
        return thongKeRepository.thongKeDoanhThuTheoNhomMonAn();
    }

    public List<Object[]> thongKeSoLuongHoaDonTheoNgay(int month, int year) {
        return thongKeRepository.thongKeSoLuongHoaDonTheoNgay(month, year);
    }

    public List<Object[]> thongKeSoLuongHoaDonTheoThang(int year) {
        return thongKeRepository.thongKeSoLuongHoaDonTheoThang(year);
    }
}