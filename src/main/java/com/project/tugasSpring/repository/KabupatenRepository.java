package com.project.tugasSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tugasSpring.model.entity.Kabupaten;

public interface KabupatenRepository extends JpaRepository<Kabupaten, Integer> {
	public Kabupaten findByKodeKabupaten(String kodeKabupaten);

}
