package Courses

import Person.Person

class CourseParticipant implements Serializable {

    Course courseRegisteredMembers
    Participant participant

    static constraints = {
    }

    static mapping = {
        id composite: ['courseRegisteredMembers','participant']
        version false
    }
}
