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

@WebServlet(urlPatterns={"/transaction"})
public class Transaction extends HttpServlet{
	private static final long serialVersionUID = 1L;
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

			con.setAutoCommit(false);

			PreparedStatement st=con.prepareStatement(
					"insert into register values(null,?,?)");
			st.setString(1,name);
			st.setString(2,course);
			st.executeUpdate();

			st.getConnection().prepareStatement(
					"select * from register where name=?");
			st.setString(1,name);
			ResultSet rs=st.executeQuery();
			int Line=0;
			while(rs.next()){
				Line++;

			}
			if(Line==1){
				con.commit();
				out.println("生徒を登録しました。");
			}else{
				con.rollback();
				out.println("すでに登録されています");
			}

			con.setAutoCommit(true);

			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}