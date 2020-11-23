package com.oscar.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oscar.dao.CombosDAO;
import com.oscar.dao.impl.ComboDAOImple;
import com.oscar.dto.ComboDTO;

public class ComboUtils {
	public static void recuperacionComboMunicipios(HttpServletRequest request) {
		CombosDAO comboMunicipio = new ComboDAOImple();
		List<ComboDTO> listaMunicipios = comboMunicipio.ComboMunicipios();
		request.setAttribute("comboMunicipios", listaMunicipios);
	}

}
