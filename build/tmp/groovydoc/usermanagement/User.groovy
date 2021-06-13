package usermanagement

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic
import org.bson.types.ObjectId

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    Organisation organisation
    ObjectId id
    String mobile
    String email
    String username
    String password

    boolean enabled = true
    boolean mobileVerified
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> authorities
    static embedded = ['authorities']

    static constraints = {
        email nullable: false, blank: false, unique: true,email:true
        mobile nullable: false, blank: false, unique: true
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
    }

    static mapping = {
        password column: '`password`'
    }
}
