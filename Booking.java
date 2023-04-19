
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Booking {
    @Id
    private Long id;
	private String bookingId;
    private String trainNo;
    private String trainName;
    private String passengerName;
	private int passesngerAge;
    private int passesngerSeats;
    
    public Booking() {}
    
    public Booking(Long id, String bookingId, String trainNo, String trainName, String passengerName, int passesngerAge,
			int passesngerSeats) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.passengerName = passengerName;
		this.passesngerAge = passesngerAge;
		this.passesngerSeats = passesngerSeats;
	}
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassesngerAge() {
		return passesngerAge;
	}
	public void setPassesngerAge(int passesngerAge) {
		this.passesngerAge = passesngerAge;
	}
	public int getPassesngerSeats() {
		return passesngerSeats;
	}
	public void setPassesngerSeats(int passesngerSeats) {
		this.passesngerSeats = passesngerSeats;
	}
	
}
