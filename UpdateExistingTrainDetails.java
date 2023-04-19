import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@WebServlet(name = "UpdateExistingTrainDetails", urlPatterns = { "/train/update/details" })
public class UpdateExistingTrainDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		ObjectifyConfig.init();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String trainNo = request.getParameter("trainNo");
		String trainName = request.getParameter("trainName");
		int trainSeats = Integer.parseInt(request.getParameter("trainSeats"));
		String param = request.getParameter("id");
		Long id = Long.parseLong(param);
		ObjectifyService.begin();
		Objectify ofy = ObjectifyService.ofy();
		Train existingTrain = ofy.load().type(Train.class).id(id).now();
		if (existingTrain != null) {
			existingTrain.setTrainNo(trainNo);
			existingTrain.setTrainName(trainName);
			existingTrain.setTrainSeats(trainSeats);
			ofy.save().entity(existingTrain).now();
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Update Successfully');");
		out.println("</script>");

	}

}
