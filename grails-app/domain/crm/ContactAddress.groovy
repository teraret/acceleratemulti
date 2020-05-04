package crm

import grails.gorm.MultiTenant

class ContactAddress implements MultiTenant<ContactAddress> {
    Contact contact
    String tenantId
    String addresslineone
    String addresslinetwo
    String country
    String state
    String zip
    OfficeType officeType
    Date dateCreated
    Date lastUpdated



    static constraints = {
    }


}
