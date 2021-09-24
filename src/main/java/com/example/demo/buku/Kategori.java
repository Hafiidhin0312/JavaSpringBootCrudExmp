package com.example.demo.buku;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="kategori")
@Entity
@Setter
@Getter
public class Kategori {
	@Id
	@Column(name="kode_kategori")
    String kodeKategori;

	String deskripsi;

}
