package com.example.asset_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.asset_manager.entity.Asset;
import com.example.asset_manager.repository.AssetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetService {
	private final AssetRepository repository;
	
	public List<Asset> findAll(){
		return repository.findAll();
	}
	
	public void save(Asset asset) {
		repository.save(asset);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Asset getAsset(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Integer getTotalAmount() {
		int sum = 0;
		List<Asset> assetList = repository.findAll();
		for(Asset a : assetList) {
			sum += a.getAmount();
		}

		return sum;
	}
}
