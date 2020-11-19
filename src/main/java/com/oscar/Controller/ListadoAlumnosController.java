package com.oscar.Controller;

import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;


import com.mysql.cj.protocol.Resultset;
import com.oscar.dao.impl.*;

import com.oscar.dto.*;
import com.oscar.dao.AlumnoDAO;
import com.oscar.dao.impl.AlumnoDAOimple;
import com.oscar.dto.AlumnoDTO;
import com.oscar.utils.*;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/listadoAlumnos") //al poner la barra significa que al entrar en la aplicación se va aa ejecutar
public class ListadoAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(ListadoAlumnosController.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoAlumnosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se hace fuera por el alcance maximo de las variables dentro del try-catch

			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/listadoAlumnos.jsp");
			d.forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		
		AlumnoDAO a = new AlumnoDAOimple();
		List<AlumnoDTO> listaAlumnos; // ojo new ArrrayLis<>();
		
		listaAlumnos = a.obtenerAlumnosporIdyNombre(nombre, id);

			request.setAttribute("lista", listaAlumnos);
	}
}
