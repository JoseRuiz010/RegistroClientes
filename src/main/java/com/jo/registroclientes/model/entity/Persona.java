package com.jo.registroclientes.model.entity;

import org.hibernate.validator.constraints.UniqueElements;

 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass 
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String lastName;
	private String phone;
	private String address;
	@NotBlank
	@UniqueElements
	private String email;
	public Persona(@NotBlank String name, @NotBlank String lastName, String phone, String address,
			@NotBlank @UniqueElements String email) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
	
	
}
