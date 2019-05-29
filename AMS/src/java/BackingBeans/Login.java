package BackingBeans;

import Controller.DBController;
import DBModel.UserTB;
import Session.UserInfo;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

@Named(value="login")
@RequestScoped
public class Login {
    private String name;
    private String pass;
    
    private String message;
    
    @Inject
    private UserInfo userInfo;
    
    @EJB
    private DBController udbc;
    
    @PostConstruct
    public void init() {
        initAuthority();
        initApproval();
        initAttendanceType();
        initUser();
    }
    
    private void initAuthority() {
        
    }
    
    private void initApproval() {
        
    }
    
    private void initAttendanceType() {
        
    }
    
    private void initUser() {
        
    }
    
    private boolean checkLogin() {
        try {
        UserTB user = udbc.getUser(name, pass);
        this.userInfo.login(user);
        } catch(NoResultException nre) {
            return false;
        }
        return true;
    }
    
    public String login() {
        if(checkLogin()) {
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
