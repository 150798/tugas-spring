package com.project.tugasSpring.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "table_provinsi")

public class Provinsi implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (unique = true, nullable = false)
	private String kodeProvinsi;
	
	@Column
	private String namaProvinsi;
	
	@Column (name = "status", columnDefinition = "boolean default true")
	private Boolean status;
	
	

	//CONSTRUCTOR
	public Provinsi(String kodeProvinsi, String namaProvinsi, Boolean status) {
		this.kodeProvinsi = kodeProvinsi;
		this.namaProvinsi = namaProvinsi;
		this.status = status;
	}		
}
