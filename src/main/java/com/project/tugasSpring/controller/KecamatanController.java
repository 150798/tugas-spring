package com.project.tugasSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tugasSpring.model.dto.KecamatanDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Kecamatan;
import com.project.tugasSpring.repository.KecamatanRepository;
import com.project.tugasSpring.service.KecamatanService;

@RestController
@RequestMapping("/api/v1")
public class KecamatanController {
	@Autowired
	private KecamatanRepository kecamatanRepository;
	@Autowired
	private KecamatanService kecamatanService;
	
	
	//GET ALL DATA KECAMATAN
	@GetMapping("/kecamatans")
	public List<?> getKecamatans(){
		List <Kecamatan> kecamatans = kecamatanRepository.findAll();
		return kecamatans;
	}
	
	//INSERT DATA KECAMATAN
	@PostMapping ("/insert/kecamatan")
	public ResponseEntity<?> insertKecamatan(@RequestBody KecamatanDto kecamatanDto){
		StatusMessageDto<?> kecamatan = kecamatanService.insertData(kecamatanDto);
		return ResponseEntity.ok(kecamatan);
	}
	
	//GET BY ID
	@GetMapping ("/kecamatan/{id}")
	public ResponseEntity<?> getProvinsi (@PathVariable Integer id){
		Kecamatan kecamatan = kecamatanRepository.findById(id).get();
		return ResponseEntity.ok(kecamatan);
	}
	
	
	//UPDATE DATA KECAMATAN
	@PutMapping("/update/kecamatan/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KecamatanDto dto){
		Kecamatan kecamatan = kecamatanService.updateData(id, dto);
		return ResponseEntity.ok(kecamatan);
	}
	
	
	//DELETE DATA KECAMATAN
//	@DeleteMapping("/delete/kecamatan/{id}")
//	public ResponseEntity<?> delete(@PathVariable Integer id){
//		Kecamatan kecamatan = kecamatanRepository.findById(id).get();
//		kecamatanRepository.delete(kecamatan);
//		
//		return ResponseEntity.ok(kecamatan);
//	}
	
	//SOFT DELETE
		@DeleteMapping("/delete/kecamatan/{id}")
		public ResponseEntity<?> delete(@PathVariable Integer id){
			Kecamatan kecamatan = kecamatanService.softDelete(id);
			return ResponseEntity.ok(kecamatan);
		}


}
