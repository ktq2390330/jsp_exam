package controlDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Register;
import dao.RegisterDAO;

@WebServlet("/insert")
public class Insert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String course = request.getParameter("course");

            Register register = new Register();
            register.setName(name);
            register.setCourse(course);

            RegisterDAO dao = new RegisterDAO();
            int line = dao.insert(register);

            if (line > 0) {
                request.setAttribute("result", "登録されました");
            } else {
                request.setAttribute("result", "登録できませんでした");
            }
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("データベースへの登録中にエラーが発生しました。", e);
        }
    }
}
