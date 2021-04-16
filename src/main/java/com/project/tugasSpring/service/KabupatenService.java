package com.project.tugasSpring.service;

import com.project.tugasSpring.model.dto.KabupatenDto;
import com.project.tugasSpring.model.entity.Kabupaten;


public interface KabupatenService {
	//UNTUK TRANSFER DATA
	public Kabupaten insertData(KabupatenDto dto);
	public Kabupaten updateData(Integer id, KabupatenDto dto);
	public Kabupaten softDelete(Integer id);

}
