package com.jo.registroclientes.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority",
			 joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
					 inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
			 )

	private List<Authority> authorities;
	public Usuario(String username, String password, Persona persona) {
		this.username = username;
		this.password = password;
		this.persona = persona;
	}

	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Usuario(String username, String password, List<Authority> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
}
