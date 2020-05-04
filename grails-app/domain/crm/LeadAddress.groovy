package crm

import grails.gorm.MultiTenant

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

    static constraints = {
    }

    static  mapping ={
        tenantId name: 'website'
    }
}
