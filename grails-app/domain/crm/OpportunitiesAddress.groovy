package crm

import grails.gorm.MultiTenant
import usermanagement.User

class OpportunitiesAddress  implements MultiTenant<OpportunitiesAddress> {

    Opportunities opportunities
    String tenantId
    String addresslineone
    String addresslinetwo
    String country
    String state
    String zip
    OfficeType officeType
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
