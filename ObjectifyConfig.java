import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class ObjectifyConfig {
    public static void init() {
        ObjectifyService.init();
        ObjectifyService.register(Train.class);
        ObjectifyService.register(Booking.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
