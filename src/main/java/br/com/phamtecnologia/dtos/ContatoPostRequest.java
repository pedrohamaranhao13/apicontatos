package br.com.phamtecnologia.dtos;

import lombok.Data;

@Data
public class ContatoPostRequest {
	
	private String nome;
	private String telefone;
	private String email;

}
