package com.project.tugasSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tugasSpring.model.dto.KabupatenDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Kabupaten;
import com.project.tugasSpring.model.entity.Provinsi;
import com.project.tugasSpring.repository.KabupatenRepository;
import com.project.tugasSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class KabupatenServiceImpl implements KabupatenService {
	
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	
	@Override
	public StatusMessageDto<?>  insertData(KabupatenDto kabupatenDto) {
		
		StatusMessageDto<Kabupaten> result = new StatusMessageDto<>();
		Kabupaten kabupaten = new Kabupaten();
		Kabupaten kabupatenexisting = kabupatenRepository.findByKodeKabupaten("KB" + kabupatenDto.getKodeKabupaten());
		
		if(kabupatenexisting!= null) {

			result.setStatus(400);
			result.setMessage("Kode Kabupaten sudah pernah dipakai");
		} else if (!kabupatenDto.getKodeKabupaten().isEmpty()) {
			
				kabupaten.setKodeKabupaten("KB" + kabupatenDto.getKodeKabupaten());
				kabupaten.setNamaKabupaten(kabupatenDto.getNamaKabupaten());
				
				Provinsi provinsi = provinsiRepository.findByKodeProvinsi(kabupatenDto.getKodeProvinsi());
				kabupaten.setProvinsi(provinsi);
				
				kabupaten.setStatus(true);
				kabupatenRepository.save(kabupaten);
				
				result.setStatus(200);
				result.setMessage("Insert data kabupaten berhasil!");
				result.setData(kabupaten);

		} else {
			result.setStatus(400);
			result.setMessage("Gagal menyimpan data kabupaten");
		}
		
		return result;
	}
	
	@Override
	public Kabupaten updateData(Integer id, KabupatenDto dto) {
		Kabupaten kabupaten = kabupatenRepository.findById(id).get();
		kabupaten.setKodeKabupaten("KB" + dto.getKodeKabupaten());
		kabupaten.setNamaKabupaten(dto.getNamaKabupaten());
		
		Provinsi provinsi = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi()); 
		kabupaten.setProvinsi(provinsi);
		kabupatenRepository.save(kabupaten);
		return kabupaten;
	}
	
	@Override
	public Kabupaten softDelete(Integer id) {
		Kabupaten kabupaten = kabupatenRepository.findById(id).get();
		kabupaten.setStatus(false);
		kabupatenRepository.save(kabupaten);
		return kabupaten;
		
	}
	
	
	

}
