

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import testJobApp.phonedb.PhoneRecord;
import testJobApp.phonedb.PhoneRecordDb;


@WebServlet("/create_record")
public class CreateServlet extends HttpServlet {	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/create_record.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            String name = request.getParameter("name");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String note = request.getParameter("note");
            PhoneRecord record = new PhoneRecord(name, phone, note);
            PhoneRecordDb.insert(record);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception e) {
             
            getServletContext().getRequestDispatcher("/create_record.jsp").forward(request, response); 
        }
	}

}
