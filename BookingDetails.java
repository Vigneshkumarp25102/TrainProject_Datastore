import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

@WebServlet(name = "trainBookingDetails", urlPatterns = { "/train/booking/details" })
public class BookingDetails extends HttpServlet {

   private static final long serialVersionUID = 1L;

   @Override
   public void init() throws ServletException {
       super.init();
       ObjectifyConfig.init();
       }
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      ObjectifyService.begin();
		int param = Integer.parseInt(request.getParameter("id"));
		Long id = Long.valueOf(param);
      List<Booking> bookingList = ObjectifyService.ofy().load().type(Booking.class).list();
		for (Booking book : bookingList) {
			if (book.getId().equals(id)) {
				request.setAttribute("bookDetails", book);
				request.getRequestDispatcher("/BookingDetails.jsp").forward(request, response);
			}
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('bbbb Successfully');");
		out.println("</script>");
   }
}
