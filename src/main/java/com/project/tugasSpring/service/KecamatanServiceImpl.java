package com.project.tugasSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tugasSpring.model.dto.KecamatanDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
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
	public StatusMessageDto<?> insertData(KecamatanDto kecamatanDto) {
		StatusMessageDto<Kecamatan> result = new StatusMessageDto<>();
		Kecamatan kecamatan = new Kecamatan();
		Kecamatan kecamatanexisting = kecamatanRepository.findByKodeKecamatan("KC" + kecamatanDto.getKodeKecamatan());
		
		Integer status = 200;
		if(kecamatanexisting!= null) {
			status = 400;
			result.setStatus(status);
			result.setMessage("Kode Kecamatan sudah pernah dipakai");
		} else if (!kecamatanDto.getKodeKecamatan().isEmpty()) {
				kecamatan.setKodeKecamatan("KC" + kecamatanDto.getKodeKecamatan());
				kecamatan.setNamaKecamatan(kecamatanDto.getNamaKecamatan());
				
				Kabupaten kabupaten = kabupatenRepository.findByKodeKabupaten(kecamatanDto.getKodeKabupaten());
				kecamatan.setKabupaten(kabupaten);
				Provinsi provinsi = provinsiRepository.findByKodeProvinsi(kecamatanDto.getKodeProvinsi());
				kecamatan.setProvinsi(provinsi);
				
				kecamatan.setStatus(true);
				kecamatanRepository.save(kecamatan);
				
				result.setStatus(200);
				result.setMessage("Insert Data Kecamatan brhasil!");
				result.setData(kecamatan);
				
		} else {
			result.setStatus(400);
			result.setMessage("Gagal menyimpan data kecamatan");
		}
		
		return result;
	}
	
	@Override
	public Kecamatan updateData(Integer id, KecamatanDto dto) {
		Kecamatan kecamatan = kecamatanRepository.findById(id).get();
		kecamatan.setKodeKecamatan("KC" +dto.getKodeKecamatan());
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
