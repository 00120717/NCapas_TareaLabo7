package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name = "id_estudiante")
	@GeneratedValue(generator = "estudiante_id_estudiante_seq",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "estudiante_id_estudiante_seq",sequenceName = "public.estudiante_id_estudiante_seq",allocationSize = 1)
	private Integer idEstudiante;
	
	@Column(name="nombre")
	@Size(min=1,max = 50,message = "Este campo debe tener entre 1 y 50 caracteres")	
	@NotEmpty(message = "Este campo no debe estar vacio")
	private String nombre;
	
	@Column(name="apellido")
	@Size(min=1,max = 50,message = "Este campo debe tener entre 1 y 50 caracteres")
	@NotEmpty(message = "Este campo no debe estar vacio")
	private String apellido;
	
	@Column(name = "edad")
	@NotNull(message = "Este campo no debe estar vacio")
	private Integer edad;
	
	@Column(name = "estado")
	private Boolean estado;
	
	
	public Estudiante() {}

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		nombre = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String lastname) {
		apellido = lastname;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer age) {
		edad = age;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean Estado) {
		estado = Estado;
	}
	
	public String getDelegateEstado() {
		return estado? "Activo":"Inactivo";
	}
}
