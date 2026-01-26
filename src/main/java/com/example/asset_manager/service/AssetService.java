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
}
