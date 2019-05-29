package BackingBeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="header")
@RequestScoped
public class Header {
    public String toAttendanceList() {
        return null;
    }
    
    public String toWorkin() {
        return null;
    }
    
    public String toWorkout() {
        return null;
    }
    
    public String toHolidayApplication() {
        return null;
    }
}
