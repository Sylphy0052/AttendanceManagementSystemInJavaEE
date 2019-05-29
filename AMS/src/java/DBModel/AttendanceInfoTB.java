package DBModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class AttendanceInfoTB implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="info_id")
    private int infoId;
    
    @Column(name="date_info")
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInfo;
    @Column(name="workin_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date workinTime;
    @Column(name="workout_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date workoutTime;
    @Column(name="break_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date breakTime;
    @Column(name="holiday_work_time")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date holidayWorkTime;
    private String memo;
    @Column(name="attend_type")
    @OneToOne(cascade={CascadeType.DETACH})
    private AttendanceTypeTB workinType;
    @OneToOne(cascade={CascadeType.DETACH})
    private AttendanceTypeTB workoutType;
    @OneToOne(cascade={CascadeType.DETACH})
    private AttendanceTypeTB holidayType;
    @OneToOne(cascade={CascadeType.DETACH})
    private ApprovalTB approval;

    public AttendanceInfoTB() {}

    public AttendanceInfoTB(Date dateInfo) {
        this.dateInfo = dateInfo;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public Date getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(Date dateInfo) {
        this.dateInfo = dateInfo;
    }

    public Date getWorkinTime() {
        return workinTime;
    }

    public void setWorkinTime(Date workinTime) {
        this.workinTime = workinTime;
    }

    public Date getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(Date workoutTime) {
        this.workoutTime = workoutTime;
    }

    public Date getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Date breakTime) {
        this.breakTime = breakTime;
    }

    public Date getHolidayWorkTime() {
        return holidayWorkTime;
    }

    public void setHolidayWorkTime(Date holidayWorkTime) {
        this.holidayWorkTime = holidayWorkTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public AttendanceTypeTB getWorkinType() {
        return workinType;
    }

    public void setWorkinType(AttendanceTypeTB workinType) {
        this.workinType = workinType;
    }

    public AttendanceTypeTB getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(AttendanceTypeTB workoutType) {
        this.workoutType = workoutType;
    }

    public AttendanceTypeTB getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(AttendanceTypeTB holidayType) {
        this.holidayType = holidayType;
    }

    public ApprovalTB getApproval() {
        return approval;
    }

    public void setApproval(ApprovalTB approval) {
        this.approval = approval;
    }

    
}
