package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.StorageCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Storage;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;
    public Storage createRequest(StorageCreationRequest request){
        Storage storage = new Storage();
        storage.setName(request.getName());
        storage.setDateReceived(request.getDateReceived());
        storage.setManufacturer(request.getManufacturer());
        storage.setQuantity(request.getQuantity());
        return storageRepository.save(storage);
    }

    public List<Storage> getStorage() {
        return storageRepository.findAll();
    }

    public Storage getStoragebyName(String name){
        return storageRepository.findByName(name);
    }
}
