package com.project.tugasSpring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class KecamatanDto {
	private String kodeKecamatan;
	private String namaKecamatan;
	private String kodeKabupaten;
	private String kodeProvinsi;
	private Boolean status = true;

}
