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

import com.project.tugasSpring.model.dto.ProvinsiDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Provinsi;
import com.project.tugasSpring.repository.ProvinsiRepository;
import com.project.tugasSpring.service.ProvinsiService;

@RestController
@RequestMapping("/api/v1")

public class ProvinsiController {
	@Autowired
	private ProvinsiRepository provinsiRepository;
	@Autowired
	private ProvinsiService provinsiService;
	
	//GET ALL DATA PROVINSI
	@GetMapping("/provinsis")
	public List<?> getProvinsis(){
		List <Provinsi> provinsis = provinsiRepository.findAll();
		return provinsis;
	}
	
	//INSERT DATA PROVINSI
	@PostMapping("/insert/provinsi")
	public ResponseEntity<?> insertProvinsi(@RequestBody ProvinsiDto provinsiDto){
		StatusMessageDto <?> provinsi = provinsiService.insertData(provinsiDto);
		return ResponseEntity.ok(provinsi);
	}
	
	//GET BY ID
	@GetMapping ("/provinsi/{id}")
	public ResponseEntity<?> getProvinsi (@PathVariable Integer id){
		Provinsi provinsi = provinsiRepository.findById(id).get();
		return ResponseEntity.ok(provinsi);
	}
	
	//UPDATE DATA PROVINSI
	@PutMapping("/update/provinsi/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ProvinsiDto dto){
		Provinsi provinsi = provinsiService.updateData(id, dto);
		return ResponseEntity.ok(provinsi);
	}
	
	//DELETE DATA PROVINSI
//	@DeleteMapping("/delete/provinsi/{id}")
//	public ResponseEntity<?> delete(@PathVariable Integer id){
//		Provinsi provinsi = provinsiRepository.findById(id).get();
//		provinsiRepository.delete(provinsi);
//		
//		return ResponseEntity.ok(provinsi);
//	}
	
	//SOFT DELETE
	@DeleteMapping("/delete/provinsi/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Provinsi provinsi = provinsiService.softDelete(id);
		return ResponseEntity.ok(provinsi);
	}

}
