package com.project.tugasSpring.service;

import com.project.tugasSpring.model.dto.DesaDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Desa;

public interface DesaService {
	
	//UNTUK TRANSFER DATA
	public StatusMessageDto<?> insertData(DesaDto dto);
	public Desa updateData(Integer id, DesaDto dto);
	public Desa softDelete(Integer id);

}
