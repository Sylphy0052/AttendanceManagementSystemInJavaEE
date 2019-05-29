package Session;

import DBModel.UserTB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UserInfo implements Serializable {
    private UserTB user;
    private boolean authenticated;
    
    public void login(UserTB user) {
        this.user = user;
        this.authenticated = true;
    }
    
    public void logout() {
        this.user = null;
        this.authenticated = false;
    }

    public UserTB getUser() {
        return user;
    }
}
