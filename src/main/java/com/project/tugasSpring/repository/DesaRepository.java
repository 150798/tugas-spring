package com.project.tugasSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tugasSpring.model.entity.Desa;

public interface DesaRepository extends JpaRepository<Desa, Integer> {
	public Desa findByKodeDesa (String kodeDesa);

}
