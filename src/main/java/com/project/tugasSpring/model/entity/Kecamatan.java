package com.project.tugasSpring.model.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "table_kecamatan")

public class Kecamatan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (unique = true, nullable = false)
	private String kodeKecamatan;
	
	@Column
	private String namaKecamatan;
	
	@ManyToOne
	@JoinColumn(name="kodeKabupaten", referencedColumnName = "kodeKabupaten")
	private Kabupaten kabupaten;
	
	@ManyToOne
	@JoinColumn(name="kodeProvinsi", referencedColumnName = "kodeProvinsi")
	private Provinsi provinsi;
	
	@Column (name = "status", columnDefinition = "boolean default true")
	private Boolean status;

	
	//CONSTRUCTOR
	public Kecamatan(String kodeKecamatan, String namaKecamatan, Kabupaten kabupaten, Provinsi provinsi, Boolean status) {
		this.kodeKecamatan = kodeKecamatan;
		this.namaKecamatan = namaKecamatan;
		this.kabupaten = kabupaten;
		this.provinsi = provinsi;
		this.status = status;
	}
	
	
}
