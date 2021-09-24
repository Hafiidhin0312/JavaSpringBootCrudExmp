package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.buku.Buku;
import com.example.demo.buku.Kategori;
import com.example.demo.dto.BukuDTO;
import com.example.demo.dto.BukuReq;
import com.example.demo.dto.GeneralRespon;
import com.example.demo.dto.KategoriDTO;
import com.example.demo.dto.KategoriReq;
import com.example.demo.repository.BukuRepository;
import com.example.demo.repository.KategoriRepository;
import com.example.demo.service.buku.BukuService;
import com.example.demo.service.kategori.KategoriService;

@RestController
@RequestMapping("/kategori")

public class KategoriController {
	@Autowired KategoriService kategoriService;
	@Autowired KategoriRepository repo;
	
	
	@GetMapping("/listkategori")
	public GeneralRespon listBuku() {
		GeneralRespon generalRespon = new GeneralRespon();
		List<Kategori> kategori = kategoriService.listAll();
		List<KategoriDTO> kategoridto = new ArrayList<>();
		
		for (Kategori kategories : kategori) {
			
			KategoriDTO katdto = new KategoriDTO();
			katdto.setKodeKategori(kategories.getKodeKategori());
			katdto.setDeskripsi(kategories.getDeskripsi());
			kategoridto.add(katdto);
			
		}
		
		 try {
			 kategoriService.listAll();
				generalRespon.setStatus(200);
				generalRespon.setKode("00");
				generalRespon.setMessage("Success");
				generalRespon.setKategoriDtoList(kategoridto);
				  
			} catch (Exception e) {
				generalRespon.setStatus(404);
				generalRespon.setKode("00");
				generalRespon.setMessage("failed"+e.getMessage());
		
			}
		 
			return generalRespon;
		}
	
	
	@PostMapping("/addkategori")
	public GeneralRespon addKategori(@RequestBody KategoriReq kategoriReq) {
		
		GeneralRespon generalRespon = new GeneralRespon();
		
		try {
			kategoriService.addKategori(kategoriReq);
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
	
	@PostMapping("/updatekategori")
	public GeneralRespon updateBuku(@RequestBody KategoriReq kategoriReq ) {
		
		GeneralRespon generalRespon = new GeneralRespon();

		try {
			
			if(kategoriService.updateKategori(kategoriReq)) {
				
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
	
	@PostMapping("/deletekategori")
	public GeneralRespon deleteBuku(@RequestBody KategoriReq kategoriReq ) {
		
		GeneralRespon generalRespon = new GeneralRespon();

		try {
			
			if(kategoriService.deleteKategori(kategoriReq)) {
				
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

@GetMapping("/getkategoribyid")
	
	public GeneralRespon getKategoriById(@RequestParam("kodeKategori") String kodeKategori) {
		
		Kategori kategori = kategoriService.getKategoriById(kodeKategori);
	    KategoriDTO kategoriDto = new KategoriDTO();
	    
	    kategoriDto.setKodeKategori(kategori.getKodeKategori());
	    kategoriDto.setDeskripsi(kategori.getDeskripsi());
	    
		GeneralRespon generalRespon = new GeneralRespon();
		
		try {
			kategoriService.getKategoriById(kodeKategori);
			generalRespon.setStatus(200);
			generalRespon.setKode("00");
			generalRespon.setMessage("Success");
			generalRespon.setKategoriDto(kategoriDto);
	
			  
		} catch (Exception e) {
			generalRespon.setStatus(404);
			generalRespon.setKode("00");
			generalRespon.setMessage("failed"+e.getMessage());
		}
	
		return generalRespon ;
		
	}


}
