package com.oscar.Controller;

import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;


import com.mysql.cj.protocol.Resultset;


import com.oscar.Alumno.*;

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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // sirve para cargar
			String dURL = "jdbc:mysql://localhost:3306/colegio";
			String username = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(dURL,username,password) ;
			
			Statement st = connection.createStatement(); // es la query que se le envia a la BBDD, lo precompila y lo guarda
			ResultSet rs = st.executeQuery("SELECT * FROM ALUMNOS"); // Conuunto de resultados
			
			while(rs.next()){
				AlumnoDTO a = new AlumnoDTO( rs.getString(2),rs.getInt(1), "");
				
			}
	
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
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
