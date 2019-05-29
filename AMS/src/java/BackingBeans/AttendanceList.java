package BackingBeans;

import DBModel.AttendanceInfoTB;
import Session.UserInfo;
import Viewer.ViewData;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="attendanceList")
@RequestScoped
public class AttendanceList {
    private String name;
    
    private ArrayList<ViewData> viewList;
    
    @Inject
    private UserInfo userInfo;
    
    public AttendanceList() {}
    
    @PostConstruct
    public void init() {
        this.name = userInfo.getUser().getUserName();
        viewList = new ArrayList<>();
        createViewList();
    }
    
    private void createViewList() {
        // 年月を指定する
        userInfo.getUser().getAttendanceInfoList().forEach((ai) -> {
            viewList.add(new ViewData(ai));
        });
    }
    
    public String toUpdate(ViewData view) {
        return null;
    }

    public String getName() {
        return name;
    }   
    
    public List<ViewData> getViewList() {
        return viewList;
    }
}
