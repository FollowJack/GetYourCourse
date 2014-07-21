package Person

class Authority {

	transient springSecurityService

	String username
	String password
    String email
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
		password blank: false
        email blank: false, unique: true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Requestmap> getAuthorities() {
		AuthorityRequestmap.findAllByAuthority(this).collect { it.requestmap } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
