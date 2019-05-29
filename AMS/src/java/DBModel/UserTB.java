package DBModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserTB implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    @Column(name="login_name")
    private String loginName;
    private String pass;
    @Column(name="user_name")
    private String userName;
    @OneToOne(cascade={CascadeType.DETACH})
    private AuthorityTB authority;
    @Column(name="attendance_info")
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<AttendanceInfoTB> attendanceInfoList = new ArrayList<>();
    
    public UserTB() {}

    public UserTB(String loginName, String pass, String userName, AuthorityTB authority) {
        this.loginName = loginName;
        this.pass = pass;
        this.userName = userName;
        this.authority = authority;
    }
    
    public void addAttendanceInfo(AttendanceInfoTB attendanceInfo) {
        this.attendanceInfoList.add(attendanceInfo);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AuthorityTB getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityTB authority) {
        this.authority = authority;
    }

    public List<AttendanceInfoTB> getAttendanceInfoList() {
        return attendanceInfoList;
    }

    public void setAttendanceInfoList(List<AttendanceInfoTB> attendanceInfoList) {
        this.attendanceInfoList = attendanceInfoList;
    }
}
