package com.example.demo.service.kategori;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.buku.Buku;
import com.example.demo.buku.Kategori;

import com.example.demo.dto.KategoriReq;

import com.example.demo.repository.KategoriRepository;

@Service
@Transactional
public class KategoriService {

	 @Autowired KategoriRepository repo;
		
	 public List<Kategori> listAll() {
	        return repo.findAll();
	    }
	 
		
	  
	  public void addKategori(KategoriReq kategoriReq) {
		  Kategori kategori = new Kategori();
		  
		  kategori.setKodeKategori(kategoriReq.getKodeKategori());
		  kategori.setDeskripsi(kategoriReq.getDeskripsi());
		 
		  repo.save(kategori);
		  
	  }
	  
	  public Kategori getBukuById(String Id) {
		  
		 return repo.findById(Id).get();
		  
	  }

	  
	  
	  public Boolean updateKategori(KategoriReq kategoriReq){
		  Kategori kategori = new Kategori();
		  
		  /*validasi untuk ID ada atau tidak
		  Sehingga Data yang masuk dari front end yg tidak diubah seperti kode kategori, 
		  back end akan mendapatkannya dari findbyId
		  
		  jika tidak dilakukan validasi ID maka seluruh data dari frontend akan tertangkap yg mana berarti data kategori
		  yg dikirimkan oleh front end berupa null akan ditangkap oleh back end menjadi null.
		  */
		  
		  kategori = repo.findById(kategoriReq.getKodeKategori()).get();
		  
		  if(kategori!=null) {
			  kategori.setKodeKategori(kategoriReq.getKodeKategori());
			  kategori.setDeskripsi(kategoriReq.getDeskripsi());
			  return true;
		  }else {
			  return false;
		  }
		  
	  }
	  
	  
	  public Boolean deleteKategori(KategoriReq kategoriReq){
		  Kategori kategori = new Kategori();
		  
		  kategori = repo.findById(kategoriReq.getKodeKategori()).get();
		  
		  if(kategori!=null) {
			  repo.delete(kategori);
			  return true;
		  }else {
			  return false;
		  }
		  
	  }
	  
	  public Kategori getKategoriById(String Id) {
		  
		 return repo.findById(Id).get();
		  
	  }
	
}
