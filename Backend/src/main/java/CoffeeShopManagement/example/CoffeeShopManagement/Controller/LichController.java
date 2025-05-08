package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.LichCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.LichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/lichs")
    public List<Lich> getLich(){
        return lichService.layLich();
    }



}
