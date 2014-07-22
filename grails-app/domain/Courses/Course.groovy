package Courses

import grails.plugins.springsecurity.Secured

@Secured(['User','Admin'])
class Course {

    Integer id
    String name
    String description
    boolean isPaymentNeeded
    Integer maxParticipantAmount

    static hasMany = [registeredMembers: Participant]

    static constraints = {
        name blank: false, unique: true
    }
}
