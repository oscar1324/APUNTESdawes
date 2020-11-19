/**
 * 
 */
package com.oscar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oscar.dto.*;
import com.oscar.dao.CombosDAO;
import com.oscar.dto.ComboDTO;
import com.oscar.utils.DBUtils;

/**
 * @author 201905
 *
 */
public class ComboDAOImple implements CombosDAO {

	@Override
	public List<ComboDTO> ComboMunicipios() {


		
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
		return null;
	}
		
}
