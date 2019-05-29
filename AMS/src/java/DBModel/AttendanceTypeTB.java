package DBModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AttendanceTypeTB implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="type_id")
    private int typeId;
    
    @Column(name="type_name")
    private String typeName;
    
    @Column(name="attend_type")
    private int attendType;
    
    public AttendanceTypeTB() {}

    public AttendanceTypeTB(String typeName, int attendType) {
        this.typeName = typeName;
        this.attendType = attendType;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getAttendType() {
        return attendType;
    }

    public void setAttendType(int attendType) {
        this.attendType = attendType;
    }
}
