package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.buku.Kategori;

public interface KategoriRepository extends CrudRepository<Kategori, String> {
	
	public List<Kategori> findAll();
	public Kategori save(Kategori kategori);
	public void delete(Kategori kategori);
	public Optional<Kategori> findById(String kodeKategori);
//	public Kategori searchDeskripsiLike(String deskripsi);

}
