package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.LichCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.LichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.LichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class LichController {
    @Autowired
    private LichService lichService;

    @PostMapping("/taolichs")
    Lich createLich(@RequestBody LichCreationRequest request)
    {
       return lichService.creationRequest(request);
    }

    @GetMapping("/laylichs/bydays/{NgayBD}/{NgayKT}")
    List<LichResponse> getLichByDay(@PathVariable String NgayBD, @PathVariable String NgayKT)
    {
        return lichService.getLichByDay(NgayBD, NgayKT);
    }

    @GetMapping("/lichs")
    List<LichResponse> getAllLich()
    {
        return lichService.getAllLich();
    }

    @PutMapping("/sualichs/{id}")
    LichResponse updateLich(@PathVariable String id, @RequestBody LichCreationRequest request){
        return lichService.updateRequest(id, request);
    }

    @DeleteMapping("/xoalichs/{id}")
    void deleteLich(@PathVariable String id){
        lichService.deleteLich(id);
    }



}
