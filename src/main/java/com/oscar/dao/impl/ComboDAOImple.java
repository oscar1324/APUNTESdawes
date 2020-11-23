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

		String sql = "SELECT * FROM municipios";
		String sql1 = "SELECT * FROM municipios ORDER BY nombre";
		List<ComboDTO> listaMunicipios = new ArrayList<>();

		try {
			Connection connection = DBUtils.DBConnection();			 
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery();
			
			while (rs.next()) {				
				ComboDTO a = new ComboDTO(rs.getInt(1), rs.getString(5));
				listaMunicipios.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return listaMunicipios;
	}

		
}
