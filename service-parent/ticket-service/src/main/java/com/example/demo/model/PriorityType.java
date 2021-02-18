package com.example.demo.model;

import lombok.Getter;

@Getter
public enum PriorityType {
	
	URGENT("Acil"), 
	LOW("Dusuk Oncelikli"), 
	HIGH("Yüksek Oncelikli");

	private String label;

	PriorityType(String label) {
		this.label = label;
	}
}
