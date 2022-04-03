package ordincode;

import java.util.List;

public class Teacher {
    private String teacherPhone;
    private Student students;

    public Teacher(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }
}
