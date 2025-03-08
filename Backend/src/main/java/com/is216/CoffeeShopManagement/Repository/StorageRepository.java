package com.is216.CoffeeShopManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is216.CoffeeShopManagement.Entity.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {

    
}
