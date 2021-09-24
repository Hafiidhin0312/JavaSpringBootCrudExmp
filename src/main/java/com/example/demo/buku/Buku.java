package com.example.demo.buku;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="buku")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Buku {
	@Id
	@Column(name="kode_buku")
	String kodeBuku;
	
	@Column(name="nama_buku")
	String namaBuku;
	
	
	@Column(name="kode_kategori")
	String kodeKategori;
	
	int harga;
	
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "kode_kategori",nullable = false, insertable = false, updatable = false)
	    private Kategori kategori;


	
	
}
