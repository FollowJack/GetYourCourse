package Services

import Courses.Course
import Courses.Participant
import Person.Person
import Person.PersonAuthority

class CourseService {

    def registerParticipantForCourse(int personId, int courseId) {

        //check if user and course exist
        if (!personId || !courseId)
            throw new Exception("personId or courseId is null")

        def person = Person.findById(personId)
        def course = Course.findById(courseId)

        if (!person || !course)
            throw new Exception("personId or courseId does not exist")

        //check if user already registered
        def registeredUser = Participant.findWhere(courseId: courseId,userId: personId);
        if(registeredUser)
            throw new Exception("participant already registered")

        //create new participant
        def participant = new Participant(userId: personId,courseId: courseId, registeredDate: new Date()).save(flush: true, failOnError: true)
        //add participant to course
        course.registeredMembers.add(participant)

        course.save(flush: true, failOnError: true)

        def emailService = new EmailService()
        String emailAddress = person.emailAddress
        String subject
        String bodyText

        //if course is full
        if(course.registeredMembers.size() >= course.maxParticipantAmount){
            subject = "You are registered! Bla bla"
            bodyText = "Unfortunately you are on the waiting list."
        } else{ //registered
            subject = "You are registered! Bla bla"
            bodyText = "In your next email you will get detailed information about your course."
        }
        emailService.sendMail(emailAddress,subject,bodyText)
    }
}
