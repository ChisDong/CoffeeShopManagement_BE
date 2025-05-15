package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.LichCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.LichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.LichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class LichController {
    @Autowired
    private LichService lichService;

    @PostMapping("/lichs")
    Lich createLich(@RequestBody LichCreationRequest request)
    {
       return lichService.creationRequest(request);
    }

    @GetMapping("/lichs/bydays")
    List<LichResponse> getLichByDay(@RequestBody String NgayBD, @RequestBody String NgayKT)
    {
        return lichService.getLichByDay(NgayBD, NgayKT);
    }

    @GetMapping("/lichs")
    List<LichResponse> getAllLich()
    {
        return lichService.getAllLich();
    }

    @PutMapping("/lichs")
    LichResponse updateLich(@RequestBody String id, @RequestBody LichCreationRequest request){
        return lichService.updateRequest(id, request);
    }

    @DeleteMapping("/lichs")
    void deleteLich(@RequestBody String id){
        lichService.deleteLich(id);
    }



}
