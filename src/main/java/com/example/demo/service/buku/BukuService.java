package com.example.demo.service.buku;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.buku.Buku;
import com.example.demo.buku.Kategori;
import com.example.demo.dto.BukuReq;
import com.example.demo.repository.BukuRepository;

@Service
@Transactional
public class BukuService {
	
	 @Autowired BukuRepository repo;
	
	 public List<Buku> listAll() {
	        return repo.findAll();
	    }
	 
		
	  public void save(Buku buku) {
	        repo.save(buku);
	    }
	  
	  
	  
	  public void addBuku(BukuReq bukuReq) {
		  Buku buku = new Buku();
		  buku.setKodeBuku(bukuReq.getKodeBuku());
		  buku.setKodeKategori(bukuReq.getKodeKategori());
		  buku.setNamaBuku(bukuReq.getNamaBuku());
		  buku.setHarga(bukuReq.getHarga());
		 
		  repo.save(buku);
		  
	  }
	  
	  public Buku getBukuById(String Id) {
		  
		 return repo.findById(Id).get();
		  
	  }
	  
	  public Buku getBukuByName(String namaBuku) {
		  
		 return repo.searchByNamaBukuLike(namaBuku);
		  
	  }
	  
	  
	  public Boolean updateBuku(BukuReq bukuReq){
		  Buku buku = new Buku();
		  
		  /*validasi untuk ID ada atau tidak
		  Sehingga Data yang masuk dari front end yg tidak diubah seperti kode kategori, 
		  back end akan mendapatkannya dari findbyId
		  
		  jika tidak dilakukan validasi ID maka seluruh data dari frontend akan tertangkap yg mana berarti data kategori
		  yg dikirimkan oleh front end berupa null akan ditangkap oleh back end menjadi null.
		  */
		  
		  buku = repo.findById(bukuReq.getKodeBuku()).get();
		  
		  if(buku!=null) {
			  buku.setKodeBuku(bukuReq.getKodeBuku());
			  buku.setNamaBuku(bukuReq.getNamaBuku());
			  buku.setHarga(bukuReq.getHarga());
			  repo.save(buku);
			  return true;
		  }else {
			  return false;
		  }
		  
	  }
	  
	  
	  public Boolean deleteBuku(BukuReq bukuReq){
		  Buku buku = new Buku();
		  
		  buku = repo.findById(bukuReq.getKodeBuku()).get();
		  
		  if(buku!=null) {
			  repo.delete(buku);
			  return true;
		  }else {
			  return false;
		  }
		  
	  }
	  
}
	  
	  
	  
	  


