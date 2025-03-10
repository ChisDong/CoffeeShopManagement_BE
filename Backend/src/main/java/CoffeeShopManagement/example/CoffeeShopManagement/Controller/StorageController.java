package CoffeeShopManagement.example.CoffeeShopManagement.Controller;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.StorageCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Storage;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storages")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping
    Storage createStorage(@RequestBody StorageCreationRequest request){
        return storageService.createRequest(request);
    }

    @GetMapping
    List<Storage> getStorage(){
        return  storageService.getStorage();
    }

    @GetMapping("/{storages_name}")
    Storage getStoragebyName(@RequestParam String Name){
        return storageService.getStoragebyName(Name);
    }
}
