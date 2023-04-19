import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@WebServlet(name = "PassengerBooking", urlPatterns = { "/train/passenger/booking" })
public class PassengerBooking extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		ObjectifyConfig.init();
	}

	int no = 100;
	String bookingId = "BKTRN";

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
			String param = json.getString("trainId");
			Long id = Long.parseLong(param);
			String trainNo = json.getString("trainNo");
			String trainName = json.getString("trainName");
			String passengerName = json.getString("passengerName");
			int passesngerAge = json.getInt("passesngerAge");
			int passengerSeats = json.getInt("passengerSeats");
			UUID uuid = UUID.randomUUID();
			Long uniq = (long) uuid.hashCode();
			ObjectifyService.begin();
			Objectify ofy = ObjectifyService.ofy();

			Train existingTrain = ofy.load().type(Train.class).id(id).now();
			if (existingTrain != null) {
				existingTrain.setTrainSeats(existingTrain.getTrainSeats() - passengerSeats);
				ofy.save().entity(existingTrain).now();
			}
			String bookId = bookingId + no++;
			Booking booking = new Booking(uniq, bookId , trainNo, trainName, passengerName, passesngerAge,
					passengerSeats);
			ofy.save().entity(booking).now();
			request.setAttribute("bookDetails", booking);
			request.getRequestDispatcher("/BookingDetails.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Booking details added successfully");
	}

}
