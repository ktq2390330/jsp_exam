package controlDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/all"})
public class All extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(
		HttpServletRequest request,HttpServletResponse response
		)throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		Page.header(out);
		try{
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
					"java:/comp/env/jdbc/kouka2");
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
					"select * from register");
			ResultSet rs=st.executeQuery();

			while(rs.next()){
				out.println(rs.getInt("id"));
				out.println(":");
				out.println(rs.getString("name"));
				out.println(":");
				out.println(rs.getString("course"));
				out.println("<br>");
			}

			st.close();
			con.close();

		}catch(Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}