package com.project.tugasSpring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ProvinsiDto {
	private String kodeProvinsi;
	private String namaProvinsi;
	private Boolean status = true;

}
