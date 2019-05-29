package Viewer;

import DBModel.AttendanceInfoTB;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class ViewData {
    private String day;
    private String week;
    private String workin;
    private String workout;
    private String holiday;
    private String workinTime;
    private String workoutTime;
    private String breakout;
    private String working;
    private String overtime;
    private String holidayTime;
    private String memo;
    
    public ViewData(AttendanceInfoTB ai) {
        this.day = new SimpleDateFormat("dd").format(ai.getDateInfo());
        this.week = calcWeekoftheDay(ai.getDateInfo());
        this.workin = ai.getWorkinType().getTypeName();
        this.workout = ai.getWorkoutType().getTypeName();
        this.holiday = ai.getHolidayType().getTypeName();
        
        if(Objects.isNull(ai.getWorkinTime())) {
            this.workinTime = "";
        } else {
            this.workinTime = Utils.Util.convertDateToStringHm(ai.getWorkinTime());
        }
        
        if(Objects.isNull(ai.getWorkoutTime())) {
            this.workoutTime = "";
        } else {
            this.workoutTime = Utils.Util.convertDateToStringHm(ai.getWorkoutTime());
        }
        
        if(Objects.isNull(ai.getBreakTime())) {
            this.breakout = "";
        } else {
            this.breakout = Utils.Util.convertDateToStringHm(ai.getBreakTime());
        }
        
        if(!Objects.isNull(ai.getWorkinTime()) && !Objects.isNull(ai.getWorkoutTime())) {
            calcWorkingTime(ai);
        } else {
            this.working = "";
            this.overtime = "";
            this.holidayTime = "";
        }
        
        this.memo = ai.getMemo();
    }
    
    private void calcWorkingTime(AttendanceInfoTB ai) {
        Calendar workinCalendar = Calendar.getInstance();
        Calendar workoutCalendar = Calendar.getInstance();
        workinCalendar.setTime(ai.getWorkinTime());
        workoutCalendar.setTime(ai.getWorkoutTime());
        Calendar c1 = Calendar.getInstance();
        c1.setTime(ai.getWorkoutTime());
        c1.add(Calendar.HOUR, -9);
        this.working = Utils.Util.convertDateToStringHm(c1.getTime());
        this.overtime
    }
    
    private String calcWeekoftheDay(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        switch(c.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                return "日";
            case Calendar.MONDAY:
                return "月";
            case Calendar.TUESDAY:
                return "火";
            case Calendar.WEDNESDAY:
                return "水";
            case Calendar.THURSDAY:
                return "木";
            case Calendar.FRIDAY:
                return "金";
            case Calendar.SATURDAY:
                return "土";
        }
        return null;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWorkin() {
        return workin;
    }

    public void setWorkin(String workin) {
        this.workin = workin;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getWorkinTime() {
        return workinTime;
    }

    public void setWorkinTime(String workinTime) {
        this.workinTime = workinTime;
    }

    public String getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(String workoutTime) {
        this.workoutTime = workoutTime;
    }

    public String getBreakout() {
        return breakout;
    }

    public void setBreakout(String breakout) {
        this.breakout = breakout;
    }

    public String getWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getHolidayTime() {
        return holidayTime;
    }

    public void setHolidayTime(String holidayTime) {
        this.holidayTime = holidayTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
