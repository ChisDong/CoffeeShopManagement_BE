package com.is216.CoffeeShopManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.is216.CoffeeShopManagement.DTO.Request.StorageCreationRequest;
import com.is216.CoffeeShopManagement.Entity.Storage;
import com.is216.CoffeeShopManagement.Service.StorageService;

@Controller
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/storages")
    Storage createStorage(@RequestBody StorageCreationRequest request) {
        return storageService.createStorage(request);
    }
}
