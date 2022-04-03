package ordincode;

import org.springframework.stereotype.Component;

@Component
public class AceSchoolWebSite implements SchoolWebsite {

    @Override
    public String findTeacherPhone() {
        Teacher teacher = findTeacher();
        return teacher.getTeacherPhone();
    }

    private Teacher findTeacher() {
        return new Teacher("teacherPhone");
    }
}
