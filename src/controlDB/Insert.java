package controlDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/controlDB/insert"})
public class Insert extends HttpServlet{
	public void doPost(
			HttpServletRequest request,HttpServletResponse response
			)throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		Page.header(out);
		try{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
					"java:/comp/env/jdbc/kouka2");
			Connection con=ds.getConnection();
			String name=request.getParameter("name");
			String course=request.getParameter("course");
			PreparedStatement st=con.prepareStatement(
					"insert into register values(null,?,?)");
			st.setString(1,name);
			st.setString(2,course);
		}catch(Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}