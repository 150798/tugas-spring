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
import com.project.tugasSpring.model.dto.DesaDto;
import com.project.tugasSpring.model.dto.StatusMessageDto;
import com.project.tugasSpring.model.entity.Desa;
import com.project.tugasSpring.repository.DesaRepository;
import com.project.tugasSpring.service.DesaService;

@RestController
@RequestMapping("/api/v1")

public class DesaController {
	@Autowired
	private DesaRepository desaRepository;
	@Autowired
	private DesaService desaService;
	
	//GET ALL DATA DESA
	@GetMapping("/desas")
	public List<?> getDesas(){
		List <Desa> desas = desaRepository.findAll();
		return desas;
	}
		
	//INSERT DATA DESA
	@PostMapping("/insert/desa")
	public ResponseEntity<?> insertDesa(@RequestBody DesaDto desaDto){
		StatusMessageDto<?> desa = desaService.insertData(desaDto);
		return ResponseEntity.ok(desa);
	}
	
	//GET BY ID
	@GetMapping ("/desa/{id}")
	public ResponseEntity<?> getDesa (@PathVariable Integer id){
		Desa desa = desaRepository.findById(id).get();
		return ResponseEntity.ok(desa);
	}
	
	//UPDATE DATA DESA
	@PutMapping("/update/desa/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DesaDto dto){
		Desa desa = desaService.updateData(id, dto);
		return ResponseEntity.ok(desa);
	}
	
	//DELETE DATA DESA
//	@DeleteMapping("/delete/desa/{id}")
//	public ResponseEntity<?> delete(@PathVariable Integer id){
//		Desa desa = desaRepository.findById(id).get();
//		desaRepository.delete(desa);
//		
//		return ResponseEntity.ok(desa);
//	}
	
	//SOFT DELETE
		@DeleteMapping("/delete/desa/{id}")
		public ResponseEntity<?> delete(@PathVariable Integer id){
			Desa desa = desaService.softDelete(id);
			return ResponseEntity.ok(desa);
		}
	

}
