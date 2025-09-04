package br.com.phamtecnologia.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phamtecnologia.dtos.ContatoPostRequest;
import br.com.phamtecnologia.entities.Contato;
import br.com.phamtecnologia.repositories.ContatoRepository;

@RestController
@RequestMapping("/api/v1/contatos")
public class ContatoController {
	
	private ContatoRepository contatoRepository = new ContatoRepository();

	@PostMapping
	public ResponseEntity<?> post(@RequestBody ContatoPostRequest request) {
		
		var contato = new Contato();
		contato.setId(UUID.randomUUID());
		contato.setNome(request.getNome());
		contato.setTelefone(request.getTelefone());
		contato.setEmail(request.getEmail());
		
		contatoRepository.insert(contato);
		
		return ResponseEntity.ok("Contato cadastrado com sucesso!");
	}
	
	@PutMapping 
	public ResponseEntity<?> put() {
		//TODO 
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete() {
		//TODO
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {

		try {
			
			var lista = contatoRepository.findAll();
			
			return ResponseEntity.status(200).body(lista);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		
	}
}
