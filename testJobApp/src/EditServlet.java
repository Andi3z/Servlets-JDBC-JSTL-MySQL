

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import testJobApp.phonedb.PhoneRecord;
import testJobApp.phonedb.PhoneRecordDb;


@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            PhoneRecord record = PhoneRecordDb.selectOne(id);
            if(record!=null) {
                request.setAttribute("record", record);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
        catch(Exception e) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String note = request.getParameter("note");
            PhoneRecord record = new PhoneRecord(id, name, phone, note);
            PhoneRecordDb.update(record);
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception e) {
             
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);   
        }
	}

}
