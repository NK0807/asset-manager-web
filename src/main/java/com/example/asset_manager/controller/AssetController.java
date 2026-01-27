package com.example.asset_manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
		
		// 合計金額を計算
		Integer total = service.getTotalAmount();

		// 画面に渡す
		model.addAttribute("assets", assetList);
		model.addAttribute("total", total);
		
		// 空っぽのフォーム用データ
		if(!model.containsAttribute("asset")) {
			model.addAttribute("asset", new Asset());
		}
		return "index";
	}
	
	// データ登録
	@PostMapping("/add")
	public String add(@Validated Asset asset, BindingResult result, Model model) {
		if(result.hasErrors()) {
			// 失敗したので保存しない
			
			// 画面下の一覧表示用データだけ再取得して渡す（これがないと画面が崩れる）
			List<Asset> assetList = service.findAll();
			model.addAttribute("assets", assetList);
			model.addAttribute("total", service.getTotalAmount());
			
			return "index";
		}
		
		// エラーがなければ保存して再読み込み
		service.save(asset);
		return "redirect:/";
	}
}
