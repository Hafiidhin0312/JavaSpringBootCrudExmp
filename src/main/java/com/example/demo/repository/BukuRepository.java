package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.buku.Buku;
import com.example.demo.buku.Kategori;

@Repository
public interface BukuRepository extends CrudRepository<Buku, String> {
	
	public List<Buku> findAll();
	public Buku save(Buku buku);
	public void delete(Buku buku);
	public Optional<Buku> findById(String kodeBuku);
	public Buku searchByNamaBukuLike(String namaBuku);


}
