package com.is216.CoffeeShopManagement.Controller;

import java.util.List;

import com.is216.CoffeeShopManagement.DTO.Request.StorageUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.is216.CoffeeShopManagement.DTO.Request.StorageCreationRequest;
import com.is216.CoffeeShopManagement.Entity.Storage;
import com.is216.CoffeeShopManagement.Service.StorageService;

@RestController
@RequestMapping("/storages")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping
    Storage createStorage(@RequestBody StorageCreationRequest request) {
        return storageService.createStorage(request);
    }

    @GetMapping
    List<Storage> getStorage(){
        return storageService.getStorage();
    }

    @GetMapping("/{storageId}")
    Storage getStorage(@PathVariable int storageId) {
        return storageService.getStorage(storageId);
    }

    @PutMapping("/{storageId}")
    Storage updateStorage(@PathVariable int storageId,
                          @RequestBody StorageUpdateRequest request) {
        System.out.println("updated successfully item" + storageId);
        return storageService.updateStorage(storageId, request);
    }

    @DeleteMapping("/{storageId}")
    String deleteStorage(@PathVariable int storageId){
        storageService.deleteStorage(storageId);
        return "Item has been deleted";
    }
}
