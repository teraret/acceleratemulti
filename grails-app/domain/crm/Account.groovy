package crm

import grails.gorm.MultiTenant
import usermanagement.User

class Account implements MultiTenant<Account> {


    def springSecurityService

    String avatar
    String tenantId
    String name
    String description
    Date establishedDate
    String email
    String mobile
    String website
    String fax
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

        avatar nullable:true, blank:true
        name unique: 'tenantId'
        description nullable: true, blank: true
        establishedDate nullable: true, blank: true
        fax nullable: true, blank: true
        email unique:'tenantId',email: true
        website unique:'tenantId',nullable: true, blank: true
        createdBy nullable: true, blank: true
        lastUpdatedBy nullable: true, blank: true


    }
}

