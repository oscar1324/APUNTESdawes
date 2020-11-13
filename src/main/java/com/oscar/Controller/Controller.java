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


import com.oscar.Alumno.*;
import com.oscar.utils.*;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/inicio") //al poner la barra significa que al entrar en la aplicación se va aa ejecutar
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(Controller.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se hace fuera por el alcance maximo de las variables dentro del try-catch
		
		List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
		
		try {
			Connection connection = DBUtils.DBConnection();
			Statement st = connection.createStatement(); // es la query que se le envia a la BBDD, lo precompila y lo guarda
			ResultSet rs = st.executeQuery("SELECT * FROM ALUMNOS"); // Conuunto de resultados
			
			while(rs.next()){
				AlumnoDTO a = new AlumnoDTO( rs.getString(2),rs.getInt(1), "");
				listaAlumnos.add(a);
			}
			
			request.setAttribute("lista", listaAlumnos);
			RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/listadoAlumnos.jsp");
			d.forward(request, response);
	
		} catch (SQLException  e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
