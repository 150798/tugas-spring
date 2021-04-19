package com.project.tugasSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tugasSpring.model.dto.ProvinsiDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Provinsi;
import com.project.tugasSpring.repository.ProvinsiRepository;

@Service
@Transactional

public class ProvinsiServiceImpl implements ProvinsiService {
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public StatusMessageDto<?> insertData(ProvinsiDto provinsiDto) {
		
		StatusMessageDto<Provinsi> result = new StatusMessageDto<>();
		Provinsi provinsi = new Provinsi();
		Provinsi provinsiexisting = provinsiRepository.findByKodeProvinsi("P" + provinsiDto.getKodeProvinsi());
		
		
		if(provinsiexisting!=null) {

			result.setStatus(400); //buat deteksi requestnya berhasil apa engga
			result.setMessage("Kode provinsi sudah pernah dipakai");
			
		} else if (!provinsiDto.getKodeProvinsi().isEmpty()) { // kalo misal kodeProvinsinya ada isinya, baru ngisi bawah ini
				provinsi.setKodeProvinsi("P" +provinsiDto.getKodeProvinsi());
				provinsi.setNamaProvinsi(provinsiDto.getNamaProvinsi());
				provinsi.setStatus(true);
				provinsiRepository.save(provinsi);
				
				result.setStatus(200);
				result.setMessage("Insert data Provinsi success!");
				result.setData(provinsi);//isi hasil dr keterangan bawahnya
			
		} else {
			result.setStatus(400);
			result.setMessage("Gagal menyimpan data provinsi");		
			
		}
		return result;
	}
	
	
	@Override
	public Provinsi updateData(Integer id, ProvinsiDto dto) {
		Provinsi provinsi = provinsiRepository.findById(id).get();
		provinsi.setKodeProvinsi("P" + dto.getKodeProvinsi());
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
