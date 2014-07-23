package Courses

import grails.plugins.springsecurity.Secured

class Participant {

    Integer id
    Integer userId
    Integer courseId
    boolean hasPayed
    Date registeredDate

    static constraints = {
        id blank: false, unique: true
        userId blank: false
        courseId blank: false
    }

}
