package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu.DoUongCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu.DoUongFindRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu.DoUongUpdateRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.DoUong;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.DoUongRespository;
import org.springframework.stereotype.Service;


@Service
public class DoUongService {
    @Autowired
    private DoUongRespository doUongRespository;

    // Thêm đồ uống
    public DoUong createRquest(DoUongCreationRequest request) {
        DoUong doUong = new DoUong();
        doUong.setMaDoUong(request.getMaDoUong());
        doUong.setTenDoUong(request.getTenDoUong());
        doUong.setLoaiDoUong(request.getLoaiDoUong());
        doUong.setGiaDoUong(request.getGiaDoUong());
        doUong.setTrangThai(request.getTrangThai());
        doUongRespository.save(doUong);
        return doUongRespository.save(doUong);
    }

    // Sửa đồ uống
    public DoUong updateRequest(DoUongUpdateRequest request) {
        DoUong doUong = doUongRespository.findById(request.getMaDoUong()).orElse(null);
        if (doUong != null) {
            doUong.setTenDoUong(request.getTenDoUong());
            doUong.setLoaiDoUong(request.getLoaiDoUong());
            doUong.setGiaDoUong(request.getGiaDoUong());
            doUong.setTrangThai(request.getTrangThai());
            return doUongRespository.save(doUong);
        }
        return null;
    }

    // Xoá đồ uống
    public void deleteRequest(String maDoUong) {
        DoUong doUong = doUongRespository.findById(maDoUong).orElse(null);
        if (doUong != null) {
            doUongRespository.delete(doUong);
        }
    }

    // Xem tất cả menu
    public List<DoUong> findAll() {
        return doUongRespository.findAll();
    }
}

