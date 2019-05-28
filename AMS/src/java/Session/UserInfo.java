package Session;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UserInfo implements Serializable {
    private String name;
    private boolean authenticated;
    
    public void login(String name) {
        this.name = name;
        this.authenticated = true;
    }
    
    public void logout() {
        this.name = null;
        this.authenticated = false;
    }

    public String getName() {
        return name;
    }
}
