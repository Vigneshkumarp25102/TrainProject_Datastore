import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

@WebServlet(name = "trainBook", urlPatterns = { "/train/book" })
public class BookTrain extends HttpServlet {

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
		ObjectifyService.begin();
		List<Train> trainList = ObjectifyService.ofy().load().type(Train.class).list();
		for (Train train : trainList) {
			if (train.getId().equals(id)) {
				request.setAttribute("trainDetail", train);
				request.getRequestDispatcher("/BookTrain.jsp").forward(request, response);
			}
		}

	}
}
