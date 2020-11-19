/**
 * 
 */
package com.oscar.dto;

/**
 * @author 201905
 *
 */
public class AlumnoDTO {
	
	private String nombre;
	private Integer id;
	private String municipio;
	
       
	
	public AlumnoDTO(String nombre, Integer id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public AlumnoDTO(String nombre, Integer id, String municipio) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.municipio = municipio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	
	
	
	
	

	
	
}
