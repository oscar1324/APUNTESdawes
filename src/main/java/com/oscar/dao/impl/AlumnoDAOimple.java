package com.oscar.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oscar.Alumno.AlumnoDTO;
import com.oscar.dao.AlumnoDAO;
import com.oscar.utils.DBUtils;

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

}
