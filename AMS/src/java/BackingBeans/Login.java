package BackingBeans;

import Session.UserInfo;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="login")
@RequestScoped
public class Login {
    private String name;
    private String pass;
    
    private String message;
    
    @Inject
    private UserInfo userInfo;
    
    public Login() {}
    
    private boolean checkLogin() {
        if(name.equals("test") && pass.equals("test")) {
            return true;
        }
        return false;
    }
    
    public String login() {
        if(checkLogin()) {
            this.userInfo.login(name);
            return "attendance_list";
        }
        message = "名前かパスワードが間違ってます.";
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
