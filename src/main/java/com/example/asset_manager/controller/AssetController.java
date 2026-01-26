package com.example.asset_manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.asset_manager.entity.Asset;
import com.example.asset_manager.service.AssetService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AssetController {
	private final AssetService service;
	
	// トップページを表示
	@GetMapping("/")
	public String index(Model model) {
		List<Asset> assetList = service.findAll();
		
		// 画面に渡す
		model.addAttribute("assets", assetList);
		return "index";
	}
	
	// データ登録
	@PostMapping("/add")
	public String add(Asset asset) {
		service.save(asset);
		return "redirect:/";
	}
}
