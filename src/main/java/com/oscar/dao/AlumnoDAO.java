/**
 * 
 */
package com.oscar.dao;

import java.util.List;

import com.oscar.dto.*;


/**
 * @author 201905
 *
 */

public interface AlumnoDAO {
		List <AlumnoDTO> obtenerTodosAlumnos();
		
		List<AlumnoDTO> obtenerAlumnosporIdyNombre(String nombre, String id);
		
		Integer insertarAlumnos(String id, String nombre, String claveMunicipio);
}

