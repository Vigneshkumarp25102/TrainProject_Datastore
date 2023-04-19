import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@WebServlet(name = "traindelete", urlPatterns = { "/train/delete" })
public class DeleteTrainDetails extends HttpServlet {
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
		String param = request.getParameter("id");
		Long id = Long.parseLong(param);

		Objectify ofy = ObjectifyService.ofy();
		List<Train> trainList = ObjectifyService.ofy().load().type(Train.class).list();
		for (Train train : trainList) {
			if (train.getId().equals(id)) {
				ofy.delete().entity(train).now();
			}
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Deletd Successfully');");
		out.println("</script>");
	}
}
