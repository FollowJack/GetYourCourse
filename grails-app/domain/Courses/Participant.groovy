package Courses

import grails.plugins.springsecurity.Secured

@Secured(['User','Admin'])
class Participant {

    Integer id
    Integer userId
    boolean hasPayed
    Date registeredDate

    static constraints = {
        id blank: false, unique: true
        userId blank: false
    }

}
