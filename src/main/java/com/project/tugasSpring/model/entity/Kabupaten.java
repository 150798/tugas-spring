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
@Table (name = "table_kabupaten")

public class Kabupaten implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (unique = true, nullable = false)
	private String kodeKabupaten;
	
	@Column
	private String namaKabupaten;
	
	@ManyToOne
	@JoinColumn(name="kodeProvinsi", referencedColumnName = "kodeProvinsi")
	private Provinsi provinsi;
	
	@Column (name = "status", columnDefinition = "boolean default true")
	private Boolean status;


	//CONSTRUCTOR
	public Kabupaten(String kodeKabupaten, String namaKabupaten, Provinsi provinsi, Boolean status) {
		this.kodeKabupaten = kodeKabupaten;
		this.namaKabupaten = namaKabupaten;
		this.provinsi = provinsi;
		this.status = status;
	}
}
