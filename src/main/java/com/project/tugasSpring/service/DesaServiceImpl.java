package com.project.tugasSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tugasSpring.model.dto.DesaDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Desa;
import com.project.tugasSpring.model.entity.Kabupaten;
import com.project.tugasSpring.model.entity.Kecamatan;
import com.project.tugasSpring.model.entity.Provinsi;
import com.project.tugasSpring.repository.DesaRepository;
import com.project.tugasSpring.repository.KabupatenRepository;
import com.project.tugasSpring.repository.KecamatanRepository;
import com.project.tugasSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class DesaServiceImpl implements DesaService{
	@Autowired
	private DesaRepository desaRepository;
	@Autowired
	private KecamatanRepository kecamatanRepository;
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private ProvinsiRepository provinsiRepository;
	
	@Override
	public StatusMessageDto<?> insertData(DesaDto desaDto) {
		
		StatusMessageDto<Desa> result = new StatusMessageDto<>();
		Desa desa = new Desa();
		Desa desaexisting = desaRepository.findByKodeDesa("D" + desaDto.getKodeDesa());
		
		if(desaexisting != null) {
			result.setStatus(400);
			result.setMessage("Kode Desa sudah pernah dipakai");
			
		} else if (!desaDto.getKodeDesa().isEmpty()) {
			 
				desa.setKodeDesa("D" + desaDto.getKodeDesa());
				desa.setNamaDesa(desaDto.getNamaDesa());
				
				Kecamatan kecamatan = kecamatanRepository.findByKodeKecamatan(desaDto.getKodeKecamatan());
				desa.setKecamatan(kecamatan);
				Kabupaten kabupaten = kabupatenRepository.findByKodeKabupaten(desaDto.getKodeKabupaten());
				desa.setKabupaten(kabupaten);
				Provinsi provinsi = provinsiRepository.findByKodeProvinsi(desaDto.getKodeProvinsi());
				desa.setProvinsi(provinsi);
				
				desa.setStatus(true);
				desaRepository.save(desa);
				
				result.setStatus(200);
				result.setMessage("Insert Data Desa berhasil!");
				result.setData(desa);
				
			} else {
			result.setStatus(400);
			result.setMessage("Gagal menyimpan data Desa!");
		}
		return result;
	}
	
	@Override
	public Desa updateData(Integer id, DesaDto dto) {
		Desa desa = desaRepository.findById(id).get();
		desa.setKodeDesa("D" + dto.getKodeDesa());
		desa.setNamaDesa(dto.getNamaDesa());
//		desa.setKodeKecamatan(dto.getKodeKecamatan());
//		desa.setKodeKabupaten(dto.getKodeKecamatan());
//		desa.setKodeProvinsi(dto.getKodeProvinsi());
		
		Kecamatan kecamatan = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		desa.setKecamatan(kecamatan);
		Kabupaten kabupaten = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		desa.setKabupaten(kabupaten);
		Provinsi provinsi = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		desa.setProvinsi(provinsi);
		
		desaRepository.save(desa);
		return desa;
	}
	
	@Override
	public Desa softDelete(Integer id) {
		Desa desa = desaRepository.findById(id).get();
		desa.setStatus(false);
		desaRepository.save(desa);
		return desa;
		
	}

}
