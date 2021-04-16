package com.project.tugasSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tugasSpring.model.dto.KecamatanDto;
import com.project.tugasSpring.model.entity.Kabupaten;
import com.project.tugasSpring.model.entity.Kecamatan;
import com.project.tugasSpring.model.entity.Provinsi;
import com.project.tugasSpring.repository.KabupatenRepository;
import com.project.tugasSpring.repository.KecamatanRepository;
import com.project.tugasSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService{
	
	@Autowired
	private KecamatanRepository kecamatanRepository;
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	
	@Override
	public Kecamatan insertData(KecamatanDto kecamatanDto) {
		Kecamatan kecamatan = new Kecamatan();
		
		if(!kecamatanDto.getKodeKecamatan().isEmpty()) {
			kecamatan.setKodeKecamatan(kecamatanDto.getKodeKecamatan());
			kecamatan.setNamaKecamatan(kecamatanDto.getNamaKecamatan());
			
			Kabupaten kabupaten = kabupatenRepository.findByKodeKabupaten(kecamatanDto.getKodeKabupaten());
			kecamatan.setKabupaten(kabupaten);
			Provinsi provinsi = provinsiRepository.findByKodeProvinsi(kecamatanDto.getKodeProvinsi());
			kecamatan.setProvinsi(provinsi);
			
			kecamatan.setStatus(true);
			kecamatanRepository.save(kecamatan);
			return kecamatan;
		}
		return null;
	}
	
	@Override
	public Kecamatan updateData(Integer id, KecamatanDto dto) {
		Kecamatan kecamatan = kecamatanRepository.findById(id).get();
		kecamatan.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatan.setNamaKecamatan(dto.getNamaKecamatan());
		
		Kabupaten kabupaten = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		kecamatan.setKabupaten(kabupaten);
		Provinsi provinsi = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		kecamatan.setProvinsi(provinsi);
		
		
		kecamatanRepository.save(kecamatan);
		return kecamatan;
		
	}
	
	@Override
	public Kecamatan softDelete(Integer id) {
		Kecamatan kecamatan = kecamatanRepository.findById(id).get();
		kecamatan.setStatus(false);
		kecamatanRepository.save(kecamatan);
		return kecamatan;
		
	}

}
