package crm

import grails.gorm.MultiTenant
import usermanagement.User

class Lead  implements MultiTenant<Lead> {
    Account account
    String tenantId
    String firstName
    String lastName
    Date dob
    String note
    String mobile
    String email
    String country
    String state
    String zip
    boolean enabled = true
    Date dateCreated
    Date lastUpdated
    User createdBy
    User lastUpdatedBy

    def beforeInsert() {

        createdBy = springSecurityService.getCurrentUser()
        lastUpdatedBy = springSecurityService.getCurrentUser()

    }

    def beforeUpdate() {

        lastUpdatedBy = springSecurityService.getCurrentUser()

    }


    static constraints = {
        createdBy nullable: true, blank: true
        lastUpdatedBy nullable: true, blank: true
    }


}
