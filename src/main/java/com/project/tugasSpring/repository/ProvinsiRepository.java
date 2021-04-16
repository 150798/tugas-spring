package com.project.tugasSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tugasSpring.model.entity.Provinsi;

public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer>{
	public Provinsi findByKodeProvinsi(String kodeProvinsi);

}
