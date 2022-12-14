package com.generation.solarenergy.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Table(name = "tb_usuarios")
public class UsuarioModels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo Nome é Obrigatório!")
	@Size(max = 255)
	private String nome;
	
	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O Atributo email é Obrigatório!")
	@Email( message = "O Atributo Usuário deve ser um email válido!")
	private String usuario;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	private String foto;
	
	@NotBlank(message = "O Atributo Senha é Obrigatório!")
	@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
	private String senha;

	@NotBlank(message = "O Atributo CPF é Obrigatório!")
	@Size(min = 8, message = "O CPF deve conter 15 caracteres")
	private String cpf;
	
	@NotBlank(message = "O Atributo endereço é Obrigatório!")
	private String endereco;
	
	@OneToMany(mappedBy ="usuario", cascade = CascadeType.ALL )
	@JsonIgnoreProperties("produto")
	private List<ProdutoModels> produto;
	
	public UsuarioModels(Long id, String nome, String usuario,String senha, String foto, String cpf, String endereco) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	public UsuarioModels() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<ProdutoModels> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModels> produto) {
		this.produto = produto;
	} 
	

	
}
