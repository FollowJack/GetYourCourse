package Courses

class Course {

    Integer id
    String name
    String description
    boolean isPaymentNeeded
    Integer maxParticipantAmount

    static hasMany = [registeredMembers: Participant]

    static constraints = {
        name size: 5..50, blank: false, unique: true
    }
}
