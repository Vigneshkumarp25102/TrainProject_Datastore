
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Train {
    @Id
    private Long id;
    private String trainNo;
    private String trainName;
    private int trainSeats;

    public Train() {}
    
    public Train(Long id,String trainNo, String trainName, int trainSeats) {
    	this.id=id;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.trainSeats = trainSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTrainSeats() {
        return trainSeats;
    }

    public void setTrainSeats(int trainSeats) {
        this.trainSeats = trainSeats;
    }
}
