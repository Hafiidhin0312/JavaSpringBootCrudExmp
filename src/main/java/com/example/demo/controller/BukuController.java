package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.buku.Buku;
import com.example.demo.dto.BukuDTO;
import com.example.demo.dto.BukuReq;
import com.example.demo.dto.GeneralRespon;
import com.example.demo.repository.BukuRepository;
import com.example.demo.service.buku.BukuService;


@RestController
//@Controller
@RequestMapping("/buku")

public class BukuController {
	@Autowired BukuService bukuService;
	@Autowired BukuRepository repo;
	
	
	@GetMapping("/listall")
	public GeneralRespon listBuku() {
		 GeneralRespon generalRespon = new GeneralRespon();
		List<Buku> buku = bukuService.listAll();
		List<BukuDTO> bukuDto = new ArrayList<>();
		
		for (Buku buku2 : buku) {
			
			BukuDTO bukus = new BukuDTO();
			bukus.setNamabuku(buku2.getNamaBuku());
			bukus.setHarga(buku2.getHarga());
			bukus.setDeskripsi(buku2.getKategori().getDeskripsi());
			bukuDto.add(bukus);
			
		}
		
		 try {
				bukuService.listAll();
				generalRespon.setStatus(200);
				generalRespon.setKode("00");
				generalRespon.setMessage("Success");
				generalRespon.setBukuDtolist(bukuDto);
				  
			} catch (Exception e) {
				generalRespon.setStatus(404);
				generalRespon.setKode("00");
				generalRespon.setMessage("failed"+e.getMessage());
		
			}
		 
			return generalRespon;
		}
	
	
	@PostMapping("/addbuku")
	public GeneralRespon addBuku(@RequestBody BukuReq bukuReq) {
		
		GeneralRespon generalRespon = new GeneralRespon();
		
		try {
			bukuService.addBuku(bukuReq);
			generalRespon.setStatus(200);
			generalRespon.setKode("00");
			generalRespon.setMessage("Success");
			
	
			  
		} catch (Exception e) {
			generalRespon.setStatus(404);
			generalRespon.setKode("00");
			generalRespon.setMessage("failed"+e.getMessage());
			
		}
	
		return generalRespon;
	}
	
	@GetMapping("/getbukubyid")
	
	public GeneralRespon getBukuById(@RequestParam("kodeBuku") String kodeBuku) {
		
		Buku buku = bukuService.getBukuById(kodeBuku);
		BukuDTO bukuDto = new BukuDTO();
	    bukuDto.setNamabuku(buku.getNamaBuku());
	    bukuDto.setHarga(buku.getHarga());
	    
		
		GeneralRespon generalRespon = new GeneralRespon();
		
		try {
			bukuService.getBukuById(kodeBuku);
			generalRespon.setStatus(200);
			generalRespon.setKode("00");
			generalRespon.setMessage("Success");
			generalRespon.setBukuDto(bukuDto);
	
			  
		} catch (Exception e) {
			generalRespon.setStatus(404);
			generalRespon.setKode("00");
			generalRespon.setMessage("failed"+e.getMessage());
		}
	
		return generalRespon ;
		
	}
	
@GetMapping("/getbukubyname")
	
	public GeneralRespon getBukuByName(@RequestParam("namaBuku") String namaBuku) {
		
		Buku buku = bukuService.getBukuByName(namaBuku);
		
		BukuDTO bukuDto = new BukuDTO();
	    bukuDto.setNamabuku(buku.getNamaBuku());
	    bukuDto.setHarga(buku.getHarga());
		GeneralRespon generalRespon = new GeneralRespon();
		
		try {
			bukuService.getBukuByName(namaBuku);
			generalRespon.setStatus(200);
			generalRespon.setKode("00");
			generalRespon.setMessage("Success");
			generalRespon.setBukuDto(bukuDto);
	
			  
		} catch (Exception e) {
			generalRespon.setStatus(404);
			generalRespon.setKode("00");
			generalRespon.setMessage("failed"+e.getMessage());
		}
	
		return generalRespon ;
	}

	
@PostMapping("/updatebuku")
public GeneralRespon updateBuku(@RequestBody BukuReq bukuReq ) {
	
	GeneralRespon generalRespon = new GeneralRespon();

	try {
		
		if(bukuService.updateBuku(bukuReq)) {
			
			generalRespon.setStatus(200);
			generalRespon.setKode("00");
			generalRespon.setMessage("Success");
			
		}else {
			throw new Error("Data tidak ditemukan");
		}

		  
	} catch (Exception e) {
		generalRespon.setStatus(404);
		generalRespon.setKode("00");
		generalRespon.setMessage("failed"+e.getMessage());
		
	}

	return generalRespon;
}


@PostMapping("/deletebuku")
public GeneralRespon deleteBuku(@RequestBody BukuReq bukuReq ) {
	
	GeneralRespon generalRespon = new GeneralRespon();

	try {
		
		if(bukuService.deleteBuku(bukuReq)) {
			
			generalRespon.setStatus(200);
			generalRespon.setKode("00");
			generalRespon.setMessage("Success");
			
		}else {
			throw new Error("Data tidak ditemukan");
		}
		
	} catch (Exception e) {
		generalRespon.setStatus(404);
		generalRespon.setKode("00");
		generalRespon.setMessage("failed"+e.getMessage());
		
	}

	return generalRespon;
}



}
