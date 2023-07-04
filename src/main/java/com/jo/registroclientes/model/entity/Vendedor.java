package com.jo.registroclientes.model.entity;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vendedor extends Persona{

	private String legajo;

	public Vendedor(@NotBlank String name, @NotBlank String lastName, String phone, String address,
			@NotBlank @UniqueElements String email) {
		super(name, lastName, phone, address, email);
		// TODO Auto-generated constructor stub
	}	
}
