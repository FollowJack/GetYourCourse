import Config.DbManager
import Person.Authority
import Person.Person
import Person.PersonAuthority


class BootStrap {

    def init = { servletContext ->
         DbManager.initialize();
            }
    def destroy = {
    }
}
