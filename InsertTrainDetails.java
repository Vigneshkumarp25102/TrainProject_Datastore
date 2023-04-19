import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.googlecode.objectify.ObjectifyService;

@WebServlet(name = "InsertTrainDetails", urlPatterns = { "/insert/train" })
public class InsertTrainDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	 @Override
	    public void init() throws ServletException {
	        super.init();
	        ObjectifyConfig.init();
	    }

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		try {
		JSONObject json = new JSONObject(sb.toString());
		String trainNo = json.getString("trainNo");
		String trainName = json.getString("trainName");
		int trainSeats = json.getInt("trainSeats");
		UUID uuid = UUID.randomUUID();
		Long uniq = (long) uuid.hashCode();
		ObjectifyService.begin();
		Train train = new Train(uniq,trainNo, trainName, trainSeats);
		ObjectifyService.ofy().save().entity(train).now();
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Train details added successfully");
	}

}
