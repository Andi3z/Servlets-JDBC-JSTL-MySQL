

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import testJobApp.phonedb.PhoneRecord;
import testJobApp.phonedb.PhoneRecordDb;


@WebServlet("/")
public class IndexServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<PhoneRecord> records = PhoneRecordDb.select();
        request.setAttribute("records", records);
          
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	

}
