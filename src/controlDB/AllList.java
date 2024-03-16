package controlDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Register;
import dao.RegisterDAO;

@WebServlet(urlPatterns={"/alllist"})
public class AllList extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(
			HttpServletRequest request,HttpServletResponse response
			)throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		try{
			RegisterDAO dao=new RegisterDAO();
			List<Register> list=dao.search("");

			request.setAttribute("list",list);

			request.getRequestDispatcher("allList.jsp")
					.forward(request,response);
		}catch(Exception e){
			e.printStackTrace(out);
		}
	}
}