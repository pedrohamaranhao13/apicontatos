package br.com.phamtecnologia.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.phamtecnologia.entities.Contato;
import br.com.phamtecnologia.factories.ConnectionFactory;

public class ContatoRepository {
	
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	
	public void insert(Contato contato) {
		try {
			
			var connection = connectionFactory.getConnection();
			
			var sql = 	"""
							insert into contato(id, nome, telefone, email)
							values(?, ?, ?, ?)
						""";
			var statement = connection.prepareStatement(sql);
			statement.setObject(1, contato.getId());
			statement.setString(2, contato.getNome());
			statement.setString(3, contato.getTelefone());
			statement.setString(4, contato.getEmail());
			statement.execute();
			
			connection.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean update(Contato contato) {
		
		try {
			
			var connection = connectionFactory.getConnection();
			
			var sql = 	"""
							update contato set 
								nome = ?,
								telefone = ?,
								email = ?
							where id = ?
						""";
			
			var statement = connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getTelefone());
			statement.setString(3, contato.getEmail());
			statement.setObject(4, contato.getId());
			var rowsAffected = statement.executeUpdate();
			
			connection.close();
			
			return rowsAffected > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(UUID id) {
		try {
			
			var connection = connectionFactory.getConnection();
			
			var sql = 	"""
							delete from contato 
							where id = ?
						""";
			
			var statement = connection.prepareStatement(sql);
			statement.setObject(1, id);
			var rowsAffected = statement.executeUpdate();
			
			connection.close();
			
			return rowsAffected > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Contato> findAll() {
		
		try {
			
			var connection = connectionFactory.getConnection();
			
			var sql = 	"""
							select * from contato
						""";
			
			var statement = connection.prepareStatement(sql);
			var result = statement.executeQuery();
			
			var lista = new ArrayList<Contato>();
			
			while(result.next()) {
				
				var contato = new Contato();
				
				contato.setId(UUID.fromString(result.getString("id")));
				contato.setNome(result.getString("nome"));
				contato.setTelefone(result.getString("telefone"));
				contato.setEmail(result.getString("email"));
				
				lista.add(contato);
			}
			
			connection.close();
			
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
