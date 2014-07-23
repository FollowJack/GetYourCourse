package Courses
import Person.Person
import Services.CourseService
import org.springframework.security.access.annotation.Secured

class CourseRegisterController {

    CourseService _courseService
    def springSecurityService

    public CourseRegisterController() {
        _courseService = new CourseService()
    }

    def index() {
        redirect(action: "list", params: params)
    }

    @Secured(['User', 'Admin'])
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [courseInstanceList: Course.list(params), courseInstanceTotal: Course.count()]
    }

    def register(Integer courseId) {
        if (!courseId)
            redirect(action: "list", params: params)

        //def currentUser = springSecurityService.currentUser.id
        int userId = session.SPRING_SECURITY_CONTEXT.authentication.principal.id

        try {
            _courseService.registerParticipantForCourse(userId, courseId)
        } catch (Exception e) {
            println e
            //ToDO add error
        }
        redirect(action: "list", params: params)
        return;
    }
}
