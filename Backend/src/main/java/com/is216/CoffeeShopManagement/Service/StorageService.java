package com.is216.CoffeeShopManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is216.CoffeeShopManagement.Entity.Storage;
import com.is216.CoffeeShopManagement.Repository.StorageRepository;
import com.is216.CoffeeShopManagement.DTO.Request.StorageCreationRequest;
import com.is216.CoffeeShopManagement.DTO.Request.StorageUpdateRequest;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public Storage createStorage(StorageCreationRequest request) { 
        Storage storage = new Storage();
        
        storage.setName(request.getName());
        storage.setDateReceived(request.getDateReceived());
        storage.setManufacturer(request.getManufacturer()); 
        storage.setQuantity(request.getQuantity());

        return storageRepository.save(storage);
    }

    public Storage updateStorage(int storageId, StorageUpdateRequest request) {
        Storage storage = getStorage(storageId);

        storage.setDateReceived(request.getDateReceived());
        storage.setManufacturer(request.getManufacturer()); 
        storage.setQuantity(request.getQuantity());

        return storageRepository.save(storage);
    }

    public List<Storage> getStorage() {
        return storageRepository.findAll();
    }

    public Storage getStorage(int id) {
        return storageRepository.findById(id).orElseThrow(() -> new RuntimeException("Storage not found"));
    }
}
