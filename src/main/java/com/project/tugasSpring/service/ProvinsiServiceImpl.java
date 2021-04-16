package com.project.tugasSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tugasSpring.model.dto.ProvinsiDto;
import com.project.tugasSpring.model.entity.Provinsi;
import com.project.tugasSpring.repository.ProvinsiRepository;

@Service
@Transactional

public class ProvinsiServiceImpl implements ProvinsiService {
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public Provinsi insertData(ProvinsiDto provinsiDto) {
		Provinsi provinsi = new Provinsi();
		
		if(!provinsiDto.getKodeProvinsi().isEmpty()) {
			provinsi.setKodeProvinsi(provinsiDto.getKodeProvinsi());
			provinsi.setNamaProvinsi(provinsiDto.getNamaProvinsi());
			provinsi.setStatus(true);
			provinsiRepository.save(provinsi);
			return provinsi;
		}
		return null;
	}
	
	
	@Override
	public Provinsi updateData(Integer id, ProvinsiDto dto) {
		Provinsi provinsi = provinsiRepository.findById(id).get();
		provinsi.setKodeProvinsi(dto.getKodeProvinsi());
		provinsi.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiRepository.save(provinsi);
		return provinsi;
	}
	
	@Override
	public Provinsi softDelete(Integer id) {
		Provinsi provinsi = provinsiRepository.findById(id).get();
		provinsi.setStatus(false);
		provinsiRepository.save(provinsi);
		return provinsi;
		
	}
	

}
