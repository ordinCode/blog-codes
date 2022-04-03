package ordincode;

import org.springframework.stereotype.Service;

@Service
public class MomService {
    public void callTheTeacher() {
        Teacher teacher = findTeacher();
        System.out.println(teacher.getTeacherPhone());
    }

    private Teacher findTeacher() {
        return new Teacher("teacherPhone");
    }
}
