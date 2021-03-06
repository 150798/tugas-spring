package com.project.tugasSpring.service;

import com.project.tugasSpring.model.dto.KecamatanDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Kecamatan;

public interface KecamatanService {
	
	//UNTUK TRANSFER DATA
	public StatusMessageDto<?> insertData(KecamatanDto dto);
	public Kecamatan updateData(Integer id, KecamatanDto dto);
	public Kecamatan softDelete(Integer id);
	

}
