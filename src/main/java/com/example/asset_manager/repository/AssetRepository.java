package com.example.asset_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.asset_manager.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer>{
	
}
