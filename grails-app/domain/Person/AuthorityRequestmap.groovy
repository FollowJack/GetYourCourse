package Person

import org.apache.commons.lang.builder.HashCodeBuilder

class AuthorityRequestmap implements Serializable {

	Authority authority
	Requestmap requestmap

	boolean equals(other) {
		if (!(other instanceof AuthorityRequestmap)) {
			return false
		}

		other.authority?.id == authority?.id &&
			other.requestmap?.id == requestmap?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (authority) builder.append(authority.id)
		if (requestmap) builder.append(requestmap.id)
		builder.toHashCode()
	}

	static AuthorityRequestmap get(long authorityId, long requestmapId) {
		find 'from AuthorityRequestmap where authority.id=:authorityId and requestmap.id=:requestmapId',
			[authorityId: authorityId, requestmapId: requestmapId]
	}

	static AuthorityRequestmap create(Authority authority, Requestmap requestmap, boolean flush = false) {
		new AuthorityRequestmap(authority: authority, requestmap: requestmap).save(flush: flush, insert: true)
	}

	static boolean remove(Authority authority, Requestmap requestmap, boolean flush = false) {
		AuthorityRequestmap instance = AuthorityRequestmap.findByAuthorityAndRequestmap(authority, requestmap)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Authority authority) {
		executeUpdate 'DELETE FROM AuthorityRequestmap WHERE authority=:authority', [authority: authority]
	}

	static void removeAll(Requestmap requestmap) {
		executeUpdate 'DELETE FROM AuthorityRequestmap WHERE requestmap=:requestmap', [requestmap: requestmap]
	}

	static mapping = {
		id composite: ['requestmap', 'authority']
		version false
	}
}
