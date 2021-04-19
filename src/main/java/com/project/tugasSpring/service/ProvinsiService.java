package com.project.tugasSpring.service;


import com.project.tugasSpring.model.dto.ProvinsiDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Provinsi;

public interface ProvinsiService {
	
	//UNTUK TRANSFER DATA
	public StatusMessageDto<?> insertData(ProvinsiDto dto);
	public Provinsi updateData(Integer id, ProvinsiDto dto);
	public Provinsi softDelete(Integer id);

}
