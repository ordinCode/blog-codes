package ordincode;

import org.springframework.stereotype.Service;

@Service
public class MomService {
    private final SchoolWebsite schoolWebsite;

    public MomService(SchoolWebsite schoolWebsite) {
        this.schoolWebsite = schoolWebsite;
    }

    public void callTheTeacher() {
        System.out.println(schoolWebsite.findTeacherPhone());
    }
}
