package com.example.asset_manager.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
@Table(name = "assets")
@Entity
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private LocalDate date;
	
	@NotBlank(message = "項目名を入力してください")
	@Size(max = 20, message = "項目名は20文字以内で入力してください")
	private String category;
	
	@NotNull
	@Min(value = 1, message = "金額は1円以上にしてください")
	private Integer amount;
}
