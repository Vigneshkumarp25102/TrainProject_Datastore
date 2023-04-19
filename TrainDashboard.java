import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

@WebServlet(name = "trainDashboard", urlPatterns = { "/train/dashboard" })
public class TrainDashboard extends HttpServlet {

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
      List<Train> trainList = ObjectifyService.ofy().load().type(Train.class).list();
      request.setAttribute("trainList", trainList);
      request.getRequestDispatcher("/TrainDashboard.jsp").forward(request, response);
   }
}
