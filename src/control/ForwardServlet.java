package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("all".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("all.jsp");
            dispatcher.forward(request, response);
        } else if ("insert".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("insert.jsp");
            dispatcher.forward(request, response);
        } else if("search".equals(action)) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        }else if("delete".equals(action)) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
            dispatcher.forward(request, response);
        }
    }
}
