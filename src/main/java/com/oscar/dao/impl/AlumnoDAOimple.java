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
		String sql2 = "SELECT a.id, a.nombre, m.nombre, m.id_municipio" 
		+ "from alumnos a, municipios m"
		+ "where a.id_municipio = m.id_municipio"
		+ "AND id like ? AND a.nombre LIKE?";
		
		ResultSet alumnoResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(sql);
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
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		
		return listaAlumnos;
	}


	@Override
	public Integer insertarAlumnos(String id, String nombre, String claveMunicipio) {
		String sql = "INSERT INTO alumnos (ID,NOMBRE,ID_MUNICIPIO) VALUES (?,?,?)";
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, claveMunicipio);
			
			 resultado = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return 0;
	}
	
	
	

	@Override
	public Integer actualizarAlumno(String idOld,String idNew, String nombre, String claveMunicipio) {
		String sql = "UPDATE alumnos SET id= ?, nombre= ?, id_municipio= ? WHERE id = ?";
		
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, claveMunicipio);
			ps.setString(4, idOld);
			
			 resultado = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return 0;
	}
	 
	
	

}
