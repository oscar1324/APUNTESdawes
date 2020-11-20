package com.oscar.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oscar.dao.AlumnoDAO;
import com.oscar.dao.CombosDAO;
import com.oscar.dao.impl.AlumnoDAOimple;
import com.oscar.dao.impl.ComboDAOImple;
import com.oscar.dto.ComboDTO;

/**
 * Servlet implementation class InsertarAlumnosController
 */

@WebServlet("/insertaralumno")
public class InsertarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAlumnosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
			recuperacionComboMunicipios(request);
			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/InsertarAlumnos.jsp");
			d.forward(request, response);


	}

	private void recuperacionComboMunicipios(HttpServletRequest request) {
		// 1- recuperar de la BBDD todos lo smunicipios y meterlos en un alista
		CombosDAO comboMunicipio = new ComboDAOImple();
		List<ComboDTO> listaMunicipios = comboMunicipio.ComboMunicipios();
		// 2- Pasar la lista a la vista
		request.setAttribute("comboMunicipios", listaMunicipios);
		// 3- Redirigir a la vista
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String claveMunicipio = request.getParameter("municipios");
		
		AlumnoDAO a = new AlumnoDAOimple(); // le pasamos los parametros para insertarlo
		
		Integer resultado = a.insertarAlumnos(id, nombre, claveMunicipio);
		
		request.setAttribute("resultado", resultado);
		recuperacionComboMunicipios(request);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/InsertarAlumnos.jsp");
		d.forward(request, response);
		
	}

}
