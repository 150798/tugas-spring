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

import com.project.tugasSpring.model.dto.KabupatenDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Kabupaten;
import com.project.tugasSpring.repository.KabupatenRepository;
import com.project.tugasSpring.service.KabupatenService;

@RestController
@RequestMapping("/api/v1")

public class KabupatenController {
	@Autowired
	private KabupatenRepository kabupatenRepository;
	@Autowired
	private KabupatenService kabupatenService;
	
	
	//GET ALL DATA KABUPATEN
	@GetMapping("/kabupatens")
	public List<?> getKabupatens(){
		List <Kabupaten> kabupatens = kabupatenRepository.findAll();
		return kabupatens;
	}
	
	//INSERT DATA KABUPATEN
	@PostMapping ("/insert/kabupaten")
	public ResponseEntity<?> insertKabupaten(@RequestBody KabupatenDto kabupatenDto){
		StatusMessageDto<?> kabupaten = kabupatenService.insertData(kabupatenDto);
		return ResponseEntity.ok(kabupaten);
	}
	
	//GET BY ID
	@GetMapping("/kabupaten/{id}")
	public ResponseEntity<?> getKabupaten (@PathVariable Integer id){
		Kabupaten kabupaten = kabupatenRepository.findById(id).get();
		return ResponseEntity.ok(kabupaten);
	}
	
	//UPDATE DATA KABUPATEN
	@PutMapping ("/kabupaten/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KabupatenDto dto){
		Kabupaten kabupaten = kabupatenService.updateData(id, dto);
		return ResponseEntity.ok(kabupaten);
	}
	
	//DELETE DATA KABUPATEN
//	@DeleteMapping("delete/kabupaten/{id}")
//	public ResponseEntity<?> delete (@PathVariable Integer id){
//		Kabupaten kabupaten = kabupatenRepository.findById(id).get();
//		kabupatenRepository.delete(kabupaten);
//		
//		return ResponseEntity.ok(kabupaten);
//	}
//	
	//SOFT DELETE
		@DeleteMapping("/delete/kabupaten/{id}")
		public ResponseEntity<?> delete(@PathVariable Integer id){
			Kabupaten kabupaten = kabupatenService.softDelete(id);
			return ResponseEntity.ok(kabupaten);
		}
	
	
	
	
		
}
