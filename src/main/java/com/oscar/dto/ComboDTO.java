/**
 * 
 */
package com.oscar.dto;

/**
 * @author 201905
 *
 */
public class ComboDTO {
	
	private Integer id;
	private String descripcion;
	
	
	public ComboDTO(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public ComboDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
