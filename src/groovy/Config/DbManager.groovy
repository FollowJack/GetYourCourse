package Config

import Person.Authority
import Person.Person
import Person.PersonAuthority

class DbManager {

    public static void initialize() {

        //Create default roles
        new Authority(authority: 'Admin').save(flush: true)
        new Authority(authority: 'User').save(flush: true)

        //Create default Admin
        def testAdmin = Person.findWhere(username: 'admin', enabled: true)
        if (!testAdmin)
            testAdmin = new Person(username: 'admin', enabled: true,emailAddress: 'deniel1@hotmail.de', password: 'admin', matriculationNumber: "1125169")
                    .save(flush: true, failOnError: true)
        //    testAdmin.save(flush: true, failOnError: true)

        //Map admin with role
        testAdmin = Person.findByUsernameAndEnabled('admin', true)
        def newAuthority = new PersonAuthority()
        newAuthority.authority = Authority.findByAuthority('Admin')
        newAuthority.person = testAdmin

        newAuthority.save(flush: true, failOnError: true)
    }
}
