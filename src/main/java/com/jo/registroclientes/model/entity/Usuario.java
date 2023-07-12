package com.jo.registroclientes.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	private Persona persona;

	public Usuario(String username, String password, Persona persona) {
		this.username = username;
		this.password = password;
		this.persona = persona;
	}

	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
