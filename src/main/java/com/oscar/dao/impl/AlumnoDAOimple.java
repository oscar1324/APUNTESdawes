package com.oscar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oscar.dto.*;
import com.oscar.dao.AlumnoDAO;
import com.oscar.utils.DBUtils;
import com.oscar.dao.*;

public class AlumnoDAOimple implements AlumnoDAO {

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() {
		List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
		try {
			
			Connection connection = DBUtils.DBConnection();
			Statement st = connection.createStatement(); // es la query que se le envia a la BBDD, lo precompila y lo guarda
			ResultSet rs = st.executeQuery("SELECT * FROM ALUMNOS"); // Conuunto de resultados
			
			while(rs.next()){
				AlumnoDTO a = new AlumnoDTO( rs.getString(2),rs.getInt(1), "");
				listaAlumnos.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaAlumnos ;
	}


	@Override
	public List<AlumnoDTO> obtenerAlumnosporIdyNombre(String nombre, String id) {
		String sql = "SELECT * FROM alumnos WHERE id LIKE ? AND nombre LIKE ?";
		String sql2 = "SELECT a.id, a.nombre, m.nombre" 
		+ "from alumnos a, municipios"
		+ "where a.id_municipio = m.id_municipio"
		+ "AND id like ? AND a.nombre LIKE?";
		
		ResultSet alumnoResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			
			alumnoResultSet =  ps.executeQuery();
			
			
			while(alumnoResultSet.next()) {
				AlumnoDTO a = new AlumnoDTO (alumnoResultSet.getString(2), alumnoResultSet.getInt(1), alumnoResultSet.getString(3));
				listaAlumnos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAlumnos;
	}
	
	

}
