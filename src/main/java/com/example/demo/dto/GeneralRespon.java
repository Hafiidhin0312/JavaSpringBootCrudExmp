package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)//supaya  yg null tidak terinclude
public class GeneralRespon {
	
	int status;
	String kode;
	String message;
	BukuDTO bukuDto;
	List<BukuDTO> bukuDtolist;
	KategoriDTO kategoriDto;
	List<KategoriDTO> KategoriDtoList;

}
