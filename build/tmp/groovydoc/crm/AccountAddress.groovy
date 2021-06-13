package crm

import grails.gorm.MultiTenant

class AccountAddress  implements MultiTenant<AccountAddress> {
    Account account
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
