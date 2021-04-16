package com.project.tugasSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tugasSpring.model.entity.Kecamatan;

public interface KecamatanRepository extends JpaRepository<Kecamatan, Integer>{
	public Kecamatan findByKodeKecamatan (String kodeKecamatan);

}
