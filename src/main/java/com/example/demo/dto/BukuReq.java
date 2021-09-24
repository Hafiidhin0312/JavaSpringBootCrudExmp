package com.example.demo.dto;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BukuReq {
	
	
	String kodeBuku;

	String namaBuku;

	String kodeKategori;
	
	int harga;

}
