package crm

import grails.gorm.MultiTenant
import usermanagement.User

class LeadAddress  implements MultiTenant<LeadAddress> {
    Lead lead
    String tenantId
    String addresslineone
    String addresslinetwo
    String country
    String state
    String zip
    OfficeType officeType
    Date dateCreated
    Date lastUpdated
    String website
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
    }

    static  mapping ={
        tenantId name: 'website'
        createdBy nullable: true, blank: true
        lastUpdatedBy nullable: true, blank: true
    }
}
